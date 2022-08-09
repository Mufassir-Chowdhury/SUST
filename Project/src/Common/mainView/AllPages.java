package Common.mainView;

import javax.swing.Box;

import Common.Main.Main;
import Common.pages.Page;

import java.awt.Component;
import java.io.IOException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Components.Card;
import Components.Label;
import Components.pageView.Panels.ListPanel;
import Constants.Collections;
import Constants.Fonts;
import Constants.Padding;

class AllPages extends ListPanel { 
    public AllPages(Main main, Page[][] pageList) throws ClassNotFoundException, IOException{
        for(int i=0; i<Collections.TITLES.length; i++){
            Label title = new Label(Collections.TITLES[i], Fonts.TITLE, Component.LEFT_ALIGNMENT);
            title.setBorder(Padding.TITLE_LINE_HEIGHT);
            
            Box line = Box.createHorizontalBox();
            for(Page pair: pageList[i]){
                Card card = new Card(pair.name, pair.icon);
                card.addMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e){
                        main.changeFrame("sideNav", pair.name);
                    }
                });
                line.add(card);
                line.add(Box.createHorizontalStrut(Padding.CARD_SPACING));
            }
            line.setAlignmentX(Component.LEFT_ALIGNMENT);
            
            add(title);
            add(line);
        }
    }
}
