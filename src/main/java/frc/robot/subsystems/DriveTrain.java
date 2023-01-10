// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveTrain extends SubsystemBase {

  private MotorController leftMotor, rightMotor;
  public DifferentialDrive diffDrive;
  
  public DriveTrain() {
    leftMotor = new PWMSparkMax(Constants.PWM.leftDrive);
    rightMotor = new PWMSparkMax(Constants.PWM.rightDrive);
    diffDrive = new DifferentialDrive(leftMotor, rightMotor);
  }

  public void stopMotor() {
    diffDrive.stopMotor();
  }

  // Differential drive
  public void tankDrive(double leftSpeed, double rightSpeed) {
    diffDrive.tankDrive(-leftSpeed, rightSpeed);
  }


}