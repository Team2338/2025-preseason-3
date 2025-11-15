// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.Robot;
import team.gif.robot.RobotMap;

public class CollectorCIM extends SubsystemBase {
    private TalonSRX talonMotorIntake;
    private TalonSRX talonMotorIntakeRearLeft;
    private TalonSRX talonMotorIntakeRearRight;
    private TalonSRX dualRearIntake;


    public CollectorCIM() {
        talonMotorIntake = new TalonSRX(RobotMap.COLLECTOR_CIM_ID);
        talonMotorIntake.configFactoryDefault();
        talonMotorIntake.setNeutralMode(NeutralMode.Brake);

        talonMotorIntakeRearLeft = new TalonSRX(RobotMap.COLLECTOR_CIM_ID);
        talonMotorIntakeRearLeft.configFactoryDefault();
        talonMotorIntakeRearLeft.setNeutralMode(NeutralMode.Brake);
        talonMotorIntakeRearLeft.setInverted(true);

        talonMotorIntakeRearRight = new TalonSRX(RobotMap.COLLECTOR_CIM_ID);
        talonMotorIntakeRearRight.configFactoryDefault();
        talonMotorIntakeRearRight.setNeutralMode(NeutralMode.Brake);
        talonMotorIntakeRearRight.setInverted(true);

        talonMotorIntakeRearLeft.follow(talonMotorIntakeRearRight);
    }
    public void talonMotorMoveIntake(double percentOutput){
        talonMotorIntake.set(TalonSRXControlMode.PercentOutput, percentOutput);
    }

    public void talonMotorMoveIntakeRear(double percentOutputRear) {
        talonMotorIntakeRearRight.set(TalonSRXControlMode.PercentOutput, percentOutputRear);
    }
}
