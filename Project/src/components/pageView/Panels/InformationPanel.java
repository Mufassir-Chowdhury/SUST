package Components.pageView.Panels;

import javax.swing.Box;
import javax.swing.JComponent;

import Components.Label;
import Components.pageView.CurrentTime;
import Components.pageView.Box.Title;
import Constants.Fonts;
import Server.Datapoints;
import Server.Datapoints.Information;

public class InformationPanel extends ListPanel {
    public InformationPanel(String title, Information[] informations) {
        super(
                new CurrentTime(),
                new Title(new Label(title, Fonts.BODY_LARGE), null),
                0);
        for (Datapoints.Information info : informations) {
            add(info.getInformation());
            add(Box.createVerticalStrut(5));
        }
    }
}
