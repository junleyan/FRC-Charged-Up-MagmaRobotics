// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PS4Controller.Button;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Arm extends SubsystemBase {

  public Spark lowerArm;
  
  public Arm() {
    lowerArm = new Spark(Constants.Subsystems.Arm.port);
  }

  public void run() {
    lowerArm.set(Constants.Subsystems.Arm.speed);
  }

  public void reverse(){
    lowerArm.set(-Constants.Subsystems.Arm.speed);
  }

  public void stop(){
    lowerArm.stopMotor();
  }

}