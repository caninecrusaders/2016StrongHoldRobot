// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4980.TestRobot;

import org.usfirst.frc4980.TestRobot.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import com.kauailabs.navx.frc.AHRS;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick joystick1 = new Joystick(1);
	AHRS ahrs = null;
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
    public JoystickButton joystick_R_Bumper;
    public JoystickButton joystickButtonA;
    public JoystickButton joystickButton6;
    public JoystickButton joystickButtonB;
    public JoystickButton joystickButtonX;
    public JoystickButton joystick_L_Bumper;
    public JoystickButton dpadLeftButton;
    public JoystickButton dpadRightButton;
    public JoystickButton dpadDownwardButton;
    public JoystickButton dpadUpwardButton;
    public JoystickButton joystickButtonStart;
    public JoystickButton joystickButtonY;
    public Joystick xboxJoystick;
    public JoystickButton button5;
    public JoystickButton button3;
    public JoystickButton button1;
    public JoystickButton button2;
    public JoystickButton button4;
    public JoystickButton button6;
    public JoystickButton button7;
    public JoystickButton button8;
    public JoystickButton button9;
    public JoystickButton button12;
    public JoystickButton button10;
    public JoystickButton button11;
    public Joystick controlPanel;
    public JoystickButton travisButton7;
    public JoystickButton travisButton8;
    public JoystickButton travisButton9;
    public JoystickButton travisButton10;
    public JoystickButton travisButton2;
    public JoystickButton travisButton5;
    public JoystickButton travisButton6;
    public JoystickButton travisButton1;
    public JoystickButton travisButton3;
    public Joystick travis;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
//    	button10 = new JoystickButton(controlPanel, 10);
//        button10.whenPressed(new FieldOrientation(-90.0));
//        button9 = new JoystickButton(controlPanel, 9);
//        button9.whenPressed(new FieldOrientation(180.0));
//        button8 = new JoystickButton(controlPanel, 8);
//        button8.whenPressed(new FieldOrientation(90.0));
//        button7 = new JoystickButton(controlPanel, 7);
//        button7.whenPressed(new FieldOrientation(0.0));
       
    	
    	try{
        	
    	   ahrs = new AHRS(SPI.Port.kMXP);
	    }catch(RuntimeException ex){
	    	DriverStation.reportError("Error instantiating navX-MXP:   "+ex.getMessage(), true);
	    }
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        travis = new Joystick(2);
        
        travisButton3 = new JoystickButton(travis, 3);
        travisButton3.whenPressed(new ToggleClimber());
        travisButton1 = new JoystickButton(travis, 1);
        travisButton1.whenPressed(new ToggleDefensiveArm());
        travisButton6 = new JoystickButton(travis, 6);
        travisButton6.whenPressed(new CylinderLow());
        travisButton5 = new JoystickButton(travis, 5);
        travisButton5.whenPressed(new CylinderHigh());
        travisButton2 = new JoystickButton(travis, 2);
        travisButton2.whenPressed(new DriveSpeedDamper());
        travisButton10 = new JoystickButton(travis, 10);
        travisButton10.whenPressed(new FieldOrientation());
        travisButton9 = new JoystickButton(travis, 9);
        travisButton9.whenPressed(new FieldOrientation());
        travisButton8 = new JoystickButton(travis, 8);
        travisButton8.whenPressed(new FieldOrientation());
        travisButton7 = new JoystickButton(travis, 7);
        travisButton7.whenPressed(new FieldOrientation());
        controlPanel = new Joystick(1);
        
        button11 = new JoystickButton(controlPanel, 11);
        button11.whenPressed(new ShooterMotorDown());
        button10 = new JoystickButton(controlPanel, 10);
        button10.whenPressed(new FieldOrientation());
        button12 = new JoystickButton(controlPanel, 12);
        button12.whenPressed(new ShooterMotorUp());
        button9 = new JoystickButton(controlPanel, 9);
        button9.whenPressed(new FieldOrientation());
        button8 = new JoystickButton(controlPanel, 8);
        button8.whenPressed(new FieldOrientation());
        button7 = new JoystickButton(controlPanel, 7);
        button7.whenPressed(new FieldOrientation());
        button6 = new JoystickButton(controlPanel, 6);
        button6.whenPressed(new CylinderLow());
        button4 = new JoystickButton(controlPanel, 4);
        button4.whenPressed(new EmergencyStop());
        button2 = new JoystickButton(controlPanel, 2);
        button2.whenPressed(new CylinderContract());
        button1 = new JoystickButton(controlPanel, 1);
        button1.whenPressed(new CylinderExtend());
        button3 = new JoystickButton(controlPanel, 3);
        button3.whenPressed(new ToggleDefensiveArm());
        button5 = new JoystickButton(controlPanel, 5);
        button5.whenPressed(new CylinderHigh());
        xboxJoystick = new Joystick(0);
        
        joystickButtonY = new JoystickButton(xboxJoystick, 4);
        joystickButtonY.whenPressed(new BallShootHigh());
        joystickButtonStart = new JoystickButton(xboxJoystick, 8);
        joystickButtonStart.whenPressed(new DriveStop());
        dpadUpwardButton = new JoystickButton(xboxJoystick, 13);
        dpadUpwardButton.whenPressed(new CameraTiltUp());
        dpadDownwardButton = new JoystickButton(xboxJoystick, 14);
        dpadDownwardButton.whenPressed(new CameraTiltDown());
        dpadRightButton = new JoystickButton(xboxJoystick, 12);
        dpadRightButton.whenPressed(new CameraPanRight());
        dpadLeftButton = new JoystickButton(xboxJoystick, 11);
        dpadLeftButton.whenPressed(new CameraPanLeft());
        joystick_L_Bumper = new JoystickButton(xboxJoystick, 5);
        joystick_L_Bumper.whenPressed(new TurnToCounterClockwise());
        joystickButtonX = new JoystickButton(xboxJoystick, 3);
        joystickButtonX.whenPressed(new InvertControl());
        joystickButtonB = new JoystickButton(xboxJoystick, 2);
        joystickButtonB.whenPressed(new BallShoot());
        joystickButton6 = new JoystickButton(xboxJoystick, 6);
        joystickButton6.whenPressed(new TurnClockwise());
        joystickButtonA = new JoystickButton(xboxJoystick, 1);
        joystickButtonA.whenPressed(new ToggleDefensiveArm());
        joystick_R_Bumper = new JoystickButton(xboxJoystick, 6);
        joystick_R_Bumper.whenPressed(new TurnClockwise());


        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("DriveWithJoystick", new DriveWithJoystick());
        SmartDashboard.putData("DriveUnderLowBar", new DriveUnderLowBar());
        SmartDashboard.putData("CylinderContract", new CylinderContract());
        SmartDashboard.putData("AutonomousDriveForward", new AutonomousDriveForward());
        SmartDashboard.putData("TurnClockwise", new TurnClockwise());
        SmartDashboard.putData("TurnToCounterClockwise", new TurnToCounterClockwise());
        SmartDashboard.putData("DriveStop", new DriveStop());
        SmartDashboard.putData("Command Group 2", new CommandGroup2());
        SmartDashboard.putData("CameraPanLeft", new CameraPanLeft());
        SmartDashboard.putData("CameraPanRight", new CameraPanRight());
        SmartDashboard.putData("CameraTiltUp", new CameraTiltUp());
        SmartDashboard.putData("CameraTiltDown", new CameraTiltDown());
        SmartDashboard.putData("CameraPanNeutral", new CameraPanNeutral());
        SmartDashboard.putData("CameraControl", new CameraControl());
        SmartDashboard.putData("BallCapture", new BallCapture());
        SmartDashboard.putData("BallShootLow", new BallShootLow());
        SmartDashboard.putData("BallShootHigh", new BallShootHigh());
        SmartDashboard.putData("ShooterMotorUp", new ShooterMotorUp());
        SmartDashboard.putData("BallShoot", new BallShoot());
        SmartDashboard.putData("ShooterMotorDown", new ShooterMotorDown());
        SmartDashboard.putData("ShootLow", new ShootLow());
        SmartDashboard.putData("CylinderHigh", new CylinderHigh());
        SmartDashboard.putData("CylinderMedium", new CylinderMedium());
        SmartDashboard.putData("CylinderLow", new CylinderLow());
        SmartDashboard.putData("CylinderExtend", new CylinderExtend());
        SmartDashboard.putData("Climb", new Climb());
        SmartDashboard.putData("ControlAngle", new ControlAngle());
        SmartDashboard.putData("SetCountLow", new SetCountLow());
        SmartDashboard.putData("SetCountHigh", new SetCountHigh());
        SmartDashboard.putData("AutoNothing", new AutoNothing());
        SmartDashboard.putData("AutoChallengeDefense", new AutoChallengeDefense());
        SmartDashboard.putData("AutoCrossDefense", new AutoCrossDefense());
        SmartDashboard.putData("AutoCrossDefAndShootLow", new AutoCrossDefAndShootLow());
        SmartDashboard.putData("AutoCrossDefAndShootHigh", new AutoCrossDefAndShootHigh());
        SmartDashboard.putData("DemoNight", new DemoNight());
        SmartDashboard.putData("FieldOrientation", new FieldOrientation());
        SmartDashboard.putData("ShooterMotorAngle", new ShooterMotorAngle());
        SmartDashboard.putData("Spin", new Spin());
        SmartDashboard.putData("SpinLeft", new SpinLeft());
        SmartDashboard.putData("DriveSpeedDamper", new DriveSpeedDamper());
        SmartDashboard.putData("EmergencyStop", new EmergencyStop());
        SmartDashboard.putData("AutoCrossDefenseArmDown", new AutoCrossDefenseArmDown());
        SmartDashboard.putData("InvertControl", new InvertControl());
        SmartDashboard.putData("ToggleClimber", new ToggleClimber());
        SmartDashboard.putData("ToggleDefensiveArm", new ToggleDefensiveArm());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
    public Joystick getJoystick1(){
    	return joystick1;
    }
    
    public void setAHRS(AHRS ahrsIN){	
    	ahrs = ahrsIN;
    	
    }
    public AHRS getAHRS (){
    	return ahrs;
    }
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getxboxJoystick() {
        return xboxJoystick;
    }

    public Joystick getControlPanel() {
        return controlPanel;
    }

    public Joystick getTravis() {
        return travis;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}
