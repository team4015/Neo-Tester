package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.Joystick;

public class Match extends TimedRobot
{
  static final int MOTOR_PWM_CHANNEL = 5;
  static final int CONTROLLER_USB_PORT = 2;

  static final int MOTOR_FORWARD_BUTTON = 2;
  static final int MOTOR_REVERSE_BUTTON = 3;

  static final double MOTOR_SPEED = 0.5;

  PWMSparkMax motor;
  Joystick controller;

  @Override
  public void robotInit()
  {
    motor = new PWMSparkMax(MOTOR_PWM_CHANNEL);
    controller = new Joystick(CONTROLLER_USB_PORT);
  }

  @Override
  public void disabledInit()
  {
    motor.set(0);
  }

  @Override
  public void teleopInit()
  {
    motor.set(0);
  }

  @Override
  public void teleopPeriodic()
  {
    if (controller.getRawButton(MOTOR_FORWARD_BUTTON))
    {
      motor.set(MOTOR_SPEED);
    }
    else if (controller.getRawButton(MOTOR_REVERSE_BUTTON))
    {
      motor.set(-MOTOR_SPEED);
    }
    else
    {
      motor.set(0);
    }
  }
}
