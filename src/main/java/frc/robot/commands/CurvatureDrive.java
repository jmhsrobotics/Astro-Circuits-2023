// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.Drivetrain;

public class CurvatureDrive extends CommandBase {

  private final Drivetrain drivetrain;
  private final Supplier<Double> forwardSpeed, turnSpeed;
  public static boolean isSlow = false;
  public static boolean turnButton = false;
  /** Creates a new CurvatureDrive. */
  public CurvatureDrive(Drivetrain Drivetrain, Supplier<Double> forwardSpeed, Supplier<Double> turnSpeed) {
    this.drivetrain = Drivetrain;
    this.forwardSpeed = forwardSpeed;
    this.turnSpeed = turnSpeed;
    addRequirements(drivetrain);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("init CurvatureDrive");
    isSlow = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (isSlow) 
    {
      this.drivetrain.m_robotDrive.curvatureDrive(-forwardSpeed.get() * DriveConstants.SLOW_SPEED_FRACTION, turnSpeed.get() * DriveConstants.SLOW_SPEED_FRACTION, turnButton);
    }
    else
    {
      this.drivetrain.m_robotDrive.curvatureDrive(-forwardSpeed.get(), turnSpeed.get(), turnButton);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
  
  @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}

