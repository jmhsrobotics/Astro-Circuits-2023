
package frc.robot;

import org.photonvision.PhotonCamera;

import edu.wpi.first.wpilibj.XboxController;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.Constants.XboxConstants;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.Autonomous;
import frc.robot.commands.MoveToTarget;
import frc.robot.commands.TurnToTarget;
import frc.robot.subsystems.Drivetrain;

public class RobotContainer {
  private static RobotContainer m_robotContainer = new RobotContainer();
  // The robot's subsystems
  public static AHRS ahrs;
  public final Drivetrain m_drivetrain = new Drivetrain();
  
  // Declaring Controller

  private final XboxController xboxController1 = new XboxController(0);
  PhotonCamera camera = new PhotonCamera("OV5647");
  // Autonomous Position Chooser
  SendableChooser<Command> m_chooser = new SendableChooser<>();



  private RobotContainer() {
    // Smartdashboard Subsystemsnull, nul
    SmartDashboard.putData(m_drivetrain);
    ahrs = new AHRS(SPI.Port.kMXP);
    configureButtonBindings();
  
    // Driving Controls
    m_drivetrain.setDefaultCommand(new ArcadeDrive(m_drivetrain,
      //Add a minus ( - ) to either of these to invert the direction the stick has to be pushed : ) - Julien
        () -> xboxController1.getRawAxis(XboxConstants.RIGHT_STICK_X),
        () -> xboxController1.getRawAxis(XboxConstants.LEFT_STICK_Y)
        ));

  
    CommandBase position1 = new SequentialCommandGroup(
        new Autonomous(-0.25, 4, m_drivetrain),
        new Autonomous(0, 10, m_drivetrain));
        m_chooser.addOption("position1", position1);
    
    SmartDashboard.putData("Auton", m_chooser);
    
    
    // try {
    //   CameraServer.startAutomaticCapture(1);
    // } catch (Exception ex1) {
    //   System.out.println("Camera not found");
    // }
    // CameraServer.startAutomaticCapture();
    }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Button bindings go below
   */
  private void configureButtonBindings() {
    new JoystickButton(xboxController1, XboxConstants.LEFT_BUMPER).onTrue(new TurnToTarget(m_drivetrain));
    new JoystickButton(xboxController1, XboxConstants.RIGHT_BUMPER).onTrue(new MoveToTarget(m_drivetrain,1));

    // XboxController()

    // new JoystickButton(xboxController1, XboxConstants.Y_BUTTON).whenHeld(new
    // Autonomous(.30, 5, m_drivetrain));
    
    //fix slow mode off a button
    new JoystickButton(xboxController1,XboxConstants.Y_BUTTON).onTrue(new InstantCommand(() -> ArcadeDrive.isSlow = !ArcadeDrive.isSlow)); 
  }

 

  // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
  public XboxController getXboxController1() {
    return xboxController1; 
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }

  public void disabledInit() {
  }

  public void enabledInit() {
  }
}
