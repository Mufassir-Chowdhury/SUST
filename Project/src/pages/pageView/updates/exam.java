package pages.pageView.updates;

import Components.pageView.EvaluationItemList;
import Components.pageView.ScrollPane;
import Components.pageView.ViewPortPanel;
import Components.pageView.EvaluationItem.Type;


public class exam extends ViewPortPanel {
    
    public exam(){
        super("Exam", null);

        getPanel().add(
            new ScrollPane(
                new EvaluationItemList(getTitle(), getPanel(), Type.EXAM)),
            "Exam");
    }
}
