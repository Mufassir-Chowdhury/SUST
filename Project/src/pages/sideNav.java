package pages;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import Constants.Datapoints;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class sideNav extends JPanel {
    public sideNav(sideNavView view) {
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        for(Datapoints.Page[] page: view.datapoints.PAGES){
            for(Datapoints.Page pair: page){
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
    }
}
