package Main;
import javax.swing.SwingUtilities;

import Components.Background;
import Components.TitleBar;
import Constants.Sizes;
import Server.Client;
import Server.Datapoints;
import login.LogInPage;
import mainView.MainPage;
import registration.RegiPage;
import registration.RegistrationPage;
import pages.sideNavView;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Dimension;

public class Main extends JFrame {
	public JFrame currentFrame;
	JPanel panel = new JPanel();

	public Main() throws ClassNotFoundException, IOException {
		currentFrame = new Background();
		panel.setSize(Sizes.DEFAULT_WINDOW_SIZE);
		panel.setLayout(new CardLayout());
		panel.setOpaque(false);
		panel.add(new sideNavView(), "sideNav");
		panel.add(new MainPage(this), "mainPage");
		panel.add(new RegistrationPage(), "registrationPage");
		panel.add(new LogInPage(this), "logInPage");
		panel.add(new RegiPage(this), "regiPage");

		currentFrame.add(panel);
		CardLayout cl = (CardLayout) (panel.getLayout());
		cl.show(panel, "logInPage");
		currentFrame.pack();
		currentFrame.setVisible(true);
	}
	

	public void changeFrame(String cardName) {
		currentFrame = new Background("");
		currentFrame.pack();
		CardLayout cl = (CardLayout)(panel.getLayout());
		cl.show(panel, cardName);
		// currentFrame.
	}
	public void changeFrame(String cardName, String nameOfPage){
		CardLayout cl = (CardLayout)(panel.getLayout());
		cl.show(panel, cardName);
		((sideNavView)panel.getComponent(0)).changePage(cardName, nameOfPage);
	}

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Client client = new Client();

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new Main();
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

}
