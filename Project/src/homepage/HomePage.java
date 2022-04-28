package homepage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import Components.Tools;
import Components.TitleBar;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class HomePage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel logInRight = new HomeRight();
	private HomeLeft logInLeft = new HomeLeft();

	public HomePage() {
		setBounds(0, 25, 1000, 575);
		setLayout(new GridLayout(0, 2));
		setOpaque(false);


		add(logInLeft);
		add(logInRight);
	}
}
