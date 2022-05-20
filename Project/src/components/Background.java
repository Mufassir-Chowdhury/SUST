package Components;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Constants.Sizes;

import java.awt.*;

public class Background extends JFrame {
    private JLabel backgroundImage = new JLabel();
	private String sourceBackgroundImage2 = "static/images/background-2.png";
    private TitleBar logInTitleBar;
    private Dimension size;

    public void Extend(){
        setExtendedState(Frame.MAXIMIZED_BOTH);
        backgroundImage.setIcon(Tools.imageScale(sourceBackgroundImage2, getSize()));
		setContentPane(backgroundImage);
        logInTitleBar.setSize(getWidth(), Sizes.TITLE_BAR_HEIGHT);
    }

    public void Normal(){
        setExtendedState(Frame.NORMAL);
        backgroundImage.setIcon(Tools.imageScale(sourceBackgroundImage2, getSize()));
        setContentPane(backgroundImage);
        logInTitleBar.setSize(getWidth(), Sizes.TITLE_BAR_HEIGHT);
    }

    public Background() {
        setUndecorated(true);
        setBackground(new Color(32, 32, 32, 240));
        setMinimumSize(Sizes.DEFAULT_WINDOW_SIZE);
        setLayout(new BorderLayout());
        logInTitleBar = new TitleBar(this, getWidth());

        backgroundImage.setIcon(Tools.imageScale(sourceBackgroundImage2, getSize()));
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
    
    public Background(Dimension size) {
        this.size = size;
        setUndecorated(true);
        setSize(size);
        setLayout(new BorderLayout());
        logInTitleBar = new TitleBar(this, (int)size.getWidth());

        backgroundImage.setIcon(Tools.imageScale(sourceBackgroundImage2, size));
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
