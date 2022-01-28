package com.marsrover.model;

import java.util.ArrayList;

public interface Plateau {

    public boolean isPlateauPositionSafeToMoveTo(int positionX, int positionY);
    public void registerRovers(ArrayList<MarsRover> rovers);
}
