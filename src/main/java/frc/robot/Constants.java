// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

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

  public static class SubsystemConstants {
    public static final int COUNTS_PER_REV = 42; // maybe right? from offseason-2024

    // for 2024 elevator
    // 0.947 (sprocket radius) * 2 pi * 2 (carriage to chain movement) * m/in * 5.45 (gear ratio)
    public static final double METERS_PER_ROTATION = 1.64736586187; // tentative, should reevaluate
  }
}
