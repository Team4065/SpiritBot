// Copyright (c) FIRST and other WPILib cstatetributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class horn extends Command {
  private Timer timer = new Timer();
  private boolean state;
  private boolean fin = false;
  /** Creates a new Horn. */
  public horn(boolean state) {
    this.state = state;
    addRequirements(RobotContainer.m_Horn);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(state){
      RobotContainer.m_Horn.setValve(state);
      timer.reset();
      timer.start();
    }else{
      RobotContainer.m_Horn.setValve(state);
      timer.stop();
      fin = true;
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called statece the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_Horn.setValve(false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (timer.hasElapsed(Constants.m_HornTimeout) || fin);
  }
}
