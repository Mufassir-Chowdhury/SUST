package Common.Main;

import Components.Background;
import Constants.Sizes;
import pages.sideNavView;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class Main extends JFrame {
	public JFrame currentFrame;
	public JPanel panel = new JPanel();
	public static Main single_instance = null;
	public static String currentPage = null;

	public static Main getInstance() {
		return single_instance;
	}

	public Main() throws ClassNotFoundException, IOException {
		currentFrame = new Background();
		panel.setSize(Sizes.USABLE_WINDOW_SIZE);
		panel.setLayout(new CardLayout());
		panel.setOpaque(false);
		currentFrame.add(panel);
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
}
