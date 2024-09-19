// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class ManuelFill extends Command {
  private boolean state;
  private boolean fin = false;
  private Timer time = new Timer();
  /** Creates a new ManuelFill. */
  public ManuelFill(boolean state) {
    this.state = state;
    addRequirements(RobotContainer.m_FillTankValve);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_FillTankValve.setValve(state);
    if (state){
      time.reset();
      time.start();
    }else {
      time.stop();
      fin = true;
    }
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_FillTankValve.setValve(false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (fin || time.hasElapsed(Constants.m_FillValveTimeout));
  }
}
