package login;
import javax.swing.JFrame;
import javax.swing.JPanel;

import components.TitleBar;

public class LogInPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel logInPageMainPanel = new JPanel();
	private JPanel logInComponentPanel = new LogInComponentPanel();
	private TitleBar logInTitlebar = new TitleBar();

	public LogInPage() {
		setUndecorated(true);
		
		logInPageMainPanel.setBounds(0, 0, 1000, 600);
		logInPageMainPanel.setLayout(null);
		logInPageMainPanel.add(logInTitlebar);
		logInPageMainPanel.add(logInComponentPanel);

		setContentPane(logInPageMainPanel);		
	}
}
