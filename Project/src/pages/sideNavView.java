package pages;

import javax.swing.JPanel;

import Constants.Datapoints;
import Constants.Margins;
import Constants.Padding;
import Constants.Sizes;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints ;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.border.EmptyBorder;

public class sideNavView extends JPanel{
    JPanel cards;
    Datapoints datapoints = new Datapoints();

    public void changeCard(String cardName){
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, cardName);
    }

    public sideNavView(){
        setOpaque(false);
        setBackground(new Color(30, 30, 30));
        setSize(Sizes.DEFAULT_WINDOW_SIZE);
        setBorder(Padding.MAIN_VIEW_PORT);
        setLayout(new GridBagLayout());

        JPanel buttonPane = new sideNav(this);
        
        cards = new JPanel(new CardLayout());
        // cards.setBackground(new Color(40, 40, 40));
        cards.setBorder(new EmptyBorder(new Insets(10, 0, 50, 40)));
        cards.setOpaque(false);
        for(Datapoints.Page[] page: datapoints.PAGES){
            for(Datapoints.Page pair: page){
                cards.add(pair.panel, pair.name);
            }
        }

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.insets = Margins.MAJOR_PANEL;

        add(buttonPane, gbc);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.gridwidth = 3;

        add(cards, gbc);

    }
}
