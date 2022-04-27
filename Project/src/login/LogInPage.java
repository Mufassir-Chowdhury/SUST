package login;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import Components.BackgroundImage;
import Components.TitleBar;


public class LogInPage extends JFrame{

	private static final long serialVersionUID = 1L;
	public JLabel 	 logInPageMainPanel  = new JLabel();
	private JPanel 	 logInComponentPanel = new LogInComponentPanel();
	private TitleBar logInTitleBar       = new TitleBar();
	private BackgroundImage bgImage = new BackgroundImage();

	public LogInPage() {
		setUndecorated(true);
		setSize(1000, 600);
		logInPageMainPanel.setBounds(0, 0, 1000, 600);
		logInPageMainPanel.setIcon(bgImage.setBackgroundImage("static/images/background.png",1000,600));
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
