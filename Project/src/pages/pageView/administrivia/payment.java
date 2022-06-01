package pages.pageView.administrivia;

import Components.Card;
import Components.pageView.Panels.Post;
import Components.pageView.Panels.TilesPanel;
import Components.pageView.Panels.ViewPortPanel;

import Constants.Icons;
import Constants.Sizes;
import Server.Datapoints;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class payment extends ViewPortPanel {
    public payment(){
        super("Payment", null);
        TilesPanel list = new TilesPanel(2, 3, Sizes.CARD_SPACING_LONG);
        
        for(String payment: Datapoints.getInstance().PAYMENT){
            Card card = new Card(payment, Icons.PAYMENT);
            list.add(card);
            card.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    getTitle().setText("Payment > " + payment);
                    Post individualExam = new Post("title", "date", "totalMarks", "description");
                    panel.add(individualExam, payment);
                    CardLayout cl = (CardLayout)(panel.getLayout());
                    cl.show(panel, payment);
                }
            });
        }

        getPanel().add(list, "Payment");
    }
}
