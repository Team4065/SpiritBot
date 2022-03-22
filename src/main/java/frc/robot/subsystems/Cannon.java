// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Cannon extends SubsystemBase {
  /** Creates a new Cannon. */
  public Cannon() {}

  private Talon TiltMotor = new Talon(Constants.m_TiltMotor);

  private DigitalInput StopPoint = new DigitalInput(0);
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setTilt (double speed) {
    TiltMotor.set(speed);
  }

  public boolean getStopPoint() {
    return StopPoint.get();
  }
}