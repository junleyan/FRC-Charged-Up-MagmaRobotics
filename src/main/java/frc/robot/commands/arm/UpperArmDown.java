package frc.robot.commands.arm;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;


public class UpperArmDown extends CommandBase {


    /**
     * an instance of {@link frc.robot.subsystems.Arm}
     */
    private final Arm arm;
    

    /**
     * @param arm an instance of {@link frc.robot.subsystems.Arm}
     */
    public UpperArmDown(Arm arm) {
        this.arm = arm;
        addRequirements(arm);
    }


    @Override
    public void initialize() {
    }


    /**
     * method that's being executed
     */
    @Override
    public void execute() {
        this.arm.upperArmDown();
    }


    @Override
    public void end(boolean interrupted) {
    }


    @Override
    public boolean isFinished() {
        return false;
    }


}