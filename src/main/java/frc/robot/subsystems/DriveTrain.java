// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class DriveTrain extends SubsystemBase {
  public int driveMode = Constants.m_drivemode;
  /** Creates a new DriveTrain. */
  public DriveTrain() {
    LM.setInverted(Constants.m_LeftSideInvert);
    RM.setInverted(Constants.m_RightSideInvert);
  }
  
  // Creates Motorcontroller
  //Right
  private final Spark RM = new Spark(Constants.m_RightMotor);
  //left
  private final Spark LM = new Spark(Constants.m_LeftMotor);
  DifferentialDrive drive = new DifferentialDrive(LM, RM);
  @Override
  public void periodic() {
    SmartDashboard.putNumber("DriveMode", driveMode);
    //System.out.println(driveMode);
    // This method will be called once per scheduler run
  }
  //Setting Commands
  public void setForward(double speed) {
    drive.tankDrive(speed, speed);
  }

  public void setTurn(double speed) {
    drive.tankDrive(speed, -speed);
  }

  public void setLeft(double speed) {
    drive.tankDrive(speed, 0);
  }

  public void setRight(double speed) {
    drive.tankDrive(0, speed);
  }

  public void setDrive(int driveMode) {
    if (driveMode == 1) {
      drive.tankDrive(RobotContainer.getDeadZoneWithRamp(1), RobotContainer.getDeadZoneWithRamp(5));
    } else if (driveMode == 2) {
      drive.arcadeDrive(RobotContainer.getDeadZoneWithRamp(1), RobotContainer.getDeadZoneWithRamp(4));
    } else if (driveMode == 3) {
      drive.curvatureDrive(RobotContainer.getDeadZoneWithRamp(1), RobotContainer.getDeadZoneWithRamp(4), false);
    } else {
      System.out.println("Error: Not a Drive Mode\n1 = Tank\n2 = Arcade\n3 = Curvature");
    }
  }
}
