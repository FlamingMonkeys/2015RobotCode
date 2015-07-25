package org.usfirst.frc3352.FlamingMonkeys2015.commands;

import org.usfirst.frc3352.FlamingMonkeys2015.Robot;
import org.usfirst.frc3352.FlamingMonkeys2015.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ThreeToteAuto extends Command {

	boolean isFinished = false;
    public ThreeToteAuto() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	requires(Robot.intake);
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.drivetrainLeftEncoder.reset();
    	RobotMap.drivetrainRightEncoder.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intake.in();
    	Robot.lift.liftMotor.set(.75);
    	while(Robot.lift.position2.get()){
    		Timer.delay(.0001);
    	}
    	Robot.lift.liftOff();
    	Robot.intake.out();
    	isFinished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lift.liftOff();
    	Robot.drivetrain.drive(0, 0);
    	Robot.intake.off();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
