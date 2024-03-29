package frc.robot.commands.claw;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Claw;


public class ClawAutoOpen extends CommandBase {


    private double duration;
    private Claw claw;


    public ClawAutoOpen(Claw claw, double duration) {
        this.claw = claw;
        this.duration = duration;
        addRequirements(claw);
    }


    // called just before this Command runs the first time
    // calculates when to end Command
    public void initialize() {
        double currentTime = System.currentTimeMillis();
        this.duration = (currentTime + this.duration);
    }


    // called repeatedly when this Command is scheduled to run
    public void execute() {
        this.claw.close();
        System.out.println("executing auto");
    }


    // make this return true when this Command no longer needs to run execute()
    // checks if the time has passed the set duration
    public boolean isFinished() {
        return System.currentTimeMillis() >= this.duration;
    }


    // called once after isFinished returns true
    // drive train is stopped
    protected void end() {
        this.claw.stop();
    }


    protected void interrupted() {
        this.end();
    }

    
}