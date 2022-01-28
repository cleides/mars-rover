package com.marsrover.model;

import java.util.ArrayList;

public class RectangularPlateau {
    private int plateauMaxSizeX;
    private int plateauMaxSizeY;
    private ArrayList<MarsRover> rovers;

    // constructor
    public void RectangularPlateau(int plateauMaxSizeX, int plateauMaxSizeY) {
        this.plateauMaxSizeX = plateauMaxSizeX;
        this.plateauMaxSizeY = plateauMaxSizeY;
    }

    public int getPlateauMaxSizeX() {
        return plateauMaxSizeX;
    }

    public int getPlateauMaxSizeY() {
        return plateauMaxSizeY;
    }

}
