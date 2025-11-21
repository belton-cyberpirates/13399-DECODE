package org.firstinspires.ftc.teamcode;


public class DeactivateTurret extends Action {
    Auto auto;

    public DeactivateTurret(Auto auto) {
        this.auto = auto;
    }

    public void onStart() {
        auto.launcher.setTurretActive(false);
    }

    public boolean isDone() {
        return true;
    }
}
