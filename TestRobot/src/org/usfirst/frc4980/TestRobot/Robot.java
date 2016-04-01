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

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc4980.TestRobot.commands.*;
import org.usfirst.frc4980.TestRobot.subsystems.*;
import com.kauailabs.navx.frc.AHRS;
//import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
//import edu.wpi.first.wpilibj.I2C;
//import edu.wpi.first.wpilibj.SerialPort;
//import edu.wpi.first.wpilibj.SampleRobot;
//import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot{ 
public static double cameraPan;
public static double cameraTilt;
public static final int kObstacleLowBar = 0;
public static final int kObstacleRoughTerrain = 1;
public static final int kObstacleRamparts = 2;
public static final int kObstacleRockWall = 3;
public static final int kObstacleMoat = 4;
public static final int kObstaclePortcullis = 5;
public static final int kObstacleChival = 6;
public static final int kObstacleDoubleNothing = 7;
public static final int kObstacleDoubleCross = 8;
public static boolean isClimberUp = false;
public static boolean isDefensiveArmUp = true;
public static boolean isFieldOrienting = false;

	public static int obstacleChoice;
	public static int doubleCrossChoice;
	
    Command autonomousCommand;
    SendableChooser autoChooser;
    SendableChooser obstacleChooser;
    SendableChooser doubleObstacleChooser;
    
    
    AHRS ahrs;
    

    public static OI oi;
    public static double startingYaw;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DriveSystem driveSystem;
    public static Camera camera;
    public static ShooterElevator shooterElevator;
    public static ShooterWheels shooterWheels;
    public static Climber climber;
    public static DefensiveArm defensiveArm;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    RobotMap.init();
    cameraPan = 0.5;
    cameraTilt = 0.5;
    
    
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveSystem = new DriveSystem();
        camera = new Camera();
        shooterElevator = new ShooterElevator();
        shooterWheels = new ShooterWheels();
        climber = new Climber();
        defensiveArm = new DefensiveArm();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands 
        //(which it very likely will), subsystems are not guaranteed to be 
        // constructed yet. Thus, their requires() statements may grab null 
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // instantiate the command used for the autonomous period
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        autonomousCommand = new AutonomousCommand();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        autoChooser = new SendableChooser();
        autoChooser.addDefault("Challenge Defense", new AutoChallengeDefense());
        autoChooser.addDefault("Cross Defense", new AutoCrossDefenseArmDown());
        autoChooser.addDefault("Do Nothing", new AutoNothing());
        SmartDashboard.putData("Autonomous mode chooser", autoChooser);
        //autoChooser.addDefault("Challenge Defense", new AutoChallengeDefense());
       /// autoChooser.addDefault("Cross Defense", new AutoCrossDefense());
//        autoChooser.addDefault("1 second Turn Right", new AutonomousCommand(1));
//        autoChooser.addDefault("0.5 second Turn Right", new AutonomousCommand(0.5));
//        autoChooser.addObject("Drive straight", new AutonomousDriveForward(30));
//        autoChooser.addObject("5 seconds", new AutonomousDriveForward(5));
//        autoChooser.addObject("12 seconds", new AutonomousDriveForward(12));
//        autoChooser.addObject("1 seconds", new AutonomousDriveForward(1));
//        autoChooser.addObject("Drive Under Low Bar", new DriveUnderLowBar());
        
        obstacleChooser = new SendableChooser();
        obstacleChooser.addDefault("Low Bar", kObstacleLowBar);
        obstacleChooser.addDefault("Rough Terrain", kObstacleRoughTerrain);
        obstacleChooser.addDefault("Ramparts", kObstacleRamparts);
        obstacleChooser.addDefault("Rock Wall", kObstacleRockWall);
        obstacleChooser.addDefault("Moat", kObstacleMoat);
        SmartDashboard.putData("Obstacle Chooser", obstacleChooser);
        
        doubleObstacleChooser = new SendableChooser();
        doubleObstacleChooser.addDefault("Do Nothing", kObstacleDoubleNothing);
        doubleObstacleChooser.addDefault("Cross Back", kObstacleDoubleCross);
        SmartDashboard.putData("Cross twice?", doubleObstacleChooser);
       
        
        
        ahrs = oi.getAHRS();
        startingYaw = ahrs.getYaw();
        
    }

    
    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
    	autonomousCommand = (Command) autoChooser.getSelected();
    	autonomousCommand.start();
    	obstacleChoice = (int) obstacleChooser.getSelected();
    	doubleCrossChoice = (int)doubleObstacleChooser.getSelected();
    	
        // schedule the autonomous command (example)
        if (autonomousCommand != null){
        	autonomousCommand.start();
        }else{
        	autonomousCommand = new AutoCrossDefenseArmDown();
        	autonomousCommand.start();
        }
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        Robot.driveSystem.getRange();
        
        SmartDashboard.putNumber(   "Bosch current count",            Robot.shooterElevator.currentCount);
        SmartDashboard.putNumber(   "Bosch current count",            Robot.shooterElevator.currentCount);
        //SmartDashboard.putBoolean(   "Trigger-InWindow",            Robot.shooterElevator.analogTrigger.getInWindow());
       // SmartDashboard.putBoolean(   "Trigger-State",            Robot.shooterElevator.analogTrigger.getTriggerState());
        // boolean zero_yaw_pressed = oi.getxBoxJoystick().getTrigger();
        
       // if ( zero_yaw_pressed ) {
       //    ahrs.zeroYaw();
       //}

        /* Display 6-axis Processed Angle Data                                      */
          SmartDashboard.putData(driveSystem);
          SmartDashboard.putData(shooterElevator);
          SmartDashboard.putData(shooterWheels);
          SmartDashboard.putData(climber);
          // SmartDashboard.putBoolean(  "IMU_Connected",        ahrs.isConnected());
       // SmartDashboard.putBoolean(  "IMU_IsCalibrating",    ahrs.isCalibrating());
        SmartDashboard.putNumber(   "IMU_Yaw",              ahrs.getYaw());
        SmartDashboard.putNumber(   "IMU_Pitch",            ahrs.getPitch());
        SmartDashboard.putNumber(   "IMU_Roll",             ahrs.getRoll());
        
        /* Display tilt-corrected, Magnetometer-based heading (requires             */
        /* magnetometer calibration to be useful)                                   */
        
        //SmartDashboard.putNumber(   "IMU_CompassHeading",   ahrs.getCompassHeading());
        
        /* Display 9-axis Heading (requires magnetometer calibration to be useful)  */
       // SmartDashboard.putNumber(   "IMU_FusedHeading",     ahrs.getFusedHeading());

        /* These functions are compatible w/the WPI Gyro Class, providing a simple  */
        /* path for upgrading from the Kit-of-Parts gyro to the navx MXP            */
        
       // SmartDashboard.putNumber(   "IMU_TotalYaw",         ahrs.getAngle());
      //  SmartDashboard.putNumber(   "IMU_YawRateDPS",       ahrs.getRate());

        /* Display Processed Acceleration Data (Linear Acceleration, Motion Detect) */
        
       // SmartDashboard.putNumber(   "IMU_Accel_X",          ahrs.getWorldLinearAccelX());
       // SmartDashboard.putNumber(   "IMU_Accel_Y",          ahrs.getWorldLinearAccelY());
       // SmartDashboard.putBoolean(  "IMU_IsMoving",         ahrs.isMoving());
       // SmartDashboard.putBoolean(  "IMU_IsRotating",       ahrs.isRotating());

        /* Display estimates of velocity/displacement.  Note that these values are  */
        /* not expected to be accurate enough for estimating robot position on a    */
        /* FIRST FRC Robotics Field, due to accelerometer noise and the compounding */
        /* of these errors due to single (velocity) integration and especially      */
        /* double (displacement) integration.                                       */
        
       // SmartDashboard.putNumber(   "Velocity_X",           ahrs.getVelocityX());
       // SmartDashboard.putNumber(   "Velocity_Y",           ahrs.getVelocityY());
       // SmartDashboard.putNumber(   "Displacement_X",       ahrs.getDisplacementX());
       //SmartDashboard.putNumber(   "Displacement_Y",       ahrs.getDisplacementY());
        
        /* Display Raw Gyro/Accelerometer/Magnetometer Values                       */
        /* NOTE:  These values are not normally necessary, but are made available   */
        /* for advanced users.  Before using this data, please consider whether     */
        /* the processed data (see above) will suit your needs.                     */
        
        //SmartDashboard.putNumber(   "RawGyro_X",            ahrs.getRawGyroX());
        //SmartDashboard.putNumber(   "RawGyro_Y",            ahrs.getRawGyroY());
        //SmartDashboard.putNumber(   "RawGyro_Z",            ahrs.getRawGyroZ());
        //SmartDashboard.putNumber(   "RawAccel_X",           ahrs.getRawAccelX());
        //SmartDashboard.putNumber(   "RawAccel_Y",           ahrs.getRawAccelY());
//        SmartDashboard.putNumber(   "RawAccel_Z",           ahrs.getRawAccelZ());
//        SmartDashboard.putNumber(   "RawMag_X",             ahrs.getRawMagX());
//        SmartDashboard.putNumber(   "RawMag_Y",             ahrs.getRawMagY());
//        SmartDashboard.putNumber(   "RawMag_Z",             ahrs.getRawMagZ());
//        SmartDashboard.putNumber(   "IMU_Temp_C",           ahrs.getTempC());
        
        /* Omnimount Yaw Axis Information                                           */
        /* For more info, see http://navx-mxp.kauailabs.com/installation/omnimount  */
        AHRS.BoardYawAxis yaw_axis = ahrs.getBoardYawAxis();
       // SmartDashboard.putString(   "YawAxisDirection",     yaw_axis.up ? "Up" : "Down" );
       // SmartDashboard.putNumber(   "YawAxis",              yaw_axis.board_axis.getValue() );
        
        /* Sensor Board Information                                                 */
       // SmartDashboard.putString(   "FirmwareVersion",      ahrs.getFirmwareVersion());
        
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
}