package start;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainProgram {
	
	private JPanel logInPageMainPanel;
	private LogInTitlebar logInTitlebar;
	private int x,y;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainProgram window = new MainProgram();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainProgram() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		logInPageMainPanel = new JPanel();
		logInPageMainPanel.setBounds(0, 0, 1000, 600);
		logInPageMainPanel.setLayout(null);
		frame.setContentPane(logInPageMainPanel);
		
		logInTitlebar = new LogInTitlebar();
		logInTitlebar.setBounds(0, 0, 1000, 25);
		logInTitlebar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int xx = e.getXOnScreen();
				int yy = e.getYOnScreen();
				frame.setLocation(xx-x,yy-y);
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
		
		logInPageMainPanel.add(new LogInComponentPanel());
	
//		frame.setContentPane(frame);
	}

}


