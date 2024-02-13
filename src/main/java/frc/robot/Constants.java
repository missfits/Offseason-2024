// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

// ***NEED TO BE UPDATED FOR 2024 SEASON***

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static class OperatorConstants {
    public static final int DRIVER_XBOX_PORT = 0;
    public static final int COPILOT_XBOX_PORT = 1;

    public static final double DRIVER_JOYSTICK_DEADBAND = 0.1;
    public static final double DRIVE_SPEED_ADJUSTMENT = 0.8;
  }

  public static class DrivetrainConstants {
    public static final int LEFT_MOTOR_1_PORT = 1;
    public static final int LEFT_MOTOR_2_PORT = 2;
    public static final int RIGHT_MOTOR_1_PORT = 3;
    public static final int RIGHT_MOTOR_2_PORT = 4;

    public static final int COUNTS_PER_REV = 42;
  }

  public static class IntakeConstants {
    public static final int INTAKE_MOTOR_PORT = 5;

    public static final double INTAKE_MOTOR_SPEED_FORWARD = 0.05; // for testing
    public static final double INTAKE_MOTOR_SPEED_BACKWARD = -0.05; // for testing

    public static final int COUNTS_PER_REV = 42;
  }

  public static class IndexerConstants {
    public static final int INDEXER_MOTOR_PORT = 6;

    public static final double INDEXER_MOTOR_SPEED_FORWARD = 0.05; // for testing
    public static final double INDEXER_MOTOR_SPEED_BACKWARD = -0.05; // for testing

    public static final int COUNTS_PER_REV = 42;
  }

  public static class ShooterConstants {
    public static final int SHOOTER_MOTOR_PORT = 7;

    public static final double SHOOTER_MOTOR_SPEED_AMP = 0.1; // TO DO: update
    public static final double SHOOTER_MOTOR_SPEED_SPEAKER = 0.1; // TO DO: update
    public static final double SHOOTER_MOTOR_SPEED_BACKWARD = 0.15; // for testing

    public static final int COUNTS_PER_REV = 42;
  }

  public static class HoodConstants {
    public static final int HOOD_MOTOR_PORT = 98; // TO DO: update
    public static final int PIVOT_MOTOR_PORT = 99; // TO DO: update

    public static final double HOOD_MOTOR_SPEED_FORWARD = 0.4; // TO DO: update
    public static final double HOOD_MOTOR_SPEED_BACKWARD = -0.6; // TO DO: update
    public static final double HOOD_MOTOR_SPEED_DEFAULT = 0.05; // TO DO: update

    public static final double PIVOT_MOTOR_SPEED = 0.2; // TO DO: update

    public static final double PIVOT_DELTA = 8; // for if we want to run a relative encoder thing

    // for if we want to fix encoder values for up and down (these are untested!)
    public static final double PIVOT_DOWN_POSITION = 8.5; // TO DO: update
    public static final double PIVOT_UP_POSITION = 0.5; // TO DO: update

    public static final int COUNTS_PER_REV = 42;
  }

  public static class ClimberConstants {
    public static final int CLIMBER_MOTOR_PORT = 100; // TO DO: set ID val

    public static final int COUNTS_PER_REV = 42;
  }

  public static class AutoConstants {
    public static final double TAXI_AUTO_TARGET_DISTANCE = 25; // (temp) distance (in rotations of encoder) to travel (can be both neg + pos)
    public static final double TAXI_AUTO_SPEED = 0.25; // (temp) speed of robot during taxi auto 
  }
}
