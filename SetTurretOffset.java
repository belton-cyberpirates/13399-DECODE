package org.firstinspires.ftc.teamcode;


public class SetTurretOffsets extends Action {
    Auto auto;
    double turretCloseOffset;
    double turretFarOffset;

    public SetTurretOffsets(Auto auto, double turretCloseOffset, double turretFarOffset) {
        this.auto = auto;
        this.turretCloseOffset = turretCloseOffset;
        this.turretFarOffset = turretFarOffset;
    }

    public void onStart() {
        auto.launcher.setTurretOffsets(turretCloseOffset, turretFarOffset); 
    }

    public boolean isDone() {
        return true;
    }
}
