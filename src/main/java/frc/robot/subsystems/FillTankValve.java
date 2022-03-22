// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FillTankValve extends SubsystemBase {
  /** Creates a new FillTankValve. */
  public FillTankValve() {}
  private Relay FillVal = new Relay(Constants.m_FillValve , Relay.Direction.kForward);
  private AnalogPotentiometer psi = new AnalogPotentiometer(Constants.m_PSIGuage, 250, 25);
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public double getPSI() {
    return psi.get();
  }

  public Relay.Value getRelay() {
    return FillVal.get();
  }

  public void setValve(boolean trigger) {
    if (trigger) {
      FillVal.set(Relay.Value.kForward);;
    } else {
      FillVal.set(Relay.Value.kOff);
    }
  }
}