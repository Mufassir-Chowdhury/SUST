package pages.pageView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Constants.Datapoints;

public class event extends JPanel {
    public event(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        for(Datapoints.Event event: Datapoints.EVENTS){
            Box line = Box.createHorizontalBox();
            JLabel title = new JLabel(event.title);
            line.add(title);
            line.add(Box.createHorizontalGlue());
            JLabel date = new JLabel(event.date);
            line.add(date);
            line.add(Box.createHorizontalGlue());
            JLabel time = new JLabel(event.duration);
            line.add(time);
            line.add(Box.createHorizontalGlue());
            JLabel venue = new JLabel(event.location);
            line.add(venue);
            line.add(Box.createHorizontalGlue());
            JLabel going = new JLabel(String.valueOf(event.going));
            line.add(going);
            line.add(Box.createHorizontalGlue());
            JLabel interested = new JLabel(String.valueOf(event.interested));
            line.add(interested);
            line.add(Box.createHorizontalGlue());
            add(line);
        }
    }
}
