package pages.pageView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Constants.Datapoints;

public class students extends JPanel {
    public students(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        for(Datapoints.Student student: Datapoints.STUDENTS){
            Box line = Box.createHorizontalBox();
            JLabel registration = new JLabel(student.registration);
            line.add(registration);
            line.add(Box.createHorizontalGlue());
            JLabel name = new JLabel(student.name);
            line.add(name);
            line.add(Box.createHorizontalGlue());
            JLabel email = new JLabel(student.email);
            line.add(email);
            line.add(Box.createHorizontalGlue());
            JLabel number = new JLabel(student.number);
            line.add(number);
            line.add(Box.createHorizontalGlue());
            JLabel blood = new JLabel(student.blood);
            line.add(blood);
            line.add(Box.createHorizontalGlue());
            JLabel birthDay = new JLabel(student.birthDay);
            line.add(birthDay);
            line.add(Box.createHorizontalGlue());
            JLabel hometown = new JLabel(student.hometown);
            line.add(hometown);
            add(line);
        }
    }
}
