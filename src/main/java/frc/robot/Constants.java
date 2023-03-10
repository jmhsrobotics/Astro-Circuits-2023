package frc.robot;
//Imports
import edu.wpi.first.math.util.Units;
//EndImports
public class Constants {
    
    // Assigns IDs to Motors
    public static final class DriveConstants {
        public static final int kRightFront = 2;
        public static final int kRightBack = 1;
        public static final int kLeftFront = 18;
        public static final int kLeftBack = 19;
        public static final double SLOW_SPEED_FRACTION = 0.5;
    }

    // Assigns IDs to buttons on Xbox Controller
    public static final class XboxConstants {
        public static final int LEFT_TRIGGER = 2;
        public static final int RIGHT_TRIGGER = 3;
        public static final int LEFT_BUMPER = 5;
        public static final int RIGHT_BUMPER = 6;
        public static final int LEFT_STICK_X = 0;
        public static final int LEFT_STICK_Y = 1;
        public static final int LEFT_STICK_CLICK = 9;
        public static final int RIGHT_STICK_X = 4;
        public static final int RIGHT_STICK_Y = 5;
        public static final int RIGHT_STICK_CLICK = 10;
        public static final int A_BUTTON = 1;
        public static final int B_BUTTON = 2;
        public static final int X_BUTTON = 3;
        public static final int Y_BUTTON = 4;
        public static final int START_BUTTON = 8;
        public static final int BACK_BUTTON = 7;
    }
    //Assigns Values to P and D variables for various tasks (This is for PID loops)
    public static final class PIDConstants {
        public static final double LINEAR_P = -0.1;
        public static final double LINEAR_D = 0.0;
        public static final double ANGULAR_P = 0.035;
        public static final double ANGULAR_I = 0;
        public static final double ANGULAR_D = 0.01;
    }
    // Assigns various values pertaining to vision related commands and subsystems
    public static final class VisionConstants {
        public static final double CAMERA_HEIGHT_METERS = Units.inchesToMeters(12.5); // Height of LimeLight Camera on Robot
        public static final double TARGET_HEIGHT_METERS = Units.feetToMeters(2.08); // Height of target
        public static final double GOAL_RANGE_METERS = Units.feetToMeters(1);
        public static final double CAMERA_PITCH_RADIANS = Units.degreesToRadians(0);
        public static final double kAngleToleranceDegrees = 5;
    }

    public static final class BalanceConstants {
        public static final double kP = 1/75.;
        public static final double REVERSE_POWER_MULTIPLIER = 1.5;
    }

    public static final class ArmConstants{
        public static final double kP = 10;
        public static final double kI = 0.0;
        public static final double kD = 0.1;
        public static final int kArmMotor = 10;
        public static final double kGVolts = 0.133;
        public static final double kSVolts = 2;
        public static final double kVVoltSecondPerRad = 1;
        public static final double kAVoltSecondSquaredPerRad = 1;
        public static final double kMaxVelocityRadPerSecond = 1.5;
        public static final double kMaxAccelerationRadPerSecSquared = 2.1;
        public static final double kEncoderDistancePerPulse = 1;
        public static final double kRotationDegree = Units.degreesToRadians(360.0/64.0);
        public static final double kGearRatio = 64;
        public static final double kArmOffsetRads = 0;
        public static final double kArmLength = Units.inchesToMeters(30);
        public static final double kArmMass = Units.lbsToKilograms(10);
        public static final double kArmMinAngle = Units.degreesToRadians(0); //TODO floor angle
        public static final double kArmMaxAngle = Units.degreesToRadians(180);
        public static final double kArmOffsetInDegrees = Units.degreesToRadians(60);
        public static final double kArmLoadingLocation = Units.degreesToRadians(105);
        public static final double kArmRestingLocation = Units.degreesToRadians(0);
        public static final double kArmScoringLocation = Units.degreesToRadians(80);
        public static final double kArmStraightUp = Units.degreesToRadians(210);
        public static final double kFeedForward = 0.133;
    }


}
