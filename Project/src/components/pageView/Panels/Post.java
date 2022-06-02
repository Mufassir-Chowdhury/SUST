package Components.pageView.Panels;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagConstraints;

import Components.DashBoardItem;
import Components.Label;
import Components.pageView.Box.Title;
import Constants.Colors;
import Constants.Fonts;
import Constants.Margins;

public class Post extends GridBagPanel {
    class meta extends JPanel{
        public meta(String title, String date, String totalMarks){
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setOpaque(false);
            setAlignmentX(Component.LEFT_ALIGNMENT);
            add(new Label(title, Fonts.TITLE, Colors.Theme.ACCENT_TEXT));
            add(Box.createVerticalStrut(10));
            add(new Label("Posted By: Mufassir Ahmad Chowdhury, May 24", Fonts.Body, Component.LEFT_ALIGNMENT));
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

    public Post(String title, String date, String totalMarks, String description, boolean submission){
        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.setOpaque(false);
        info.add(new meta(title, date, totalMarks));
        info.add(Box.createVerticalStrut(15));
        JPanel details = new JPanel();
        details.setLayout(new BoxLayout(details, BoxLayout.Y_AXIS));
        details.setOpaque(false);
        details.setAlignmentX(Component.LEFT_ALIGNMENT);
        for(int i=0; i<25; i++)
            details.add(new Label(description, Fonts.Body, Component.LEFT_ALIGNMENT));
        info.add(new ScrollPane(details));
        setOpaque(false);
        setAlignmentX(Component.LEFT_ALIGNMENT);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 3;
        gbc.insets = Margins.MAJOR_PANEL;

        add(info, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.weighty = 0;
        gbc.weightx = .3;
        gbc.gridwidth = 1;

        JPanel image = new JPanel();
        image.setOpaque(false);
        image.add(new DashBoardItem());
        if(submission)
            add(image, gbc);       
    }
}
