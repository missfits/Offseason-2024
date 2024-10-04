package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Hood;

import frc.robot.Constants.HoodConstants;

/**
 * Moves hood to setpointAngle
 */
public class HoodPivotPID extends Command{
    private final Hood m_hood;
    private final double m_setpointAngle;
    private final PIDController m_controller;

    public HoodPivotPID(Hood hood, double setpointAngle){
        m_hood = hood;
        m_setpointAngle = setpointAngle;
        m_controller = new PIDController(HoodConstants.PID_KP, HoodConstants.PID_KI, HoodConstants.PID_KD);
        m_controller.setTolerance(HoodConstants.TARGET_TOLERANCE);
        addRequirements(hood);
    }

    @Override
    public void initialize() {
        m_controller.reset();
        SmartDashboard.putNumber("Hood Setpoint Angle", m_setpointAngle);
    }  

    @Override
    public void execute() {
        double measuredAngle = m_hood.getPivotPositionDegrees();
        // multiplied by -1 to ensure motor turns in the correct direction
        double calculatedOutput = -1.*m_controller.calculate(measuredAngle, m_setpointAngle);
        calculatedOutput = MathUtil.clamp(calculatedOutput, -1*HoodConstants.MAX_POWER, HoodConstants.MAX_POWER);
        m_hood.runPivotHoodMotor(calculatedOutput);

        SmartDashboard.putNumber("Hood Measured Angle", measuredAngle);
        SmartDashboard.putNumber("Hood Calculated Output", calculatedOutput);
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
