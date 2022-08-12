package Components.pageView.Panels;

import javax.swing.JPanel;
import java.awt.Insets;
import javax.swing.border.EmptyBorder;

import java.awt.Component;
import java.awt.GridLayout;

public class TilesPanel extends JPanel {

    public TilesPanel(int row, int column, int gap, float alignment) {
        setBorder(new EmptyBorder(new Insets(gap, gap, gap, gap)));
        setOpaque(false);
        setAlignmentX(alignment);
        setLayout(new GridLayout(row, column, gap, gap));
    }


    public TilesPanel(int row, int column, int gap) {
        setBorder(new EmptyBorder(new Insets(gap, gap, gap, gap)));
        setOpaque(false);
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setLayout(new GridLayout(row, column, gap, gap));
    }

    public TilesPanel(int row, int column, int gapLeft, int gapTop) {
        setBorder(new EmptyBorder(new Insets(gapTop, gapLeft, gapTop, gapLeft)));
        setOpaque(false);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setLayout(new GridLayout(row, column, gapLeft, gapTop));
    }
}
