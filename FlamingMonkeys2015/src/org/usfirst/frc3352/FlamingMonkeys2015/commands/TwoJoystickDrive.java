package org.usfirst.frc3352.FlamingMonkeys2015.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3352.FlamingMonkeys2015.*;

/**
 *
 */
public class TwoJoystickDrive extends Command {
	double turn;
	double forward;
	double left;
	double right;

    public TwoJoystickDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//forward = -Robot.oi.getLeftJoyForward();
    	//turn = Robot.oi.getRightJoyTurn();
    	left = forward+turn;
    	right = forward-turn;
    	Robot.drivetrain.drive(left, right);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
