// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class Arm extends SubsystemBase {


    /**
     * an abstract representation of a physical robot arm
     */
    private PWMSparkMax lowerArm, lowerArm2, upperMiddleArm;
    private CANSparkMax lowerArm, lowerArm2, upperMiddleArm;

  
    /**
     * subsystem base object for arm
     */
    public Arm() {
        //this.lowerArm = new PWMSparkMax(Constants.Subsystems.LowerArm2.kPORT);
        this.lowerArm = new CANSparkMax(6, MotorType.kBrushless);
        System.out.println("Subsystem Log: Lower arm is configured to port " + Constants.Subsystems.LowerArm2.kPORT);

        //this.lowerArm2 = new PWMSparkMax(Constants.Subsystems.LowerArm.kPORT);
        //System.out.println("Subsystem Log: Upper arm is configured to port " + Constants.Subsystems.LowerArm.kPORT);

        //this.upperMiddleArm = new PWMSparkMax(Constants.Subsystems.UpperMiddleArm.kPORT);
        //System.out.println("Subsystem Log: Lower second arm is configured to port " + Constants.Subsystems.UpperMiddleArm.kPORT);
        
    }


    /**
     * arm goes up by setting power on the arm motor
     */
    public void lowerArmUp() {
        this.lowerArm.set(Constants.Subsystems.LowerArm2.kPOWER);
        this.lowerArm2.set(-Constants.Subsystems.LowerArm.kPOWER);
        System.out.println("Command Log: Lower arm is going up");
    }

    /**
     * arm goes down by setting power on the arm motor
     */
    public void lowerArmDown() {
        this.lowerArm.set(-Constants.Subsystems.LowerArm2.kPOWER);
        this.lowerArm2.set(Constants.Subsystems.LowerArm.kPOWER);
        System.out.println("Command Log: Lower arm is going down");
    }


    /**
     * calls stopMotor method within {@link edu.wpi.first.wpilibj.drive.DifferentialDrive}
     * to stop motors
     */
    public void lowerArmStop() {
        this.lowerArm.stopMotor();
        this.lowerArm2.stopMotor();
        System.out.println("Command Log: Lower arm is stopped");
    }


    /**
     * second arm goes up by setting power on the arm motor
     */
    public void upperArmUp() {
        this.upperMiddleArm.set(Constants.Subsystems.UpperMiddleArm.kPOWER);
        System.out.println("Command Log: Upper arm is going up");
    }


     /**
     * second arm goes down by setting power on the arm motor
     */
    public void upperArmDown() {
        this.upperMiddleArm.set(-Constants.Subsystems.UpperMiddleArm.kPOWER);
        System.out.println("Command Log: Upper arm is going up");
    }


    /**
     * calls stopMotor method within {@link edu.wpi.first.wpilibj.drive.DifferentialDrive}
     * to stop second motors
     */
    public void upperArmStop() {
        this.upperMiddleArm.stopMotor();
        System.out.println("Command Log: Upper arm is stopped");
    }

  
}