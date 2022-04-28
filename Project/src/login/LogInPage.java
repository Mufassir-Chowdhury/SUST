package login;

import javax.swing.JPanel;
import Main.Main;
import homepage.HomePage;
import java.awt.GridLayout;

public class LogInPage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel logInRight = new LogInRight(this);
	private LogInLeft logInLeft = new LogInLeft();
	private Main frame;
	public void LogIn(){
		frame.changeFrame(new HomePage());
	}

	public LogInPage(Main frame) {
		this.frame = frame;

		setBounds(0, 35, 1000, 600);
		setLayout(new GridLayout(0, 2));
		setOpaque(false);

		add(logInLeft);
		add(logInRight);
	}
}
