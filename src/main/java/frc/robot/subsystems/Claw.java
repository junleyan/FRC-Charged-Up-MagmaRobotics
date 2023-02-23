package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Claw extends SubsystemBase {


    private Spark claw; 
    private Counter counter;
    private int position = 0;

    
    // make sure that the deviceID is same as the ID set on the motor controller
    public Claw() {
        this.claw = new Spark(21);
        this.counter = new Counter(new DigitalInput(1));
        //this.encoder = this.claw.getEncoder();
        //this.claw.restoreFactoryDefaults();
        System.out.println("Subsystem Log: Claw is configured to port 56");
    }


    public void stop() {
        this.claw.stopMotor();
        System.out.println("Command Log: Stopped claw");
        //SmartDashboard.putNumber("Encoder Value", this.getEncoder());
    }


    public void open() {
        this.claw.set(-Constants.Subsystems.Claw.kPOWER);
        this.position += this.counter.get();
        System.out.println("Command Log: Opened claw");
        //SmartDashboard.putNumber("Encoder Value", this.getEncoder());
    }


    public void close() {
        this.claw.set(Constants.Subsystems.Claw.kPOWER);
        this.position -= this.counter.get();
        System.out.println("Command Log: Closed claw");
        //SmartDashboard.putNumber("Encoder Value", this.getEncoder());
    }

    /*
    public double getEncoder() {
        return this.encoder.getPosition();
    }
     */

    public boolean isOpened() {
        return this.position >= Constants.Subsystems.Claw.kOpenLimit;
    }

    public boolean isClosed() {
        return this.position <= Constants.Subsystems.Claw.kCloseLimit;
    }


}