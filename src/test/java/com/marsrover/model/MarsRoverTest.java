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
    void testExecuteNextMoveInstruction() {

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
    void getFacingPosition() {
    }

    @Test
    void getRoverPositionAndOrientation() {
    }

}