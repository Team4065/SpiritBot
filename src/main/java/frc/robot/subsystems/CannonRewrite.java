// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CannonRewrite extends SubsystemBase {
  /** Creates a new CannonRewrite. */
  private TalonSRX TiltMotor = new TalonSRX(Constants.CannonConstants.m_TiltMotor);
  private DigitalInput LimitSwitch = new DigitalInput(Constants.CannonConstants.LimitSwich);

  PIDController pid = new PIDController(0.045, 0, 0);

  double target;

  public CannonRewrite() {
    target = 5;
    TiltMotor.setNeutralMode(NeutralMode.Brake);
  }

  public  double clamp(double value, double min, double max) {
    return Math.max(min, Math.min(max, value));
  }

  public void setAngle(double angle) {
    target = angle;
  }


  @Override
  public void periodic() {
    double pidOutput = clamp(pid.calculate(getAngle(), target), -1, 1);

    SmartDashboard.putNumber("PID", pidOutput);

    setSpeed(pidOutput);

    SmartDashboard.putNumber("Cannon Angle", getEncoderVal());
    SmartDashboard.putBoolean("Cannon Bottom Limit", getStopPoint());
    SmartDashboard.putNumber("Target- Rewrite", target);
    SmartDashboard.putNumber("Position", getAngle());
    SmartDashboard.putNumber("Volt Applied", TiltMotor.getMotorOutputVoltage());

    // if (LimitSwitch.get()) {
      // resetEncoder();
    // }
  }



  public double getAngle() {
    return (TiltMotor.getSelectedSensorPosition()) / 12 / 10; //Sensor is 10:1 with arm rotation
  }

  public void resetEncoder() {
    TiltMotor.setSelectedSensorPosition(24);
  }

  public double getEncoderVal() {
    return TiltMotor.getSelectedSensorPosition();
  }

  final double MIN_ANGLE = 5;
  final double MAX_ANGLE = 45;

  public void changeAngle(double change) {
    if (getStopPoint() && change < 0 && target <= MIN_ANGLE) {
        target = MIN_ANGLE;
    } else if (target >= MAX_ANGLE && change > 0) {
        target = MAX_ANGLE;
    } else {
        target += change;
        target = Math.max(MIN_ANGLE, Math.min(target, MAX_ANGLE));        
    }
  }


  public void setSpeed(double percent) {
    TiltMotor.set(TalonSRXControlMode.PercentOutput, percent);
  }

  public boolean getStopPoint() {
    return LimitSwitch.get();
  }
}
