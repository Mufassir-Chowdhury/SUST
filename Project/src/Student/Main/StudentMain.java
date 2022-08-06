package Student.Main;

import java.io.IOException;

import Server.Client;
import mainView.MainPage;
import pages.sideNavView;
import java.awt.CardLayout;
import javax.swing.SwingUtilities;

import Common.login.LogInPage;

public class StudentMain extends Common.Main.Main {

    public StudentMain() throws ClassNotFoundException, IOException {
        super();
        panel.add(new sideNavView(), "sideNav");
		panel.add(new MainPage(this), "mainPage");
		panel.add(new LogInPage(this, "Student"), "logInPage");
        CardLayout cl = (CardLayout) (panel.getLayout());
        cl.show(panel, "logInPage");
		currentPage = "logInPage";
    }
    public static void main(String[] args) throws ClassNotFoundException, IOException {
		new Client();

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					single_instance = new StudentMain();
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
    
}
