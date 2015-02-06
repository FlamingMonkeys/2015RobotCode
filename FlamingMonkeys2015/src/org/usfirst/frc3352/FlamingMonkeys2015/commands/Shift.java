package org.usfirst.frc3352.FlamingMonkeys2015.commands;

import org.usfirst.frc3352.FlamingMonkeys2015.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Shift extends Command {
	static boolean isHigh;//true means in high gear; false means in low gear
	boolean isFinished;

    public Shift() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(isHigh){
    		Robot.shifter.shiftDown();
    	}else{
    		Robot.shifter.shiftUp();
    	}
    	isFinished=true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
