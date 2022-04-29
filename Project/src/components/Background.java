package Components;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Constants.Sizes;

import java.awt.BorderLayout;
import java.awt.Frame;

public class Background extends JFrame {
    private JLabel backgroundImage = new JLabel();
	private String sourceBackgroundImage2 = "static/images/background-2.png";
    private TitleBar logInTitleBar;

    public void Extend(){
        setExtendedState(Frame.MAXIMIZED_BOTH);
        backgroundImage.setIcon(Tools.imageScale(sourceBackgroundImage2, getWidth(), getHeight()));
		setContentPane(backgroundImage);
        logInTitleBar.setSize(getWidth(), Sizes.TITLE_BAR_HEIGHT);
    }

    public void Normal(){
        setExtendedState(Frame.NORMAL);
        backgroundImage.setIcon(Tools.imageScale(sourceBackgroundImage2, getWidth(), getHeight()));
        setContentPane(backgroundImage);
        logInTitleBar.setSize(getWidth(), Sizes.TITLE_BAR_HEIGHT);
    }

    public Background(){
        setUndecorated(true);
		setSize(Sizes.DEFAULT_WINDOW_SIZE);
		setLayout(new BorderLayout());
        logInTitleBar = new TitleBar(this, getWidth());

		backgroundImage.setIcon(Tools.imageScale(sourceBackgroundImage2, getWidth(), getHeight()));
		setContentPane(backgroundImage);
        add(logInTitleBar);

        logInTitleBar.addComponentListener(new java.awt.event.ComponentAdapter() {
			@Override
			public void componentMoved(java.awt.event.ComponentEvent evt) {
				setLocation(logInTitleBar.point);
			}
		});
        logInTitleBar.addMouseListener(logInTitleBar);
		logInTitleBar.addMouseMotionListener(logInTitleBar);

    }
}
