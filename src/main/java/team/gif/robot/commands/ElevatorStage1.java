package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class ElevatorStage1 extends Command {

    public ElevatorStage1() {
        super();
        addRequirements(Robot.elevatorNEO); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        Robot.elevatorNEO.setVoltage(Constants.ELEVATOR_VOLT);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return Robot.elevatorNEO.getPosition() == 42 * 10; //Needs testing
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.elevatorNEO.setVoltage(0);
    }
}
