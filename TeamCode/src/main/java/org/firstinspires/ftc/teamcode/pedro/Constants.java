package org.firstinspires.ftc.teamcode.pedro;

import com.pedropathing.algorithm.ForesightConfig;
import com.pedropathing.controllers.Controller;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Matrix;
import com.pedropathing.math.Vector2D;
import com.pedropathing.revhub.drivetrains.MecanumConfig;
import com.pedropathing.revhub.localizers.PinpointConfig;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Constants {
    public static Follower create(HardwareMap h) {

        // return new Follower(Drivetrain, Localizer, Foresight);
        return null;
    }
    public static MecanumConfig drivetrainConfig = new MecanumConfig(
    c -> {
        c.frontLeftName.set("leftFront");
        c.frontRightName.set("rightFront");
        c.backLeftName.set("leftBack");
        c.backRightName.set("rightBack");
        c.frontLeftDirection.set(DcMotorSimple.Direction.REVERSE);
        c.frontRightDirection.set(DcMotorSimple.Direction.FORWARD);
        c.backLeftDirection.set(DcMotorSimple.Direction.REVERSE);
        c.backRightDirection.set(DcMotorSimple.Direction.FORWARD);
    });

    public static PinpointConfig localizerConfig = new PinpointConfig(c -> {
        c.name.set("pinpoint");
        c.podType.set(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_SWINGARM_POD);
        c.xPodOffset.set(8.265732892854945);
        c.yPodOffset.set(-8.055989423136074);
        c.xPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
        c.yPodDirection.set(GoBildaPinpointDriver.EncoderDirection.REVERSED);
        c.globalDistanceUnit.set(DistanceUnit.INCH);
        c.offsetUnits.set(DistanceUnit.INCH);
    });
    public static ForesightConfig foresightConfig = new ForesightConfig(
            c -> {
                Controller primaryTranslationalForward = Controller.proportional(1.597489279172428);
                Controller secondaryTranslationalForward = Controller.proportional(0.5902296029545188);
                Controller primaryTranslationalLateral = Controller.proportional(0.5414351666473379);
                Controller secondaryTranslationalLateral = Controller.proportional(0.20004582666208842);

                c.forwardTranslational.set(Controller.piecewise(secondaryTranslationalForward).put(2.5, primaryTranslationalForward));
                c.strafeTranslational.set(Controller.piecewise(secondaryTranslationalLateral).put(2.5, primaryTranslationalLateral));

                c.coast.set(Controller.proportionalFeedforward(0.018868036667564744));
                c.brake.set(Controller.proportionalFeedforward(0.01603783116743003));

                c.headingFeedback.set(Controller.proportional(5.314851835639011));
                c.headingBrakeCoefficients.set(Vector2D.cartesian(0.19058517433191982, -0.03458786279140206));

                c.linearBrakeCoefficients.set(Matrix.diag(0.15093102672748412, 0.07755450968763104));
                c.quadraticBrakeCoefficients.set(Matrix.diag(-9.872125751028897E-4, 0.0012467664359716458));

                c.maxAchievableForwardVelocity.set(61.057877341901644);
                c.maxAchievableStrafeVelocity.set(49.382526218891456);
                c.naturalForwardDeceleration.set(38.304235922456364);
                c.naturalStrafeDeceleration.set(50.77438178721904);
            }
    );
}