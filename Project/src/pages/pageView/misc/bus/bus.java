package pages.pageView.misc.bus;

import Components.pageView.Panels.GridBagPanel;
import Components.pageView.Panels.InformationPanel;
import Components.pageView.Panels.ViewPort;
import Server.Datapoints;

import java.awt.Insets;
import java.awt.GridBagConstraints;

public class bus extends ViewPort {
    public bus(){
        super("Bus Schedule", null);

        GridBagPanel list = new GridBagPanel();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 0, 5, 5);

        
        list.add(new InformationPanel("Buses", null, Datapoints.getInstance().BUSES), gbc);

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
