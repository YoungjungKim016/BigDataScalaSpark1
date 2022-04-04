## Local Environment Setup
Open a terminal window and type "python" to find out if it is already installed and which version is installed.

 

## Getting Python
**Windows platform**

Binaries of latest version of Python 3 (Python 3.10.1) are available on this download page

Following different installation options are available

- Windows x86-64 embeddable zip file
- Windows x86-64 executable installer
- Windows x86-64 web-based installer
- Windows x86 embeddable zip file
- Windows x86 executable installer
- Windows x86 web-based installer

Linux platform

Different flavours of Linux use different package managers for installation of new packages.

On Ubuntu Linux Python 3 is installed using following command from terminal
```Bash
$sudo apt-get install python3-minimal
```
Installation from source
```Bash
Download Gzipped source tarball from Python's download URL : https://www.python.org/ftp/python/3.5.1/Python-3.5.1.tgz
Extract the tarball
tar xvfz Python-3.5.1.tgz
Configure and Install:
cd Python-3.5.1
./configure --prefix=/opt/python3.5.1
make  
sudo make install
```
### Mac OS

Download Mac OS installers from this URL: https://www.python.org/downloads/mac-osx/

- Mac OS X 64-bit/32-bit installer : python-3.5.1-macosx10.6.pkg
- Mac OS X 32-bit i386/PPC installer : python-3.5.1-macosx10.5.pkg
Double click this package file and follow wizard instructions to install.

The most up-to-date and current source code, binaries, documentation, news, etc., is available on the official website of Python:

### [Python Official Website](http://www.python.org/)

You can download Python documentation from the following site. The documentation is available in HTML, PDF and PostScript formats.

Python Documentation Website : www.python.org/doc/

 

## Setting up PATH
Programs and other executable files can be in many directories, so operating systems provide a search path that lists the directories that the OS searches for executables.

The path is stored in an environment variable, which is a named string maintained by the operating system. This variable contains information available to the command shell and other programs.

The **path** variable is named as PATH in Unix or Path in Windows (Unix is case-sensitive; Windows is not).

In Mac OS, the installer handles the path details. To invoke the Python interpreter from any particular directory, you must add the Python directory to your path.

 

## Setting path at Unix/Linux
To add the Python directory to the path for a particular session in Unix:

- In the csh shell: type setenv PATH "$PATH:/usr/local/bin/python3" and press Enter.

- In the bash shell (Linux): type export PYTHONPATH=/usr/local/bin/python3.4 and press Enter.

- In the sh or ksh shell: type PATH="$PATH:/usr/local/bin/python3" and press Enter.

**Note**: /usr/local/bin/python3 is the path of the Python directory

 

## Setting path at Windows
To add the Python directory to the path for a particular session in Windows:

- At the command prompt : type 

    path %path%;C:\Python and press Enter.

**Note**: C:\Python is the path of the Python directory

 

Python Environment Variables
Here are important environment variables, which can be recognized by Python:
|Variable|	Description|
|----|----|
|PYTHONPATH|	It has a role similar to PATH. This variable tells the Python interpreter where to locate the module files imported into a program. It should include the Python source library directory and the directories containing Python source code. PYTHONPATH is sometimes preset by the Python installer.|
|PYTHONSTARTUP|	It contains the path of an initialization file containing Python source code. It is executed every time you start the interpreter. It is named as .pythonrc.py in Unix and it contains commands that load utilities or modify PYTHONPATH.|
|PYTHONCASEOK|	It is used in Windows to instruct Python to find the first case-insensitive match in an import statement. Set this variable to any value to activate it.|
|PYTHONHOME|	It is an alternative module search path. It is usually embedded in the PYTHONSTARTUP or PYTHONPATH directories to make switching module libraries easy.|
 

Running Python
There are three different ways to start Python:

 

1. Interactive Interpreter:
    You can start Python from Unix, DOS, or any other system that provides you a command-line interpreter or shell window.

    Enter python the command line.

    Start coding right away in the interactive interpreter.
    ```Python
    $python             # Unix/Linux
    or 
    python%             # Unix/Linux
    or 
    C:>python           # Windows/DOS
    ```
    Here is the list of all the available command line options:

    Option	Description
    -d	provide debug output
    -O	generate optimized bytecode (resulting in .pyo files)
    -S	do not run import site to look for Python paths on startup
    -v	verbose output (detailed trace on import statements)
    -X	disable class-based built-in exceptions (just use strings); obsolete starting with version 1.6
    -c cmd	run Python script sent in as cmd string
    file	run Python script from given file
    

2. Script from the Command-line:
    A Python script can be executed at command line by invoking the interpreter on your application, as in the following:
    ```Python
    $python  script.py          # Unix/Linux
    or 
    python% script.py           # Unix/Linux
    or 
    C:>python script.py         # Windows/DOS
    ```
    Note: Be sure the file permission mode allows execution.

 

3. Integrated Development Environment
    You can run Python from a Graphical User Interface (GUI) environment as well, if you have a GUI application on your system that supports Python.

    **Unix**: IDLE is the very first Unix IDE for Python.

    **Windows**: PythonWin is the first Windows interface for Python and is an IDE with a GUI.

    **Macintosh**: The Macintosh version of Python along with the IDLE IDE is available from the main website,      downloadable as either MacBinary or BinHex'd files.

    If you are not able to set up the environment properly, then you can take help from your system admin. Make sure the Python environment is properly set up and working perfectly fine.