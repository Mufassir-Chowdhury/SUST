package Components.pageView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Server.Datapoints.Tilable;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;

public class MainCardListItem extends Box {
    public MainCardListItem(String pageName, Tilable event, Title title, JPanel panel){
        super(BoxLayout.X_AXIS);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        Box line = event.getListItem();
        line.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                title.setText(pageName + " > " + event.getTitle());
                Post individualExam = event.getPost();
                panel.add(individualExam, event.getTitle());
                CardLayout cl = (CardLayout)(panel.getLayout());
                cl.show(panel, event.getTitle());
            }
        });
        add(line);
    }
}
