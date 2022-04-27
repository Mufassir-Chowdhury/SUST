package login;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Components.TitleBar;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class LogInPage extends JFrame{

	private static final long serialVersionUID = 1L;
	public JPanel 	 logInPageMainPanel  = new JPanel();
	private JPanel 	 logInComponentPanel = new LogInComponentPanel();
	private TitleBar logInTitleBar       = new TitleBar();

	public LogInPage() {
		setUndecorated(true);
		setSize(1000, 600);
		logInPageMainPanel.setBounds(0, 0, 1000, 600);
		logInPageMainPanel.setLayout(null);
		logInPageMainPanel.add(logInTitleBar);
		logInPageMainPanel.add(logInComponentPanel);
		
		logInTitleBar.addMouseListener(logInTitleBar);
		logInTitleBar.addMouseMotionListener(logInTitleBar);

		setContentPane(logInPageMainPanel);		
	}
}
