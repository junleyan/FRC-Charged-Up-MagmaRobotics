package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Claw extends SubsystemBase {


    private Spark claw;

    
    public Claw() {
        this.claw = new Spark(Constants.Subsystems.Claw.PORT);
        System.out.println("Subsystem Log: Lower arm is configured to port " + Constants.Subsystems.Claw.PORT);
    }


    public void stop() {
        this.claw.stopMotor();
    }


    public void open() {
        this.claw.set(Constants.Subsystems.Claw.POWER);
    }


    public void close() {
        this.claw.set(-Constants.Subsystems.Claw.POWER);
    }


}