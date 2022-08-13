package Components.pageView.Panels;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;

import Constants.Colors;

import java.awt.Component;

public class ScrollPane extends JScrollPane {
    public ScrollPane(JComponent component){
        super(component);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setOpaque(false);
        getViewport().setOpaque(false);
        setBorder(new EmptyBorder(0, 0, 0, 0));
        UIManager.put("ScrollBar.thumb", new ColorUIResource(Colors.SCROLLBAR));
        setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        getVerticalScrollBar().setUI(new BasicScrollBarUI(){
            @Override
            protected void configureScrollBarColors(){
                this.thumbColor = Colors.SCROLLBAR;
                
            }
        });
        getHorizontalScrollBar().setUI(new BasicScrollBarUI(){
            @Override
            protected void configureScrollBarColors(){
                this.thumbColor = Colors.SCROLLBAR;
                
            }
        });
    }
}
