package org.usfirst.frc.team4277.robot.commands;

import org.usfirst.frc.team4277.robot.Robot;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTestCommand extends Command {
	
	double startTime;
	
	boolean finish  = false;
	boolean isXNeg = false;
	boolean isYNeg = false;
	boolean isThetaNeg = false;
	
	double driveX;
	double driveY;
	double driveZ;
	
	double distanceX;
	double distanceY;
	double degrees;
	double durration;

    public AutoTestCommand(Double inputDistanceX, Double inputDistanceY, Double inputDegrees, Double inputDurration) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.mecanumDrive);
    	
    	if(inputDistanceX < 0) isXNeg = true;
    	if(inputDistanceY < 0) isYNeg = true;
    	if(inputDegrees < 0) isThetaNeg = true;
    	
    	distanceX = Math.abs(inputDistanceX);
    	distanceY = Math.abs(inputDistanceY);
    	durration = inputDurration;
    	degrees = Math.abs(inputDegrees);
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime = RobotController.getFPGATime();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if((RobotController.getFPGATime() - startTime)/1000000 >= durration) {
    		finish = true;
    	}
    	
    	normalizeDrive();
    	//Robot.mecanumDrive.autonomousMecanumDrive(driveX, driveY, driveZ, 0.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finish;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.mecanumDrive.autonomousMecanumStop();
    	finish = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.mecanumDrive.autonomousMecanumStop();
    }
    
    protected void normalizeDrive() {
    	
    	if(isXNeg) {
    		driveX = -Robot.mecanumDrive.calculateLMDriveVector(distanceX, distanceY, durration, startTime).x;
    	}
    	else if(!isXNeg) {
    		driveX = Robot.mecanumDrive.calculateLMDriveVector(distanceX, distanceY, durration, startTime).x;
    	}
    	
    	if(isYNeg) {
    		driveY = -Robot.mecanumDrive.calculateLMDriveVector(distanceX, distanceY, durration, startTime).y;
    	}
    	else if (!isYNeg) {
    		driveY = Robot.mecanumDrive.calculateLMDriveVector(distanceX, distanceY, durration, startTime).y;
    	}
    	
    	if(isThetaNeg) {
    		driveZ = -Robot.mecanumDrive.calculateLMRotationalVelocity(degrees, durration, startTime);
    	}
    	else if(!isThetaNeg) {
    		driveZ = Robot.mecanumDrive.calculateLMRotationalVelocity(degrees, durration, startTime);
    	}
    }
}
