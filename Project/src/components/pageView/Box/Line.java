package Components.pageView.Box;

import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.image.BufferedImage;

import Constants.Sizes;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Components.Card;
import Components.Label;
import Constants.Colors;
import Constants.Fonts;
import Constants.Icons;
import Constants.Padding;

public class Line extends Box {
    class ListItem extends JPanel{
        public ListItem(String serial, BufferedImage image, String title, String caption, String center, String trailing){
            setBackground(Colors.CARD);
            setAlignmentX(Component.LEFT_ALIGNMENT);
            setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            setBorder(Padding.LIST_ITEM);
            if(serial != null){
                add(Box.createHorizontalStrut(10));
                add(new Label(serial.substring(serial.length()-3), Fonts.CAPTION));
            }
            if(image != null){
                add(Box.createHorizontalStrut(10));
                add(new Card(image, (int)Sizes.DP.getWidth(), Sizes.DP));
            }
            add(Box.createHorizontalStrut(10));
            Box congestedInfo = Box.createVerticalBox();
            congestedInfo.add(new Label(title));
            congestedInfo.add(new Label(caption, Fonts.CAPTION));
            add(congestedInfo);
            add(Box.createHorizontalGlue());
            add(new Label(center, Fonts.PLAIN_TEXT, SwingConstants.RIGHT));
            add(Box.createHorizontalStrut(20));
            add(new Label(trailing, Fonts.PLAIN_TEXT)); 
        }
    }

    public Line(String title, String caption, String center, String trailing) {
        super(BoxLayout.X_AXIS);
        setMaximumSize(Sizes.LIST_ITEM);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        add(new ListItem(null, null, title, caption, center, trailing));
    }
      
    public Line(String serial, BufferedImage image, String title, String caption, String center, String trailing){
        super(BoxLayout.X_AXIS);
        setMaximumSize(Sizes.LIST_ITEM);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        add(new ListItem(serial, Icons.DP, title, caption, center, trailing));
    }    
}
