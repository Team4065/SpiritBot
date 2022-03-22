// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class DriveTrain extends SubsystemBase {
  public int driveMode = Constants.m_drivemode;
  /** Creates a new DriveTrain. */
  public DriveTrain() {
    left.setInverted(Constants.m_LeftSideInvert);
    right.setInverted(Constants.m_RightSideInvert);
  }
  // Creates Motorcontroller
  //Right
  private final Spark right = new Spark(Constants.m_RightMotor);
  //left
  private final Spark left = new Spark(Constants.m_LeftMotor);
  DifferentialDrive drive = new DifferentialDrive(left, right);
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

  public void setDrive(int driveMode) {
    if (driveMode == 1) {
      drive.tankDrive(RobotContainer.getDeadZone(1), RobotContainer.getDeadZone(5));
    } else if (driveMode == 2) {
      drive.arcadeDrive(RobotContainer.getDeadZone(1), RobotContainer.getDeadZone(4));
    } else if (driveMode == 3) {
      drive.curvatureDrive(RobotContainer.getDeadZone(1), RobotContainer.getDeadZone(4), false);
    } else {
      System.out.println("Error: Not a Drive Mode\n1 = Tank\n2 = Arcade\n3 = Curvature");
    }
  }
}
