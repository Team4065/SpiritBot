// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Horn extends SubsystemBase {
  private Relay HornCompressor = new Relay(Constants.m_HornCompressor, Direction.kForward);
  /** Creates a new Horn. */
  public Horn() {}

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Horn On?", getRelay());

    if (getRelay()){
      RobotContainer.XboxC.setRumble(RumbleType.kRightRumble, 1);
    }else{
      RobotContainer.XboxC.setRumble(RumbleType.kRightRumble, 0);
    }
    // This method will be called once per scheduler run
  }

  public boolean getRelay() {
    return (HornCompressor.get() == Relay.Value.kOn);
  }

  public void setValve(boolean trigger) {
    if (trigger) {
      HornCompressor.set(Value.kForward);;
    } else {
      HornCompressor.set(Value.kOff);
    }
  }
}
