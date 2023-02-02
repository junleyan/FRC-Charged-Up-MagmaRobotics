// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class NavX extends SubsystemBase {


    /**
     * an abstract representation of a physical NavX
     */
    private AHRS navx;
    private PIDController balancePID;

    public boolean calibrated = false; 

    private double kP = 0.1;
    private double kI = 0.01;
    private double kD = 0.05;

    
    /**
     * subsystem base object for NavX
     */
    public NavX() {
        this.navx = new AHRS(Port.kMXP);
        this.balancePID = new PIDController(kP, kI, kD);

        this.balancePID.setSetpoint(0);
        this.balancePID.setIntegratorRange(-1, 1);
    }


    public double getCalculatedBalancePID() {
        System.out.println(this.balancePID.calculate(getPitch()));
        return this.balancePID.calculate(getPitch());
    }


    /**
     * @return returns the yaw of the NavX 
     */
    public double getYaw() {
        return this.navx.getYaw();
    }


    /**
     * @return returns the pitch of the NavX 
     */
    public double getPitch(){
        return this.navx.getPitch();
    }


    /**
     * @return returns the roll of the NavX 
     */
    public double getRoll(){
        return this.navx.getRoll();
    }


    public void calibrate() {
        this.navx.calibrate();
        this.calibrated = true; 
    }


}