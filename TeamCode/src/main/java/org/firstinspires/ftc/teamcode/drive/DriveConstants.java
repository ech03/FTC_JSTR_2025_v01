package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.RobotConfig;

public class DriveConstants {
    private static RobotConfig config;

    public static void initialize(HardwareMap hardwareMap) {
        config = RobotConfig.load(hardwareMap);
    }

    public static double WHEEL_RADIUS() {
        return config.wheelRadius;
    }

    public static double GEAR_RATIO() {
        return config.gearRatio;
    }

    public static double TRACK_WIDTH() {
        return config.trackWidth;
    }

    public static double LATERAL_MULTIPLIER() {
        return config.lateralMultiplier;
    }

    public static double TICKS_PER_REV() {
        return config.encoderTicksPerRev;
    }

    public static double MAX_VEL() {
        return config.maxVel;
    }

    public static double MAX_ACCEL() {
        return config.maxAccel;
    }

    public static double MAX_ANG_VEL() {
        return config.maxAngVel;
    }

    public static double MAX_ANG_ACCEL() {
        return config.maxAngAccel;
    }

    public static RobotConfig.PIDCoefficients getPID() {
        return config.pidCoefficients;
    }
}
