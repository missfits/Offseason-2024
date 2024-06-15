// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.SparkRelativeEncoder;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IndexerConstants;
import edu.wpi.first.wpilibj.Timer;

public class Indexer extends SubsystemBase {

    // instance variables
    private final CANSparkMax m_indexerMotor = new CANSparkMax(IndexerConstants.INDEXER_MOTOR_PORT, MotorType.kBrushless);
    private final SparkRelativeEncoder m_indexerEncoder = (SparkRelativeEncoder) m_indexerMotor
            .getEncoder(SparkRelativeEncoder.Type.kHallSensor, IndexerConstants.COUNTS_PER_REV);
    private final Timer bbTimer;

    public DigitalInput m_input = new DigitalInput(9); // takes in values from the beam breaker

    // constructor
    public Indexer() {
        bbTimer = new Timer();
        bbTimer.reset();
    }

    // Sets Indexer motor speed (forward if positive, backward if negative)
    public void runIndexerMotor(double speed) {
        m_indexerMotor.set(speed);
    }

    // Sets Indexer motor speed to zero and stops motor
    public void indexerOff() {
        m_indexerMotor.set(0);
        m_indexerMotor.stopMotor();
    }

    // returns encoder position
    public double getEncoderPosition() {
        return m_indexerEncoder.getPosition();
    }

    // sets encoder to desired position
    public void setEncoderPosition(double position) {
            m_indexerEncoder.setPosition(position);
    }

    // returns encoder velocity
    public double getEncoderVelocity() {
        return m_indexerEncoder.getVelocity();
    }

    // returns true if beam is *not* broken, false if no light detected
    public boolean getBeamBreak() {
        return m_input.get();
    }

    // returns true (green) for 1 second after beam is broken, false (red) otherwise
    public boolean getBeamBreakSignal() {
        if (!m_input.get()) {
            bbTimer.stop();
            bbTimer.reset();
            bbTimer.start();
            return true;
        } else if (bbTimer.get() <= 5) {
            return true;
        } else {
            bbTimer.stop();
            return false;
        }
    }

    // testing method for beam break
    public void printBeamBreak() {
        System.out.println(m_input.get());
    }
}
