// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class horn extends CommandBase {
  private Relay.Value KF;
  private Relay.Value KOFF;
  /** Creates a new Horn. */
  public horn() {
    addRequirements(RobotContainer.m_Horn);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    KF = Relay.Value.kForward;
    if (RobotContainer.m_FireValve.getRelay() == KF) {
      RobotContainer.m_FireValve.setValve(false);
    } else if (RobotContainer.m_FireValve.getRelay() == KOFF) {
      RobotContainer.m_FireValve.setValve(true);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
