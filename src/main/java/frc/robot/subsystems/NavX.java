// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class NavX extends SubsystemBase {


    /**
     * an abstract representation of a physical NavX
     */
    private AHRS navx;
  

    /**
     * subsystem base object for NavX
     */
    public NavX() {
        this.navx = new AHRS(Port.kMXP);
    }


    /**
     * @return returns the yaw of the NavX 
     */
    public double getYaw() {
        return this.navx.getYaw();
    }

    public double getPitch(){
        return this.navx.getPitch();
    }
    public double getRoll(){
        return this.navx.getRoll();
    }

  
}