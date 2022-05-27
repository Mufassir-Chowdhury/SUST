package Components.pageView;

import javax.swing.JComponent;

import Server.Datapoints.Tilable;

public class ViewPortBasicPanel extends ViewPortPanel {
    public ViewPortBasicPanel(String title, JComponent component, Tilable[] tiles) {
        super(title, component);

        getPanel().add(
            new ScrollPane(
                new MainCardList(title, getTitle(), getPanel(), tiles)),
            title);
    }
}