package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Test RobotConfig.json", group = "Test")
public class RobotConfigTestOpMode extends LinearOpMode {
    @Override
    public void runOpMode() {
        RobotConfig config = RobotConfig.load(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            telemetry.addData("wheelRadius", config.wheelRadius);
            telemetry.addData("trackWidth", config.trackWidth);
            telemetry.addData("gearRatio", config.gearRatio);
            telemetry.addData("PID kP", config.pidCoefficients.kP);
            telemetry.addData("PID kI", config.pidCoefficients.kI);
            telemetry.addData("PID kD", config.pidCoefficients.kD);
            telemetry.addData("Max Vel", config.maxVel);
            telemetry.addData("Max Accel", config.maxAccel);
            telemetry.addData("Max Ang Vel", config.maxAngVel);
            telemetry.addData("Max Ang Accel", config.maxAngAccel);
            telemetry.update();
        }
    }
}
