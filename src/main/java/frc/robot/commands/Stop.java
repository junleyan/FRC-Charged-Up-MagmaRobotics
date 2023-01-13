package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;

public class Stop extends CommandBase{
    private final Arm arm;
    
    public Stop(Arm arm){
        this.arm = arm;
        addRequirements(arm);
    }

    @Override
        public void initialize() {
    }

    @Override
    public void execute(){
        arm.stop();
        System.out.println("Arm stop");
    }

    @Override
        public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
