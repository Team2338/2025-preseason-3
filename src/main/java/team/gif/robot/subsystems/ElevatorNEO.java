// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.EncoderConfig;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;
import team.gif.robot.commands.ElevatorHold;

public class ElevatorNEO extends SubsystemBase {
    /**
     * Creates a new ExampleSubsystem.
     */
    public void initDefaultCommand(){
        setDefaultCommand(new ElevatorHold());
    }

    private SparkMax motor;
    public SparkClosedLoopController neoPID;
    public SparkMaxConfig config;
    public RelativeEncoder encoder;
    public EncoderConfig encoderConfig;
    public ElevatorNEO() {

        motor = new SparkMax(RobotMap.ELEVATOR_NEO_ID, SparkLowLevel.MotorType.kBrushless);
        config = new SparkMaxConfig();
        encoder = motor.getEncoder();
        neoPID = motor.getClosedLoopController();
        config.idleMode(SparkBaseConfig.IdleMode.kBrake);
        config.inverted(true);


        //Spark Encoder value for 1 rotation = 42
        encoder.setPosition(0);
    }

    public double getPosition() {
       return encoder.getPosition();
    }

    public void setVoltage(double voltage) {
        motor.setVoltage(voltage); //Our electrical systems run on 12v, so this value can be from -12 to 12
    }

    public double getRPM() {
        return motor.getEncoder().getVelocity();
    }

    public void setRPM(double RPM) {
        neoPID.setReference(RPM, SparkBase.ControlType.kVelocity);
    }

    public void zeroEncoder() {
        motor.getEncoder().setPosition(0);
    }
}
