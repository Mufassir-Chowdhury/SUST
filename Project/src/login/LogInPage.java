package login;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Components.BackgroundPanel;
import Components.TitleBar;

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
		logInTitleBar.addComponentListener(new java.awt.event.ComponentAdapter() {
			@Override
			public void componentMoved(java.awt.event.ComponentEvent evt) {
				setLocation(logInTitleBar.point);
			}
		});
		logInPageMainPanel.add(logInComponentPanel);
		
		logInTitleBar.addMouseListener(logInTitleBar);
		logInTitleBar.addMouseMotionListener(logInTitleBar);

		setContentPane(logInPageMainPanel);		
	}
}
