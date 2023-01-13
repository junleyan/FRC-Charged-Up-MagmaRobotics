package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class Run extends CommandBase{
    private final Arm arm;
    
    public Run(Arm arm){
        this.arm = arm;
        addRequirements(arm);
    }

    @Override
        public void initialize() {
    }

    @Override
    public void execute(){
        arm.run();
    }

    @Override
        public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
