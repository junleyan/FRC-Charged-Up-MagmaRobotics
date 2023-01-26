// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;


public class Tabs extends SubsystemBase {


    /**
     * an abstract representation of the shuffleboard
     */
    private GenericEntry entry; 
  

    /**
     * subsystem base object for NavX
     */
    public Tabs() {
        
    }


    /**
     * This method will be called once per scheduler run
     * @param 
     */
    @Override
    public void periodic() {
    }


}