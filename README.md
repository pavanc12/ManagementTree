# ManagementTree
Application that takes a list of employees and displays employees in a management tree

## PROBLEM
Write a method that takes a list of employees and displays employees in a management tree.
An employee has an ID, name and manager ID.
```
Example:
Id   |  Name   |  ManagerId
---------------------------
1    |  Tom    |  0
2    |  Mickey |  1
3    |  Jerry  |  1
4    |  John   |  2
5    |  Sarah  |  1
---------------------------
Expected output:
->Tom
->->Jerry
->->Mickey
->->->John
->->Sarah
```
The method displayManagementTree displays the management tree.
For each level of management there is extra indentation to show who manages who
* The tree must start from the root manager. The root manager will have a manager ID equal to 0. There is only 1 root manager.
* The root manager must have 1 set of indentation characters, ‘->’. For example, ->Tom
* If an employee has a manager, then they must be displayed below their manager.
* For every level management, they must be another set of indentation characters, ‘->’.

### Additional Example/Test Case
```
Id   |  Name   |  ManagerId
---------------------------
1    |  Jerry  |  0
2    |  Stacie |  1
3    |  Philip |  1
4    |  Tom    |  2
5    |  Mike   |  4
6    |  John   |  5
7    |  Alice  |  4
8    |  Key    |  2
9    |  Peter  |  8
10   |  David  |  2
---------------------------
Expected output:
->Jerry
->->Stacie
->->->Tom
->->->->Mike
->->->->->John
->->->->Alice
->->->Key
->->->->Peter
->->->David
->->Philip
```

## Getting Started

To compile and run the application and tests on your local machine, download the Source (com) to a local directory on your local machine. Alternatively you can download the project to IDE like Eclipse or IntelliJ Idea.

### Pre-requisites

To compile & run the application you need Java Development Kit 8 on your local machine which can be downloaded from the below link.
* [JDK Download](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

To run the application with different inputs you need to edit the main method in the source file.

## Compiling the application

1. Open Command-Line or Terminal on you local machine.
2. Change the directory to parent directory of the extracted ManagemetTree.zip file.
3. Compile the application as below.

```
$ javac com/kiwiplan/ManagemetTree.java
```
Alternatively if your are using an IDE, you can use your IDE's Debug/Compile options

## Running the application

1. Open Command-Line or Terminal on you local machine.
2. Change the directory to parent directory of the source.
3. Run the application as below.

```
$ java com/kiwiplan/ManagemetTree
```
Alternatively if your are using an IDE, you can use your IDE's Run option

## Running the tests

Application has been designed to run with a static list of employees which is hardcoded in the main method. You need to edit the main method in the source file to test with different inputs.

## Built With

* [JAVA 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

## Authors

* **Pavan Kumar** - *Initial work*
