package frc.robot.commands.claw;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Claw;


public class ClawOpen extends CommandBase {


    private final Claw claw;
    

    public ClawOpen(Claw claw) {
        this.claw = claw;
        addRequirements(claw);
    }


    @Override
    public void initialize() {
    }


    /**
     * method that's being executed
     */
    @Override
    public void execute() {
        this.claw.open();
    }


    @Override
    public void end(boolean interrupted) {
    }


    @Override
    public boolean isFinished() {
        return false;
    }


}