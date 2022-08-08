package Common.pages.pageView.course_information;

import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.CardLayout;

import Components.Card;
import Components.Buttons.AccentButton;
import Components.pageView.Box.Options;
import Components.pageView.Panels.TilesPanel;
import Components.pageView.Panels.ViewPortPanel;
import Constants.Collections;
import Constants.Colors;
import Constants.Icons;
import Constants.Padding;
import Server.Datapoints;
import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.ScrollPane;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class resources extends ViewPortPanel {
    public resources(){
        super("Resources", new AccentButton("Post New Material"));

        String[] secondOptions = {"Course", "Course 2"};
        add(new Options(Datapoints.getInstance().SEMESTER, secondOptions));
        add(Box.createVerticalStrut(20));

        TilesPanel list = new TilesPanel(2, 3, Padding.CARD_SPACING_LONG);
        
        for(String resource: Collections.RESOURCES){
            Card card = new Card(resource, Icons.Pages.PAYMENT);
            list.add(card);
            card.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    getTitle().setText("Resources > " + resource);
                    JTable table = new JTable(Datapoints.getInstance().SYLLABUS, Datapoints.getInstance().TITLE_FOR_SYLLABUS_TABLE);
                    table.setFillsViewportHeight(true);
                    table.setOpaque(false);
                    table.setShowGrid(false);
                    table.setAutoscrolls(true);
                    table.setRowHeight(30);
                    table.setCellSelectionEnabled(false);
                    table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){{
                        setOpaque(false);
                    }});
                    table.setForeground(Colors.PLAIN_TEXT);
                    ListPanel individualResource = new ListPanel(
                        new ScrollPane(table),
                        null,
                        0
                    );
                    // Post individualExam = new Post("title", "date", "totalMarks", "description", false);
                    panel.add(individualResource, resource);
                    CardLayout cl = (CardLayout)(panel.getLayout());
                    cl.show(panel, resource);
                }
            });
        }

        getPanel().add(list, "Resources");
    }
}
