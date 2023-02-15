package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Claw extends SubsystemBase {

    private CANSparkMax claw;
    private RelativeEncoder encoder; 

    
    public Claw() {
        this.claw = new CANSparkMax(9, MotorType.kBrushless);
        this.encoder = this.claw.getEncoder();
        this.claw.restoreFactoryDefaults();
        System.out.println("Subsystem Log: Claw is configured to port 42");
    }


    public void stop() {
        this.claw.set(0);
        System.out.println("Command Log: Stopped claw");
        SmartDashboard.putNumber("Encoder Value", this.getEncoder());
    }


    public void open() {
        this.claw.set(Constants.Subsystems.Claw.kPOWER);
        System.out.println("Command Log: Opened claw");
        SmartDashboard.putNumber("Encoder Value", this.getEncoder());
    }


    public void close() {
        this.claw.set(-Constants.Subsystems.Claw.kPOWER);
        System.out.println("Command Log: Closed claw");
        SmartDashboard.putNumber("Encoder Value", this.getEncoder());
    }


    public double getEncoder() {
        return this.encoder.getPosition();
    }


}