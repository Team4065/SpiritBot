// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Cannon extends SubsystemBase {
  double Target;
  /** Creates a new Cannon. */
  public Cannon() {}

  private Talon TiltMotor = new Talon(Constants.m_TiltMotor);

  private DigitalInput StopPoint = new DigitalInput(0);
  private AnalogPotentiometer potentiometer = new AnalogPotentiometer(0, 360, 0);

  //private double kp = 0.1, ki = 0.01, kd = 0.001;
  //public PIDController pid = new PIDController(kp, ki, kd);
  @Override
  public void periodic() {
    /*if (potentiometer.get() < Constants.m_CannonStopPoint) {
      TiltMotor.set(pid.calculate(potentiometer.get(), Target));
    } else {
      TiltMotor.set(0);
    }*/
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Cannon Angle", potentiometer.get());
    SmartDashboard.putBoolean("Cannon Bottom Limit", StopPoint.get());
  }
  
  /*public void setAngle(double target) {
    Target = target;
  }*/

  public void setTilt(double speed) {
    TiltMotor.set(speed);
    if (/*(potentiometer.get() < Constants.m_CannonStopPoint && speed < 0) && */ (getStopPoint() && speed < 0)) {
      TiltMotor.set(speed);
    } else {
      TiltMotor.set(0);
    }
  }

  /*public double getAngle() {
    return potentiometer.get();
  }*/

  public boolean getStopPoint() {
    return StopPoint.get();
  }
}
