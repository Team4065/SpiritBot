// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class CannonToZero extends Command {
  private boolean fin = false;
  /** Creates a new CannonToZero. */
  public CannonToZero() {
    addRequirements(RobotContainer.M_Cannon);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // while (!RobotContainer.M_Cannon.getStopPoint()) {
    //     System.out.println("Zeroing");
    //     RobotContainer.M_Cannon.setAngle(0);
    //   }
    //   RobotContainer.M_Cannon.setTilt(0);
      RobotContainer.M_Cannon.resetEncoder();
      // System.out.println("Zeroed");
      fin = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return fin;
  }
}
