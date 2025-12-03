package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Direction;
import org.firstinspires.ftc.teamcode.BotConfig;
import org.firstinspires.ftc.teamcode.Auto;


@Autonomous(name = "Test Auto"/*, preselectTeleOp="Your Drive Code Here"*/)
//@Disabled
public class TestAuto extends Auto {

    public Action[] getActions() {
        Action[] actions = {
            // ======================= AUTO START ======================= //

            // Actions Here:
            new Move(this, 1000, 0, 90),
            new Move(this, 1000, 1000, 180),
            new Move(this, 0, 1000, 270),
            new Move(this, 0, 0, 0),
            //new Move(this, -100, -100, -45),
            
            new Wait(this, 10000),
            
            // ======================== AUTO END ======================== //
        };
        
        return actions;
    }
}

