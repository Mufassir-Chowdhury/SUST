package Components;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Constants.Colors;
import Constants.Fonts;
import Constants.Padding;

public class ListItem extends JPanel implements MouseListener {
    public ListItem(String title, String caption, String center, String trailing) {
        setBackground(Colors.CARD);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(Padding.LIST_ITEM);
        Box congestedInfo = Box.createVerticalBox();
        congestedInfo.add(new Label(title));
        congestedInfo.add(new Label(caption, Fonts.CAPTION));
        add(congestedInfo);
        add(Box.createHorizontalGlue());
        add(new Label(center, Fonts.PLAIN_TEXT, SwingConstants.RIGHT));
        add(Box.createHorizontalStrut(20));
        add(new Label(trailing, Fonts.PLAIN_TEXT));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setBackground(Colors.CARD_HOVER);
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setBackground(Colors.CARD);
    }
}
