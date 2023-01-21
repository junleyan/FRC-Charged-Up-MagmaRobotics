// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public class Constants {
  

    public static final class PWM{

        public static final int leftDrive = 0;
        public static final int rightDrive = 1;

    }


    public static class JoyStickAxis{


        public static class JoystickController {

            public static final int positionJoystick = 1;
            public static final int angleJoystick = 2;
            public static final int speedJoystick = 3;

        }


        public static class XboxController {

            
            public static final int leftJoystick = 1;
            public static final int rightJoystick = 4;

        }
       

    }


    public static class Button{

        public static final int armButton = 5;
        public static final int armButton2 = 6;

    }


    public static class ControllerPort{

        public static final int driver = 0;

    }


    public static class Subsystems{


        public static class UpperArm{

            public static final double speed = 0.3;
            public static final int port = 3;

        }

        public static class LowerArm{

            public static final double speed = 0.3;
            public static final int port = 3;

        }


    }

}
