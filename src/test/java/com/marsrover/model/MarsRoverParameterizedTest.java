package com.marsrover.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverParameterizedTest {


    @ParameterizedTest
    @CsvFileSource(resources= "/ParametersForRovers.csv", numLinesToSkip = 1)
    void testExecuteMultipleMoveInstructions(int plateauMaxSizeX, int plateauMaxSizeY,
                                             int startPositionX, int startPositionY, String moveInstructions,
                                             int expectedX, int expectedY) {

        //arrange
        Plateau plateau = new RectangularPlateau(plateauMaxSizeX, plateauMaxSizeY);
        MarsRover sut = new MarsRover(plateau, startPositionX, startPositionY, CompassPoint.N);

        //Act  -make rover do something
        sut.setMoveInstructions(moveInstructions);
        for (int i = 0; i < moveInstructions.length(); i++) {
            sut.executeNextMoveInstruction();
        }

        // Assert - compare expect with actual. is the rover where it should be.
        //check position coordinates
        int actualX = sut.getRoverPositionX();
        int actualY = sut.getRoverPositionY();
        assertEquals(expectedX, actualX);
        assertEquals(expectedY, actualY);
    }
}