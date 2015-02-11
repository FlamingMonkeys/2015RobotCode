// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3352.FlamingMonkeys2015.subsystems;

import org.usfirst.frc3352.FlamingMonkeys2015.RobotMap;
//import org.usfirst.frc3352.FlamingMonkeys2015.commands.*;
import edu.wpi.first.wpilibj.*;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Lift extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public SpeedController liftMotor = RobotMap.liftLiftMotor;
    DigitalInput position1 = RobotMap.liftPosition1;
    DigitalInput position2 = RobotMap.liftPosition2;
    DigitalInput position3 = RobotMap.liftPosition3;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void liftUp(){
    	liftMotor.set(1);
    }
    
    public void liftDown(){
    	liftMotor.set(-1);
    }
    
    public void liftOff(){
    	liftMotor.set(0);
    }
    
    public int getLevel(){
    	return position1.get() ? 1:position2.get()? 2:position3.get()? 3:0;
    }
}

