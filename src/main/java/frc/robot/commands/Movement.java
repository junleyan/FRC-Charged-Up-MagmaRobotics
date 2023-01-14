package frc.robot.commands;


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

    // Called just before this Command runs the first time
    public void initialize() {
        double currentTime = System.currentTimeMillis();
        this.duration = (currentTime + this.duration);
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {
        driveTrain.arcadeDriveWithJoystick(this.power, 0, 1);
        System.out.println("executing auto");
    }

    // Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() {
        System.out.println("auto done");
        return System.currentTimeMillis() >= this.duration;
    }

    // Called once after isFinished returns true
    protected void end() {
        driveTrain.stopMotor();
    }

    protected void interrupted() {
        end();
    }
}