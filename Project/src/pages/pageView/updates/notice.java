package pages.pageView.updates;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Component;

import Components.ListItem;
import Components.pageView.Line;
import Components.pageView.ScrollPane;
import Components.pageView.ViewPort;
import Server.Datapoints;

public class notice extends ViewPort {
    public notice(){
        super("Notices", null);

        JPanel list = new JPanel();
        list.setOpaque(false);
        list.setAlignmentX(Component.LEFT_ALIGNMENT);
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        for(Datapoints.Notice notice: Datapoints.getInstance().NOTICES){
            list.add(new Line(new ListItem(notice.title, "caption", "center", notice.date)));
            list.add(Box.createVerticalStrut(10));
        }
        add(new ScrollPane(list));
    }
}
