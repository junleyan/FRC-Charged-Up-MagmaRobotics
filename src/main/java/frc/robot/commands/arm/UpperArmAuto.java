package frc.robot.commands.arm;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;


public class UpperArmAuto extends CommandBase {


    private double duration;
    private Arm arm;


    public UpperArmAuto(Arm arm, double duration) {
        this.arm = arm;
        this.duration = duration;
        addRequirements(arm);
    }


    // called just before this Command runs the first time
    // calculates when to end Command
    public void initialize() {
        double currentTime = System.currentTimeMillis();
        this.duration = (currentTime + this.duration);
    }


    // called repeatedly when this Command is scheduled to run
    public void execute() {
        this.arm.upperArmDown();
    }


    // make this return true when this Command no longer needs to run execute()
    // checks if the time has passed the set duration
    public boolean isFinished() {
        return System.currentTimeMillis() >= this.duration;
    }


    // called once after isFinished returns true
    // drive train is stopped
    protected void end() {
        this.arm.stopAll();
    }


    protected void interrupted() {
        this.end();
    }

    
}