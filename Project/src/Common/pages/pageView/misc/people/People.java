package Common.pages.pageView.misc.people;

import Components.pageView.Panels.ViewPortBasicPanel;
import Server.Datapoints;

public class People extends ViewPortBasicPanel {
    public People(){
        super("People", null, Datapoints.getInstance().STUDENTS);
    }
}
