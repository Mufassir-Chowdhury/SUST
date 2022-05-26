package pages.pageView.updates;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;

import Components.pageView.EvaluationItemList;
import Components.pageView.Title;
import Components.pageView.EvaluationItem.Type;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.CardLayout;

public class assignment extends JPanel {
    JPanel assignmentPanel = new JPanel(new CardLayout());
    Title title = new Title("Assignment", null);

    public assignment(){
        assignmentPanel.setOpaque(false);
        assignmentPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(title);
        title.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                CardLayout cl = (CardLayout)(assignmentPanel.getLayout());
                cl.show(assignmentPanel, "assignment");
                title.setText("Assignment");
            }
        });
        add(title);
        add(Box.createVerticalStrut(20));

        assignmentPanel.add(new EvaluationItemList(title, assignmentPanel, Type.ASSIGNMENT), "assignment");
        add(assignmentPanel);
    }
}
