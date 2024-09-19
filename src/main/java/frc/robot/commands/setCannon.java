// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class setCannon extends Command {
  private String state;
  private boolean fin = false;
  /** Creates a new setCannon. */
  public setCannon(String state) {
    this.state = state;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.M_Cannon);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }
  
  // Called every time the scheduler runs while the command is scheduled. 
  @Override
  public void execute() {
    switch (state){
      case "Up":
        RobotContainer.M_Cannon.changeAngle(Constants.CannonConstants.TiltSpeed);
        break;
      case "Down":
        RobotContainer.M_Cannon.changeAngle(-Constants.CannonConstants.TiltSpeed);
        break;
      case "stop":
        fin = true;
        break;
      default:
        fin = true;
        break;

    }

    // RobotContainer.M_Cannon.setTilt(state);
    // System.out.println(state);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //RobotContainer.M_Cannon.setTilt(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return fin;
  }
}
