package Main;
import javax.swing.SwingUtilities;

import Components.Background;
import login.LogInPage;
import mainView.MainPage;
import registration.RegistrationPage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
	public JFrame currentFrame;
	public Main(){
		currentFrame = new Background();
		// currentFrame.add(new LogInPage(this), 0);
		currentFrame.add(new MainPage(), 0);
		// currentFrame.add(new RegistrationPage(), 0);
		currentFrame.setVisible(true);
	}

	public void changeFrame(JPanel panel) {
		// currentFrame.re
		// currentFrame.getComponent(0).setVisible(false);
		// currentFrame.add(panel, 1);
		// currentFrame.remove(0);
		// currentFrame.repaint();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main();
			}
		});
	}

}
