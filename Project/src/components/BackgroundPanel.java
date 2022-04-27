package Components;

import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Dimension;

public class BackgroundPanel extends JPanel{
    private Image background;
 
    public BackgroundPanel(Image background){
        this.background = background;
        setLayout( new BorderLayout() );
    }
 
    @Override
    protected void paintComponent(Graphics g){
        // super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
    }
 
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(background.getWidth(this), background.getHeight(this));
    }
}