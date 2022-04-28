package Main;
import javax.swing.SwingUtilities;

import homepage.HomePage;
import login.LogInPage;
import javax.swing.JFrame;

public class Main extends JFrame {
	public JFrame currentFrame;
	public Main(){
		currentFrame = new LogInPage(this);
		currentFrame.setVisible(true);
	}
	public void changeFrame(JFrame frame){
		currentFrame = frame;
		currentFrame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main();
			}
		});
	}

}
