package Components;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Frame;

public class Background extends JFrame {
    private JLabel backgroundImage = new JLabel();
	private String sourceBackgroundImage2 = "static/images/background-2.png";
    private Tools tools = new Tools();
    private TitleBar logInTitleBar = new TitleBar(this);

    public void Extend(){
        setExtendedState(Frame.MAXIMIZED_BOTH);
        backgroundImage.setIcon(tools.imageScale(sourceBackgroundImage2, getWidth(), getHeight()));
		setContentPane(backgroundImage);
    }

    public Background(){
        setUndecorated(true);
		setSize(1000, 600);
		setLayout(new BorderLayout());

		backgroundImage.setIcon(tools.imageScale(sourceBackgroundImage2, getWidth(), getHeight()));
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
