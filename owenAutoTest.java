package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class owenAutoTest extends LinearOpMode {
    
    private DcMotorEx driveMotorBL;
    private DcMotorEx driveMotorFL;
    private DcMotorEx driveMotorBR;
    private DcMotorEx driveMotorFR;

    @Override
    public void runOpMode() {

        driveMotorBL = hardwareMap.get(DcMotorEx.class, "driveBL");
        driveMotorFL = hardwareMap.get(DcMotorEx.class, "driveFL");
        driveMotorBR = hardwareMap.get(DcMotorEx.class, "driveBR");
        driveMotorFR = hardwareMap.get(DcMotorEx.class, "driveFR");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        
        driveMotorBL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        driveMotorBR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        driveMotorFL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        driveMotorFR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        
        driveMotorBL.setDirection(DcMotor.Direction.REVERSE);
        driveMotorFL.setDirection(DcMotor.Direction.REVERSE);

        driveMotorBL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        driveMotorBR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        driveMotorFL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        driveMotorFR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();
        if (opModeIsActive()) {
            while (opModeIsActive()) {
                //100 ticks looks to be 3.5 in.
                FBWithTicks(100);
                sleep(1000000);
            }
        }
    }

private void FBWithTicks(int ticks) {
    driveMotorBL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    driveMotorBR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    driveMotorFL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    driveMotorFR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    driveMotorBL.setTargetPosition(ticks);
    driveMotorBR.setTargetPosition(ticks);
    driveMotorFL.setTargetPosition(ticks);
    driveMotorFR.setTargetPosition(ticks);

    driveMotorBL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    driveMotorBR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    driveMotorFL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    driveMotorFR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    while (driveMotorFL.isBusy() || driveMotorBR.isBusy()) {
        driveMotorBL.setVelocity(1000);
        driveMotorBR.setVelocity(1000);
        driveMotorFL.setVelocity(1000);
        driveMotorFR.setVelocity(1000);
        telemetry.addData("left", driveMotorFL.getPower());
        telemetry.update();
    }

    driveMotorBL.setPower(0);
    driveMotorBR.setPower(0);
    driveMotorFL.setPower(0);
    driveMotorFR.setPower(0);
}

private void strafeRight(int ticks) {
    driveMotorBL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    driveMotorBR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    driveMotorFL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    driveMotorFR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    driveMotorBL.setTargetPosition(-ticks);
    driveMotorBR.setTargetPosition(ticks);
    driveMotorFL.setTargetPosition(ticks);
    driveMotorFR.setTargetPosition(-ticks);

    driveMotorBL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    driveMotorBR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    driveMotorFL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    driveMotorFR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    while (driveMotorFL.isBusy() || driveMotorBR.isBusy()) {
        driveMotorBL.setVelocity(1000);
        driveMotorBR.setVelocity(1000);
        driveMotorFL.setVelocity(1000);
        driveMotorFR.setVelocity(1000);
        telemetry.addData("left", driveMotorFL.getPower());
        telemetry.update();
    }

    driveMotorBL.setPower(0);
    driveMotorBR.setPower(0);
    driveMotorFL.setPower(0);
    driveMotorFR.setPower(0);
}

private void turnRight(int ticks) {
    driveMotorBL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    driveMotorBR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    driveMotorFL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    driveMotorFR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    driveMotorBL.setTargetPosition(ticks);
    driveMotorBR.setTargetPosition(-ticks);
    driveMotorFL.setTargetPosition(ticks);
    driveMotorFR.setTargetPosition(-ticks);

    driveMotorBL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    driveMotorBR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    driveMotorFL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    driveMotorFR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    while (driveMotorFL.isBusy() || driveMotorBR.isBusy()) {
        driveMotorBL.setVelocity(1000);
        driveMotorBR.setVelocity(1000);
        driveMotorFL.setVelocity(1000);
        driveMotorFR.setVelocity(1000);
        telemetry.addData("left", driveMotorFL.getPower());
        telemetry.update();
    }

    driveMotorBL.setPower(0);
    driveMotorBR.setPower(0);
    driveMotorFL.setPower(0);
    driveMotorFR.setPower(0);
}
}
