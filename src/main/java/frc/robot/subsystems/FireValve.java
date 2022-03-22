// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FireValve extends SubsystemBase {
  private Relay FireVal = new Relay(Constants.m_FillValve);
  /** Creates a new FireValve. */
  public FireValve() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public Relay.Value getRelay() {
    return FireVal.get();
  }

  public void setValve(boolean trigger) {
    if (trigger) {
      FireVal.set(Relay.Value.kForward);;
    } else {
      FireVal.set(Relay.Value.kOff);
    }
  }
}