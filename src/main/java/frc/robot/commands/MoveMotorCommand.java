// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ExampleSubsystem;

import frc.robot.OI;

/** An example command that uses an example subsystem. */
public class MoveMotorCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ExampleSubsystem m_subsystem;
  private final OI m_humanControl;


  public MoveMotorCommand(ExampleSubsystem subsystem, OI humanControl) {
    m_subsystem = subsystem;
    m_humanControl = humanControl;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {}

  @Override
  /**
   * joystick input translates to percent power in MoveMotorCommand
   */
  public void execute() {
    double xJoy = m_humanControl.getDriverXBoxLeftJoyX();
    m_subsystem.setPercentPower(xJoy);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
