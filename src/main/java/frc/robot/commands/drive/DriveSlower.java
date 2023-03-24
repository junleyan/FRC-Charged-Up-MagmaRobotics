package frc.robot.commands.drive;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.NavX;

public class DriveSlower extends CommandBase {


    /**
     * an instance of {@link frc.robot.subsystems.DriveTrain}
     */
    private final DriveTrain driveTrain;
    private final XboxController driveController;


    /**
     * @param driveTrain an instance of {@link frc.robot.subsystems.DriveTrain}
     * @param driveController an instance of {@link edu.wpi.first.wpilibj.XboxController}
     */
    public DriveSlower(DriveTrain driveTrain, XboxController driveController){
        this.driveTrain = driveTrain;
        this.driveController = driveController;
        addRequirements(driveTrain);
    }
    
    @Override
    public void initialize() {
    }


    /**
     * method that's being executed in a loop;
     * change the method being called in {@link frc.robot.subsystems.DriveTrain} to accommodate 
     * different driving styles
     */
    @Override

    public void execute() {
        this.driveTrain.diffDrive(
            -this.driveController.getRawAxis(Constants.Control.XboxController.kLEFT)*0.5, 
            -this.driveController.getRawAxis(Constants.Control.XboxController.kRIGHT)*0.5);     
    }
    


    @Override
    public void end(boolean interrupted) {
    }


    @Override
    public boolean isFinished() {
        return false;
    }


}