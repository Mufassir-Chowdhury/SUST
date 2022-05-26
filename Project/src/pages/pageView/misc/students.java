package pages.pageView.misc;

import javax.swing.Box;

import Components.ListItem;
import Components.pageView.Line;
import Components.pageView.ListPanel;
import Components.pageView.ScrollPane;
import Components.pageView.ViewPort;
import Server.Datapoints;

public class students extends ViewPort {
    public students(){
        super("Student Information", null);

        ListPanel list = new ListPanel();
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
