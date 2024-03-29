package Components;

import java.awt.BorderLayout;

import Components.Buttons.AccentButton;
import Components.Buttons.FileButton;
import Components.pageView.Panels.ListPanel;

public class Work extends DashBoardItem {
    public Work(){
        add(
            new Title("Your Work"), 
            BorderLayout.PAGE_START
        );
        add(
            new ListPanel(
                new FileButton("+ Add or Create"),
                new AccentButton("Mark as Done"), 
                30
            ),
            BorderLayout.PAGE_END
        );
    }
}
