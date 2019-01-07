/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SerialPort;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public interface RobotMap {
  //Drive TalonSRX
	public static int FRONT_LEFT_TALON = 2;
	public static int BACK_LEFT_TALON = 3;
	public static int FRONT_RIGHT_TALON = 4;
	public static int BACK_RIGHT_TALON = 5;
	
  //Joysticks
	public static Joystick driveStick = new Joystick(0);
	
  //NavX Gyro
	public static AHRS navX = new AHRS(SerialPort.Port.kMXP);
}
