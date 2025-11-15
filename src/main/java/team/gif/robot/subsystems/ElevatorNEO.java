// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.EncoderConfig;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.math.controller.ElevatorFeedforward;
import edu.wpi.first.units.measure.MutAngle;
import edu.wpi.first.units.measure.MutAngularVelocity;
import edu.wpi.first.units.measure.MutVoltage;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.sysid.SysIdRoutine;
import team.gif.robot.Constants;
import team.gif.robot.RobotMap;

import static edu.wpi.first.units.Units.Radians;
import static edu.wpi.first.units.Units.RadiansPerSecond;
import static edu.wpi.first.units.Units.Volts;

public class ElevatorNEO extends SubsystemBase {
    /**
     * Creates a new ExampleSubsystem.
     */
    private SparkMax motor;
    public SparkClosedLoopController neoPID;
    public SparkMaxConfig config;
    public RelativeEncoder encoder;
    public EncoderConfig encoderConfig;
    public ElevatorFeedforward elevatorFF;
    public ElevatorNEO() {

        motor = new SparkMax(RobotMap.ELEVATOR_NEO_ID, SparkLowLevel.MotorType.kBrushless);
        config = new SparkMaxConfig();
        encoder = motor.getEncoder();
        neoPID = motor.getClosedLoopController();
        config.idleMode(SparkBaseConfig.IdleMode.kBrake);
        config.inverted(true);
        //ks = amount needed to overcome static friction, kg = amount of voltage required to overcome gravity
        elevatorFF = new ElevatorFeedforward(Constants.KS_ELEVATOR, Constants.KG_ELEVATOR, Constants.KV_ELEVATOR);

        //Spark Encoder value for 1 rotation = 42
        encoder.setPosition(0);
    }

    public double getPosition() {
       return encoder.getPosition();
    }

    public void setVoltage(double voltage) {
        motor.setVoltage(voltage); //Our electrical systems run on 12v, so this value can be from -12 to 12
    }

    public double getVoltage(){
        return motor.getBusVoltage() * motor.getAppliedOutput();
    }

    public double getVelocity(){
        return encoder.getVelocity();
    }

    public void zeroEncoder() {
        motor.getEncoder().setPosition(0);
    }

    //Gives values for FF
    private SysIdRoutine getElevatorSysIdRoutine() {
        MutVoltage m_appliedVoltage = Volts.mutable(0);
        MutAngle m_angle = Radians.mutable(0);
        MutAngularVelocity m_velocity = RadiansPerSecond.mutable(0);

        return new SysIdRoutine(
                new SysIdRoutine.Config(),
                new SysIdRoutine.Mechanism(
                        voltage -> {
                            motor.setVoltage(voltage.baseUnitMagnitude());
                        },
                        sysIdRoutineLog -> {
                            sysIdRoutineLog.motor("elevator")
                                    .voltage(m_appliedVoltage.mut_replace(getVoltage(), Volts))
                                    .angularPosition(m_angle.mut_replace(getPosition(), Radians))
                                    .angularVelocity(m_velocity.mut_replace(getVelocity(), RadiansPerSecond));
                        },
                        this));
    }

    public Command sysIdQuasistatic(SysIdRoutine.Direction direction){
        return getElevatorSysIdRoutine().quasistatic(direction);
    }

    public Command sysIDDynamic(SysIdRoutine.Direction direction){
        return getElevatorSysIdRoutine().dynamic(direction);
    }
}
