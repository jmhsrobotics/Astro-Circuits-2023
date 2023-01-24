package frc.robot;
//Imports
import com.ctre.phoenix.motorcontrol.StickyFaults;

//End Imports

import edu.wpi.first.math.util.Units;

public class Constants {
    
    // Assigns IDs to Motors
    public static final class DriveConstants {
        public static final int kRightFront = 0;
        public static final int kRightBack = 1;
        public static final int kLeftFront = 2;
        public static final int kLeftBack = 3;
        public static final double SLOW_SPEED_FRACTION = 1;
    }

    // Assigns IDs to buttons on Xbox Controller
    public static final class XboxConstants {
        public static final int LEFT_TRIGGER = 2;
        public static final int RIGHT_TRIGGER = 3;
        public static final int LEFT_BUMPER = 5;
        public static final int RIGHT_BUMPER = 6;
        public static final int LEFT_STICK_X = 0;
        public static final int LEFT_STICK_Y = 1;
        public static final int RIGHT_STICK_X = 4;
        public static final int RIGHT_STICK_Y = 5;
        public static final int A_BUTTON = 1;
        public static final int B_BUTTON = 2;
        public static final int X_BUTTON = 3;
        public static final int Y_BUTTON = 4;
        public static final int START_BUTTON = 8;
        public static final int BACK_BUTTON = 7;
    }
    //Assigns Values to P and D variables for various tasks (This is for PID loops)
    public static final class PIDConstants {
        public static final double LINEAR_P = 0.1;
        public static final double LINEAR_D = 0.0;
        public static final double ANGULAR_P = 0.1;
        public static final double ANGULAR_D = 0.0;
    }
    // Assigns various values pertaining to vision related commands and subsystems
    public static final class VisionConstants {
        public static final double CAMERA_HEIGHT_METERS = Units.inchesToMeters(12.5); // Height of LimeLight Camera on Robot

    }
}
