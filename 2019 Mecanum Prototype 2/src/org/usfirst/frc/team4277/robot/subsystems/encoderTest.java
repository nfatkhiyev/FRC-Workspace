package org.usfirst.frc.team4277.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class encoderTest extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	WPI_TalonSRX encoderMotor;
	public encoderTest(int port) {
		encoderMotor = new WPI_TalonSRX(port);
	}

	public void runMotor() {
		encoderMotor.set(ControlMode.PercentOutput, 0.5);
	}
	
	public double getEncoderMotorSpeed() {
		double speed = encoderMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, arg2)
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

