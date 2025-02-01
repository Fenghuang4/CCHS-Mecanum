// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Subsystems.Drivetrain;

public class RobotContainer {
  private final Drivetrain drivetrain;
  private final CommandXboxController controller;
  private final SendableChooser<Command> autoChooser;

  public RobotContainer() {
    drivetrain = new Drivetrain();
    controller = new CommandXboxController(0);
    configureBindings();

    drivetrain.setDefaultCommand(
    drivetrain.drive(() -> controller.getLeftX(), ()-> controller.getLeftY(), ()-> controller.getRightX())
    );

    autoChooser = new SendableChooser<Command>();
    autoChooser.addOption("Mobility", drivetrain.mobilityAuto());
    autoChooser.addOption("None", Commands.print("No autonomous command configured"));
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return autoChooser.getSelected();
  }
}
