package Components.pageView.Panels;

import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GridBagPanel extends JPanel {
    public static GridBagConstraints GetConstant(int fill, int gridx, int gridy, double weightx, double weighty, int gridwidth, int gridheight, Insets insets){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = fill;
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        if(insets != null)
            gbc.insets = insets;
        return gbc;
    }
    
    public GridBagPanel(){
        setOpaque(false);
        setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
        setLayout(new java.awt.GridBagLayout());
    }
}
