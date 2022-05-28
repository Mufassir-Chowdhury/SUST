package pages.pageView.administrivia;

import java.awt.CardLayout;

import javax.swing.JPanel;

import Components.Card;
import Components.pageView.Panels.TilesPanel;
import Components.pageView.Panels.ViewPort;

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

        TilesPanel list = new TilesPanel();
        
        for(String payment: Datapoints.getInstance().PAYMENT)
            list.add(new Card(payment, Icons.PAYMENT));

        resources.add(list);
        add(resources);
    }
}
