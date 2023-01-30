package frc.robot.commands.secondarm;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;


public class SecondArmUp extends CommandBase{


    /**
     * an instance of {@link frc.robot.subsystems.Arm}
     */
    private final Arm arm;
    

    /**
     * @param arm an instance of {@link frc.robot.subsystems.Arm}
     */
    public SecondArmUp(Arm arm){
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
    public void execute(){
        this.arm.upSecond();
    }


    @Override
    public void end(boolean interrupted) {
    }


    @Override
    public boolean isFinished() {
        return false;
    }


}