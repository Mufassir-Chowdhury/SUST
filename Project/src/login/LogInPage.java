package login;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class LogInPage extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel logInPageMainPanel;
	public JPanel logInComponentPanel;
	private LogInTitlebar logInTitlebar;
	
	private int x,y;

	public LogInPage() {
		setBounds(new Rectangle(170, 70, 1000, 600));
		setUndecorated(true);
		
		logInPageMainPanel = new JPanel();
		logInPageMainPanel.setBounds(0, 0, 1000, 600);
		logInPageMainPanel.setLayout(null);
		setContentPane(logInPageMainPanel);
		
		logInTitlebar = new LogInTitlebar();
		logInTitlebar.setBounds(0, 0, 1000, 25);
		logInTitlebar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int xx = e.getXOnScreen();
				int yy = e.getYOnScreen();
				setLocation(xx-x,yy-y);
			}
		});
		logInTitlebar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
		
		logInPageMainPanel.add(logInTitlebar);
		
		logInComponentPanel = new LogInComponentPanel();
		logInPageMainPanel.add(logInComponentPanel);
	}
}
