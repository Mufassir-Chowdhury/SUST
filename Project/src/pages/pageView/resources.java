package pages.pageView;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class resources extends JPanel {
    public resources(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel post = new JLabel("Post new material");
        add(post);
        JLabel syllabus = new JLabel("Syllabus");
        add(syllabus);
        JLabel videos = new JLabel("Class Videos");
        add(videos);
        JLabel ctQuestions = new JLabel("CT Questions");
        add(ctQuestions);
        JLabel termFinalQuestions = new JLabel("Term Final Questions");
        add(termFinalQuestions);
        JLabel lectureNotes = new JLabel("Lecture Notes");
        add(lectureNotes);
        JLabel books = new JLabel("Books");
        add(books);
    }
}
