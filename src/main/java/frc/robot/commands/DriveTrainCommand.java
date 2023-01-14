package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class DriveTrainCommand extends CommandBase{
    private final DriveTrain driveTrain;
    private final XboxController driveController;
    
    public DriveTrainCommand(DriveTrain driveTrain, XboxController driveController){
        this.driveTrain = driveTrain;
        this.driveController = driveController;
        addRequirements(driveTrain);
    }

    @Override
        public void initialize() {
    }

    //arcadeDriveWithXbox = Katelyn
    //diffDrive = Standard
    @Override
    public void execute() {
        driveTrain.diffDrive(
            driveController.getRawAxis(Constants.JoyStickAxis.XboxController.leftJoystick), 
            driveController.getRawAxis(Constants.JoyStickAxis.XboxController.rightJoystick));
    }

    @Override
        public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
