package team.gif.robot.commands.Autos;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Robot;


public class ForwardSpin extends Command {
    double finalTime;
    public ForwardSpin() {
        super();
        addRequirements(Robot.arcadeDrive);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        finalTime = 0;
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        finalTime+=1;
        Robot.arcadeDrive.driverArcade(0,0.3);
    }

    // Return true when the command should end, false if it[\] should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return (finalTime == 50 * 2);
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.arcadeDrive.driverArcade(0,0);
    }
}
