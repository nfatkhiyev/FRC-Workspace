/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.RobotController;
import frc.robot.Robot;
import frc.robot.subsystems.*;

public class MotionProfileDriveCommand extends Command {

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
	double rotationZ;
	double durration;

    public MotionProfileDriveCommand(Double inputDistanceX, Double inputDistanceY, Double inputDegrees, Double inputDurration) {

    	requires(Robot.motionProfile);
    	
    	if(inputDistanceX < 0) isXNeg = true;
    	if(inputDistanceY < 0) isYNeg = true;
    	if(inputDegrees < 0) isThetaNeg = true;
    	
    	distanceX = Math.abs(inputDistanceX);
    	distanceY = Math.abs(inputDistanceY);
    	rotationZ = Math.abs(inputDegrees);
      
      durration = inputDurration;
    	
    }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    startTime = RobotController.getFPGATime();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    	
    if((RobotController.getFPGATime() - startTime)/1000000 >= durration) {
      finish = true;
    }
    
    normalizeDrive();
    Robot.mecanumDrive.autonomousMecanumDrive(driveX, driveY, driveZ, Robot.m_oi.getGyro());
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
      driveX = -Robot.motionProfile.calculateDriveValues(distanceX, distanceY, rotationZ, durration, startTime)[0];
    }
    else if(!isXNeg) {
      driveX = Robot.motionProfile.calculateDriveValues(distanceX, distanceY, rotationZ, durration, startTime)[0];
    }
    
    if(isYNeg) {
      driveY = -Robot.motionProfile.calculateDriveValues(distanceX, distanceY, rotationZ, durration, startTime)[1];
    }
    else if (!isYNeg) {
      driveY = Robot.motionProfile.calculateDriveValues(distanceX, distanceY, rotationZ, durration, startTime)[1];;
    }
    
    if(isThetaNeg) {
      driveZ = -Robot.motionProfile.calculateDriveValues(distanceX, distanceY, rotationZ, durration, startTime)[2];
    }
    else if(!isThetaNeg) {
      driveZ = Robot.motionProfile.calculateDriveValues(distanceX, distanceY, rotationZ, durration, startTime)[2];
    }
  }
}
