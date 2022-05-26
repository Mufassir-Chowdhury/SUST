package pages.pageView.updates;

import javax.swing.Box;

import Components.ListItem;
import Components.pageView.Line;
import Components.pageView.ListPanel;
import Components.pageView.ScrollPane;
import Components.pageView.ViewPort;
import Server.Datapoints;

public class notice extends ViewPort {
    public notice(){
        super("Notices", null);

        ListPanel list = new ListPanel();
        for(Datapoints.Notice notice: Datapoints.getInstance().NOTICES){
            list.add(new Line(new ListItem(notice.title, "caption", "center", notice.date)));
            list.add(Box.createVerticalStrut(10));
        }
        add(new ScrollPane(list));
    }
}
