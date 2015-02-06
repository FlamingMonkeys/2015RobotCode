// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3352.FlamingMonkeys2015.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3352.FlamingMonkeys2015.Robot;

/**
 *	Jack is a boss.
 */
public class  Drive extends Command 
{
    double rightPreviousVal;
    double leftPreviousVal;
    final double rampLimit = .05;
    final double kDeadband = .2;
    final double kGain = .8;
    double turnVal;
    double forwardVal;
    double motorVals[] = new double[2];
    double leftVal;
    double rightVal;

    public Drive() 
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.drivetrain);
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    protected void initialize() 
    {
    	
    }
    protected void execute() 
    {
    	 forwardVal = inverseDeadband(Robot.oi.getForwardSpeed());
         turnVal = deadband(Robot.oi.getTurnSpeed(), .2);
         turnVal = quickTurn(turnVal, forwardVal);
         motorVals[0]=forwardVal+turnVal;
         motorVals[1]=forwardVal-turnVal;
         motorVals = saturation(motorVals[0], motorVals[1]);
         leftVal = ramp(motorVals[0], leftPreviousVal);
         rightVal = ramp(motorVals[1], rightPreviousVal);
         Robot.drivetrain.drive(leftVal, rightVal);
         leftPreviousVal = leftVal;
         rightPreviousVal = rightVal;
    }
    protected boolean isFinished()
    {
        return false;
    }
    protected void end() 
    {
    	Robot.drivetrain.drive(0, 0);
    }
    protected void interrupted() 
    {
    	end();
    }
    public double ramp(double setVal, double lastVal)
    {
        if(Math.abs(setVal)>kDeadband)
        {
            double changeVal = setVal - lastVal;
            if(changeVal>rampLimit)
            {
                setVal = lastVal + rampLimit;
            }
            else if(changeVal<-rampLimit){
                setVal = lastVal - rampLimit;
            }
        }
        return setVal;
    }
    public double inverseDeadband(double x)
    {
        if(x>0)
        {
            x=kDeadband+(1-kDeadband)*((kGain*(x*x*x))+(1-kGain)*x);
        }
        else if(x<0)
        {
            x=-kDeadband+(1-kDeadband)*((kGain*(x*x*x))+(1-kGain)*x);
        }
        return x;
    }
    public double quickTurn(double turnSpeed, double forwardSpeed)
    {
        if(forwardSpeed>0)
        {
            turnSpeed = -forwardSpeed*turnSpeed;
        }
        else if(forwardSpeed<0)
        {
            turnSpeed = -forwardSpeed*turnSpeed;
        }
        else
        {
            turnSpeed = -turnSpeed;
        }
        return turnSpeed;
    }
    public double[] saturation(double leftSpeed, double rightSpeed)
    {
        double maxMagnitude;
        double speeds[] = new double[2];
        maxMagnitude=Math.max(Math.abs(leftSpeed), Math.abs(rightSpeed));
        if(maxMagnitude>1)
        {
            speeds[0]=leftSpeed/maxMagnitude;
            speeds[1]=rightSpeed/maxMagnitude;
        }
        else
        {
            speeds[0]=leftSpeed;
            speeds[1]=rightSpeed;
        }
        return speeds;
    }
    public double deadband(double setVal, double deadband)
    {
        return (Math.abs(setVal)<deadband)? 0.0 : setVal;
    }
}
