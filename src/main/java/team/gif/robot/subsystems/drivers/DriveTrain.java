// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems.drivers;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class DriveTrain extends SubsystemBase {
    public WPI_TalonSRX rightCIM;
    public WPI_TalonSRX leftCIM;

    private DifferentialDrive driveTrain;
    public DriveTrain() {
        /** Creates a new ExampleSubsystem. */
        rightCIM = new WPI_TalonSRX(RobotMap.CIM_RIGHT);
        leftCIM = new WPI_TalonSRX(RobotMap.CIM_LEFT);

        rightCIM.configFactoryDefault();
        leftCIM.configFactoryDefault();

        rightCIM.setNeutralMode(NeutralMode.Brake);
        leftCIM.setNeutralMode(NeutralMode.Brake);
        leftCIM.setInverted(true);
        driveTrain = new DifferentialDrive(leftCIM, rightCIM);
    }
    //Type 1 TankDrive
    public void driverArcade(double speed, double rotation){
        driveTrain.arcadeDrive(speed, rotation);
    }

    /* Type 2 TankDrive
    public void tankDrive(double leftSpeed, double rightSpeed){
        driveTrain.tankDrive(leftSpeed, rightSpeed);
    }
     */
}
