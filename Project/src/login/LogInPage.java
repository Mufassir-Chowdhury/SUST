package login;

import java.awt.GridLayout;

import javax.swing.JPanel;

import Constants.Sizes;
import Main.Main;

public class LogInPage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel logInRight = new LogInRight(this);
	private LogInLeft logInLeft = new LogInLeft();
	private Main frame;
	public void LogIn(){
		frame.changeFrame(new JPanel());
	}

	public LogInPage(Main frame) {
		this.frame = frame;

		setSize(Sizes.DEFAULT_WINDOW_SIZE);
		setLayout(new GridLayout(0, 2));
		setOpaque(false);

		add(logInLeft);
		add(logInRight);
	}
}
