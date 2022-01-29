package com.marsrover.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularPlateauSizeTest {

    @Test
    void testIsPlateauPositionSafeToMoveTo01() {
        //Arrange
        RectangularPlateau sut = new RectangularPlateau(5,5);
        //Act
        boolean actual = sut.isPlateauPositionSafeToMoveTo(0,0);
        //Assert
        assertEquals(true, actual);
    }
    @Test
    void testIsPlateauPositionSafeToMoveTo02() {
        //Arrange
        RectangularPlateau sut = new RectangularPlateau(5,5);
        //Act
        boolean actual = sut.isPlateauPositionSafeToMoveTo(6,-1);
        //Assert
        assertEquals(false, actual);
    }
    @Test
    void testIsPlateauPositionSafeToMoveTo03() {
        //Arrange
        RectangularPlateau sut = new RectangularPlateau(5,5);
        //Act
        boolean actual = sut.isPlateauPositionSafeToMoveTo(5,5);
        //Assert
        assertEquals(true, actual);
    }
    @Test
    void testIsPlateauPositionSafeToMoveTo04() {
        //Arrange
        RectangularPlateau sut = new RectangularPlateau(5,5);
        //Act
        boolean actual = sut.isPlateauPositionSafeToMoveTo(6,5);
        //Assert
        assertEquals(false, actual);
    }
    @Test
    void testPlateauCannotHaveNegativeSize01() {
        //Arrange
        RectangularPlateau sut = new RectangularPlateau(-5,-6);
        //Act
        boolean actual = sut.isPlateauPositionSafeToMoveTo(0,0);
        //Assert
        assertEquals(true, actual);
    }
    @Test
    void testPlateauCannotHaveNegativeSize02() {
        //Arrange
        RectangularPlateau sut = new RectangularPlateau(-5,-6);
        //Act
        boolean actual = sut.isPlateauPositionSafeToMoveTo(-1,-1);
        //Assert
        assertEquals(false, actual);
    }
}