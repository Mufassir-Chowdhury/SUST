package pages.pageView;

import javax.swing.JPanel;

import Components.Label;
import Constants.Fonts;

public class notice extends JPanel {
    public notice(){
        add(new Label("Official Notices", Fonts.TITLE));
        add(new Label("Community Posts", Fonts.TITLE));
    }
}
