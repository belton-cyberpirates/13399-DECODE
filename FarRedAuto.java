package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Direction;
import org.firstinspires.ftc.teamcode.BotConfig;
import org.firstinspires.ftc.teamcode.Auto;


@Autonomous(name = "Far Red"/*, preselectTeleOp="Your Drive Code Here"*/)
//@Disabled
public class FarRedAuto extends Auto {

    public Action[] getActions() {
        Action[] actions = {
            // ======================= AUTO START ======================= //
                
            // NOT FINISHED
                
            // Move to shooting position
            new Move(this, 180, 0, 21),
            
            // Shoot preloads
            new SpinLauncherFast(this),
            new WaitForLauncher(this),
            new Wait(this, 750),
            new SpinIntake(this),
            new SpinPusher(this),
            new Wait(this, 5000),

            // Reset
            new StopLauncher(this),
            new StopIntake(this),
            new StopPusher(this),

            // Move to first line
            new Move(this, 691, 0, 90),
            new Wait(this, 500),

            // Intake artifacts
            new SpinIntake(this),
            new SpinPusher(this, -1), 
            new Move(this, 691, -1150, 90, 0.2),

            // Move back to shooting position, while intaking to not lose artifacts
            new Move(this, 180, 0, 21), // same as first shooting position

            // Shoot artifacts
            new SpinLauncherFast(this),
            new WaitForLauncher(this),
            new Wait(this, 750),
            new SpinIntake(this),
            new SpinPusher(this),
            new Wait(this, 5000),

            // Reset
            new StopLauncher(this),
            new StopIntake(this),
            new StopPusher(this),

            // If we have more time 

            // Move to second line
            new Move(this, 1300, 0, 90),
            new Wait(this, 500),

            // Intake artifacts
            new SpinIntake(this),
            new SpinPusher(this, -1), 
            new Move(this, 1300, -1150, 90, 0.2), 

            // I don't think we have any chance of shooting these artifacts, if we even have time to grab them
            
            // End sequence

            // Move out of triangle
            new Move(this, 600, 0, 21),



            
            
            // ======================== AUTO END ======================== //
        };
        
        return actions;
    }
}