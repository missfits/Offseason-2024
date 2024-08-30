// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Hood;

// shuffle board import
import edu.wpi.first.wpilibj.smartdashboard.*;

/**
 * displays hood encoder values to shuffleboard
 */
public class HoodEncoderDisplayCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Hood m_hood;

  public HoodEncoderDisplayCommand(Hood hood) {
    m_hood = hood;
    addRequirements(m_hood);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    SmartDashboard.putNumber("Hood Encoder", m_hood.getPivotEncoderPosition());
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
