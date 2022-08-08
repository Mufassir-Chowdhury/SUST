package Modes.Administration.Main;

import java.io.IOException;

import Server.Client;

import javax.swing.SwingUtilities;

import Common.login.LogInPage;
import Common.mainView.MainPage;
import Common.pages.sideNavView;
import Modes.Student.pages.PageList;

public class Main extends Common.Main.Main {

    public Main() throws ClassNotFoundException, IOException {
        super();
		// TODO add new getPages for admin
        panel.add(new sideNavView(PageList.getPages()), "sideNav");
		panel.add(new MainPage(this, PageList.getPages()), "mainPage");
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
