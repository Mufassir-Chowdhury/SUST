package mainView;

import javax.swing.Box;
import javax.swing.BoxLayout;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Constants.Colors;
import Constants.Fonts;
import Constants.Datapoints;
import Constants.Padding;
import Constants.Sizes;

class AllPages extends JPanel { 
    Datapoints datapoints = new Datapoints();;   

    public AllPages(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        for(int i=0; i<Datapoints.TITLES.length; i++){
            JLabel title = new JLabel(Datapoints.TITLES[i]);
            title.setForeground(Colors.PLAIN_TEXT);
            title.setFont(Fonts.TITLE);
            title.setAlignmentX(Component.LEFT_ALIGNMENT);
            title.setBorder(Padding.TITLE_LINE_HEIGHT);
            
            Box line = Box.createHorizontalBox();
            for(Datapoints.Page pair: datapoints.PAGES[i]){
                line.add(new Card(pair.name, pair.icon));
                line.add(Box.createHorizontalStrut(Sizes.CARD_SPACING));
            }
            line.setAlignmentX(Component.LEFT_ALIGNMENT);
            
            add(title);
            add(line);
        }
    }
}
