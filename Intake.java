package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.JavaUtil;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.BotConfig;
import java.util.List;

public class Intake {

    private LinearOpMode auto;

    public DcMotorEx intake;
    public CRServo pusherRight;
    public CRServo pusherLeft;


    public Intake(LinearOpMode auto) {
        this.auto = auto;
        
        this.intake = auto.hardwareMap.get(DcMotorEx.class, BotConfig.INTAKE_NAME);
        this.pusherRight = auto.hardwareMap.get(CRServo.class, BotConfig.PUSHER_RIGHT_NAME);
        this.pusherLeft = auto.hardwareMap.get(CRServo.class, BotConfig.PUSHER_LEFT_NAME);
    }
  
  
    public void SetIntakeVelocity(int velocity) {
        intake.setVelocity(-velocity);
    }


    public void SpinIntake() {
        this.SetIntakeVelocity(BotConfig.AUTO_INTAKE_VELOCITY);
    }
  
  
    public void SetPusherVelocity(double velocity) {
        pusherLeft.setPower(-velocity);
        pusherRight.setPower(velocity);
    }


    public void SpinPusher(double mult) {
        this.SetPusherVelocity(BotConfig.AUTO_PUSHER_VELOCITY * mult);
    }
    
    
    public int getIntakeVelocity() {
        return (int)intake.getVelocity();
    }
}