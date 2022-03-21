// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  public DriveTrain() {
    FLM.setInverted(Constants.m_LeftSideInvert);
    BLM.setInverted(Constants.m_LeftSideInvert);

    FRM.setInverted(Constants.m_RightSideInvert);
    BRM.setInverted(Constants.m_RightSideInvert);
  }
  // Creates Mortercontroller
  //left
  private Spark FLM = new Spark(Constants.m_FrontLeftM);
  private Spark BLM = new Spark(Constants.m_BackLeftM);
  //Right
  private Spark FRM = new Spark(Constants.m_FrontRightM);
  private Spark BRM = new Spark(Constants.m_BackRightM);
  // Creates Mortercontroller groups
  public MotorControllerGroup left = new MotorControllerGroup(FLM, BLM);
  public MotorControllerGroup right = new MotorControllerGroup(FRM, BRM);

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  //Setting Commands
  public void setForward(double speed) {
    left.set(speed);
    right.set(speed);
  }

  public void setTurn(double speed) {
    left.set(speed);
    right.set(-speed);
  }

  public void setLeft(double speed) {
    left.set(speed);
  }

  public void setRight(double speed) {
    right.set(speed);
  }
}
