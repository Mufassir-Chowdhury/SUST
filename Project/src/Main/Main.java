package Main;
import javax.swing.SwingUtilities;

import Components.Background;
import Constants.Sizes;
import Server.Client;
import login.LogInPage;
import mainView.MainPage;
import registration.RegiPage;
import registration.RegistrationPage;
import pages.sideNavView;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class Main extends JFrame {
	public JFrame currentFrame;
	public JPanel panel = new JPanel();
	private static Main single_instance = null;
	public static String currentPage = null;

	public static Main getInstance() {
		return single_instance;
	}

	public Main() throws ClassNotFoundException, IOException {

		currentFrame = new Background();
		panel.setSize(Sizes.USABLE_WINDOW_SIZE);
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
		currentPage = "logInPage";
		currentFrame.pack();
		currentFrame.setVisible(true);
	}
	

	public void changeFrame(String cardName) {
		CardLayout cl = (CardLayout)(panel.getLayout());
		cl.show(panel, cardName);
		currentPage = cardName;
		repaint();
		revalidate();
	}
	public void changeFrame(String cardName, String nameOfPage){
		CardLayout cl = (CardLayout)(panel.getLayout());
		cl.show(panel, cardName);
		((sideNavView)panel.getComponent(0)).changePage(cardName, nameOfPage);
	}

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		new Client();

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					single_instance = new Main();
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

}
