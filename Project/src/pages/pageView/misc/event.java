package pages.pageView.misc;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Component;

import Components.ListItem;
import Components.pageView.Line;
import Components.pageView.ScrollPane;
import Components.pageView.Title;
import Server.Datapoints;

public class event extends JPanel {
    public event(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new Title("Events", null));
        add(Box.createVerticalStrut(20));

        JPanel list = new JPanel();
        list.setOpaque(false);
        list.setAlignmentX(Component.LEFT_ALIGNMENT);
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
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
