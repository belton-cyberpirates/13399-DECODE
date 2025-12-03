package org.firstinspires.ftc.teamcode;


public class OpenStopper extends Action {
    Auto auto;

    public OpenStopper(Auto auto) {
        this.auto = auto;
    }

    public void onStart() {
        this.auto.launcher.setStopper(false);
    }

    public boolean isDone() {
        return true;
    }
}