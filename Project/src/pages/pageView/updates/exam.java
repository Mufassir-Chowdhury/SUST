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

public class exam extends ViewPort {
    
    public exam(){
        super("Exam", null);
        JPanel examPanel = new JPanel(new CardLayout());
        examPanel.setOpaque(false);
        examPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        Title title = super.getTitle();
        title.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                CardLayout cl = (CardLayout)(examPanel.getLayout());
                cl.show(examPanel, "assignment");
                title.setText("Exam");
            }
        });
        add(Box.createVerticalStrut(20));

        examPanel.add(new ScrollPane(new EvaluationItemList(title, examPanel, Type.EXAM)), "assignment");

        add(examPanel);
    }
}
