package org.usfirst.frc.team4277.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.kauailabs.sf2.frc.*;
import com.kauailabs.navx.frc.*;
/**
 *
 */
public class calibrationSystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	AHRS ahrs;
	navXSensor navX;// = new navXSensor(AHRS navx_sensor, java.lang.String sensor_name) 
	public calibrationSystem() {
		
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

