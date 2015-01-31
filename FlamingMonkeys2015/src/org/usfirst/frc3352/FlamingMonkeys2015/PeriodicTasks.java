package org.usfirst.frc3352.FlamingMonkeys2015;

/**
 * This class contains all tasks that need to run on the robot, such as updating the states of triggers.
 * 
 * @author Zaque
 *
 */
public class PeriodicTasks {
	
	public PeriodicTasks(){
		
	}
	
	public void run(){
		Robot.oi.runLift();
	}

}
