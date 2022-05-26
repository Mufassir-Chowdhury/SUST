package Components.pageView;

import javax.swing.JPanel;
import java.awt.Insets;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

public class TilesPanel extends JPanel {
    public TilesPanel(){
        setBorder(new EmptyBorder(new Insets(50, 50, 50, 50)));
        setOpaque(false);
        setLayout(new GridLayout(2, 3, 50, 50));
    }
}
