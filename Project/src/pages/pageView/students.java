package pages.pageView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Components.Label;
import Components.ListItem;

import java.awt.Component;
import java.awt.Dimension;

import Constants.Fonts;
import Server.Datapoints;

public class students extends JPanel {
    public students(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Box title = Box.createHorizontalBox();
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        title.add(new Label("Students", Fonts.DISPLAY));
        add(title);
        add(Box.createVerticalStrut(20));
        JPanel list = new JPanel();
        list.setOpaque(false);
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        for(Datapoints.Student student: Datapoints.STUDENTS){
            Box line = Box.createHorizontalBox();
            line.setMaximumSize(new Dimension(1000, 60));
            line.add(new Label((student.registration.substring(student.registration.length() - 3)), Fonts.BODY_LARGE));
            line.add(Box.createHorizontalStrut(5));
            line.add(new ListItem(
                student.name, 
                student.blood + " | " + student.birthDay + " | " + student.hometown, 
                student.email, 
                "+880" + student.number));
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
