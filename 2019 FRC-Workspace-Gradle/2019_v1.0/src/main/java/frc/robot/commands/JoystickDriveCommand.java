
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;


public class JoystickDriveCommand extends Command implements  RobotMap{

	
	public JoystickDriveCommand() {
		super("JoystickDriveCommand");
		requires(Robot.mecanumDrive);
	}
	
	protected void initialize() {
		
	}
	
	protected void  execute() {
		if(driveStick.getRawAxis(3) > 0) 
			Robot.mecanumDrive.mecaumDriveJoystick(driveStick);
		
		else if(driveStick.getRawAxis(3) < 0)
			Robot.mecanumDrive.fieldOrientedMecanumDriveJoystick(driveStick, navX.getAngle());
	}
	
	@Override
	protected boolean isFinished() {
		// return true when this command no longer needs to run
		return false;
	}
	
	protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

}
