package frc;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.Button;

/**
 * @author James@team2168.org
 */
public class TriggerButtons extends Button {

  GenericHID m_joystick;
  int m_axisNumber;
  private double THRESHOLD = 0.5;

  /**
   * Create a button for triggering commands off a joystick's analog axis
   * 
   * @param joystick The GenericHID object that has the button (e.g. Joystick, KinectStick, etc)
   * @param axisNumber The axis number
   */
  public TriggerButtons(GenericHID joystick, int axisNumber) {
      m_joystick = joystick;
      m_axisNumber = axisNumber;
  }

  /**
   * Create a button for triggering commands off a joystick's analog axis
   * 
   * @param joystick The GenericHID object that has the button (e.g. Joystick, KinectStick, etc)
   * @param axisNumber The axis number
   * @param threshold The threshold to trigger above (positive) or below (negative)
   */
  public TriggerButtons(GenericHID joystick, int axisNumber, double threshold) {
  	m_joystick = joystick;
      m_axisNumber = axisNumber;
      THRESHOLD = threshold;
  }

  /**
   * Set the value above which triggers should occur (for positive thresholds)
   *  or below which triggers should occur (for negative thresholds)
   * The default threshold value is 0.5
   *  
   * @param threshold the threshold value (1 to -1)
   */
  public void setThreshold(double threshold){
  	THRESHOLD = threshold;
  }
 
  /**
   * Get the defined threshold value.
   * @return the threshold value
   */
  public double getThreshold(){
  	return THRESHOLD;
  }
  

  public boolean get() {
    if(THRESHOLD < 0){
      return m_joystick.getRawAxis(m_axisNumber) < THRESHOLD;    //Return true if axis value is less than negative threshold
    } else {
      return m_joystick.getRawAxis(m_axisNumber) > THRESHOLD;    //Return true if axis value is greater than positive threshold
    }
  }

}