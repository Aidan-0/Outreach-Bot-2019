/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static WPI_TalonSRX Fl;
  public static WPI_TalonSRX Fr;
  public static WPI_TalonSRX Bl;
  public static WPI_TalonSRX Br;

  public double FlEncoder;
  public double FrEncoder;
  public double BlEncoder;
  public double BrEncoder;

  public static double deadZone = 0.05;

  public Drivetrain(int flid, int frid, int blid, int brid) {

    Fl = new WPI_TalonSRX(flid);
    Fr = new WPI_TalonSRX(frid);
    Bl = new WPI_TalonSRX(blid);
    Br = new WPI_TalonSRX(brid);

  }

  public static void Drive(Joystick driver1, Joystick driver2) {

    if (driver1.getY() > 0 + deadZone || driver1.getY() < 0 - deadZone) {

      Fl.set(driver1.getY());
      Fr.set(driver1.getY());
      Bl.set(driver1.getY());
      Br.set(driver1.getY());

      if (driver2.getX() < 0 - deadZone || driver2.getX() > 0 + deadZone) {

        if (driver2.getX() < 0) {

          Fr.set(driver2.getX());
          Br.set(driver2.getX());
       /* Fl.set(-driver2.getX());
        * Bl.set(-driver2.getX());
        */ 

        }
        if (driver2.getX() > 0 ) {

          Fl.set(driver2.getX());
          Bl.set(driver2.getX());
       /* Fr.set(-driver2.getX());
        * Br.set(-driver2.getX());
        */
        }

      }
    }
    /* else if () {
      Fl.set(0);
      Fr.set(0);
      Bl.set(0);
      Br.set(0);
    } */
    else {
      Fl.set(0);
      Fr.set(0);
      Bl.set(0);
      Br.set(0);
    }

  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
