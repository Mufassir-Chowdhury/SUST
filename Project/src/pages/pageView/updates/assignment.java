package pages.pageView.updates;

import Components.pageView.MainCardList;
import Components.pageView.ScrollPane;
import Components.pageView.ViewPortPanel;
import Components.pageView.MainCardListItem.Type;

public class assignment extends ViewPortPanel {    
    public assignment(){
        super("Assignment", null);

        getPanel().add(
            new ScrollPane(
                new MainCardList("Assignment", getTitle(), getPanel(), Type.ASSIGNMENT)),
                "Assignment");
    }
}