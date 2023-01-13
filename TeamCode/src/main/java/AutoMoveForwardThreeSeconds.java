import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="January 2023 test 1", group="Linear Opmode")
public class AutoMoveForwardThreeSeconds extends LinearOpMode {
    private DcMotor frontLeft, backLeft, frontRight, backRight;

    @Override
    public void runOpMode() throws InterruptedException {
         frontLeft = hardwareMap.get(DcMotor.class, "frontleft");
         frontRight = hardwareMap.get(DcMotor.class, "frontright");
         backLeft = hardwareMap.get(DcMotor.class, "backleft");
         backRight = hardwareMap.get(DcMotor.class, "backright");


        waitForStart(); // Mandatory part of the process.
        while(opModeIsActive()) {
            frontLeft.setDirection(DcMotor.Direction.FORWARD);
            backLeft.setDirection(DcMotor.Direction.FORWARD);

            frontRight.setDirection(DcMotor.Direction.REVERSE);
            backRight.setDirection(DcMotor.Direction.REVERSE);

            frontLeft.setPower(0.5);
            frontRight.setPower(0.5);
            backRight.setPower(0.5);
            backLeft.setPower(0.5);

            sleep(3000);

            frontLeft.setPower(0);
            frontRight.setPower(0);
            backRight.setPower(0);
            backLeft.setPower(0);

            stop();
        }
    }
}
