package login;

import java.awt.GridBagLayout;
import java.io.IOException;
import java.awt.GridBagConstraints;

import javax.swing.JPanel;

import Constants.Margins;
import Constants.Sizes;
import Main.Main;

public class LogInPage extends JPanel {

	private static final long serialVersionUID = 1L;
	private Main frame;
	public void LogIn() throws ClassNotFoundException, IOException{
		frame.changeFrame("mainPage");
	}

	public LogInPage(Main frame) {
		this.frame = frame;

		setSize(Sizes.DEFAULT_WINDOW_SIZE);
		setLayout(new GridBagLayout());

		setOpaque(false);
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 2;
        gbc.insets = Margins.MAJOR_PANEL;

        add(new LogInLeft(), gbc);

        gbc.gridx = 2;
        gbc.weightx = .5;
        gbc.gridwidth = 1;

        add(new LogInRight(this), gbc);
	}
}
