// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.arm.LowerArmDown;
import frc.robot.commands.arm.LowerArmStop;
import frc.robot.commands.arm.LowerArmUp;
import frc.robot.commands.arm.UpperArmDown;
import frc.robot.commands.arm.UpperArmStop;
import frc.robot.commands.arm.UpperArmUp;
import frc.robot.commands.claw.ClawClose;
import frc.robot.commands.claw.ClawOpen;
import frc.robot.commands.claw.ClawStop;
import frc.robot.commands.clawservo.ClawServoDown;
import frc.robot.commands.clawservo.ClawServoStop;
import frc.robot.commands.clawservo.ClawServoUp;
import frc.robot.commands.drive.DriveTrainCommand;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.ClawServo;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.NavX;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

    
    // The robot's subsystems and commands are defined here... 
    DriveTrain driveTrain;
    Arm arm;
    NavX navx;
    ClawServo clawServo;
    Claw claw;

    XboxController driversController, driverPartnerController;
    JoystickButton buttonA, buttonB, buttonX, buttonY, rightBumper, leftBumper;
    POVButton upPOV, downPOV, leftPOV, rightPOV;

    UsbCamera camera_a; 
    UsbCamera camera_b;
    
    
    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        this.navx = new NavX();
        this.driveTrain = new DriveTrain();
        this.arm = new Arm();
        this.clawServo = new ClawServo();
        this.claw = new Claw();

        this.driversController = new XboxController(Constants.Control.ControllerPort.kDRIVER);
        this.driverPartnerController = new XboxController(Constants.Control.ControllerPort.kPARTNER);
        this.buttonA = new JoystickButton(driverPartnerController, Constants.Control.Button.kA);
        this.buttonB = new JoystickButton(driverPartnerController, Constants.Control.Button.kB);
        this.buttonX = new JoystickButton(driverPartnerController, Constants.Control.Button.kX);
        this.buttonY = new JoystickButton(driverPartnerController, Constants.Control.Button.kY);
        this.rightBumper = new JoystickButton(driverPartnerController, Constants.Control.Button.kRIGHT_BUMPER);
        this.leftBumper = new JoystickButton(driverPartnerController, Constants.Control.Button.kLEFT_BUMPER);
        this.upPOV = new POVButton(driverPartnerController, Constants.Control.POVButton.kUP);
        this.downPOV = new POVButton(driverPartnerController, Constants.Control.POVButton.kDOWN);
        this.leftPOV = new POVButton(driverPartnerController, Constants.Control.POVButton.kLEFT);
        this.rightPOV = new POVButton(driverPartnerController, Constants.Control.POVButton.kRIGHT);
      
        this.driveTrain.setDefaultCommand(new DriveTrainCommand(this.driveTrain, this.driversController, this.navx));
        this.camera_a = CameraServer.startAutomaticCapture(0);
        this.camera_b = CameraServer.startAutomaticCapture(1);

        this.camera_a.setResolution(240, 140);
        this.camera_b.setResolution(240, 140);
        this.camera_a.setFPS(7);
        this.camera_b.setFPS(7);
        
        // Configure the trigger bindings
        this.configureBindings();
    }


    /**
     * Use this method to define your trigger->command mappings. Triggers can be created via the
     * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
     * predicate, or via the named factories in {@link
     * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
     * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
     * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
     * joysticks}.
     */
    private void configureBindings() {
        // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
        this.upPOV.onTrue(new UpperArmDown(this.arm)).onFalse(new UpperArmStop(this.arm));
        this.downPOV.onTrue(new UpperArmUp(this.arm)).onFalse(new UpperArmStop(this.arm));
        this.leftPOV.onTrue(new LowerArmUp(this.arm)).onFalse(new LowerArmStop(this.arm));
        this.rightPOV.onTrue(new LowerArmDown(this.arm)).onFalse(new LowerArmStop(this.arm));
        this.buttonX.onTrue(new ClawOpen(this.claw)).onFalse(new ClawStop(this.claw));
        this.buttonY.onTrue(new ClawClose(this.claw)).onFalse(new ClawStop(this.claw));
        this.rightBumper.onTrue(new ClawServoUp(this.clawServo)).onFalse(new ClawServoStop(this.clawServo));
        this.leftBumper.onTrue(new ClawServoDown(this.clawServo)).onFalse(new ClawServoStop(this.clawServo));
    }


    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        return new SequentialCommandGroup(
        // Auto 1
            // new Movement(this.driveTrain, 0, 0, 0)
        // Auto 2
            // new Movement(this.driveTrain, 1000, -0.5, -0.5),
            // new Movement(this.driveTrain, 1000, 0.5, 0.5)
        // Last Resort
            // new Movement(this.driveTrain, 0, 1, 1),
            // new AutoBalance(this.driveTrain, this.navx)
        );
        //Just edit the times and power
      }


}