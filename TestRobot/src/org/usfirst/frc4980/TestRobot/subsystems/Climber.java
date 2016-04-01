// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4980.TestRobot.subsystems;

import org.usfirst.frc4980.TestRobot.RobotMap;
import org.usfirst.frc4980.TestRobot.commands.*;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Climber extends Subsystem {
	public final int kHigh = 1;
	public final int kMed = 0;
	public final int kLow = -1;
	public int climberPosition = kMed;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final DoubleSolenoid doubleSolenoidClimber = RobotMap.climberDoubleSolenoidClimber;
    private final SpeedController leftMotor = RobotMap.climberLeftMotor;
    private final SpeedController rightMotor = RobotMap.climberRightMotor;
    private final Solenoid solenoidPivotUp = RobotMap.climberSolenoidPivotUp;
    private final Solenoid solenoidPivotDown = RobotMap.climberSolenoidPivotDown;
    private final Solenoid singleSolenoidClimbWheels = RobotMap.climberSingleSolenoidClimbWheels;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.
   public Climber(){
	   doubleSolenoidClimber.set(DoubleSolenoid.Value.kOff);
	   solenoidPivotUp.set(false);
	   solenoidPivotDown.set(false);
   }
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
   public void ClimberUp(){
	   //leftMotor.set(1.0);
	   //rightMotor.set(1.0);
	  solenoidPivotUp.set(true);
	  solenoidPivotDown.set(false);
   }
   public void ClimberDown() {
	   //leftMotor.set(-1.0);
	   //rightMotor.set(-1.0);
	   solenoidPivotDown.set(true);
	   solenoidPivotUp.set(false);
	   
   }
   public void ClimberStop(){
	  // leftMotor.set(0.0);
	  // rightMotor.set(0.0);
	 solenoidPivotUp.set(false);
	 solenoidPivotDown.set(false);
   }
   public void ClimberHold(){
		  // leftMotor.set(0.0);
		  // rightMotor.set(0.0);
		 solenoidPivotUp.set(false);
		 solenoidPivotDown.set(false);
	   }
   public void ClimberExtend(){
	   doubleSolenoidClimber.set(DoubleSolenoid.Value.kReverse);
	   singleSolenoidClimbWheels.set(false);
	   
   }
   public void ClimberContract(){
	   doubleSolenoidClimber.set(DoubleSolenoid.Value.kForward);
	   singleSolenoidClimbWheels.set(true);
   }
  
}
