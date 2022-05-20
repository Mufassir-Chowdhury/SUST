package pages;

import javax.swing.JPanel;

import Constants.Margins;
import Constants.Padding;
import Constants.Sizes;
import Server.Datapoints;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints ;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.border.EmptyBorder;

public class sideNavView extends JPanel{
    JPanel cards;
    Datapoints datapoints = new Datapoints();
    sideNav buttonPane = new sideNav(this);

    public void changeCard(String cardName){
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, cardName);
    }
    public void changePage(String cardName, String nameOfPage){
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, nameOfPage);
        buttonPane.setSelected(nameOfPage);
    }

    public sideNavView() throws ClassNotFoundException, IOException{
        setOpaque(false);
        setBackground(new Color(30, 30, 30));
        setSize(Sizes.DEFAULT_WINDOW_SIZE);
        setBorder(Padding.MAIN_VIEW_PORT);
        setLayout(new GridBagLayout());

        
        cards = new JPanel(new CardLayout());
        // cards.setBackground(new Color(58, 58, 58, 76));
        cards.setBorder(new EmptyBorder(new Insets(10, 0, 50, 40)));
        cards.setOpaque(false);
        for(Datapoints.Page[] page: datapoints.getPages()){
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
