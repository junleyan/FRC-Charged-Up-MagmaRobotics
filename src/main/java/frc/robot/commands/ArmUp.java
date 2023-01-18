package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;


public class ArmUp extends CommandBase{


    private final Arm arm;
    

    /**
     * @param arm an instance of {@link frc.robot.subsystems.Arm}
     */
    public ArmUp(Arm arm){
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
        arm.up();
        System.out.println("Arm is on");
    }


    @Override
    public void end(boolean interrupted) {
    }


    @Override
    public boolean isFinished() {
        return false;
    }


}