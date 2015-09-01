// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3352.FlamingMonkeys2015;

import org.usfirst.frc3352.FlamingMonkeys2015.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public Joystick driver1 = new Joystick(0);
    public Joystick driver2 = new Joystick(1);
    public Joystick operator = new Joystick(2);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    Button intakeInButton = new JoystickButton(driver1, 5);
    Button intakeOutButton = new JoystickButton(driver1, 6);
    Button shiftButton = new JoystickButton(driver1, 3);
    //Button liftButton = new JoystickButton(operator, 3);
    InternalButton liftTrigger = new InternalButton();
    //Button liftUpButton = new JoystickButton(operator,1);
    //Button liftDownButton = new JoystickButton(operator,2);

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
	    
        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());

        SmartDashboard.putData("Drive", new Drive());

        SmartDashboard.putData("IntakeIn", new IntakeIn());

        SmartDashboard.putData("IntakeOut", new IntakeOut());

        SmartDashboard.putData("LiftToPosition", new LiftToPosition());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        intakeInButton.whileHeld(new IntakeIn());
        intakeOutButton.whileHeld(new IntakeOut());
        shiftButton.whenPressed(new Shift());
        //liftButton.whenPressed(new LiftToPosition());
        liftTrigger.whenActive(new LiftToPosition());
        //liftUpButton.whileHeld(new LiftUp());
        //liftDownButton.whileHeld(new LiftDown());
    }
    
    /**public void runLift(){
    	liftTrigger.setPressed(getTargetLevel()==0 ? false:true);
    }*/
    
    public int getTargetLevel(){
    	return operator.getRawButton(1) ? 1:operator.getRawButton(2)? 2:operator.getRawButton(3)? 3:0;
    }
    
    public double getForwardSpeed(){
    	if(driver1.getRawAxis(3)>0){
    		return driver1.getRawAxis(3);
    	}else if(driver1.getRawAxis(2)>0){
    		return -driver1.getRawAxis(2);
    	}else{
    		return 0;
    	}
    }
    
    public double getTurnSpeed(){
    	return driver1.getRawAxis(0);
    }
    
    public double getLeftJoyForward(){
    	return driver1.getRawAxis(1);
    }
    
    public double getRightJoyTurn(){
    	return driver2.getRawAxis(0);
    }
    
    public double getLiftAxis(){
    	double val = -driver1.getRawAxis(5);
    	if(Math.abs(val)<.3){
    		val=0;
    	}
    	return val;
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getDriver1() {
        return driver1;
    }

    public Joystick getDriver2() {
        return driver2;
    }

    public Joystick getOperator() {
        return operator;
    }

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

