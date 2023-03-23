package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.NavX;


public class AutoBalance extends CommandBase {


    private double duration, length;
    private DriveTrain driveTrain;
    private NavX navx; 


    public AutoBalance(DriveTrain driveTrain, NavX navx, double duration) {
        this.driveTrain = driveTrain;
        this.navx = navx;
        this.duration = duration;
        addRequirements(driveTrain, navx);
    }


    // called just before this Command runs the first time
    // calculates when to end Command
    public void initialize() {
        double currentTime = System.currentTimeMillis();
        this.duration = (currentTime + duration);
        this.length = duration;
    }


    // called repeatedly when this Command is scheduled to run
    public void execute() {
        if(this.navx.checkCalculatedBalancePID() == false){
            this.driveTrain.diffDrive(this.navx.getCalculatedBalancePID(), this.navx.getCalculatedBalancePID());
            System.out.println("Pitch: " + this.navx.getPitch());
        }
        else {
            this.driveTrain.diffDrive(0, 0);
        }

    }


    // make this return true when this Command no longer needs to run execute()
    // checks if the time has passed the set duration
    public boolean isFinished() {
        while (System.currentTimeMillis() >= this.length) {
            return (!this.navx.checkCalculatedBalancePID());
        }
        return false;
    }


    // called once after isFinished returns true
    // drive train is stopped
    protected void end() {
        this.driveTrain.stop();
    }


    protected void interrupted() {
        this.end();
    }

    
}