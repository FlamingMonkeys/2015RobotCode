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

//import org.usfirst.frc3352.FlamingMonkeys2015.Robot;
import org.usfirst.frc3352.FlamingMonkeys2015.RobotMap;
import org.usfirst.frc3352.FlamingMonkeys2015.commands.*;

import edu.wpi.first.wpilibj.*;
//import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
//import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Drivetrain extends Subsystem 
{
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public Encoder leftEncoder = RobotMap.drivetrainLeftEncoder;
    SpeedController leftMotor = RobotMap.drivetrainLeftMotor;
    //public PIDController left = RobotMap.drivetrainLeft;
    public Encoder rightEncoder = RobotMap.drivetrainRightEncoder;
    SpeedController rightMotor = RobotMap.drivetrainRightMotor;
    //public PIDController right = RobotMap.drivetrainRight;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Drivetrain(){
    	leftEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
    	rightEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
    	leftEncoder.setDistancePerPulse(.0090902565);
    	rightEncoder.setDistancePerPulse(.0090902565);
    	leftEncoder.setMinRate(20.16651156);
    	rightEncoder.setMinRate(20.16651156);
    	leftEncoder.setSamplesToAverage(4);
    	rightEncoder.setSamplesToAverage(4);
    	//left.
    }
    public void initDefaultCommand() 
    {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Drive());
    }
    
    public void drive(double left, double right)
    {
    	leftMotor.set(-left);
    	rightMotor.set(right);
    }
    
}
