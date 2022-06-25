package pages.pageView.administrivia;

import Components.Card;
import Components.pageView.Panels.TilesPanel;
import Components.pageView.Panels.ViewPortPanel;

import Constants.Icons;
import Constants.Padding;
import Server.Datapoints;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class payment extends ViewPortPanel {
    public payment(){
        super("Payment", null);
        TilesPanel list = new TilesPanel(2, 3, Padding.CARD_SPACING_LONG);
        
        for(String payment: Datapoints.getInstance().PAYMENT){
            Card card = new Card(payment, Icons.Pages.PAYMENT);
            list.add(card);
            card.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    getTitle().setText("Payment > " + payment);
                    paymentPage individualExam = new paymentPage();
                    panel.add(individualExam, payment);
                    CardLayout cl = (CardLayout)(panel.getLayout());
                    cl.show(panel, payment);
                }
            });
        }

        getPanel().add(list, "Payment");
    }
}
