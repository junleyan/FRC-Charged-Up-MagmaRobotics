package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Claw extends SubsystemBase {


    private PWMSparkMax claw;

    
    public Claw() {
        this.claw = new PWMSparkMax(Constants.Subsystems.Claw.PORT);
        System.out.println("Subsystem Log: Claw is configured to port " + Constants.Subsystems.Claw.PORT);
    }


    public void stop() {
        this.claw.stopMotor();
        System.out.println("Command Log: Stopped claw");
    }


    public void open() {
        this.claw.set(Constants.Subsystems.Claw.POWER);
        System.out.println("Command Log: Opened claw");
    }


    public void close() {
        this.claw.set(-Constants.Subsystems.Claw.POWER);
        System.out.println("Command Log: Closed claw");
    }


}