package Components;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
        this.size = Sizes.DEFAULT_WINDOW_SIZE;
        decorateFrame();
        logInTitleBar = new TitleBar(this, (int) size.getWidth());
        addTitleBar();
    }
    
    public Background(Dimension size) {
        this.size = size;
        decorateFrame();
        logInTitleBar = new TitleBar(this, (int) size.getWidth());
        addTitleBar();
    }
    
    public Background(String s)
    {
        this.size = Sizes.DEFAULT_WINDOW_SIZE;
        decorateFrame();
        logInTitleBar = new TitleBar(this, (int) size.getWidth(), s);
        addTitleBar();
    }
    
    private void decorateFrame()
    {
        setSize(size);
        setUndecorated(true);
        setLayout(new BorderLayout());

        backgroundImage.setIcon(Tools.imageScale(sourceBackgroundImage2, getSize()));
        setContentPane(backgroundImage);
    }

    private void addTitleBar()
    {
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
