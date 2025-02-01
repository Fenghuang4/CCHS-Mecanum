package frc.robot.Subsystems;

import java.util.function.DoubleSupplier;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    MecanumDrive drivetrain;
    SparkMax fl;
    SparkMax fr;
    SparkMax rl;
    SparkMax rr;

    public Drivetrain() {
       fl = new SparkMax(14, MotorType.kBrushed);
       fr = new SparkMax(12, MotorType.kBrushed);
       rl = new SparkMax(16, MotorType.kBrushed);
       rr = new SparkMax(13, MotorType.kBrushed);
       drivetrain = new MecanumDrive(fl, rl, fr, rr);
       SparkMaxConfig leftConfig = new SparkMaxConfig();
       SparkMaxConfig rightConfig = new SparkMaxConfig();
       leftConfig.idleMode(IdleMode.kBrake).smartCurrentLimit(40).inverted(false);
       rightConfig.idleMode(IdleMode.kBrake).smartCurrentLimit(40).inverted(true);
    }

    public Command drive(DoubleSupplier x, DoubleSupplier y, DoubleSupplier z) {
        return run(()-> drivetrain.driveCartesian(x.getAsDouble(), y.getAsDouble(), z.getAsDouble()));
    }
}
