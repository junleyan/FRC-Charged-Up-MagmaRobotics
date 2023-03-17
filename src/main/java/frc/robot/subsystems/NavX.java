// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import java.lang.Math;

public class NavX extends SubsystemBase {


    /**
     * an abstract representation of a physical NavX
     */
    private AHRS navx;
    private PIDController balancePID;
    public boolean calibrated = false; 

    
    /**
     * subsystem base object for NavX
     */
    public NavX() {
        try { 
            this.navx = new AHRS(Port.kMXP);
        } catch (Exception e) {
            System.out.print("Unable to connect to NavX");
        }

        this.balancePID = new PIDController(Constants.PIDController.BalancePID.kP, 
                                            Constants.PIDController.BalancePID.kI, 
                                            Constants.PIDController.BalancePID.kD);
        this.balancePID.setSetpoint(Constants.PIDController.BalancePID.kSetpoint);
    }


    public double getCalculatedBalancePID() {
        double calculatedBalancePID = this.balancePID.calculate(getPitch());
        if(calculatedBalancePID > 1){
            calculatedBalancePID = 1;
        }
        if(calculatedBalancePID < -1){
            calculatedBalancePID = -1;
        }
        SmartDashboard.putNumber("Power", calculatedBalancePID);
        SmartDashboard.putNumber("Balance Error", Constants.PIDController.BalancePID.kSetpoint - getPitch());
        SmartDashboard.putNumber("Setpoint", Constants.PIDController.BalancePID.kSetpoint);
        return calculatedBalancePID;
    }

    public boolean checkCalculatedBalancePID(){
        double calculatedBalancePID = this.balancePID.calculate(getPitch());
        if (Math.abs(calculatedBalancePID) < 2){
            calculatedBalancePID = 0;
            return true;
        }
        return false;
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
        SmartDashboard.putNumber("NavX Pitch", this.navx.getPitch());
        return this.navx.getPitch();
    }


    /**
     * @return returns the roll of the NavX 
     */
    public double getRoll(){
        return this.navx.getRoll();
    }


    // public void calibrate() {
    //     this.navx.calibrate();
    //     this.calibrated = true; 
    // }


}