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
    private Spark lowerArm;
    private Spark upperArm;
  

    /**
     * subsystem base object for arm
     */
    public Arm() {
        try {
            this.lowerArm = new Spark(Constants.Subsystems.LowerArm.port);
            System.out.println("Subsystem Log: Lower arm is configured to port " + Constants.Subsystems.LowerArm.port);
        } 
        catch(Exception e) {
            System.out.println("Subsystem Log: Lower arm failed to be configured to port " + Constants.Subsystems.LowerArm.port);
        }  

        try {
            this.upperArm = new Spark(Constants.Subsystems.UpperArm.port);
            System.out.println("Subsystem Log: Lower arm is configured to port " + Constants.Subsystems.UpperArm.port);
        } 
        catch(Exception e) {
            System.out.println("Subsystem Log: Lower arm failed to be configured to port " + Constants.Subsystems.UpperArm.port);
        }   
    }


    /**
     * arm goes up by setting power on the arm motor
     */
    public void up() {
        this.lowerArm.set(-Constants.Subsystems.LowerArm.speed);
        this.upperArm.set(Constants.Subsystems.UpperArm.speed);
        System.out.println("Command Log: Arm is going up");
    }


    /**
     * arm goes down by setting power on the arm motor
     */
    public void down(){
        this.lowerArm.set(Constants.Subsystems.LowerArm.speed);
        this.upperArm.set(-Constants.Subsystems.UpperArm.speed);
        System.out.println("Command Log: Arm is going down");
    }


    /**
     * calls stopMotor method within {@link edu.wpi.first.wpilibj.drive.DifferentialDrive}
     * to stop motors
     */
    public void stop(){
        this.lowerArm.stopMotor();
        this.upperArm.stopMotor();
        System.out.println("Command Log: Arm is stopped");
    }

  
}