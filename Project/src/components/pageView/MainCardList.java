package Components.pageView;

import javax.swing.Box;
import javax.swing.JPanel;

import Server.Datapoints;
import Server.Datapoints.Tilable;

public class MainCardList extends ListPanel {
    public MainCardList(String pageName, Title title, JPanel panel, Tilable[] tiles) {
        for(Datapoints.Tilable eventItem: tiles){
            add(new MainCardListItem(pageName, eventItem, title, panel));
            add(Box.createVerticalStrut(10));
        }
    }
}
