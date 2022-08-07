package Components;

import java.awt.BorderLayout;

import Components.InputFields.TextField;
import Components.pageView.Panels.ListPanel;

public class Comment extends DashBoardItem{
    public Comment(){
        add(
            new Title("Comments"), 
            BorderLayout.PAGE_START
        );
        add(
            new ListPanel(
                new TextField("Write a comment", TextField.TYPE.PLAIN),
                null, 
                0
            ),
            BorderLayout.PAGE_END
        );
    }
}
