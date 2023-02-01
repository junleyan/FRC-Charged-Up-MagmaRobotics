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
            public static final int driver = 0;
        }

        public static class JoystickController {
            public static final int positionJoystick = 1;
            public static final int angleJoystick = 2;
            public static final int speedJoystick = 3;
        }

        public static class XboxController {
            public static final int leftJoystick = 1;
            public static final int rightJoystick = 4;
        }

        public static class Button {
            public static final int armButton = 1;
            public static final int armButton2 = 2;
        }

        public static class POVButton {
            public static final int UP = 0;
            public static final int DOWN = 180;
            public static final int LEFT = 90;
            public static final int RIGHT = 270;
        }

    }


    public static class Subsystems{

        public static final class DriveTrain {
            public static final int leftDrive = 6;
            public static final int rightDrive = 5;
    
        }

        public static class LowerArm {
            public static final double POWER = 0.4;
            public static final int PORT = 3;
        }

        public static class LowerArm2 {
            public static final double POWER = 0.4;
            public static final int PORT = 2;
        }

        public static class UpperArm {
            public static final double POWER = 0.4;
            public static final int PORT = 0;
        }

        public static class UpperArm2 {
            public static final double POWER = 0.4;
            public static final int PORT = 1;
        }

        public static class Claw {
            public static final double POWER = 0.5;
            public static final int PORT = 4;
        }

        public static class Tabs {
            public static final String constants = "Constants";
        }

    }

}
