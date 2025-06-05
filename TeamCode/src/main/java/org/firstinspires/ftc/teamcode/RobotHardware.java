package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class RobotHardware {
    // Drive motors
    public DcMotor lf, lr, rf, rr;

    // Odometry encoders (REV Through-Bore)
    public DcMotor leftOdo, rightOdo, centerOdo;

    // Built-in IMU
    public BNO055IMU imu;

    public RobotHardware(HardwareMap hwMap) {
        // Map drive motors
        lf = hwMap.get(DcMotor.class, "lf");
        lr = hwMap.get(DcMotor.class, "lr");
        rf = hwMap.get(DcMotor.class, "rf");
        rr = hwMap.get(DcMotor.class, "rr");

        // Map odometry encoders (can be encoder-only motors or unused motor ports)
        leftOdo = hwMap.get(DcMotor.class, "leftOdo");
        rightOdo = hwMap.get(DcMotor.class, "rightOdo");
        centerOdo = hwMap.get(DcMotor.class, "centerOdo");

        // Map IMU
        imu = hwMap.get(BNO055IMU.class, "imu");

        initDriveMotors();
        initIMU();
    }

    private void initDriveMotors() {
        DcMotor[] motors = {lf, lr, rf, rr};
        for (DcMotor motor : motors) {
            motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }

        // Reverse left side motors
        lf.setDirection(DcMotor.Direction.REVERSE);
        lr.setDirection(DcMotor.Direction.REVERSE);
    }

    private void initIMU() {
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.RADIANS;
        imu.initialize(parameters);
    }
}
