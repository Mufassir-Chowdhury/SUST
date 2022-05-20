package pages.pageView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Components.Label;
import Constants.Fonts;
import Server.Datapoints;

public class event extends JPanel {
    public event(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        for(Datapoints.Event event: Datapoints.EVENTS){
            Box line = Box.createHorizontalBox();
            line.add(new Label(event.title, Fonts.BODY_LARGE));
            line.add(Box.createHorizontalGlue());
            line.add(new Label(event.date, Fonts.BODY_LARGE));
            line.add(Box.createHorizontalGlue());
            line.add(new Label(event.duration, Fonts.Body));
            line.add(Box.createHorizontalGlue());
            line.add(new Label(event.location, Fonts.Body));
            line.add(Box.createHorizontalGlue());
            line.add(new Label(String.valueOf(event.going), Fonts.Body));
            line.add(Box.createHorizontalGlue());
            line.add(new Label(String.valueOf(event.interested), Fonts.Body));
            line.add(Box.createHorizontalGlue());
            add(line);
        }
    }
}
