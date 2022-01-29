package com.marsrover.model;

public class MarsRover {

    private int roverPositionX;
    private int roverPositionY;
    private CompassPoint facingPosition;
    private Plateau plateau;
    private String moveInstructionsLeftToDo;

    public MarsRover(Plateau plateau, int startPositionX, int startPositionY,
                     CompassPoint startFacingPosition) {

    }

    private void turnLeft() {

    }

    private void turnRight() {

    }

    private void movesForward() {

    }

    public void move() {

    }

    public int getRoverPositionX() {
        return roverPositionX;
    }

    public int getRoverPositionY() {
        return roverPositionY;
    }

    public CompassPoint getFacingPosition() {
        return facingPosition;
    }

    public String getRoverPositionAndOrientation() {
        // TODO
        return "to do";
    }

    public void setMoveInstructions(String moveInstructions) {
        this.moveInstructionsLeftToDo = moveInstructions;
    }
}
