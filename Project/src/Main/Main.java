package Main;
import javax.swing.SwingUtilities;

import Components.Background;
import login.LogInPage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
	public JFrame currentFrame;
	public Main(){
		currentFrame = new Background();
		currentFrame.add(new LogInPage(this));
		currentFrame.setVisible(true);
	}
	public void changeFrame(JPanel panel){
		// currentFrame.remove(LogInPage());
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main();
			}
		});
	}

}
