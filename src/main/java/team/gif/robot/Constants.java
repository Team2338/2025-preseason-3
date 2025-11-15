// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
//Encoder value format: value per RPM * number of rotations
public final class Constants {
    public static final double ELEVATOR_VOLT = 0.25; //needs testing
    public static final double HOLD_ELEVATOR_FF = 0.003; //needs testing
    public static final double CIM_MOTOR_PERC = 0.25; //needs testing
    public static final double FINAL_POSITION = 42 * 50; //needs testing
    public static final double SAFE_FALL_VOLT = -0.01; //needs testing
    public static final double STAGE_ONE_VALUE = 42 * 15; //Needs testing
    public static final double STAGE_TWO_VALUE = 42 * 15; //needs testing
    public static final double STAGE_THREE_VALUE = 42 * 15; //needs testing
    public static final double KG_ELEVATOR = 10; //Placeholder needs actual value
    public static final double KS_ELEVATOR = 10; //Placeholder needs actual value
    public static final double KV_ELEVATOR = 10; //Placeholder needs actual value

}
