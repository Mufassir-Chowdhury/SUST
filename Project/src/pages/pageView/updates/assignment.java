package pages.pageView.updates;

import javax.swing.Box;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;

import Components.pageView.EvaluationItemList;
import Components.pageView.ScrollPane;
import Components.pageView.Title;
import Components.pageView.ViewPort;
import Components.pageView.EvaluationItem.Type;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.CardLayout;

public class assignment extends ViewPort {    
    public assignment(){
        super("Assignment", null);
        JPanel assignmentPanel = new JPanel(new CardLayout());
        assignmentPanel.setOpaque(false);
        assignmentPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        Title title = super.getTitle();
        title.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                CardLayout cl = (CardLayout)(assignmentPanel.getLayout());
                cl.show(assignmentPanel, "assignment");
                title.setText("Assignment");
            }
        });

        add(Box.createVerticalStrut(20));

        assignmentPanel.add(new ScrollPane(new EvaluationItemList(title, assignmentPanel, Type.ASSIGNMENT)), "assignment");
        add(assignmentPanel);
    }
}
