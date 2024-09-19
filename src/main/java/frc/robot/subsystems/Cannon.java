// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Cannon extends SubsystemBase {
  private TalonSRX TiltMotor = new TalonSRX(Constants.CannonConstants.m_TiltMotor);
  private DigitalInput LimitSwitch = new DigitalInput(Constants.CannonConstants.LimitSwich);

  Double Target;// in ticks
  
  /** Creates a new Cannon. */
  public Cannon() {
    TiltMotor.selectProfileSlot(0, 0);
    TiltMotor.configAllowableClosedloopError(0, 1);
    // TiltMotor.configForwardSoftLimitThreshold(6000);
    // TiltMotor.configForwardSoftLimitEnable(true);
    // TiltMotor.configReverseSoftLimitThreshold(0);
    // TiltMotor.configReverseSoftLimitEnable(true);

    setAngle(0.0);

    TiltMotor.config_kP(0, 7);
    TiltMotor.config_kI(0, 0);
    TiltMotor.config_kD(0, 0);
    Target = 0.0;

    // TiltMotor.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Cannon Angle", getEncoderVal());
    SmartDashboard.putBoolean("Cannon Bottom Limit", getStopPoint());
    SmartDashboard.putNumber("Target", TiltMotor.getClosedLoopTarget());
    SmartDashboard.putNumber("Position", getAngle());
    SmartDashboard.putNumber("Volt Applied", TiltMotor.getMotorOutputVoltage());

    if(LimitSwitch.get()){
      zeroEncoder();
    }

    TiltMotor.set(TalonSRXControlMode.Position, Target);
// 
  }

  public void setSpeed(double speed) {
    TiltMotor.set(TalonSRXControlMode.PercentOutput, speed);
  }
  
  public void setAngle(Double target) {
    Target = target;
  }

  public void changeAngle(Double change){
    if(Target > 0 && change < 0 && getStopPoint()){
      System.out.println();
    }else{
    }
    Target = change + TiltMotor.getClosedLoopTarget();
  } 


  public void setTilt(double speed) {
    TiltMotor.set(TalonSRXControlMode.Position, speed);
  }

  public double getEncoderVal() {
    return TiltMotor.getSelectedSensorPosition();
  }

  public double getAngle(){
    return (TiltMotor.getSelectedSensorPosition()) / 12 / 10; //Sensor is 10:1 with arm rotation
  }

  public void zeroEncoder(){
    TiltMotor.setSelectedSensorPosition(24);
    TiltMotor.set(TalonSRXControlMode.Position, 0);
  }

  public boolean getStopPoint() {
    return LimitSwitch.get();
  }
}
