package Components.pageView.Panels;

import javax.swing.Box;
import javax.swing.JComponent;

import Components.pageView.CurrentTime;
import Components.pageView.Box.Title;
import Constants.Fonts;
import Server.Datapoints;

public class InformationPanel extends ListPanel {
    public enum Type{
        BUS, ROUTINE
    }
    public InformationPanel(String title, JComponent component, Type type){
        super(new CurrentTime(), new Title(title, Fonts.BODY_LARGE, component));        
        add(Box.createVerticalStrut(5));
        for(Datapoints.Information info: type == Type.BUS ? Datapoints.getInstance().BUSES : Datapoints.getInstance().COURSES){
            add(info.getInformation());
            add(Box.createVerticalStrut(10));
        }
    }
}
