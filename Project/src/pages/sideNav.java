package pages;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import Constants.Colors;
import Constants.Datapoints;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class sideNav extends JPanel {
    public sideNav(sideNavView view) {
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Vector<Datapoints.Page> pageList = new Vector<>();
        for(Datapoints.Page[] page: view.datapoints.PAGES){
            for(Datapoints.Page pair: page){
                pageList.add(pair);
                JButton button = new JButton(pair.name);
                button.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        view.changeCard(e.getActionCommand());
                    }
                });
                button.setIcon(pair.icon);
                add(button);
            }
        }
        JList<Datapoints.Page> list = new JList<>(pageList);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        add(list);
    }
}
