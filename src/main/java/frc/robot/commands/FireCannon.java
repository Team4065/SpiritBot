// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class FireCannon extends Command {
  private boolean fin = false;
  private Timer time;
  /** Creates a new FireCannon. */
  public FireCannon() {
    addRequirements(RobotContainer.m_FireValve);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    time = new Timer();
    time.reset();
    time.start();
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.m_FireValve.setValve(true);
    System.out.println("on");
    Timer.delay(1);
    System.out.println("off");
    time.stop();
    RobotContainer.m_FireValve.setValve(false);
    fin = true;
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
