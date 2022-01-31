package com.marsrover.model;

public class MarsRover {

    private int roverPositionX;
    private int roverPositionY;
    private CompassPoint facingPosition;
    private Plateau plateau;
    private String moveInstructionsLeftToDo;

    public MarsRover(Plateau plateau, int startPositionX, int startPositionY,
                     CompassPoint startFacingPosition) {
        this.plateau = plateau;
        this.roverPositionX = startPositionX;
        this.roverPositionY = startPositionY;
        this.facingPosition = startFacingPosition;
    }

    private void turnLeft() {
        if (facingPosition == CompassPoint.N) {
            facingPosition = CompassPoint.W;
        }
        if (facingPosition == CompassPoint.E) {
            facingPosition = CompassPoint.N;
        }
        if (facingPosition == CompassPoint.S) {
            facingPosition = CompassPoint.E;
        }
        if (facingPosition == CompassPoint.W) {
            facingPosition = CompassPoint.S;
        }
    }

    private void turnRight() {
        if (facingPosition == CompassPoint.N) {
            facingPosition = CompassPoint.E;
        }
        if (facingPosition == CompassPoint.E) {
            facingPosition = CompassPoint.S;
        }
        if (facingPosition == CompassPoint.S) {
            facingPosition = CompassPoint.W;
        }
        if (facingPosition == CompassPoint.W) {
            facingPosition = CompassPoint.N;
        }
    }

    private void movesForward() {
        // calculate coordinates that I would like to move to
        int desiredX = 0;
        int desiredY = 0;
        if (facingPosition == CompassPoint.N) {
            desiredX = roverPositionX;
            desiredY = roverPositionY + 1;
        }
        if (facingPosition == CompassPoint.E) {
            desiredX = roverPositionX + 1;
            desiredY = roverPositionY;
        }
        if (facingPosition == CompassPoint.S) {
            desiredX = roverPositionX;
            desiredY = roverPositionY - 1;
        }
        if (facingPosition == CompassPoint.W) {
            desiredX = roverPositionX - 1;
            desiredY = roverPositionY;
        }
        // ask the Plateau if that coordinate is safe to move to
        boolean isSafe;
        isSafe = plateau.isPlateauPositionSafeToMoveTo(desiredX, desiredY);

        // if it is safe, move to that coordinate
        if (isSafe) {
            roverPositionX = desiredX;
            roverPositionY = desiredY;
        }
        // if is NOT safe, stay put
    }

    public void executeNextMoveInstruction() {
        String nextMoveInstruction = moveInstructionsLeftToDo;
        if (nextMoveInstruction.equals("L")) { // for String .equals usually is ==
            turnLeft();
        }
        if (nextMoveInstruction.equals("R")) {
            turnRight();
        }
        if (nextMoveInstruction.equals("M")) {
            movesForward();
        }
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
