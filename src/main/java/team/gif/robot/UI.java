package team.gif.robot;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import team.gif.robot.commands.Autos.ForwardAuto;
import team.gif.robot.commands.Autos.ForwardSpin;

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
        SmartDashboard.putData("Commands", CommandScheduler.getInstance());
       // autoChooser.setDefaultOption("No Auto", new NoAuto());
       // SmartDashboard.putData("Auto", autoChooser);

        ShuffleboardTab shuffleboardTab = Shuffleboard.getTab("Preseason 3");
//        shuffleboardTab.addDouble("Heading", Robot.pigeon::get360Heading).withWidget(BuiltInWidgets.kGyro);
        shuffleboardTab.addDouble("NEO Position", Robot.elevatorNEO::getPosition).withWidget(BuiltInWidgets.kEncoder);
        shuffleboardTab.addDouble("Spark voltage", Robot.elevatorNEO::getVoltage).withWidget(BuiltInWidgets.kVoltageView);
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
