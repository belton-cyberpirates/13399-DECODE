package org.firstinspires.ftc.teamcode;


public class SetLauncherDist extends Action {
    Auto auto;
    Distance dist;

    public SetLauncherDist(Auto auto, Distance dist) {
        this.auto = auto;
        this.dist = dist;
    }

    public void onStart() {
        auto.launcher.setDistance(dist); 
    }

    public boolean isDone() {
        return true;
    }
}
