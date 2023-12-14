# ECS Building Defence Simulation on CLI
## Description
A tower building defence simulation that can be played on a terminal.

## Table of Contents
- [Installation](#installation)
- [Usage](#usage)
- [Coursework Overview](#coursework-overview)
- [Extension](#extension)
- [Bugs to fixed](#bugs-to-fixed)

## Installation
1. Make sure you have Java installed.
2. `git clone` this repo.

## Usage
1. For Windows, open Windows Command Prompt.
2. Run this command to start the simulation:
    - Top Floor - The maximum floor for the tower defence
    - Construction Points - The building construction points or health, the higher it is, the longer it will take for the bugs to destroy it.
```
java EcsBuildingDefence (set the top floor) (set the construction points) easy.txt
```
## Coursework Overview

### Part 1 ##
I have implemented the classes [Bug, ConcurrentModificationBug, NoneTerminationBug, NullPointerBug]  following the coursework specification.
Additional methods are added to Bug class such as [compareTo(Bug bug) method, toString() method] accordingly to sort the bugs following the specification and to print out information about the bugs.

### Part 2 ##
I have implemented the classes [Building] following the coursework specification.

### Part 3 ##
I have implemented the classes [AiStudent, CsStudent, CyberStudent, SeStudent, Student Interface] following the coursework specification.
specification

I added a new class [Toolbox] to implement the probability involved in Defence method by CyberStudent for the special attack.

### Part 4 ##
I have implemented the class [Team] following the coursework specification.

### Part 5 ##
I have implemented the class [Battle] following the coursework specification.

### Part 6 ##
I have implemented the class [EcsBuildingDefence] following the coursework specification.

## Extension #
I have implement the following extension.

3 new bugs are added.
- ArithmeticBug
- InterruptedBug
- InvocationTargetBug

Each bugs is granted a 50% chance of special ability in each move they make or 50% chance to decrease the construction points more than usual.

- NullPointerBug 
    - Special Ability: A chance to skip 1 floor.
- ConcurrentModificationBug 
    - Special Ability: A chance to move faster than usual. (by 4 steps)
- NoneTerminationBug 
    - Special Ability: A chance to heals up by 100 HP.
- ArithmeticBug 
    - Special Ability: A chance to deal double damage to building when it reaches the top floor.
- InterruptedBug 
    - Special Ability: A chance to restore HP to maximum.
- InvocationTargetBug 
    - Special Ability: A chance to heals up by 100 HP, deals additional damage to construction points by 25% of the current construction points.

The following classes are added.

- ArithmeticBug
- InterruptedBug
- InvocationTargetBug

To run the program with the extension, please use the following command.

```
java EcsBuildingDefence (set the top floor) (set the construction points) extension.txt
```
## Bugs to fixed
- After running `mvn test`, 6 test cases were not passed.
```
[INFO] Results:
[INFO]
[ERROR] Failures: 
[ERROR]   TestPart2$TestBuildingSpecification.testBuilding_bugsMove:364->lambda$testBuilding_bugsMove$4:425 Move 2: The first bug should be NullPointerBug ==> expected: <Bug: NullPointerBug || Level: 3 || HP: 52> but was: <Bug: ConcurrentModificationBug || Level: 1 || HP: 20>
[ERROR]   TestPart2$TestBuildingSpecification.testBuilding_getAllBugs:130->lambda$testBuilding_getAllBugs$1:208 : There should be no bugs ==> expected: <3> but was: <2>
[ERROR]   TestPart3$TestAiStudentSpecification.testAiStudent_defense:148->lambda$testAiStudent_defense$1:208 expected: <200> but was: <300>
[ERROR]   TestPart3$TestCsStudentSpecification.testCsStudent_defense:468->lambda$testCsStudent_defense$1:528 expected: <200> but was: <300>
[ERROR]   TestPart3$TestCyberStudentSpecification.testCyberStudent_defense:743->lambda$testCyberStudent_defense$1:806 expected: <200> but was: <300>
[ERROR]   TestPart3$TestSeStudentSpecification.testSeStudent_defense:1065->lambda$testSeStudent_defense$1:1135 expected: <200> but was: <300>
[INFO]
[ERROR] Tests run: 33, Failures: 6, Errors: 0, Skipped: 0
```
