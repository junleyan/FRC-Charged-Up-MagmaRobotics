// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Arm extends SubsystemBase {


  /**
   * an abstract representation of a physical robot arm
   */
  private final Spark lowerArm;
  

  /**
   * subsystem base object for arm
   */
  public Arm() {
    lowerArm = new Spark(Constants.Subsystems.Arm.port);
  }


  /**
   * arm goes up by setting power on the arm motor
   */
  public void up() {
    lowerArm.set(Constants.Subsystems.Arm.speed);
  }


  /**
   * arm goes down by setting power on the arm motor
   */
  public void down(){
    lowerArm.set(-Constants.Subsystems.Arm.speed);
  }


  /**
   * calls stopMotor method within {@link edu.wpi.first.wpilibj.drive.DifferentialDrive}
   * to stop motors
   */
  public void stop(){
    lowerArm.stopMotor();
  }

  
}