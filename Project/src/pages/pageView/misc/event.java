package pages.pageView.misc;

import Components.pageView.MainCardList;
import Components.pageView.ScrollPane;
import Components.pageView.ViewPortPanel;
import Components.pageView.MainCardListItem.Type;

public class event extends ViewPortPanel {
    public event(){
        super("Events", null);

        getPanel().add(
            new ScrollPane(
                new MainCardList(getTitle(), getPanel(), Type.EVENT)),
            "Events");
    }
}
