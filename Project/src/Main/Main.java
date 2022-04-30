package Main;
import javax.swing.SwingUtilities;

import Components.Background;
import login.LogInPage;
import mainView.MainPage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
	public JFrame currentFrame;
	public Main(){
		currentFrame = new Background();
		// currentFrame.add(new LogInPage(this), 0);
		currentFrame.add(new MainPage(), 0);
		currentFrame.setVisible(true);
	}
	public void changeFrame(JPanel panel){
		// currentFrame.add(panel, 1);
		// currentFrame.remove(0);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main();
			}
		});
	}

}
