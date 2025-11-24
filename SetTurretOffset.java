package org.firstinspires.ftc.teamcode;


public class SetTurretOffset extends Action {
    Auto auto;
    double turretOffset;

    public SetTurretOffset(Auto auto, double turretOffset) {
        this.auto = auto;
        this.turretOffset = turretOffset;
    }

    public void onStart() {
        auto.launcher.setTurretOffset(turretOffset); 
    }

    public boolean isDone() {
        return true;
    }
}
