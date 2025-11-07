package team.gif.robot.commands.Autos;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutosGroup extends SequentialCommandGroup {
    public AutosGroup(){
    addCommands(
            new ParallelCommandGroup(new ForwardAuto())

    );
    }
}
