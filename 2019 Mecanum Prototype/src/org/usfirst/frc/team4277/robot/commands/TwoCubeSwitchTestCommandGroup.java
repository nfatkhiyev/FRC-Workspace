package org.usfirst.frc.team4277.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TwoCubeSwitchTestCommandGroup extends CommandGroup {

    public TwoCubeSwitchTestCommandGroup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	addSequential(new AutoTestCommand(-4.5,8.2,0.0,2.85));
    	addSequential(new AutoTestCommand(4.5,-8.2,0.0,2.85));
    	addParallel(new IntakeCubeCommand());
    	addSequential(new AutoTestCommand(0.0,5.0,0.0,1.6));
    	addSequential(new AutoTestCommand(0.0,-5.0,0.0,1.6));
    	addSequential(new AutoTestCommand(-4.5,8.2,0.0,2.85));
    }
}
