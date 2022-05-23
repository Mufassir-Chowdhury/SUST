package pages.pageView.misc;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Dimension;

import Components.Label;
import Components.ListItem;
import Constants.Fonts;
import Server.Datapoints;

public class event extends JPanel {
    public event(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Box title = Box.createHorizontalBox();
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        title.add(new Label("Events", Fonts.DISPLAY));
        add(title);
        add(Box.createVerticalStrut(20));

        JPanel list = new JPanel();
        list.setOpaque(false);
        list.setAlignmentX(Component.LEFT_ALIGNMENT);
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        for(Datapoints.Event event: Datapoints.getInstance().EVENTS){
            Box line = Box.createHorizontalBox();
            line.setMaximumSize(new Dimension(1000, 60));
            line.setAlignmentX(Component.LEFT_ALIGNMENT);
            line.add(new ListItem(
                event.title, 
                event.location, 
                event.duration + " at  " + event.date, 
                String.format("%03d", event.interested) + "   " + String.format("%03d", event.going)));
                list.add(line);
            list.add(Box.createVerticalStrut(10));
        }
        JScrollPane scroll = new JScrollPane(list);
        scroll.setAlignmentX(Component.LEFT_ALIGNMENT);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(null);
        add(scroll);
    }
}
