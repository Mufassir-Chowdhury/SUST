package pages.pageView.administrivia;

import java.awt.CardLayout;

import javax.swing.JPanel;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;

import Components.Card;
import Components.pageView.ViewPort;

import java.awt.Component;
import Constants.Icons;
import Server.Datapoints;

public class payment extends ViewPort {
    public payment(){
        super("Payment", null);

        JPanel resources = new JPanel();
        resources.setAlignmentX(Component.LEFT_ALIGNMENT);
        resources.setOpaque(false);
        resources.setLayout(new CardLayout());

        JPanel list = new JPanel();
        list.setBorder(new EmptyBorder(new Insets(50, 50, 50, 50)));
        list.setOpaque(false);
        list.setLayout(new GridLayout(2, 3, 50, 50));
        
        for(String payment: Datapoints.getInstance().PAYMENT)
            list.add(new Card(payment, Icons.PAYMENT));

        resources.add(list);
        add(resources);
    }
}
