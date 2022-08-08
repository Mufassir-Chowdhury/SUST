package Common.pages.pageView.misc.map;

import Components.pageView.Panels.ViewPort;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Canvas;

public class map extends ViewPort {

    Canvas canvas = new Canvas();
    JPanel drawingPanel = new JPanel();

    public map() {
        super("Map", null);

        drawingPanel.setLayout(new BoxLayout(drawingPanel, BoxLayout.X_AXIS));
        drawingPanel.setOpaque(false);
        drawingPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        canvas c = new canvas();

        drawingPanel.add(c);
        add(drawingPanel);

    }
}
