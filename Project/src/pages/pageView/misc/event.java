package pages.pageView.misc;

import javax.swing.Box;

import Components.ListItem;
import Components.pageView.Line;
import Components.pageView.ListPanel;
import Components.pageView.ScrollPane;
import Components.pageView.ViewPort;
import Server.Datapoints;

public class event extends ViewPort {
    public event(){
        super("Events", null);

        ListPanel list = new ListPanel();
        for(Datapoints.Event event: Datapoints.getInstance().EVENTS){
            list.add(new Line(new ListItem(
                event.title, 
                event.location, 
                event.duration + " at  " + event.date, 
                String.format("%03d", event.interested) + "   " + String.format("%03d", event.going))));
            list.add(Box.createVerticalStrut(10));
        }
        add(new ScrollPane(list));
    }
}
