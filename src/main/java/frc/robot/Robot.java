// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Robot extends TimedRobot {
  WPI_VictorSPX left1 = new WPI_VictorSPX(1);
  WPI_VictorSPX left2 = new WPI_VictorSPX(2);
  WPI_VictorSPX right1 = new WPI_VictorSPX(3);
  WPI_VictorSPX right2 = new WPI_VictorSPX(4);

  MotorControllerGroup left = new MotorControllerGroup(left1, left2);
  MotorControllerGroup right = new MotorControllerGroup(right1, right2);

  DifferentialDrive mainDrive = new DifferentialDrive(left, right);

  Joystick driver = new Joystick(0);
  
  /** This function is called once when the code starts */
  @Override
  public void robotInit() {
    
  }

  /** this function is called periodically while the code runs */
  @Override
  public void robotPeriodic() {

  }

  /** This function is called once when autonomous is enabled. */
  @Override
  public void autonomousInit() {

  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {

  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {

  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {

    double x = driver.getRawAxis(0);
    double y = driver.getRawAxis(1);

    if(Math.sqrt(x*x + y*y) > 0.04) {
      mainDrive.arcadeDrive(y, x);
    } else {
      mainDrive.arcadeDrive(0, 0);
    }
  }

}
