package org.firstinspires.ftc.teamcode;


public class ActivateTurret extends Action {
    Auto auto;

    public ActivateTurret(Auto auto) {
        this.auto = auto;
    }

    public void onStart() {
        auto.launcher.setTurretActive(true);
    }

    public boolean isDone() {
        return auto.launcher.turretPIDController.lastError <= 1 && auto.launcher.turretPIDController.lastError != 0;
    }
}