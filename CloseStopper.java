package org.firstinspires.ftc.teamcode;


public class CloseStopper extends Action {
    Auto auto;

    public CloseStopper(Auto auto) {
        this.auto = auto;
    }

    public void onStart() {
        this.auto.launcher.setStopper(false);
    }

    public boolean isDone() {
        return true;
    }
}