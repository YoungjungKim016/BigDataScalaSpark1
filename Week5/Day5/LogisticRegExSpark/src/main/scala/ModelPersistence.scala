import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.ml.evaluation.BinaryClassificationEvaluator
import org.apache.spark.ml.feature.{QuantileDiscretizer, VectorAssembler}
import org.apache.spark.ml.tuning.{CrossValidator, CrossValidatorModel, ParamGridBuilder}
import org.apache.spark.sql.SparkSession

object ModelPersistence extends App {

  System.setProperty("hadoop.home.dir", "C:\\hadoop")
  val spark = SparkSession
    .builder
    .appName("ModelPersistence")
    .config("spark.master", "local[*]")
    .enableHiveSupport()
    .getOrCreate()
  println("created spark session")
  spark.sparkContext.setLogLevel("ERROR")
  val data = Seq(
    (0, 18.0, 0),
    (1, 20.0, 0),
    (2, 8.0, 1),
    (3, 5.0, 1),
    (4, 2.0, 0),
    (5, 21.0, 0),
    (6, 7.0, 1),
    (7, 18.0, 0),
    (8, 3.0, 1),
    (9, 22.0, 0),
    (10, 8.0, 1),
    (11, 2.0, 0),
    (12, 5.0, 1),
    (13, 4.0, 1),
    (14, 1.0, 0),
    (15, 11.0, 0),
    (16, 7.0, 1),
    (17, 15.0, 0),
    (18, 3.0, 1),
    (19, 20.0, 0))

  val instances = spark.createDataFrame(data)
    .toDF("id", "seeds", "label")

  val discretizer = new QuantileDiscretizer()
    .setInputCol("seeds")
    .setOutputCol("discretized")
    .setNumBuckets(4)

  val assembler = new VectorAssembler()
    .setInputCols(Array("discretized"))
    .setOutputCol("features")

  val classifier = new LogisticRegression()
    .setMaxIter(10)

  val pipeline = new Pipeline()
    .setStages(Array(discretizer, assembler, classifier))

  val paramMaps = new ParamGridBuilder()
    .addGrid(classifier.regParam, Array(0.0, 0.1))
    .build()

  val evaluator = new BinaryClassificationEvaluator()

  val crossValidator = new CrossValidator()
    .setEstimator(pipeline)
    .setEvaluator(evaluator)
    .setNumFolds(2)
    .setEstimatorParamMaps(paramMaps)

  val model = crossValidator.fit(instances)

  model.write.overwrite().save("my-model")

  val persistedModel = CrossValidatorModel.load("./my-model")
  println(s"UID: ${persistedModel.uid}")

  val result = model.transform(instances)
  result.show(false)


  val assembler2 = new VectorAssembler()
    .setInputCols(Array("seeds"))
    .setOutputCol("features")
  // Fit the model
  var df3=instances.select("seeds", "label")
  val df2=assembler2.transform(df3)
  df2.show()
  val lrModel = classifier.fit(df2)

  // Print the coefficients and intercept for logistic regression
  println(s"Coefficients: \n${lrModel.coefficientMatrix}")
  println(s"Intercepts: ${lrModel.interceptVector}")
  lrModel.summary.predictions.show(truncate=false)
  println(lrModel.summary.weightedFMeasure)

}
//https://www.programcreek.com/scala/org.apache.spark.ml.classification.LogisticRegression