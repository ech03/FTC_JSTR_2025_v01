package org.firstinspires.ftc.teamcode;

import android.content.Context;
import com.google.gson.Gson;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.io.InputStream;
import java.io.InputStreamReader;

public class RobotConfig {
    public double wheelRadius;
    public double gearRatio;
    public double trackWidth;
    public double lateralMultiplier;
    public double encoderTicksPerRev;
    public double odometryWheelRadius;
    public double odometryGearRatio;
    public PIDCoefficients pidCoefficients;
    public double maxVel;
    public double maxAccel;
    public double maxAngVel;
    public double maxAngAccel;

    public static class PIDCoefficients {
        public double kP;
        public double kI;
        public double kD;
    }

    public static RobotConfig load(HardwareMap hwMap) {
        try {
            Context context = hwMap.appContext;
            InputStream is = context.getAssets().open("robot_config.json");
            return new Gson().fromJson(new InputStreamReader(is), RobotConfig.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load robot_config.json", e);
        }
    }
}
