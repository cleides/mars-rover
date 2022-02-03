package com.marsrover.model;

public class MarsRover {

    private int roverPositionX;
    private int roverPositionY;
    private CompassPoint facingPosition;
    private final Plateau plateau; // fixed, rover cannot change Plateau
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
        } else if (facingPosition == CompassPoint.W) {
            facingPosition = CompassPoint.S;
        } else if (facingPosition == CompassPoint.S) {
            facingPosition = CompassPoint.E;
        } else if (facingPosition == CompassPoint.E) {
            facingPosition = CompassPoint.N;
        }
    }

    private void turnRight() {
        if (facingPosition == CompassPoint.N) {
            facingPosition = CompassPoint.E;
        } else if (facingPosition == CompassPoint.E) {
            facingPosition = CompassPoint.S;
        } else if (facingPosition == CompassPoint.S) {
            facingPosition = CompassPoint.W;
        } else if (facingPosition == CompassPoint.W) {
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
        } else if (facingPosition == CompassPoint.E) {
            desiredX = roverPositionX + 1;
            desiredY = roverPositionY;
        } else if (facingPosition == CompassPoint.S) {
            desiredX = roverPositionX;
            desiredY = roverPositionY - 1;
        } else if (facingPosition == CompassPoint.W) {
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
        //pulling out first letter of remaining instructions
        String nextMoveInstruction = moveInstructionsLeftToDo.substring(0, 1);
        if (nextMoveInstruction.equals("L")) { // for String .equals usually is ==
            turnLeft();
        } else if (nextMoveInstruction.equals("R")) {
            turnRight();
        } else if (nextMoveInstruction.equals("M")) {
            movesForward();
        }
        // Once instruction is executed we can remove it.
        moveInstructionsLeftToDo = moveInstructionsLeftToDo.substring(1);
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
        return roverPositionX + " " + roverPositionY + " " + facingPosition;
    }

    public void setMoveInstructions(String moveInstructions) {
        this.moveInstructionsLeftToDo = moveInstructions;
    }
}
