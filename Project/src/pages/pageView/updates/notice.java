package pages.pageView.updates;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Dimension;

import Components.Label;
import Components.ListItem;
import Components.pageView.ScrollPane;
import Components.pageView.Title;
import Constants.Fonts;
import Server.Datapoints;

public class notice extends JPanel {
    public notice(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new Title("Notices", null));
        add(Box.createVerticalStrut(20));

        JPanel list = new JPanel();
        list.setOpaque(false);
        list.setAlignmentX(Component.LEFT_ALIGNMENT);
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        for(Datapoints.Notice notice: Datapoints.getInstance().NOTICES){
            Box line = Box.createHorizontalBox();
            line.setMaximumSize(new Dimension(1000, 60));
            line.setAlignmentX(Component.LEFT_ALIGNMENT);
            line.add(new ListItem(
                notice.title, 
                "", 
                "", 
                notice.date));
                list.add(line);
            list.add(Box.createVerticalStrut(10));
        }
        add(new ScrollPane(list));
    }
}
