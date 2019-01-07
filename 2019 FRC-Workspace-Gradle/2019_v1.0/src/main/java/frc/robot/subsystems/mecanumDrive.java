/*
 * FRC Team 4277 mecanum drive subsystem
 * Version1.0
 */

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

@SuppressWarnings("deprecation")
public class mecanumDrive extends Subsystem {

	static WPI_TalonSRX FRONT_LEFT_TALON,BACK_LEFT_TALON,FRONT_RIGHT_TALON,BACK_RIGHT_TALON;
	RobotDrive drive;
	
	public mecanumDrive(int frontLeftMotor, int backLeftMotor, int frontRightMotor, int backRightMotor) {
		
		FRONT_LEFT_TALON = new WPI_TalonSRX(frontLeftMotor);
		BACK_LEFT_TALON = new WPI_TalonSRX(backLeftMotor);
		FRONT_RIGHT_TALON = new WPI_TalonSRX(frontRightMotor);
		BACK_LEFT_TALON = new WPI_TalonSRX(backRightMotor);
		
		drive = new RobotDrive(FRONT_LEFT_TALON,BACK_LEFT_TALON,FRONT_RIGHT_TALON,BACK_RIGHT_TALON);
	}
	
	public void mecaumDriveJoystick(Joystick driveStick) {
		 drive.mecanumDrive_Cartesian(driveStick.getX(), driveStick.getY(), driveStick.getZ(),0);
	}
	
	public void fieldOrientedMecanumDriveJoystick(Joystick driveStick, Double gyro) {
		drive.mecanumDrive_Cartesian(driveStick.getX(), driveStick.getY(), driveStick.getZ(), gyro);
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}

}
