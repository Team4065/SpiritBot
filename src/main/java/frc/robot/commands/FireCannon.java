// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RobotContainer;

public class FireCannon extends CommandBase {
  boolean done = false;
  /** Creates a new FireCannon. */
  public FireCannon() {
    addRequirements(RobotContainer.m_FireValve);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_FireValve.setValve(false);
    new WaitCommand(.2);
    RobotContainer.m_FireValve.setValve(true);
    done = true;
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  }
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_FireValve.setValve(false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return done;
  }
}
