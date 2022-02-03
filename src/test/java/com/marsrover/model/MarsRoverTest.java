package com.marsrover.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.*;

class MarsRoverTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testExecuteSingleMoveInstruction() {

        //arrange
        Plateau plateau = new RectangularPlateau(5, 5);
        // creating a new rectangular plateau that implements
        // the plateau interface
        MarsRover sut = new MarsRover(plateau, 1, 2, CompassPoint.N);
        // created the Plateau and created Rover on that Plateau.

        //act  -make rover do something
        sut.setMoveInstructions("M");   // it is already facing N so just move it.
        sut.executeNextMoveInstruction();

        // assert - compare expect with actual. is the rover where it should be.
        //check position coordinates
        int expectedX = 1;
        int expectedY = 3;
        int actualX = sut.getRoverPositionX();
        int actualY = sut.getRoverPositionY();
        assertEquals(expectedX, actualX);
        assertEquals(expectedY, actualY);

        //check facing position
        CompassPoint expectedFacing = CompassPoint.N;
        CompassPoint actualFacing = sut.getFacingPosition();
        assertEquals(expectedFacing, actualFacing);

    }

    @Test
    void testExecuteMultipleMoveInstructions() {

        //arrange
        Plateau plateau = new RectangularPlateau(5, 5);
        // creating a new rectangular plateau that implements
        // the plateau interface
        MarsRover sut = new MarsRover(plateau, 1, 2, CompassPoint.N);
        // created the Plateau and created Rover on that Plateau.

        //act  -make rover do something
        sut.setMoveInstructions("LMLM");   // it is already facing N so just move it.
        sut.executeNextMoveInstruction();
        sut.executeNextMoveInstruction();
        sut.executeNextMoveInstruction();
        sut.executeNextMoveInstruction();

        // assert - compare expect with actual. is the rover where it should be.
        //check position coordinates
        int expectedX = 0;
        int expectedY = 1;
        int actualX = sut.getRoverPositionX();
        int actualY = sut.getRoverPositionY();
        assertEquals(expectedX, actualX);
        assertEquals(expectedY, actualY);

        //check facing position
        CompassPoint expectedFacing = CompassPoint.S;
        CompassPoint actualFacing = sut.getFacingPosition();
        assertEquals(expectedFacing, actualFacing);

    }

    @Test
    void testRoverCannotLeaveThePlateau() {

        //arrange
        Plateau plateau = new RectangularPlateau(5, 5);
        MarsRover sut = new MarsRover(plateau, 1, 2, CompassPoint.N);
        // created the Plateau and created Rover on that Plateau.

        //act - make rover do something, making the Rover to go to (-1,3) with instructions
        // "MLMM" but actual result is (0,3) because the Plateau prevents the Rover from moving
        //off it. See method Plateau.isPlateauPositionSafeToMoveTo()
        sut.setMoveInstructions("MLMM");   // it is already facing N so just move it.
        sut.executeNextMoveInstruction();
        sut.executeNextMoveInstruction();
        sut.executeNextMoveInstruction();
        sut.executeNextMoveInstruction();

        // assert - compare expect with actual. is the rover where it should be.
        //check position coordinates
        int expectedX = 0;
        int expectedY = 3;
        int actualX = sut.getRoverPositionX();
        int actualY = sut.getRoverPositionY();
        assertEquals(expectedX, actualX);
        assertEquals(expectedY, actualY);

        //check facing position
        CompassPoint expectedFacing = CompassPoint.W;
        CompassPoint actualFacing = sut.getFacingPosition();
        assertEquals(expectedFacing, actualFacing);

    }

    @Test
    void testGetRoverPositionAndOrientation() {

        //Arrange
        Plateau plateau = new RectangularPlateau(5, 5);
        MarsRover sut = new MarsRover(plateau, 3, 3, CompassPoint.S);

        //Act
        String actual = sut.getRoverPositionAndOrientation();
        String expected = "3 3 S";

        //Assert
        assertEquals(expected, actual);
    }

}