array=[1,2,3] # a list named array
pivot=2
less=[]
greater=[]

for x in array:
    if x < pivot:
        less.append(x)
    else:
        greater.append(x)
        
def isiterable(obj):
    try:
        iter(obj)
        return True
    except TypeError: # not iterable
        return False
    
isiterable('a string')
isiterable([1, 2, 3])
isiterable(5)

x="12345"
if not isinstance(x, list) and isiterable(x):
    x = list(x)
    
    
#In this string,
#{0:.2f} means to format the first argument as a floating-point number
#with two decimal places.{1:s} means to format the second argument as a string.
#{2:d} means to format the third argument as an exact integer.
#To substitute arguments for these format parameters, we pass a sequence of arguments to the format method"""

template = '{0:.2f} {1:s} are worth US${2:d}'
template.format(4.5560, 'Argentine Pesos', 1)

x=7
if x < 0:
    print('negative!')
    elif x == 0:
        # TODO: put something smart here
        pass
    else:
        print('positive!')

#for loop with continue
sequence = [1, 2, None, 4, None, 5]
total = 0
for value in sequence:
    if value is None:
        continue
    total += value

#while loop with break        
x = 256
total = 0
while x > 0:
    if total > 500:
        break
    total += x
    x = x//2  
    
#ternary expression
'Non-negative' if x >= 0 else 'Negative'

#Since Python functions are objects, many constructs can be easily expressed
#that are difficult to do in other languages
some_list = ['foo', 'bar', 'baz']
mapping = {}
for i, v in enumerate(some_list):
    mapping[v] = i
mapping

###############################
states = [' Alabama ', 'Georgia!', 'Georgia', 'georgia', 'FlOrIda', .....: 'south carolina##', 'West virginia?']
import re
def clean_strings(strings):
    result = []
    for value in strings:
        value = value.strip()
        value = re.sub('[!#?]', '', value)
        value = value.title()
    result.append(value)
    return result

#vs
def remove_punctuation(value):
    return re.sub('[!#?]', '', value)

clean_ops = [str.strip, remove_punctuation, str.title]
    def clean_strings(strings, ops):
        result = []
        for value in strings:
            for function in ops:
                value = function(value)
                result.append(value)
        return result

clean_strings(states, clean_ops)

###############

class inch(float):
    "Convert from inch to meter"
    def __new__(cls, arg=0.0):
        return float.__new__(cls, arg*0.0254)

#https://docs.python.org/3.9/tutorial/classes.html#method-objects
#.3.5. Class and Instance Variables
#Generally speaking, instance variables are for data unique to each instance and class variables are for attributes and methods shared by all instances of the class:

class Dog:

    kind = 'canine'         # class variable shared by all instances

    def __init__(self, name):
        self.name = name    # instance variable unique to each instance

d = Dog('Fido')
e = Dog('Buddy')
d.kind                  # shared by all dogs

e.kind                  # shared by all dogs

d.name                  # unique to d

e.name                  # unique to e

#As discussed in A Word About Names and Objects, shared data can have possibly surprising effects with involving mutable objects such as lists and dictionaries. 
#For example, the tricks list in the following code should not be used as a class variable because just a single list would be shared by all Dog instances:

class Dog:

    tricks = []             # mistaken use of a class variable

    def __init__(self, name):
        self.name = name

    def add_trick(self, trick):
        self.tricks.append(trick)

d = Dog('Fido')
e = Dog('Buddy')
d.add_trick('roll over')
e.add_trick('play dead')
d.tricks                # unexpectedly shared by all dogs
#['roll over', 'play dead']
#Correct design of the class should use an instance variable instead:

class Dog:

    def __init__(self, name):
        self.name = name
        self.tricks = []    # creates a new empty list for each dog

    def add_trick(self, trick):
        self.tricks.append(trick)

d = Dog('Fido')
d.add_trick('roll over')
e.add_trick('play dead')
d.tricks
#['roll over']
e.tricks
#['play dead']