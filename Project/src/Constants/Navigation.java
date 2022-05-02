package Constants;

import javax.swing.Icon;

public class Navigation {
    public static class Page{
        public String name;
        public Icon icon;
        public Page(String name, Icon icon){
            this.name = name;
            this.icon = icon;
        }
    };

    public static final String[] TITLES = { "UPDATES", "COURSE INFORMATION", "ADMINISTRIVIA", "MISCELLANEOUS" };
    public static final Page[][] PAGES = {
        {new Page("Class Routines", Icons.SCHEDULE), 
            new Page("Due Assignments", Icons.ASSIGNMENT),
            new Page("Upcoming Exams", Icons.EXAM),
            new Page("Notice Board", Icons.NOTICE)},
        { new Page("Resources", Icons.RESOURCES),
            new Page("Results", Icons.RESULT),
            new Page("Attendance", Icons.ATTENDANCE)},
        { new Page("Payment", Icons.PAYMENT),
            new Page("Course Registration", Icons.COURSE_REGISTRATION),
            new Page("Important Links", Icons.IMPORTANT_LINKS)},
        { new Page("Bus Schedule", Icons.BUS_SCHEDULE),
            new Page("Student Information", Icons.STUDENT_INFO),
            new Page("Events", Icons.EVENTS),
            new Page("Map", Icons.MAP)}
    };

    public static final Page[] CLIENT = {
        new Page("STUDENT", Icons.STUDENT),
        new Page("TEACHER", Icons.TEACHER),
        new Page("ADMINISTRATOR", Icons.ADMINISTRATOR)    
    };
}
