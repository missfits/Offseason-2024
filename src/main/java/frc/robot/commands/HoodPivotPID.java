package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Hood;

import frc.robot.Constants.HoodConstants;


/**
 * Puts hood forward (in amp shooting position).
 * In encoder position, moves the hood from 0 to approximately -48.2.
 */
public class HoodPivotPID extends Command{
    private final Hood m_hood;
    private final double m_setpointAngle;
    private final PIDController m_controller;


    public HoodPivotPID(Hood hood, double setpointAngle){
        m_hood = hood;
        m_setpointAngle = setpointAngle;
        m_controller = new PIDController(0.01, 0, 0);
        m_controller.setTolerance(0.5); // error bound
        addRequirements(hood);
    }

    @Override
    public void initialize() {
        // m_hood.resetPivotEncoderPosition();
        m_controller.reset();
    }  

    @Override
    public void execute() {
        double measuredAngle = m_hood.getPivotPositionDegrees();
        double calculatedOutput = -1.*m_controller.calculate(measuredAngle, m_setpointAngle);
        calculatedOutput = MathUtil.clamp(calculatedOutput, -0.6, 0.6);
        m_hood.runPivotHoodMotor(calculatedOutput);
    }

    @Override
    public void end(boolean interrupted) {
        m_hood.pivotMotorOff();
    }

    @Override
    public boolean isFinished() {
        return m_controller.atSetpoint();
    }
}
