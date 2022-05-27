package pages.pageView.updates;

import Components.pageView.EvaluationItemList;
import Components.pageView.ScrollPane;
import Components.pageView.ViewPortPanel;
import Components.pageView.EvaluationItem.Type;

public class assignment extends ViewPortPanel {    
    public assignment(){
        super("Assignment", null);

        getPanel().add(
            new ScrollPane(
                new EvaluationItemList(getTitle(), getPanel(), Type.ASSIGNMENT)),
                "Assignment");
    }
}
