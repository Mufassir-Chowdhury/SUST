package pages.pageView.administrivia;

import javax.swing.Box;
import javax.swing.BoxLayout;

import java.awt.CardLayout;

import javax.swing.JPanel;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;

import Components.Card;
import Components.Label;

import java.awt.Component;
import Constants.Fonts;
import Constants.Icons;

public class payment extends JPanel {
    public payment(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Box title = Box.createHorizontalBox();
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        title.add(new Label("Payment", Fonts.DISPLAY));
        add(title);
        add(Box.createVerticalStrut(20));

        

        JPanel resources = new JPanel();
        resources.setAlignmentX(Component.LEFT_ALIGNMENT);
        resources.setOpaque(false);
        resources.setLayout(new CardLayout());
        JPanel list = new JPanel();
        list.setBorder(new EmptyBorder(new Insets(50, 50, 50, 50)));
        list.setOpaque(false);
        list.setLayout(new GridLayout(2, 3, 50, 50));
        list.add(new Card("Registration Fee", Icons.PAYMENT));
        list.add(new Card("Library Fine", Icons.PAYMENT));
        list.add(new Card("Migration Fee", Icons.PAYMENT));
        list.add(new Card("Credit Fee", Icons.PAYMENT));
        list.add(new Card("Documents Fee", Icons.PAYMENT));
        list.add(new Card("Apply for Transcript", Icons.PAYMENT));
        resources.add(list);
        add(resources);
    }
}
