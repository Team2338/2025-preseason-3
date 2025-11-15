package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class ElevatorManual extends Command {

    public ElevatorManual() {
        super();
        addRequirements(Robot.elevatorNEO); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        double manualUp = Robot.oi.aux.getLeftY();
        double initialPosition = Robot.elevatorNEO.getPosition();
        initialPosition = 0;

        if(Robot.elevatorNEO.getPosition() >= Constants.FINAL_POSITION && manualUp > 0) {
            Robot.elevatorNEO.setVoltage(0);
        } else {
            Robot.elevatorNEO.setVoltage(manualUp);
        }

        if(Robot.elevatorNEO.getPosition() >= Constants.FINAL_POSITION && manualUp > 0) {
            Robot.elevatorNEO.setVoltage(0);
        } else {
            Robot.elevatorNEO.setVoltage(manualUp);
        }
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}
}
