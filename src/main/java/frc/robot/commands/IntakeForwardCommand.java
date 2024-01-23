package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Hood;
import frc.robot.Constants.IntakeConstants;

public class IntakeForwardCommand extends Command {
    private Hood m_intake;
    
    public IntakeForwardCommand(Hood intake){
        m_intake = intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        // System.out.println("INTAKE SUCK COMMAND STARTED");
    }  

    @Override
    public void execute() {
        m_intake.runIntakeMotor(IntakeConstants.INTAKE_MOTOR_SPEED_FORWARD);
    }

    @Override
    public void end(boolean interrupted) {
        m_intake.intakeOff();
    }

    @Override
    public boolean isFinished() {
       return false;
    }
}
