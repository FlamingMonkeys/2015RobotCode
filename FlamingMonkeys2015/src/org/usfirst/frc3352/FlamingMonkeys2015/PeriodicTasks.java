package org.usfirst.frc3352.FlamingMonkeys2015;

//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	}
}
