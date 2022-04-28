package login;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import Components.Tools;
import Main.Main;
import homepage.HomePage;
import Components.TitleBar;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Timer;
import java.util.TimerTask;

public class LogInPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel backgroundImage = new JLabel();
	private TitleBar logInTitleBar = new TitleBar();
	private String sourceBackgroundImage2 = "static/images/background-2.png";
	private Tools tools = new Tools();
	private int width, height;
	private JPanel logInRight = new LogInRight(this);
	private LogInLeft logInLeft = new LogInLeft();
	private JPanel componentPanel = new JPanel();
	private Main frame;
	public void LogIn(){
		frame.changeFrame(new HomePage());
		// Timer timer = new Timer();
		// timer.schedule(setVisible(false), 1000);
		setVisible(false);
	}

	public LogInPage(Main frame) {
		this.frame = frame;
		setUndecorated(true);
		setSize(1000, 600);
		setLayout(new BorderLayout());

		componentPanel.setBounds(0, 25, 1000, 575);
		componentPanel.setLayout(new GridLayout(0, 2));
		componentPanel.setOpaque(false);

		width = getWidth();
		height = getHeight();

		backgroundImage.setIcon(tools.imageScale(sourceBackgroundImage2, width, height));
		setContentPane(backgroundImage);

		add(logInTitleBar);
		logInTitleBar.addComponentListener(new java.awt.event.ComponentAdapter() {
			@Override
			public void componentMoved(java.awt.event.ComponentEvent evt) {
				setLocation(logInTitleBar.point);
			}
		});

		componentPanel.add(logInLeft);
		componentPanel.add(logInRight);

		add(componentPanel);

		logInTitleBar.addMouseListener(logInTitleBar);
		logInTitleBar.addMouseMotionListener(logInTitleBar);

	}
}
