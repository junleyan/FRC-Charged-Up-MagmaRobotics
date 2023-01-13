package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class Reverse extends CommandBase{
    private final Arm arm;
    
    public Reverse(Arm arm){
        this.arm = arm;
        addRequirements(arm);
    }

    @Override
        public void initialize() {
    }

    @Override
    public void execute(){
        arm.reverse();
        System.out.println("Arm reverse");
    }

    @Override
        public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
