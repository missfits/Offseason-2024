// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkRelativeEncoder;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SubsystemConstants;

public class ExampleSubsystem extends SubsystemBase {
  private final CANSparkMax m_motor = new CANSparkMax(11, MotorType.kBrushless);
  private final SparkRelativeEncoder m_encoder = (SparkRelativeEncoder) m_motor
    .getEncoder(SparkRelativeEncoder.Type.kHallSensor, SubsystemConstants.COUNTS_PER_REV);

  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {
    m_encoder.setPositionConversionFactor(SubsystemConstants.METERS_PER_ROTATION); // want: meters (from rotations)
    m_encoder.setVelocityConversionFactor(SubsystemConstants.METERS_PER_ROTATION / 60); // want: m/s (from rpm)
  }

  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(()
                       -> { // restores the spark max to factory default 
                          System.out.println("restored to factory defaults :)");
                          m_motor.restoreFactoryDefaults();
                       });
  }

  public boolean exampleCondition() { return false; }

  @Override
  public void periodic() {
    System.out.println(getEncoderPosition());
  }

  @Override
  public void simulationPeriodic() {}

  public void setPercentPower(double power){
    m_motor.set(power);
  }

  public double getEncoderPosition() {
    return m_encoder.getPosition();
  }


}
