package Components.pageView;

import javax.swing.JComponent;

public class ViewPortBasicPanel extends ViewPortPanel {
    public ViewPortBasicPanel(String title, Server.Datapoints.Tilable[] tiles) {
        super(title, null);

        getPanel().add(
            new ScrollPane(
                new MainCardList(title, getTitle(), getPanel(), tiles)),
            title);
    }

    public ViewPortBasicPanel(String title, Components.pageView.MainCardListItem.Type type){
        super(title, null);

        getPanel().add(
            new ScrollPane(
                new MainCardList(title, getTitle(), getPanel(), type)),
            title);
    }
    public ViewPortBasicPanel(String title, JComponent component, Components.pageView.MainCardListItem.Type type){
        super(title, component);

        getPanel().add(
            new ScrollPane(
                new MainCardList(title, getTitle(), type)),
            title);
    }
}