package Common.pages;

import javax.swing.JPanel;

import Components.pageView.Panels.GridBagPanel;
import Constants.Margins;
import Constants.Padding;
import Constants.Sizes;

import java.awt.GridBagLayout;
import java.awt.CardLayout;
import java.io.IOException;

public class sideNavView extends JPanel{
    JPanel cards;
    sideNav buttonPane;

    public void changeCard(String cardName){
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, cardName);
    }
    public void changePage(String cardName, String nameOfPage){
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, nameOfPage);
        buttonPane.setSelected(nameOfPage);
    }

    public sideNavView(Page[][] pages) throws ClassNotFoundException, IOException{
        setOpaque(false);
        setSize(Sizes.USABLE_WINDOW_SIZE);
        setBorder(Padding.MAIN_VIEW_PORT);
        setLayout(new GridBagLayout());

        
        cards = new JPanel(new CardLayout());
        cards.setBorder(Padding.SIDE_NAV_VIEW);
        cards.setOpaque(false);
        for(Page[] page: pages){
            for(Page pair: page){
                cards.add(pair.panel, pair.name);
            }
        }
        buttonPane = new sideNav(this, pages);

        add(
            buttonPane, 
            GridBagPanel.GetConstant(3, 0, 0, 0, 1, 1, 1, Margins.MAJOR_PANEL)
        );

        add(
            cards,
            GridBagPanel.GetConstant(1, 1, 0, 1, 1, 3, 1, Margins.MAJOR_PANEL)
        );

    }
}
