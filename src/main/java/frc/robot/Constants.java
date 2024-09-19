// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
<<<<<<< Updated upstream
public final class Constants {}
=======
public final class Constants {
    //RoboRio PWM
    public static final int m_LeftMotor = 0;
    public static final int m_RightMotor = 1;
    //RoboRio Relay
    public static final int m_FillValve = 0;
    public static final int m_HornCompressor = 2;
    //RoboRio Analog in
    public static final int m_PSIGuage = 1;
    //Motor Inverts
    public static final boolean m_LeftSideInvert = false;
    public static final boolean m_RightSideInvert = true;
    //Contorller Port
    public static final int JOYSTICK_PORT = 0;
    //presets
    public static final int m_drivemode = 1;//Drive Modes 1 = Tank 2 = Arcade 3 = Curvature
    public static final double m_TriggerPoint = 0.75;
    public static final double m_RamingExponet = 2;
    public static final double m_hornlenght = 0.5;
    public static final double m_Deadzone = 0.02;
    public static final double m_FillValveTimeout = 5;
    public static final double m_HornTimeout = 5;
    public static final double m_FirerValveTimeout = 5;
    
    public final class CannonConstants{
        public static final int m_TiltMotor = 1;
        public static final int m_FireValve = 3;
        public static final int LimitSwich = 9;
        public static final double TiltSpeed = 0.75;
    }
}
>>>>>>> Stashed changes
