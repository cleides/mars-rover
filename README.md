# Mars Rover Kata

## Introduction


This repository contains a program to move rovers around the surface of Mars. 
The surface of Mars is represented by a square/rectangular grid plateau, although the design is easily
extendable to support others shapes as discussed later.

## Approach

The starting point was to design a UML diagram, to define roles and 
responsibilities of each object. 
 - The `RectangularPlateau` class is responsible for saying if any given position
on the plateau is safe to move to. This includes collision with other rovers.
 - The `MarsRover` class contains a list of movement instructions that will execute. The `MarsRover` asks 
the plateau if position is safe to move to.
 - `MissionControl` class coordinates the movements of multiple rovers and any other vehicles that might
be added in the future.

After designing the UML diagram a TDD approach was taken. The plateau tests were created first and then
the rover. The parameterized tests were developed later.

## Class Diagram
The UML diagram below shows the classes mentioned above plus a `CompassPoint` enum class containing
the vehicles facing position. There is a `Plateau` interface that every plateau shape class must implement.

![](https://github.com/cleides/mars-rover/blob/master/docs/MarsRoversUMLDiagram.png?raw=true)

##Assumptions

 - A rover cannot move off the `Plateau`.
 - If a rover is asked to move off the `Plateau`, it does not move and move instruction is regarded as 
consumed/used.

## Testing

A csv file has been created containing test parameters: 

![](https://github.com/cleides/mars-rover/blob/master/docs/TestParameters.png?raw=true)

This csv file can be edited in e.g. Excel to add more tests.
This means new tests can be added by non developers simply by editing the csv file.
The test class `MarsRoverParameterizedTest` reads this csv file.

There are also non-parameterized tests in `RectangularPlateauSizeTest` and `MarsRoverTest`.

## Improvements 

The `MissionControl` class will be implemented to manage multiple rovers and other vehicles once
they are added to the list. It will also coordinate the movements so that each vehicle moves one 
at the time.

The `RectangularPlateau` class does not yet implement checks for collision between Rovers although
the design for it is done. The idea is that `MissionControl` class will call the
`Plateau.registerRovers()` method so that the plateau has visibility of all rovers and can therefore
detect collision between them.





