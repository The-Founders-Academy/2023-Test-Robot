import static androidx.core.math.MathUtils.clamp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (name="January 2023 TeleOp test 1", group="Linear Opmode")
public class BasicTeleOp extends LinearOpMode {
    private DcMotor frontRight, backRight, frontLeft, backLeft;
    private DcMotor arm;
    private Servo armLeft, armRight;

    @Override
    public void runOpMode() throws InterruptedException {
        // Initialize variables
        frontRight = hardwareMap.get(DcMotor.class, "frontright");
        backRight = hardwareMap.get(DcMotor.class, "backright");
        frontLeft = hardwareMap.get(DcMotor.class, "frontleft");
        backLeft = hardwareMap.get(DcMotor.class, "backleft");
        arm = hardwareMap.get(DcMotor.class, "arm");
        armRight = hardwareMap.get(Servo.class, "armr");
        armLeft = hardwareMap.get(Servo.class, "arml");

        // Set direction of wheel motors
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);
        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);


        arm.setDirection(DcMotor.Direction.FORWARD);
        armRight.setDirection(Servo.Direction.FORWARD);
        armLeft.setDirection(Servo.Direction.REVERSE);

        waitForStart();
        while (opModeIsActive()) {
            // Wheel controls
            double velocityRight = -gamepad1.left_stick_y;
            double velocityLeft = -gamepad1.right_stick_y;

            frontRight.setPower(velocityRight);
            frontLeft.setPower(velocityLeft);

            backRight.setPower(velocityRight);
            backLeft.setPower(velocityLeft);

            // Arm controls
            arm.setPower(-gamepad2.left_stick_y); // Forward on gamepad stick is negative.

        }
    }
}
