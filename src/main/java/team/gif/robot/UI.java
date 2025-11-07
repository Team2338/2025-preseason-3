package team.gif.robot;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class UI {
    /**
     *  Widgets (e.g. gyro, text, True/False flags),
     *  buttons (e.g. SmartDashboard.putData("Reset", new ResetHeading()); ),
     *  and Chooser options (e.g. auto mode, auto delay)
     *
     *  Placed in SmartDashboard network table
     *  After dashboard loads for the first time, manually move items from network table onto respective dashboard tab
     *  and save file as "YYYY elastic-layout.json"
     */
    public UI() {
        ShuffleboardTab shuffleboardTab = Shuffleboard.getTab("Preseason 3");
        shuffleboardTab.addDouble("Heading", Robot.pigeon::get360Heading).withWidget(BuiltInWidgets.kGyro);
        shuffleboardTab.addDouble("NEO Position", Robot.elevatorNEO::getPosition);
        
    }

    /**
     * Widgets which are updated periodically should be placed here
     *
     * Convenient way to format a number is to use putString w/ format:
     *     SmartDashboard.putString("Elevator", String.format("%11.2f", Elevator.getPosition());
     */
    public void update() {
        //Example
        //SmartDashboard.putNumber("Climber Position", Robot.elevator.getPosition())
    }
}
