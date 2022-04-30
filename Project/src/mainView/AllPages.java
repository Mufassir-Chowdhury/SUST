package mainView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Constants.Colors;
import Constants.Fonts;
import Constants.Sizes;

class AllPages extends JPanel {
    String[] titles = { "UPDATES", "COURSE INFORMATION", "ADMINISTRIVIA", "MISCELLANEOUS" };
    String[][] pageNames = {
        {"Class Routines", "Due Assignments", "Upcoming Exams", "Notices"},
        {"Resources", "Results", "Attendence"},
        {"Payment", "Course Registration", "Important Links"},
        {"Bus Schedule", "Student Information", "Events", "Map"}
    };

    public AllPages(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        for(int i=0; i<4; i++){
            JLabel title = new JLabel(titles[i]);
            title.setForeground(Colors.PLAIN_TEXT);
            title.setFont(Fonts.TITLE);
            title.setAlignmentX(Component.LEFT_ALIGNMENT);
            add(title);
            Box line;
            line = Box.createHorizontalBox();
            for(String page: pageNames[i]){
                line.add(new Card(page));
                line.add(Box.createHorizontalStrut(Sizes.CARD_SPACING));
            }
            line.setAlignmentX(Component.LEFT_ALIGNMENT);
            add(line);
        }
    }

    class Card extends JPanel {
        public Card(String text){
            setLayout(new GridBagLayout());
            setBackground(Colors.CARD);
            setSize(Sizes.CARD_SIZE);
            setMinimumSize(Sizes.CARD_SIZE);
            setMaximumSize(Sizes.CARD_SIZE);
            JLabel label = new JLabel(text);
            label.setFont(Fonts.PLAIN_TEXT);
            label.setForeground(Colors.ACCENT);
            add(label);
        }
        protected void paintComponent(Graphics g) {
            g.setColor(Colors.CARD);
            g.fillRoundRect(0, 0, getWidth(), getHeight(), 7, 7);
             super.paintComponent(g);
        }
        protected void paintBorder(Graphics g) {
            g.setColor(Colors.CARD);
            g.drawRoundRect(0, 0, getWidth(), getHeight(), 7, 7);
        }
    }
}
