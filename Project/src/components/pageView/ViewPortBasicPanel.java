package Components.pageView;

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
}