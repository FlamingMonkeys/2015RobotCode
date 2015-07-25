package org.usfirst.frc3352.FlamingMonkeys2015;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class contains all tasks that need to run on the robot, such as updating the states of triggers.
 * 
 * @author Zaque
 *
 */
public class PeriodicTasks {
	
	public PeriodicTasks(){
		
	}
	
	public static void run(){
		if(Robot.oi.getTargetLevel()>0){
			Robot.oi.liftTrigger.setPressed(true);
		}else{
			Robot.oi.liftTrigger.setPressed(false);
		}
		SmartDashboard.putBoolean("switch1", !Robot.lift.position1.get());
		SmartDashboard.putBoolean("switch2", !Robot.lift.position2.get());
		SmartDashboard.putBoolean("switch3", !Robot.lift.position3.get());
		SmartDashboard.putNumber("left distance", Robot.drivetrain.leftEncoder.getDistance());
		SmartDashboard.putNumber("right distance", Robot.drivetrain.rightEncoder.getDistance());
		SmartDashboard.putBoolean("auto running", Robot.autonomousCommand.isRunning());
	}
}
