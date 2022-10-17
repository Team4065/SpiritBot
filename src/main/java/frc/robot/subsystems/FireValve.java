// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FireValve extends SubsystemBase {
  private Relay FireVal = new Relay(Constants.m_FireValve, Direction.kForward);
  /** Creates a new FireValve. */
  public FireValve() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("Fire Valve", getRelay());

  }

  public boolean getRelay() {
    return (FireVal.get() == Relay.Value.kOn);
  }

  public void setValve(boolean trigger) {
    if (trigger) {
      FireVal.set(Value.kForward);
    } else {
      FireVal.set(Value.kOff);
    }
  }
}
