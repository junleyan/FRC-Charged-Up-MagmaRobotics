package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.NavX;


public class AutoBalance extends CommandBase {


    private double duration;
    private DriveTrain driveTrain;
    private NavX navx; 


    public AutoBalance(DriveTrain driveTrain, NavX navx) {
        this.driveTrain = driveTrain;
        this.navx = navx;
        addRequirements(driveTrain, navx);
    }


    // called just before this Command runs the first time
    // calculates when to end Command
    public void initialize() {
        double currentTime = System.currentTimeMillis();
        this.duration = (currentTime + 3000);
    }


    // called repeatedly when this Command is scheduled to run
    public void execute() {
        while (isFinished() == false){
            if(this.navx.checkCalculatedBalancePID() == false){
                this.driveTrain.diffDrive(this.navx.getCalculatedBalancePID()/2.5, this.navx.getCalculatedBalancePID()/2.5);
                System.out.println("Pitch: " + this.navx.getPitch());
            }
            else{
                this.driveTrain.diffDrive(0, 0);
            }
        }
    }


    // make this return true when this Command no longer needs to run execute()
    // checks if the time has passed the set duration
    public boolean isFinished() {
        if (System.currentTimeMillis() >= this.duration) {
            System.out.println("Executing auto balancing");
            System.out.println("Pitch: " + this.navx.getPitch());
            System.out.println("PID Value: " + this.navx.getCalculatedBalancePID());
            return true;
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