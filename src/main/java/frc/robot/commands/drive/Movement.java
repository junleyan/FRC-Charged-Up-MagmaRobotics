package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;


public class Movement extends CommandBase {


    private double power, duration;
    private DriveTrain driveTrain;


    public Movement(DriveTrain driveTrain, double duration, double power) {
        this.driveTrain = driveTrain;
        this.duration = duration;
        this.power = power;
        addRequirements(driveTrain);
    }


    // called just before this Command runs the first time
    // calculates when to end Command
    public void initialize() {
        double currentTime = System.currentTimeMillis();
        this.duration = (currentTime + this.duration);
    }


    // called repeatedly when this Command is scheduled to run
    public void execute() {
        this.driveTrain.diffDrive(this.power,0);
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
        System.out.println("auto done");
        this.driveTrain.stop();
    }


    protected void interrupted() {
        this.end();
    }

    
}