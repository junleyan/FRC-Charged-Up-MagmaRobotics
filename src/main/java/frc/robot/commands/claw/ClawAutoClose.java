package frc.robot.commands.claw;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Claw;


public class ClawAutoClose extends CommandBase {


    private double duration;
    private Claw claw;


    public ClawAutoClose(Claw claw) {
        this.claw = claw;
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
    protected boolean end() {
        System.out.println("auto done");
        return this.claw.isClosed();
    }


    protected void interrupted() {
        this.end();
    }

    
}