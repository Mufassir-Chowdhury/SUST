package pages.pageView.misc;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Components.ListItem;
import Components.pageView.Line;
import Components.pageView.ScrollPane;
import Components.pageView.Title;

import Server.Datapoints;

public class students extends JPanel {
    public students(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new Title("Student Information", null));
        add(Box.createVerticalStrut(20));
        JPanel list = new JPanel();
        list.setOpaque(false);
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        for(Datapoints.Student student: Datapoints.getInstance().STUDENTS){
            list.add(new Line(new ListItem(
                student.name, 
                student.blood + " | " + student.birthDay + " | " + student.hometown, 
                student.email, 
                "+880" + student.number)));
            list.add(Box.createVerticalStrut(10));
        }
        add(new ScrollPane(list));

    }
}
