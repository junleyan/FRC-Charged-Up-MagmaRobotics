package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Claw extends SubsystemBase {

    private CANSparkMax claw;
    private Counter counter;
    private int position = 0; 

    
    // make sure that the deviceID is same as the ID set on the motor controller
    public Claw() {
        this.claw = new CANSparkMax(7, MotorType.kBrushless);
        this.counter = new Counter(new DigitalInput(0));
        //this.encoder = this.claw.getEncoder();
        //this.claw.restoreFactoryDefaults();
        System.out.println("Subsystem Log: Claw is configured to port 4");
    }


    public void stop() {
        this.claw.disable();
        System.out.println("Command Log: Stopped claw");
        //SmartDashboard.putNumber("Encoder Value", this.getEncoder());
        SmartDashboard.putNumber("Claw Position", this.position);
    }


    public void open() {
        this.claw.set(-Constants.Subsystems.Claw.kPOWER);
        this.position += this.counter.get();
        System.out.println("Command Log: Opened claw");
        SmartDashboard.putNumber("Claw Position", this.position);
        //SmartDashboard.putNumber("Encoder Value", this.getEncoder());
    }


    public void close() {
        this.claw.set(Constants.Subsystems.Claw.kPOWER);
        this.position -= this.counter.get();
        System.out.println("Command Log: Closed claw");
        SmartDashboard.putNumber("Claw Position", this.position);
        //SmartDashboard.putNumber("Encoder Value", this.getEncoder());
    }


    //public double getEncoder() {
        //return this.encoder.getPosition();
    //}

    //public boolean isOpened() {
        //return this.getEncoder() >= Constants.Subsystems.Claw.kOpenLimit;
    //}

    //public boolean isClosed() {
        //return this.getEncoder() <= Constants.Subsystems.Claw.kCloseLimit;
    //}


}