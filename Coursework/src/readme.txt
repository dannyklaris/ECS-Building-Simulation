# Coursework Basic Part by: Danial Akmal #

## Part 1 ##
I have implemented the classes [Bug, ConcurrentModificationBug, NoneTerminationBug, NullPointerBug]  following the coursework specification.
Additional methods are added to Bug class such as [compareTo(Bug bug) method, toString() method] accordingly to sort the bugs following the specification and to print out information about the bugs.

## Part 2 ##
I have implemented the classes [Building] following the coursework specification.

## Part 3 ##
I have implemented the classes [AiStudent, CsStudent, CyberStudent, SeStudent, Student Interface] following the coursework specification.
specification

I added a new class [Toolbox] to implement the probability involved in Defence method by CyberStudent for the special attack.

## Part 4 ##
I have implemented the class [Team] following the coursework specification.

## Part 5 ##
I have implemented the class [Battle] following the coursework specification.

## Part 6 ##
I have implemented the class [EcsBuildingDefence] following the coursework specification.



# Extension #
I have implement the following extension.

3 new bugs are added.[ArithmeticBug, InterruptedBug, InvocationTargetBug]
Each bugs is granted a 50% chance of special ability in each move they make or 50% chance to decrease the construction points more than usual.

NullPointerBug special ability: A chance to skip 1 floor.
ConcurrentModificationBug special ability: A chance to move faster than usual. (by 4 steps)
NoneTerminationBug special ability: A chance to heals up by 100 HP.
ArithmeticBug special ability: A chance to deal double damage to building when it reaches the top floor.
InterruptedBug special ability: A chance to restore HP to maximum.
InvocationTargetBug special ability: A chance to heals up by 100 HP, deals additional damage to construction points by 25% of the current construction points.

The following classes are added.

ArithmeticBug
InterruptedBug
InvocationTargetBug

To run the program with the extension, please use the following command.

java EcsBuildingDefence (set the top floor) (set the construction points) extension.txt