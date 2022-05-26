package pages.pageView.misc.bus;

import javax.swing.JPanel;

import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;

import Components.pageView.ViewPort;

public class bus extends ViewPort {
    public bus(){
        super("Bus Schedule", null);

        JPanel list = new JPanel();
        list.setOpaque(false);
        list.setAlignmentX(Component.LEFT_ALIGNMENT);
        list.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 0, 5, 5);

        
        list.add(new informationPanel(), gbc);

        for(int i=1; i<=5; i++){
            gbc.gridx = i;
            gbc.gridy = 0;
            gbc.weighty = 1;
            gbc.weightx = 1;
            gbc.gridwidth = 1;
            gbc.insets = new Insets(5, 5, 5, 5);
            list.add(new busItem("2"), gbc);
        }

        add(list);
    }
}
