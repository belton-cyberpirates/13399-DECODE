package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.JavaUtil;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.BotConfig;
import java.util.List;
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.LLStatus;
import com.qualcomm.hardware.limelightvision.Limelight3A;

public class Launcher {

    private LinearOpMode auto;

    public DcMotorEx launcherLeft;
    public DcMotorEx launcherRight;
    public DcMotorEx turret;
    boolean turretActive;
    public Limelight3A limelight;
    
    PIDFController launcherPIDFController = new PIDFController(0.0004, 0.008, 0, 0);
    PIDController turretPIDController = new PIDController(0.035, 0, 0.0005);
    
    ElapsedTime deltaTimer = new ElapsedTime();

    int launcherTargetVelocity = 0;


    public Launcher(LinearOpMode auto) {
        this.auto = auto;
        
        this.launcherLeft = auto.hardwareMap.get(DcMotorEx.class, BotConfig.LAUNCHER_LEFT_NAME);
        this.launcherRight = auto.hardwareMap.get(DcMotorEx.class, BotConfig.LAUNCHER_RIGHT_NAME);
        this.limelight = auto.hardwareMap.get(Limelight3A.class, "Ethernet Device");
        this.turret = auto.hardwareMap.get(DcMotorEx.class, BotConfig.TURRET_NAME);
        
        limelight.setPollRateHz(100);
        limelight.start();
        limelight.pipelineSwitch(0);
        
        
        turret.setTargetPosition(0);
        turret.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
  
  
    public void SetVelocity(int velocity) {
        launcherTargetVelocity = velocity;
    }


    public void Spin() {
        this.SetVelocity(BotConfig.LAUNCHER_VELOCITY);
    }


    public void SetTurretPower(double power) {
        turret.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        turret.setPower(power);
    }


    public void SetTurretVelocity(int velocity) {
        turret.setVelocity(velocity);
    }


    public void SetTurretPosition(int position) {
        turret.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        turret.setTargetPosition(position);
    }


    public boolean isAtVelocity() {
        return launcherRight.getVelocity() > this.launcherTargetVelocity - BotConfig.LAUNCHER_VELOCITY_MARGIN &&
            launcherRight.getVelocity() < this.launcherTargetVelocity + BotConfig.LAUNCHER_VELOCITY_MARGIN;
    }
    
    public double process(){
        
        LLResult result = limelight.getLatestResult();
            
        double deltaTime = deltaTimer.seconds();
        
        double launcherVelocity = launcherRight.getVelocity();
        
        double power = launcherPIDFController.PIDFControl(
            this.launcherTargetVelocity,
            launcherVelocity,
            deltaTime
        );
        
        
        launcherLeft.setPower(power);
        launcherRight.setPower(-power);
        
        double turretPosition = turret.getCurrentPosition();
        
        if (turretActive) {
            turret.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            
            double turretPower = turretPIDController.PIDControl(
                result.getTx() - 1.5,
                deltaTime
            );
        
            if (turret.getCurrentPosition() > 300) {
                turret.setPower(-.5);
            } else if (turret.getCurrentPosition() < -300) {
                turret.setPower(.5);
            } else {
                turret.setPower(turretPower);
            }
            
            auto.telemetry.addData("Turret Power", turretPower);
            auto.telemetry.addData("Limelight Tx", result.getTx());
            
        } else {
            turret.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            turret.setVelocity(1000);
        }
        
        deltaTimer.reset();
        
        auto.telemetry.addData("Launcher Velocity", getVelocity());
        auto.telemetry.addData("Launcher Target Velocity", launcherTargetVelocity);
        auto.telemetry.addData("Launcher Velocity", launcherPIDFController.lastOutput);
        
        return deltaTime;
    }
    
    public int getVelocity() {
        return (int)launcherRight.getVelocity();
    }
    
    public void setTurretActive(boolean val) {
        turretActive = val;
    }
}