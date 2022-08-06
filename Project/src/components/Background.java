package Components;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Common.Main.Main;
import Constants.Sizes;

import java.awt.*;

public class Background extends JFrame {
    private JLabel backgroundImage = new JLabel();
	private String sourceBackgroundImage2 = "static/images/background-2.png";
    private TitleBar logInTitleBar;
    private Dimension size;

    public void Extend(){
        Sizes.USABLE_WINDOW_SIZE = this.size = Sizes.DEFAULT_WINDOW_SIZE;
        REPAINT();
    }

    public void Normal() {
        Sizes.USABLE_WINDOW_SIZE = this.size = Sizes.NORMAL_WINDOW_SIZE;
        // setBounds(Tools.locate(Sizes.DEFAULT_WINDOW_SIZE, Sizes.NORMAL_WINDOW_SIZE));
        REPAINT();
    }
    
    private void REPAINT()
    {
        Main.getInstance().panel.setSize(size);
        setSize(size);

        backgroundImage.setIcon(Tools.imageScale(sourceBackgroundImage2, size));
        setContentPane(backgroundImage);

        logInTitleBar.setSize((int) size.getWidth(), Sizes.TITLE_BAR_HEIGHT);

        repaint();
        revalidate();
    }

    public Background() {
        this.size = Sizes.USABLE_WINDOW_SIZE;
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
    
    private void decorateFrame()
    {
        setSize(size);
        setUndecorated(true);
        setResizable(true);
        setLayout(new BorderLayout());

        backgroundImage.setIcon(Tools.imageScale(sourceBackgroundImage2, size));
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
    }
}
