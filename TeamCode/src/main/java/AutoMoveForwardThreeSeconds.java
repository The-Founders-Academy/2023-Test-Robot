import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="January 2023 test 1", group="Linear Opmode")
public class AutoMoveForwardThreeSeconds extends LinearOpMode {
    private DcMotor frontLeft, frontRight = null;
    private DcMotor backLeft, backRight = null;

    @Override
    public void runOpMode() throws InterruptedException {
        frontLeft = hardwareMap.get(DcMotor.class,"frontleft");
        frontRight = hardwareMap.get(DcMotor.class, "frontright");

        waitForStart(); // Mandatory part of the process.
        while(opModeIsActive()) {
            frontLeft.setDirection(DcMotor.Direction.FORWARD);
            frontLeft.setPower(1);

            frontRight.setDirection(DcMotor.Direction.REVERSE);
            frontRight.setPower(1);

            sleep(1000);
            frontLeft.setPower(0);
            frontRight.setPower(0);
            sleep(1000);
            stop();
        }
    }
}
