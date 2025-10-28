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
    public WPI_TalonSRX rearRightCIM;
    public WPI_TalonSRX frontLeftCIM;
    public WPI_TalonSRX frontRightCIM;
    public WPI_TalonSRX rearLeftCIM;

    private DifferentialDrive driveTrain;
    public DriveTrain() {
        /** Creates a new ExampleSubsystem. */
        rearLeftCIM = new WPI_TalonSRX(RobotMap.CIM_REAR_LEFT);
        rearRightCIM = new WPI_TalonSRX(RobotMap.CIM_REAR_RIGHT);
        frontLeftCIM = new WPI_TalonSRX(RobotMap.CIM_FRONT_LEFT);
        frontRightCIM = new WPI_TalonSRX(RobotMap.CIM_FRONT_RIGHT);

        rearLeftCIM.configFactoryDefault();
        rearRightCIM.configFactoryDefault();
        frontRightCIM.configFactoryDefault();
        frontLeftCIM.configFactoryDefault();

        rearLeftCIM.setNeutralMode(NeutralMode.Brake);
        rearRightCIM.setNeutralMode(NeutralMode.Brake);
        frontRightCIM.setNeutralMode(NeutralMode.Brake);
        frontLeftCIM.setNeutralMode(NeutralMode.Brake);

        rearRightCIM.follow(frontRightCIM);
        rearLeftCIM.follow(frontLeftCIM);

        driveTrain = new DifferentialDrive(frontLeftCIM, frontRightCIM);
    }
    //Type 1 TankDrive
    public void driverArcade(double speed, double rotation){
        driveTrain.arcadeDrive(speed, rotation);
    }
    //Type 2 TankDrive
    public void tankDrive(double leftSpeed, double rightSpeed){
        driveTrain.tankDrive(leftSpeed, rightSpeed);
    }
}
