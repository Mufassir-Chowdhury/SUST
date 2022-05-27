package pages.pageView.updates;

import Components.pageView.MainCardList;
import Components.pageView.ScrollPane;
import Components.pageView.ViewPortPanel;
import Components.pageView.MainCardListItem.Type;

public class notice extends ViewPortPanel {
    public notice(){
        super("Notices", null);

        getPanel().add(
            new ScrollPane(
                new MainCardList(getTitle(), getPanel(), Type.NOTICE)),
            "Notices");
    }
}
