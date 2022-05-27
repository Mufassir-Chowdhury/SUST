package Components.pageView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Components.ListItem;
import Server.Datapoints.Event;
import Server.Datapoints.Notice;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;

public class MainCardListItem extends Box {
    public enum Type {
        NOTICE, EVENT
    }
    public MainCardListItem(Event event, Title title, JPanel panel){
        super(BoxLayout.X_AXIS);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        Box line = new Line(new ListItem(
            event.title, 
            event.location, 
            event.duration + " at  " + event.date, 
            String.format("%03d", event.interested) + "   " + String.format("%03d", event.going)));
        line.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                title.setText("Event > " + event.title);
                Post individualExam = new Post(
                    event.title,
                    "Date: " + event.date, 
                    "Location: " + event.location, 
                    event.description);
                panel.add(individualExam, event.title);
                CardLayout cl = (CardLayout)(panel.getLayout());
                cl.show(panel, event.title);
            }
        });
        add(line);
    }
    public MainCardListItem(Notice notice, Title title, JPanel panel){
        super(BoxLayout.X_AXIS);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        Box line = new Line(new ListItem(
            notice.title, 
            "", 
            "", 
            notice.date));
        line.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                title.setText("Notices > " + notice.title);
                Post individualExam = new Post(
                    notice.title,
                    notice.date, 
                    "", 
                    notice.description);
                panel.add(individualExam, notice.title);
                CardLayout cl = (CardLayout)(panel.getLayout());
                cl.show(panel, notice.title);
            }
        });
        add(line);
    }
}
