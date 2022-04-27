package login;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import Components.Tools;
import Components.TitleBar;
import java.awt.BorderLayout;


public class LogInPage extends JFrame{

	private static final long serialVersionUID = 1L;
	private JLabel 	 backgroundImage  = new JLabel();
	private JPanel 	 logInComponentPanel = new LogInComponentPanel();
	private TitleBar logInTitleBar       = new TitleBar();
	private String sourceBackgroundImage2 = "static/images/background-2.png";
	private Tools tools = new Tools();
	private int width, height;

	public LogInPage() {
		setUndecorated(true);
		setSize(1000, 600);
		setLayout(new BorderLayout());
		
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
		
		
		

		add(logInComponentPanel);
		
		logInTitleBar.addMouseListener(logInTitleBar);
		logInTitleBar.addMouseMotionListener(logInTitleBar);
		
	}
}
