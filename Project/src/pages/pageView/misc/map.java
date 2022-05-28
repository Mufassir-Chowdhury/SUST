package pages.pageView.misc;

import Components.Label;
import Components.pageView.Panels.GridBagPanel;
import Components.pageView.Panels.ViewPort;
import java.awt.GridBagConstraints;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Canvas;
import java.awt.*;

public class map extends ViewPort {
    public map() {
        super("Map", null);

        JPanel drawingPanel = new JPanel();
        drawingPanel.setOpaque(false);
        drawingPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        Canvas canvas = new Canvas();
        canvas.setSize(400, 400);
        // canvas.drawColor(Color.argb(0, 0, 0, 0));
        
        // canvas.drawColor(Color.TRANSLUCENT, PorterDuff.Mode.CLEAR);
        drawingPanel.add(canvas);
        add(drawingPanel);
        System.out.println(drawingPanel.getHeight());
    }
}
