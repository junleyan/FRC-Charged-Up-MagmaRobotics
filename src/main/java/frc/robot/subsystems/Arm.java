// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Arm extends SubsystemBase {


    /**
     * an abstract representation of a physical robot arm
     */
    private PWMSparkMax lowerArm;
    private PWMSparkMax upperArm;
    private PWMSparkMax lowerSecondArm;
    private PWMSparkMax upperSecondArm;
  

    /**
     * subsystem base object for arm
     */
    public Arm() {
        this.lowerArm = new PWMSparkMax(Constants.Subsystems.LowerArm.port);
        System.out.println("Subsystem Log: Lower arm is configured to port " + Constants.Subsystems.LowerArm.port);

        this.upperArm = new PWMSparkMax(Constants.Subsystems.UpperArm.port);
        System.out.println("Subsystem Log: Upper arm is configured to port " + Constants.Subsystems.UpperArm.port);

        this.lowerSecondArm = new PWMSparkMax(Constants.Subsystems.LowerSecondArm.port);
        System.out.println("Subsystem Log: Lower  second arm is configured to port " + Constants.Subsystems.LowerSecondArm.port);

        this.upperSecondArm = new PWMSparkMax(Constants.Subsystems.UpperSecondArm.port);
        System.out.println("Subsystem Log: Upper second arm is configured to port " + Constants.Subsystems.UpperSecondArm.port);
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
     * second arm goes up by setting power on the arm motor
     */
    public void upSecond() {
        this.lowerSecondArm.set(-Constants.Subsystems.LowerSecondArm.speed);
        this.upperSecondArm.set(Constants.Subsystems.UpperSecondArm.speed);
        System.out.println("Command Log: Second arm is going up");
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
     * second arm goes down by setting power on the arm motor
     */
    public void downSecond() {
        this.lowerSecondArm.set(Constants.Subsystems.LowerSecondArm.speed);
        this.upperSecondArm.set(-Constants.Subsystems.UpperSecondArm.speed);
        System.out.println("Command Log: Second arm is going up");
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


    /**
     * calls stopMotor method within {@link edu.wpi.first.wpilibj.drive.DifferentialDrive}
     * to stop motors
     */
    public void stopSecond(){
        this.lowerSecondArm.stopMotor();
        this.upperSecondArm.stopMotor();
        System.out.println("Command Log: Second arm is stopped");
    }

  
}