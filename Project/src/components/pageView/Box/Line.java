package Components.pageView.Box;

import javax.swing.Box;
import javax.swing.BoxLayout;

import Constants.Sizes;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Components.Label;
import Constants.Colors;
import Constants.Fonts;
import Constants.Padding;

public class Line extends Box {
    public Line(String title, String caption, String center, String trailing){
        super(BoxLayout.X_AXIS);
        setMaximumSize(Sizes.LIST_ITEM);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JPanel ListItem = new JPanel();
        ListItem.setBackground(Colors.CARD);
        ListItem.setAlignmentX(Component.LEFT_ALIGNMENT);
        ListItem.setLayout(new BoxLayout(ListItem, BoxLayout.X_AXIS));
        ListItem.setBorder(Padding.LIST_ITEM);
        Box congestedInfo = Box.createVerticalBox();
        congestedInfo.add(new Label(title));
        congestedInfo.add(new Label(caption, Fonts.CAPTION));
        ListItem.add(congestedInfo);
        ListItem.add(Box.createHorizontalGlue());
        ListItem.add(new Label(center, Fonts.PLAIN_TEXT, SwingConstants.RIGHT));
        ListItem.add(Box.createHorizontalStrut(20));
        ListItem.add(new Label(trailing, Fonts.PLAIN_TEXT)); 
        add(ListItem);
    }    
}
