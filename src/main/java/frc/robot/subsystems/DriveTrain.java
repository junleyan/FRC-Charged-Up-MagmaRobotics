// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import java.lang.Math;


public class DriveTrain extends SubsystemBase {

  private MotorController leftMotor, rightMotor;
  public DifferentialDrive diffDrive;
  
  public DriveTrain() {
    leftMotor = new PWMSparkMax(Constants.PWM.leftDrive);
    rightMotor = new PWMSparkMax(Constants.PWM.rightDrive);
    diffDrive = new DifferentialDrive(leftMotor, rightMotor);
  }

  /**
   * calls stopMotor method within {@link edu.wpi.first.wpilibj.drive.DifferentialDrive}
   * to stop motors
   */
  public void stopMotor() {
    diffDrive.stopMotor();
  }


  /**
   * {@param speed the speed multiplier}
   */
  public double adjustedSpeed(double speed){
    if (-speed <= 0){
      return 0.5-(Math.abs(-speed) / 2);
    } 
    return (-speed/2) + 0.5;
  }

  public void arcadeDriveWithJoystick(double position, double angle, double speed) {
    diffDrive.arcadeDrive(-position, -angle * this.adjustedSpeed(speed));
  }

  public void arcadeDriveWithXbox(double position, double angle) {
    diffDrive.arcadeDrive(-position, -angle);
  }

  public void diffDrive(double leftPower, double rightPower) {
    diffDrive.tankDrive(-leftPower, -rightPower);
  }


}