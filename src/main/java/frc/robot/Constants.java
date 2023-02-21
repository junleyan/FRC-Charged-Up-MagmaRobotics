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


    public static class Control {

        public static class ControllerPort {
            public static final int kDRIVER = 0;
        }

        public static class JoystickController {
            public static final int kPOSITION = 1;
            public static final int kANGLE = 2;
            public static final int kSPEED = 3;
        }

        public static class XboxController {
            public static final int leftJoystick = 1;
            public static final int rightJoystick = 5;
        }

        public static class Button {
            public static final int kA = 1;
            public static final int kB = 2;
            public static final int kX = 3;
            public static final int kY = 4;
            public static final int kRIGHT_BUMPER = 5;
            public static final int kLEFT_BUMPER = 6;
        }

        public static class POVButton {
            public static final int kUP = 0;
            public static final int kDOWN = 180;
            public static final int kLEFT = 90;
            public static final int kRIGHT = 270;
        }

    }


    public static class Subsystems{

        public static final class DriveTrain {
            public static final int kLEFT = 6;
            public static final int kRIGHT = 5;
    
        }

        public static class LowerArm {
            public static final double kPOWER = 0.2;
            public static final int kPORT = 3;
        }

        public static class LowerArm2 {
            public static final double kPOWER = 0.2;
            public static final int kPORT = 2;
        }

        public static class UpperArm {
            public static final double kPOWER = 0.15;
            public static final int kPORT = 0;
        }

        public static class UpperArm2 {
            public static final double kPOWER = 0.15;
            public static final int kPORT = 1;
        }

        public static class Claw {
            public static final double kPOWER = 0.8;
            public static final int kPORT = 4;
            public static final double kCloseLimit = 0;
            public static final double kOpenLimit = 300; 
        }

        public static class ClawServo{
            public static final double kPOWER = 0.5;
            public static final int kPORT = 7;
        }

    }



    public static class PIDController {

        public static class BalancePID {
            public static final int kSetpoint = 0;
            public static final double kP = 0.1;
            public static final double kI = 0.05;
            public static final double kD = 0.5;
        }

    }


}