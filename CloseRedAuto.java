package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Direction;
import org.firstinspires.ftc.teamcode.BotConfig;
import org.firstinspires.ftc.teamcode.Auto;


@Autonomous(name = "Close Red"/*, preselectTeleOp="Your Drive Code Here"*/)
//@Disabled
public class CloseRedAuto extends Auto {

    public Action[] getActions() {
        Action[] actions = {
            // ======================= AUTO START ======================= //
                
            // NOT FINISHED
                
            // Move to shooting position
            new Move(this,-450, 1120, -135),
            
            // // Shoot preloads
            new SpinLauncherFast(this),
            new ActivateTurret(this),
            new WaitForLauncher(this),
            new OpenStopper(this),
            new Wait(this, 750),
            new SpinIntake(this),
            new SpinPusher(this),
            new Wait(this, 5000),
            
            // // Reset
            new StopLauncher(this),
            new StopIntake(this),
            new StopPusher(this),
            new DeactivateTurret(this),
            new CloseStopper(this),

            // // Move to third line
            // new Move(this, ___, ___, ___),

            // // Intake artifacts
            // new SpinIntake(this),
            // new SpinPusher(this, -1),
            // new Move(this, ___, ___, ___), //add numbers

            //  // Move back to shooting position, while intaking to not lose artifacts
            // new Move(this, ___, ___, ___), // same as first shooting position

            // // Shoot artifacts
            // new SpinLauncherFast(this),
            // new ActivateTurret(this),
            // new WaitForLauncher(this),
            // new OpenStopper(this),
            // new Wait(this, 750),
            // new SpinIntake(this),
            // new SpinPusher(this),
            // new Wait(this, 5000),
            // 
            // // Reset
            // new StopLauncher(this),
            // new StopIntake(this),
            // new StopPusher(this),
            // new DeactivateTurret(this),
            // new CloseStopper(this),

            // // If we have more time 

            // // // Move to first line
            // // new Move(this, ___, ___, ___),

            // // // Intake artifacts
            // // new SpinIntake(this),
            // // new SpinPusher(-this), //idk how to do down pusher, this is my guess
            // // new Move(this, ___, ___, ___), //add numbers

            // // I don't think we have any chance of shooting these artifacts, if we even have time to grab them
            
            // // End sequence

            // // Move out of triangle
            // new Move(this, ___, ___, ___),




            
            // ======================== AUTO END ======================== //
        };
        
        return actions;
    }
}