package login;

import java.awt.GridBagLayout;
import java.io.IOException;

import javax.swing.JPanel;

import Components.pageView.Panels.GridBagPanel;
import Constants.Margins;
import Constants.Sizes;
import Main.Main;

public class LogInPage extends JPanel {

	private static final long serialVersionUID = 1L;
    private Main frame;
	public void LogIn(String page) throws ClassNotFoundException, IOException{
		frame.changeFrame(page);
	}

	public LogInPage(Main frame) {
        this.frame = frame;
		setSize(Sizes.USABLE_WINDOW_SIZE);
		setLayout(new GridBagLayout());

		setOpaque(false);

        add(
            new LogInLeft(), 
            GridBagPanel.GetConstant(1, 0, 0, 1, 1, 2, 1, Margins.MAJOR_PANEL)
        );

        add(
            new LogInRight(this),
            GridBagPanel.GetConstant(0, 2, 0, .5, 1, 1, 1, null)
        );
	}
}
