package Modes.Administration.pages;

import Components.Card;
import Components.Payment;
import Components.pageView.Panels.TilesPanel;
import Components.pageView.Panels.ViewPortPanel;
import Constants.Collections;
import Constants.Icons;
import Constants.Padding;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class payment extends ViewPortPanel {
    public payment(){
        super("Payment", null);
        TilesPanel list = new TilesPanel(2, 3, Padding.CARD_SPACING_LONG);
        
        for(Payment payment: Collections.PAYMENT){
            Card card = new Card(payment.title, Icons.Pages.PAYMENT);
            list.add(card);
            card.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    getTitle().setText("Payment > " + payment.title);
                    panel.add(new PaymentHistory(payment.title), payment.title);
                    CardLayout cl = (CardLayout)(panel.getLayout());
                    cl.show(panel, payment.title);
                }
            });
        }

        getPanel().add(list, "Payment");
    }
}
