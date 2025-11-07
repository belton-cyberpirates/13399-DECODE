package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


public class owenAutoTest extends LinearOpMode {

    int driveSpeed = 800;
    
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
        
        //leftDrive.setDirection(DcMotor.Direction.REVERSE);
        //rightDrive.setDirection(DcMotor.Direction.FORWARD);

        //leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Wait for the game to start (driver presses START)
        waitForStart();

        // Step through each leg of the path,
        // Note: Reverse movement is obtained by setting a negative distance (not speed)
        //encoderDrive(DRIVE_SPEED,  48,  48, 5.0);  // S1: Forward 47 Inches with 5 Sec timeout
    }
}
