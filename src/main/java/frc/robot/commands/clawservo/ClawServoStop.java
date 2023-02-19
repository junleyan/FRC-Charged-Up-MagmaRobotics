package frc.robot.commands.clawservo;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClawServo;


public class ClawServoStop extends CommandBase {


    private final ClawServo clawServo;
    

    public ClawServoStop(ClawServo clawServo) {
        this.clawServo = clawServo;
        addRequirements(clawServo);
    }


    @Override
    public void initialize() {
    }


    /**
     * method that's being executed
     */
    @Override
    public void execute() {
        this.clawServo.stop();
    }


    @Override
    public void end(boolean interrupted) {
    }


    @Override
    public boolean isFinished() {
        return false;
    }


}