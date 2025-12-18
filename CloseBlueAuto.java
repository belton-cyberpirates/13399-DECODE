package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Direction;
import org.firstinspires.ftc.teamcode.BotConfig;
import org.firstinspires.ftc.teamcode.Auto;


@Autonomous(name = "Close Blue"/*, preselectTeleOp="Your Drive Code Here"*/)
//@Disabled
public class CloseBlueAuto extends Auto {

    public Action[] getActions() {
        
        Action[] launchSequence = {
            // Move to shooting position
            new CloseStopper(this),
            new SpinLauncher(this),
            new SpinIntake(this),
            // new SpinPusher(this, -1),
            // new Move(this,-650, 915, 10),
            // new StopIntake(this),
            new Move(this,-650, -915, -40, 0.45),
            new ActivateTurret(this),
            // new SpinIntake(this),
            
            // Shoot artifacts
            new WaitForLauncher(this),
            new SpinPusher(this),
            new OpenStopper(this),
            new Wait(this, 500),
            new SpinIntake(this),
            new SpinPusher(this),
            new Wait(this, 3800),
            
            // Reset
            new StopLauncher(this),
            new StopIntake(this),
            new StopPusher(this),
            new DeactivateTurret(this),
            new CloseStopper(this),
        };
        
       Action[] actions = {
            // ======================= AUTO START ======================= //
                
            // FINISHED
            
            // Set turret offset
            new SetTurretOffsets(this, BotConfig.TURRET_OFFSET_CLOSE_BLUE, BotConfig.TURRET_OFFSET_FAR_BLUE),
            new SetLauncherDist(this, Distance.CLOSE),

            // Action sequence
            new ActionSequence(this, launchSequence),

            // Move to third line
            new Move(this, -650, -650, -90),

            // Intake artifacts
            new SpinIntake(this),
            new SpinPusher(this, -1),
            new Move(this, -680, -50, -90), 

            // Action sequence
            new ActionSequence(this, launchSequence),

            // If we have more time 

            // Move to second line
            new Move(this, -1310, -800, -90),

            // Intake artifacts
            new SpinIntake(this),
            new SpinPusher(this, -1), 
            new Move(this, -1340, 100, -90),

            new ActionSequence(this, launchSequence),

            new Move(this, -650, -650, -40),

            // I don't think we have any chance of shooting these artifacts, if we even have time to grab them
            
            // End sequence

            // // Move out of triangle
            // new Move(this, ___, ___, ___),



            
            // ======================== AUTO END ======================== //
        };
        
        return actions;
    }
}