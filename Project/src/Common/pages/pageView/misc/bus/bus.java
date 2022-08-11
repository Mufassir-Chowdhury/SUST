package Common.pages.pageView.misc.bus;

import javax.swing.JComponent;

import Components.Label;
import Components.pageView.Box.Title;
import Components.pageView.Panels.Column;
import Components.pageView.Panels.GridBagPanel;
import Components.pageView.Panels.InformationPanel;
import Components.pageView.Panels.ViewPort;
import Constants.Fonts;
import Constants.Margins;
import Server.Datapoints;

public class bus extends ViewPort {
    public bus(JComponent component) {
        super("Bus Schedule", component);

        GridBagPanel list = new GridBagPanel();

        list.add(
                new InformationPanel("Buses", null, Datapoints.getInstance().BUSES),
                GridBagPanel.GetConstant(1, 0, 0, 1, 1, 1, 1, Margins.INFORMATION_PANEL));

        for (int i = 1; i <= 5; i++) {
            list.add(
                    new Column(new Title(new Label("Bus 1", Fonts.SUBTITLE), null), new Day()),
                    GridBagPanel.GetConstant(1, i, 0, 1, 1, 1, 1, Margins.COLUMN));
        }

        add(list);
    }
}
