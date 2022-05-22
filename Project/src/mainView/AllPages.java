package mainView;

import javax.swing.Box;
import javax.swing.BoxLayout;

import java.awt.Component;
import java.io.IOException;

import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Components.Card;
import Components.Label;
import Constants.Fonts;
import Constants.Padding;
import Constants.Sizes;
import Main.Main;
import Server.Datapoints;

class AllPages extends JPanel { 
    public AllPages(Main main) throws ClassNotFoundException, IOException{
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        for(int i=0; i<Datapoints.getInstance().TITLES.length; i++){
            Label title = new Label(Datapoints.getInstance().TITLES[i], Fonts.TITLE, Component.LEFT_ALIGNMENT);
            title.setBorder(Padding.TITLE_LINE_HEIGHT);
            
            Box line = Box.createHorizontalBox();
            for(Datapoints.Page pair: Datapoints.getInstance().getPages()[i]){
                Card card = new Card(pair.name, pair.icon);
                card.addMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e){
                        main.changeFrame("sideNav", pair.name);
                    }
                });
                line.add(card);
                line.add(Box.createHorizontalStrut(Sizes.CARD_SPACING));
            }
            line.setAlignmentX(Component.LEFT_ALIGNMENT);
            
            add(title);
            add(line);
        }
    }
}
