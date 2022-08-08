package Common.mainView;

import Components.pageView.Panels.GridBagPanel;
import Constants.Margins;
import Constants.Padding;
import Constants.Sizes;

import java.io.IOException;

import Common.Main.Main;
import Common.pages.Page;

public class MainPage extends GridBagPanel {
    public MainPage(Main main, Page pageList[][]) throws ClassNotFoundException, IOException{
        setOpaque(false);
        setSize(Sizes.USABLE_WINDOW_SIZE);
        setBorder(Padding.MAIN_VIEW_PORT);
        
        add(
            new AllPages(main, pageList), 
            GridBagPanel.GetConstant(1, 0, 0, 1, 1, 2, 1, Margins.MAJOR_PANEL)
        );

        add(
            new DashBoard(), 
            GridBagPanel.GetConstant(1, 2, 0, .5, 1, 1, 1, Margins.MAJOR_PANEL)
        );

    }
}
