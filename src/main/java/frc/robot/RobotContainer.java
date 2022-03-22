// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Drive;
import frc.robot.subsystems.Cannon;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.FillTankValve;
import frc.robot.subsystems.FireValve;
import frc.robot.subsystems.Horn;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final static DriveTrain m_DriveTrain = new DriveTrain();
  public final static Cannon M_Cannon = new Cannon();
  public final static FireValve m_FireValve = new FireValve();
  public final static Horn m_Horn = new Horn();
  public final static FillTankValve m_FillTankValve = new FillTankValve();

  public final Drive m_TankDrive = new Drive();
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }
  public static Joystick XboxC = new Joystick(Constants.JOYSTICK_PORT);

  public static double getDeadZone (int axis){
    if (Math.abs(XboxC.getRawAxis(axis)) < 0.1) {
      return 0.0;
    } else {
      return XboxC.getRawAxis(axis);
    }
  }
  
  //Controller buttons
  public static JoystickButton AB = new JoystickButton(XboxC, 1);
  public static JoystickButton BB = new JoystickButton(XboxC, 2);
  public static JoystickButton XB = new JoystickButton(XboxC, 3);
  public static JoystickButton YB = new JoystickButton(XboxC, 4);
  public static JoystickButton LB = new JoystickButton(XboxC, 5);
  public static JoystickButton RB = new JoystickButton(XboxC, 6);
  public static JoystickButton HB = new JoystickButton(XboxC, 7);
  public static JoystickButton ZB = new JoystickButton(XboxC, 8);
  public static JoystickButton LJB = new JoystickButton(XboxC, 9);
  public static JoystickButton RJB = new JoystickButton(XboxC, 10);
  //Dpad
  public static POVButton up = new POVButton(XboxC, 0);
  public static POVButton right = new POVButton(XboxC, 90);
  public static POVButton down = new POVButton(XboxC, 180);
  public static POVButton left = new POVButton(XboxC, 270);

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_TankDrive;
  }
}
