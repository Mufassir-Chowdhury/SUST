package Common.Main;

import Components.Background;
import Constants.Sizes;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import Common.pages.sideNavView;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

public class Main extends JFrame {
	public JFrame currentFrame;
	public JPanel panel = new JPanel();
	public static Main single_instance = null;
	public static String currentPage = null;
	public CardLayout cl;

	public static Main getInstance() {
		return single_instance;
	}

	public Main() throws ClassNotFoundException, IOException {
		currentFrame = new Background();
		panel.setSize(Sizes.USABLE_WINDOW_SIZE);
		panel.setLayout(new CardLayout());
		panel.setOpaque(false);
		currentFrame.add(panel);
		cl = (CardLayout) (panel.getLayout());
		currentPage = "logInPage";
		currentFrame.pack();
		currentFrame.setVisible(true);
		UIManager.put("OptionPane.background", new Color(33, 33, 33));
        UIManager.put("Panel.background", new Color(33, 33, 33));
        UIManager.put("OptionPane.minimumSize", new Dimension(1000, 500));

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
