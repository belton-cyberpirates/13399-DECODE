package org.firstinspires.ftc.teamcode;


public class OpenStopper extends Action {
    Auto auto;

    public OpenStopper(Auto auto) {
        this.auto = auto;
    }

    public void onStart() {
        this.auto.launcher.setStopper(true);
    }

    public boolean isDone() {
        return true;
    }
}