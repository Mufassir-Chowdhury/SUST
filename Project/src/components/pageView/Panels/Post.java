package Components.pageView.Panels;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Graphics;

import Components.Comment;
import Components.Label;
import Components.Work;
import Components.InputFields.TextArea;
import Components.pageView.Box.Title;
import Constants.Colors;
import Constants.Fonts;
import Constants.Margins;
import Constants.Padding;

public class Post extends ListPanel {
    class meta extends JPanel{
        public meta(String title, String date, String totalMarks, String uploader, String dateOfUpload){
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setOpaque(false);
            setAlignmentX(Component.LEFT_ALIGNMENT);
            add(new Label(title, Fonts.TITLE, Colors.Theme.ACCENT_TEXT));
            add(Box.createVerticalStrut(10));
            add(new Label("Posted By: "+uploader+", "+ dateOfUpload, Fonts.BODY, Component.LEFT_ALIGNMENT));
            add(Box.createVerticalStrut(10));
            add(new Title(new Label(String.valueOf(totalMarks)), new Label(date)));
            add(Box.createVerticalStrut(15));
        }
        @Override
        protected void paintBorder(Graphics g) {
            g.setColor(Colors.Theme.ACCENT_FILL);
            g.fillRoundRect(0, getHeight() -1, getWidth(), 2, 0, 0);
        }
    }

    public Post(String title, String date, String totalMarks, String uploader, String dateOfUpload, String description, boolean submission){
        setOpaque(false);
        setAlignmentX(Component.LEFT_ALIGNMENT); 
        add(new meta(title, date, totalMarks, uploader, dateOfUpload));
        GridBagPanel info = new GridBagPanel();

        JPanel details = new JPanel();
        details.setLayout(new BoxLayout(details, BoxLayout.Y_AXIS));
        details.setOpaque(false);
        details.setAlignmentX(Component.LEFT_ALIGNMENT);
        details.add(new TextArea(description));
        
        info.add(
            new ScrollPane(details),
            GridBagPanel.GetConstant(1, 0, 0, 1, 1, 3, 1, Margins.MAJOR_PANEL)
        );
        
        if(submission){
            JPanel sideBar = new JPanel();
            sideBar.setOpaque(false);
            sideBar.setLayout(new BoxLayout(sideBar, BoxLayout.Y_AXIS));
            sideBar.setAlignmentX(Component.LEFT_ALIGNMENT);
            sideBar.setBorder(Padding.LIST_ITEM);
            sideBar.add(new Work());
            sideBar.add(Box.createVerticalStrut(30));
            sideBar.add(new Comment()); 
            info.add(
                sideBar,
                GridBagPanel.GetConstant(1, 3, 0, .3, 1, 1, 1, null)
            );
        }
        add(info);
    }
}
