// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

<<<<<<< Updated upstream
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
=======
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.TriggerButtons;
import frc.robot.commands.Drive;
import frc.robot.commands.FireCannon;
import frc.robot.commands.ManuelFill;
import frc.robot.commands.changeDriveMode;
import frc.robot.commands.fillToPSI;
import frc.robot.commands.horn;
import frc.robot.commands.setCannon;
import frc.robot.subsystems.Cannon;
import frc.robot.subsystems.CannonRewrite;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.FillTankValve;
import frc.robot.subsystems.FireValve;
import frc.robot.subsystems.Horn;
>>>>>>> Stashed changes

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
<<<<<<< Updated upstream
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
=======
  public final static DriveTrain m_DriveTrain = new DriveTrain();
  public final static CannonRewrite M_Cannon = new CannonRewrite();
  public final static FireValve m_FireValve = new FireValve();
  public final static Horn m_Horn = new Horn();
  public final static FillTankValve m_FillTankValve = new FillTankValve();
>>>>>>> Stashed changes

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }
<<<<<<< Updated upstream
=======
  public static Joystick XboxC = new Joystick(Constants.JOYSTICK_PORT);

  public static double getDeadZone (int axis){
    if (Math.abs(XboxC.getRawAxis(axis)) < Constants.m_Deadzone) {
      return 0.0;
    } else {
      return XboxC.getRawAxis(axis);
    }
  }

  public static double getRawAxis (int axis){
    return XboxC.getRawAxis(axis);
  }

  public static double getDeadZoneWithRamp (int axis){
    if (Math.abs(XboxC.getRawAxis(axis)) < Constants.m_Deadzone) {
      return 0.0;
    } else {
      return getAxisRamped(axis);
    }
  }

  public static double getAxisRamped(int axis) {
    return (2/(1+Math.pow(Math.E, -4*XboxC.getRawAxis(axis))))-1;
  }

  //Controller buttons
  public static JoystickButton AB = new JoystickButton(XboxC, 1);
  public static JoystickButton BB = new JoystickButton(XboxC, 2);
  public static JoystickButton XB = new JoystickButton(XboxC, 3);
  public static JoystickButton YB = new JoystickButton(XboxC, 4);
  public static JoystickButton LB = new JoystickButton(XboxC, 5);
  public static JoystickButton RB = new JoystickButton(XboxC, 6);
  public static JoystickButton VB = new JoystickButton(XboxC, 7);
  public static JoystickButton MB = new JoystickButton(XboxC, 8);
  public static JoystickButton LJB = new JoystickButton(XboxC, 9);
  public static JoystickButton RJB = new JoystickButton(XboxC, 10);
  //Dpad
  public static POVButton up = new POVButton(XboxC, 0);
  public static POVButton right = new POVButton(XboxC, 90);
  public static POVButton down = new POVButton(XboxC, 180);
  public static POVButton left = new POVButton(XboxC, 270);

  public static TriggerButtons leftTrig = new TriggerButtons(XboxC, 2, .2);
  public static TriggerButtons RightTrig = new TriggerButtons(XboxC, 3, .2);
>>>>>>> Stashed changes

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
<<<<<<< Updated upstream
  private void configureButtonBindings() {}
=======
  private void configureButtonBindings() {
    VB.onFalse(new changeDriveMode());//change drive mode

    up.onTrue(new setCannon("Up"));//cannon up
    up.onFalse(new setCannon("stop"));//cannon Stop
    down.onTrue(new setCannon("Down"));//cannon down
    down.onFalse(new setCannon("stop"));//cannon Stop

    // up.whileTrue(new CannonSpeed("forward", 0.2));

    // down.whileTrue(new CannonSpeed("downward", 0.2));

    // left.onFalse(new CannonToZero());//cannon reset

    YB.onTrue(new fillToPSI(90));//long fill set
    BB.onTrue(new fillToPSI(60));//mid fill set
    AB.onTrue(new fillToPSI(30));// short set
    XB.onTrue(new ManuelFill(true));//Manual on
    XB.onFalse(new ManuelFill(false));//Manual off
    
    LB.onTrue(new horn(true));//Horn on
    LB.onFalse(new horn(false));//Horn off

    RB.onTrue(new FireCannon());//Shoot Cannon
>>>>>>> Stashed changes

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
