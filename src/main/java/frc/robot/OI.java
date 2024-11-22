package frc.robot;

import frc.robot.Constants.OperatorConstants;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.OI;



public class OI {
    
    // Replace with CommandPS4Controller or CommandJoystick if needed
    public static CommandXboxController m_driverXbox = new CommandXboxController(
        OperatorConstants.DRIVER_XBOX_PORT);

    // driver xbox inputs

    // needs to be negative to make motors run straight as of 9/26/23
    public double getDriverXBoxLeftJoyY() {
        return -m_driverXbox.getLeftY();
    }

    public double getDriverXBoxLeftJoyX() {
        return m_driverXbox.getLeftX();
    }

    public double getDriverXBoxRightJoyY() {
        return m_driverXbox.getRightY();
    }
}
