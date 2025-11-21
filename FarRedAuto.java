package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Direction;
import org.firstinspires.ftc.teamcode.BotConfig;
import org.firstinspires.ftc.teamcode.Auto;


@Autonomous(name = "Far Blue"/*, preselectTeleOp="Your Drive Code Here"*/)
//@Disabled
public class FarBlueAuto extends Auto {

    public Action[] getActions() {
        Action[] actions = {
            // ======================= AUTO START ======================= //
                
            // Move to shooting position
            new Move(this, ___, ___, ___),
            
            // Shoot preloads
            new SpinLauncherFast(this),
            new WaitForLauncher(this),
            new Wait(this, 500),
            new SpinIntake(this),
            new SpinPusher(this),
            new Wait(this, 5500),

            // Reset
            new StopLauncher(this),
            new StopIntake(this),
            new StopPusher(this),

            // Move to first line
            new Move(this, ___, ___, ___),

            // Intake artifacts
            new SpinIntake(this),
            new SpinPusher(-this), //idk how to do down pusher, this is my guess
            new Move(this, ___, ___, ___), //add numbers

            // Move back to shooting position, while intaking to not lose artifacts
            new Move(this, 180, 0, -22.5), // same as first shooting position

            // Shoot artifacts
            new SpinLauncherFast(this),
            new WaitForLauncher(this),
            new Wait(this, 500),
            new SpinIntake(this),
            new SpinPusher(this),
            new Wait(this, 5500),

            // Reset
            new StopLauncher(this),
            new StopIntake(this),
            new StopPusher(this),

            // If we have more time 

            // // Move to first line
            // new Move(this, ___, ___, ___),

            // // Intake artifacts
            // new SpinIntake(this),
            // new SpinPusher(-this), //idk how to do down pusher, this is my guess
            // new Move(this, ___, ___, ___), //add numbers

            // I don't think we have any chance of shooting these artifacts, if we even have time to grab them
            
            // End sequence

            // Move out of triangle
            new Move(this, ___, ___, ___),




            
            // ======================== AUTO END ======================== //
        };
        
        return actions;
    }
}