package Components.pageView.Panels;

import javax.swing.JComponent;
import javax.swing.JPanel;

import Components.pageView.Box.Title;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class ViewPortPanel extends ViewPort {
    public JPanel panel = new JPanel(new CardLayout());
    Title title = super.getTitle();

    public JPanel getPanel() {
        return panel;
    }
    public Title getTitle() {
        return title;
    }

    public ViewPortPanel(String pageName, JComponent component){
        super(pageName, component);
        
        panel.setOpaque(false);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        title.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                CardLayout cl = (CardLayout)(panel.getLayout());
                cl.show(panel, pageName);
                title.setText(pageName);
            }
        });

        add(panel);
    }
}
