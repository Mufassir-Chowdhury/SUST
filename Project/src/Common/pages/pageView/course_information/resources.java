package Common.pages.pageView.course_information;

import javax.swing.Box;

import java.awt.CardLayout;

import Components.Card;
import Components.Buttons.AccentButton;
import Components.pageView.Box.Options;
import Components.pageView.Panels.TilesPanel;
import Components.pageView.Panels.ViewPortPanel;
import Constants.Collections;
import Constants.Icons;
import Constants.Padding;
import Server.Datapoints;
import Server.Datapoints.Resource;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class resources extends ViewPortPanel {
    public resources(){
        super("Resources", new AccentButton("Post New Material"));

        String[] secondOptions = {"Course", "Course 2"};
        add(new Options(Datapoints.getInstance().SEMESTER, secondOptions));
        add(Box.createVerticalStrut(20));

        TilesPanel list = new TilesPanel(2, 3, Padding.CARD_SPACING_LONG);
        
        for(Resource resource: Collections.RESOURCES){
            Card card = new Card(resource.title, Icons.Pages.PAYMENT);
            list.add(card);
            card.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    getTitle().setText("Resources > " + resource.title);
                    panel.add(resource.getInformation(), resource.title);
                    CardLayout cl = (CardLayout)(panel.getLayout());
                    cl.show(panel, resource.title);
                }
            });
        }

        getPanel().add(list, "Resources");
    }
}
