package Modes.Administration.Main;

import java.io.IOException;

import Server.Client;
import mainView.MainPage;
import pages.sideNavView;
import javax.swing.SwingUtilities;

import Common.login.LogInPage;

public class Main extends Common.Main.Main {

    public Main() throws ClassNotFoundException, IOException {
        super();
        panel.add(new sideNavView(), "sideNav");
		panel.add(new MainPage(this), "mainPage");
		panel.add(new LogInPage(this, "Administrator"), "logInPage");
		cl.show(panel, "logInPage");
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
