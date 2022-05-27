package pages.pageView.updates;

import Components.pageView.MainCardList;
import Components.pageView.ScrollPane;
import Components.pageView.ViewPortPanel;
import Components.pageView.MainCardListItem.Type;


public class exam extends ViewPortPanel {
    public exam(){
        super("Exam", null);

        getPanel().add(
            new ScrollPane(
                new MainCardList("Exam", getTitle(), getPanel(), Type.EXAM)),
            "Exam");
    }
}