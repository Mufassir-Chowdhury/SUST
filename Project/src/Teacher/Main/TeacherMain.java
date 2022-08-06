package Teacher.Main;

import java.io.IOException;

import Server.Client;
import mainView.MainPage;
import pages.sideNavView;
import java.awt.CardLayout;
import javax.swing.SwingUtilities;

import Common.login.LogInPage;

public class TeacherMain extends Common.Main.Main {

    public TeacherMain() throws ClassNotFoundException, IOException {
        super();
        panel.add(new sideNavView(), "sideNav");
		panel.add(new MainPage(this), "mainPage");
		panel.add(new LogInPage(this, "Teacher"), "logInPage");
        CardLayout cl = (CardLayout) (panel.getLayout());
        cl.show(panel, "logInPage");
		currentPage = "logInPage";
    }
    public static void main(String[] args) throws ClassNotFoundException, IOException {
		new Client();

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					single_instance = new TeacherMain();
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
    
}
