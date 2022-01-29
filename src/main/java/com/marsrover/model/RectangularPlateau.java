package com.marsrover.model;

import java.util.ArrayList;

public class RectangularPlateau implements Plateau {
    private int plateauMaxSizeX;
    private int plateauMaxSizeY;
    private ArrayList<MarsRover> rovers;

    // constructor
    public RectangularPlateau(int plateauMaxSizeX, int plateauMaxSizeY) {
        //data cleansing before storing them inside the object
        if (plateauMaxSizeX < 0) {
            plateauMaxSizeX = 0;
        }
        if (plateauMaxSizeY < 0) {
            plateauMaxSizeY = 0;
        }
        this.plateauMaxSizeX = plateauMaxSizeX;
        this.plateauMaxSizeY = plateauMaxSizeY;
    }

    public int getPlateauMaxSizeX() {

        return plateauMaxSizeX;
    }

    public int getPlateauMaxSizeY() {

        return plateauMaxSizeY;
    }

    @Override   //this is from the Interface
    public boolean isPlateauPositionSafeToMoveTo(int positionX, int positionY) {
        // check against Plateau size
        if(positionX < 0) {
            return false;
        }
        if (positionX > plateauMaxSizeX) {
            return false;
        }
        if(positionY < 0) {
            return false;
        }
        if (positionY > plateauMaxSizeY) {
            return false;
        }

        // is there another rover in that point
        // TODO
        return true;
    }

    @Override //this is from the Interface
    public void registerRovers(ArrayList<MarsRover> rovers) {

    }
}
