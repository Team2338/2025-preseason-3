package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class CollectorIntakeReverse extends Command {

    public CollectorIntakeReverse() {
        super();
        addRequirements(Robot.collector); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        Robot.collector.talonMotorMoveIntake(-Constants.CIM_MOTOR_PERC);
        System.out.println("This is working");
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        System.out.println("end");
        Robot.collector.talonMotorMoveIntake(0);
    }
}
