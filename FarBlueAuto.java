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
                
            // NOT FINISHED
                
            // Move to shooting position
            new Move(this, 180, 0, -22.5),
            
            // Shoot preloads
            new SpinLauncherFast(this),
            new WaitForLauncher(this),
            new Wait(this, 750),
            new SpinIntake(this),
            new SpinPusher(this),
            new Wait(this, 5500),

            // Reset
            new StopLauncher(this),
            new StopIntake(this),
            new StopPusher(this),

            // Move to first line
            new Move(this, 691, 405, -90),

            // Intake artifacts
            new SpinIntake(this),
            new SpinPusher(this, -1), 
            new Move(this, 691, 805, -90),

            // Move back to shooting position, while intaking to not lose artifacts
            new Move(this, 180, 0, -22.5, 0.4), // same as first shooting position

            // Shoot artifacts
            new SpinLauncherFast(this),
            new WaitForLauncher(this),
            new Wait(this, 750),
            new SpinIntake(this),
            new SpinPusher(this),
            new Wait(this, 5500),

            // Reset
            new StopLauncher(this),
            new StopIntake(this),
            new StopPusher(this),

            // If we have more time 

            // Move to second line
            new Move(this, 1250, 405, -90),

            // Intake artifacts
            new SpinIntake(this),
            new SpinPusher(this, -1), 
            new Move(this, 1250, 805, -90), 

            // I don't think we have any chance of shooting these artifacts, if we even have time to grab them
            
            // End sequence

            // Move out of triangle
            new Move(this, 500, 0, -22),



            
            
            // ======================== AUTO END ======================== //
        };
        
        return actions;
    }
}