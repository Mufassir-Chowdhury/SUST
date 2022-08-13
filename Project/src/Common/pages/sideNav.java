package Common.pages;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import Components.Label;
import Components.List;
import Components.InputFields.TextField;
import Components.InputFields.TextField.TYPE;
import Constants.Fonts;
import Constants.Icons;
import Constants.Padding;
import Constants.Sizes;

import java.awt.Component;
import java.io.IOException;
import java.util.Vector;

public class sideNav extends JPanel {
    List<Page> list;
    Vector<String> pageNames;

    public void setSelected(String nameOfPage){
        list.setSelectedIndex(pageNames.indexOf(nameOfPage));
        list.repaint();
    }
    public sideNav(sideNavView view, Page[][] pages) throws ClassNotFoundException, IOException {
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Box line = Box.createHorizontalBox();
        line.setAlignmentX(Component.LEFT_ALIGNMENT);
        line.add(Box.createHorizontalStrut(5));

        TextField searchField = new TextField("Search", TYPE.PLAIN);
        searchField.setMaximumSize(Sizes.SEARCH_FIELD);
        line.add(searchField);
        line.add(Box.createHorizontalStrut(5));
        add(line);
        add(Box.createVerticalStrut(10));
        Vector<Page> pageList = new Vector<>();
        pageNames = new Vector<>();
        for(Page[] page: pages){
            for(Page pair: page){
                pageList.add(pair);
                pageNames.add(pair.name);
            }
        }
        list = new List<Page>(pageList, true, ListSelectionModel.SINGLE_SELECTION);
        
        list.addListSelectionListener(listener -> {
            if(list.getSelectedIndex() != -1){
                // TODO create a new object and delete previous one each time a item is selected
                view.changeCard(list.getSelectedValue().name);
            }
        });
        
        add(list);
        
    }
}
