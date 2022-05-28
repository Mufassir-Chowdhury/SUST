package Components.pageView.Panels;

import javax.swing.JPanel;

public class GridBagPanel extends JPanel {
    public GridBagPanel(){
        setOpaque(false);
        setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
        setLayout(new java.awt.GridBagLayout());
    }
}
