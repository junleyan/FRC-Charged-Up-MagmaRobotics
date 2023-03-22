// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Arduino extends SubsystemBase {


    /**
     * an abstract representation of a physical robot arm
     */
    private SerialPort arduino;

  
    /**
     * subsystem base object for arm
     */
    public Arduino() {
        try {
            arduino = new SerialPort(9600, SerialPort.Port.kUSB);
            System.out.println("Connected on kUSB!");
        } catch (Exception e) {
            System.out.println("Failed to connect on kUSB, trying kUSB 1");
      
            try {
              arduino = new SerialPort(9600, SerialPort.Port.kUSB1);
              System.out.println("Connected on kUSB1!");
            } catch (Exception e1) {
              System.out.println("Failed to connect on kUSB1, trying kUSB 2");
      
              try {
                arduino = new SerialPort(9600, SerialPort.Port.kUSB2);
                System.out.println("Connected on kUSB2!");
              } catch (Exception e2) {
                System.out.println("Failed to connect on kUSB2, all connection attempts failed!");
              }
            }
        }

    }

    public String getSelectedMode() {
        arduino.write(new byte[] {0x12}, 1);
        return this.arduino.readString();
    }
  
}