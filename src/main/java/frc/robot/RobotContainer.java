// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.arm.ArmDown;
import frc.robot.commands.arm.ArmStop;
import frc.robot.commands.arm.ArmUp;
import frc.robot.commands.claw.ClawClose;
import frc.robot.commands.claw.ClawOpen;
import frc.robot.commands.drive.DriveTrainCommand;
import frc.robot.commands.drive.Movement;
import frc.robot.commands.secondarm.SecondArmDown;
import frc.robot.commands.secondarm.SecondArmStop;
import frc.robot.commands.secondarm.SecondArmUp;

import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.NavX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;


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
    Claw claw;
    NavX navx; 

    XboxController driverController;
    JoystickButton buttonA, buttonB, buttonC, buttonD;
    POVButton upPOV, downPOV;
    
    
    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        this.navx = new NavX();
        this.driveTrain = new DriveTrain();
        this.arm = new Arm();

        this.driverController = new XboxController(Constants.Control.ControllerPort.driver);
        this.buttonA = new JoystickButton(driverController, XboxController.Button.kA.value);
        this.buttonB = new JoystickButton(driverController, XboxController.Button.kB.value);
        this.buttonC = new JoystickButton(driverController, XboxController.Button.kX.value);
        this.buttonD = new JoystickButton(driverController, XboxController.Button.kX.value);
        this.upPOV = new POVButton(driverController, Constants.Control.POVButton.UP);
        this.downPOV = new POVButton(driverController, Constants.Control.POVButton.DOWN);
      
        this.driveTrain.setDefaultCommand(new DriveTrainCommand(this.driveTrain, this.driverController, this.navx));
      
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
        this.upPOV.onTrue(new ArmDown(this.arm)).onFalse(new ArmStop(this.arm));
        this.downPOV.onTrue(new ArmUp(this.arm)).onFalse(new ArmStop(this.arm));
        this.buttonA.onTrue(new SecondArmDown(this.arm)).onFalse(new SecondArmStop(this.arm));
        this.buttonB.onTrue(new SecondArmUp(this.arm)).onFalse(new SecondArmStop(this.arm));
        this.buttonC.onTrue(new ClawOpen(this.claw)).onFalse(new ClawClose(this.claw));
        this.buttonD.onTrue(new ClawClose(this.claw)).onFalse(new ClawClose(this.claw));
    }


    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        return new Movement(this.driveTrain, 2000, 0.5);
    }


}