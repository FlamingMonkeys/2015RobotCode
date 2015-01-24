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
    
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType; import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.smartdashboard.*;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import java.util.Vector;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Encoder drivetrainLeftEncoder;
    public static SpeedController drivetrainLeftMotor;
    public static PIDController drivetrainLeft;
    public static Encoder drivetrainRightEncoder;
    public static SpeedController drivetrainRightMotor;
    public static PIDController drivetrainRight;
    public static SpeedController liftLiftMotor;
    public static DigitalInput liftPosition1;
    public static DigitalInput liftPosition2;
    public static DigitalInput liftPosition3;
    public static SpeedController intakeLeftIntake;
    public static SpeedController intakeRightIntake;
    public static DoubleSolenoid shifterShifter;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    public static Compressor comp;

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drivetrainLeftEncoder = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("Drivetrain", "LeftEncoder", drivetrainLeftEncoder);
        drivetrainLeftEncoder.setDistancePerPulse(1.0);
        drivetrainLeftEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        drivetrainLeftMotor = new Talon(0);
        LiveWindow.addActuator("Drivetrain", "LeftMotor", (Talon) drivetrainLeftMotor);
        
        drivetrainLeft = new PIDController(1.0, 0.0, 0.0, 1.0, drivetrainLeftEncoder, drivetrainLeftMotor, 0.02);
        LiveWindow.addActuator("Drivetrain", "Left", drivetrainLeft);
        drivetrainLeft.setContinuous(false); drivetrainLeft.setAbsoluteTolerance(0.2); 
        drivetrainLeft.setOutputRange(-1.0, 1.0);        

        drivetrainRightEncoder = new Encoder(2, 3, false, EncodingType.k4X);
        LiveWindow.addSensor("Drivetrain", "RightEncoder", drivetrainRightEncoder);
        drivetrainRightEncoder.setDistancePerPulse(1.0);
        drivetrainRightEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        drivetrainRightMotor = new Talon(1);
        LiveWindow.addActuator("Drivetrain", "RightMotor", (Talon) drivetrainRightMotor);
        
        drivetrainRight = new PIDController(1.0, 0.0, 0.0, 1.0, drivetrainRightEncoder, drivetrainRightMotor, 0.02);
        LiveWindow.addActuator("Drivetrain", "Right", drivetrainRight);
        drivetrainRight.setContinuous(true); drivetrainRight.setAbsoluteTolerance(0.2); 
        drivetrainRight.setOutputRange(-1.0, 1.0);        

        liftLiftMotor = new Talon(2);
        LiveWindow.addActuator("Lift", "LiftMotor", (Talon) liftLiftMotor);
        
        liftPosition1 = new DigitalInput(4);
        LiveWindow.addSensor("Lift", "Position1", liftPosition1);
        
        liftPosition2 = new DigitalInput(5);
        LiveWindow.addSensor("Lift", "Position2", liftPosition2);
        
        liftPosition3 = new DigitalInput(6);
        LiveWindow.addSensor("Lift", "Position3", liftPosition3);
        
        intakeLeftIntake = new Talon(3);
        LiveWindow.addActuator("Intake", "LeftIntake", (Talon) intakeLeftIntake);
        
        intakeRightIntake = new Talon(4);
        LiveWindow.addActuator("Intake", "RightIntake", (Talon) intakeRightIntake);
        
        shifterShifter = new DoubleSolenoid(0, 0, 1);      
        LiveWindow.addActuator("Shifter", "Shifter", shifterShifter);
        
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        comp = new Compressor();
        LiveWindow.addActuator("Compressor", "Comp", comp);
        
    }
}
