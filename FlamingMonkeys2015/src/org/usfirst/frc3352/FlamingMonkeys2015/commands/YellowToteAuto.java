package org.usfirst.frc3352.FlamingMonkeys2015.commands;

import org.usfirst.frc3352.FlamingMonkeys2015.Robot;
import org.usfirst.frc3352.FlamingMonkeys2015.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class YellowToteAuto extends Command {

	boolean isFinished = false;
	
    public YellowToteAuto() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.drivetrainLeftEncoder.reset();
    	RobotMap.drivetrainRightEncoder.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shifter.shiftDown();
    	Robot.intake.in();
    	while(-RobotMap.drivetrainLeftEncoder.getDistance()<9){
    		Robot.drivetrain.drive(.4, .4);
    		SmartDashboard.putNumber("left distance", RobotMap.drivetrainLeftEncoder.getDistance());
    	}
    	Robot.drivetrain.drive(0, 0);
    	Timer.delay(.5);
    	Robot.intake.in();
    	RobotMap.drivetrainLeftEncoder.reset();
    	RobotMap.drivetrainRightEncoder.reset();
    	while(-RobotMap.drivetrainLeftEncoder.getDistance()<35){
    		Robot.drivetrain.drive(.5, 0);
    		SmartDashboard.putNumber("left distance", RobotMap.drivetrainLeftEncoder.getDistance());
    	}
    	Robot.drivetrain.drive(0, 0);
    	Robot.intake.off();
    	RobotMap.drivetrainLeftEncoder.reset();
    	RobotMap.drivetrainRightEncoder.reset();
    	Timer.delay(1);
    	while(-RobotMap.drivetrainLeftEncoder.getDistance()<110){
    		Robot.drivetrain.drive(.5, .5);
    		SmartDashboard.putNumber("left distance", RobotMap.drivetrainLeftEncoder.getDistance());
    	}
    	Robot.drivetrain.drive(0, 0);
    	isFinished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.drive(0, 0);
    	Robot.intake.off();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
