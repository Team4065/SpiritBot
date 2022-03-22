// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Horn extends SubsystemBase {
  private Relay HornCompressor = new Relay(Constants.m_HornCompressor);
  /** Creates a new Horn. */
  public Horn() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public boolean getRelay() {
    return (HornCompressor.get() == Relay.Value.kForward);
  }

  public void setValve(boolean trigger) {
    if (trigger) {
      HornCompressor.set(Relay.Value.kForward);;
    } else {
      HornCompressor.set(Relay.Value.kOff);
    }
  }
}
