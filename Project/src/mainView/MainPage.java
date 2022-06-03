package mainView;

import javax.swing.JPanel;

import Constants.Margins;
import Constants.Padding;
import Constants.Sizes;
import Main.Main;

import java.awt.GridBagLayout;
import java.io.IOException;
import java.awt.GridBagConstraints ;

public class MainPage extends JPanel {
    public MainPage(Main main) throws ClassNotFoundException, IOException{
        setOpaque(false);
        setSize(Sizes.USABLE_WINDOW_SIZE);
        setBorder(Padding.MAIN_VIEW_PORT);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 2;
        gbc.insets = Margins.MAJOR_PANEL;

        add(new AllPages(main), gbc);

        gbc.gridx = 2;
        gbc.weightx = .5;
        gbc.gridwidth = 1;

        add(new DashBoard(), gbc);

    }
}
