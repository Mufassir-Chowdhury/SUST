package pages.pageView;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class notice extends JPanel {
    public notice(){
        JLabel notice = new JLabel("Official Notices");
        add(notice);
        JLabel posts = new JLabel("Community Posts");
        add(posts);
    }
}
