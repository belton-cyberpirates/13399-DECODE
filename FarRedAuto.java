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
                
            // FINISHED

            // Set turret offset
            new SetTurretOffsets(this, BotConfig.TURRET_OFFSET_CLOSE_RED, BotConfig.TURRET_OFFSET_FAR_RED),
            new SetLauncherDist(this, Distance.FAR),

            // Move to shooting position
            new Move(this, 180, 0, 0),
            
            // Shoot preloads
            new SpinLauncherFast(this),
            new ActivateTurret(this),
            new WaitForLauncher(this),
            new Wait(this, 750),
            new SpinIntake(this),
            new SpinPusher(this),
            new Wait(this, 5000),

            // Reset
            new StopLauncher(this),
            new StopIntake(this),
            new StopPusher(this),
            new DeactivateTurret(this),

            // Move to first line
            new Move(this, 691, 0, 90),
            new Wait(this, 500),

            // Intake artifacts
            new SpinIntake(this),
            new SpinPusher(this, -1), 
            new Move(this, 691, -1050, 90),

            // Move back to shooting position, while intaking to not lose artifacts
            new Move(this,  180, 0, 22, 0.5), // same as first shooting position

            // Shoot artifacts
            new SpinLauncherFast(this),
            new ActivateTurret(this),
            new WaitForLauncher(this),
            new Wait(this, 750),
            new SpinIntake(this),
            new SpinPusher(this),
            new Wait(this, 5000),

            // Reset
            new StopLauncher(this),
            new StopIntake(this),
            new StopPusher(this),
            new DeactivateTurret(this),

            // If we have more time 

            // Move to second line
            new Move(this, 1300, 0, 90),
            new Wait(this, 500),

            // Intake artifacts
            new SpinIntake(this),
            new SpinPusher(this, -1), 
            new Move(this, 1300, -1050, 90), 

            // I don't think we have any chance of shooting these artifacts, if we even have time to grab them
            



            
            
            // ======================== AUTO END ======================== //
        };
        
        return actions;
    }
}