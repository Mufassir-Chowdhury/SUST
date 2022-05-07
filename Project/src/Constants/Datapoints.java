package Constants;

import javax.swing.Icon;

public class Datapoints {
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

    public static class Notification{
        public String title, date;
        public Severity severity;
        public Boolean dismissable;
        public enum Severity{
            CRITICAL, INFORMATIONAL, SUCCESS, WARNING
        }
        public Notification(Severity severity, String title, String date, Boolean dismissable){
            this.severity = severity;
            this.title = title;
            this.date = date;
            this.dismissable = dismissable;
        }
    }
    public static String[] DETAILS = {
        "Mufassir Ahmad Chowdhury",
        "Student",
        "Computer Science and Engineering",
        "2nd year 1st semester"
    };
    public static Notification[] EXAM = {
        new Notification(Notification.Severity.CRITICAL, "STAT", "Today", false),
        new Notification(Notification.Severity.INFORMATIONAL, "Algo", "9th April", false),
    };
    public static Notification[] ASSIGNMENT = {
        new Notification(Notification.Severity.INFORMATIONAL, "Algo", "Tuesday", false),
    };
    public static Notification[] REGISTRATION = {
        new Notification(Notification.Severity.CRITICAL, "Fee Overdue", "Contact with register office today!", false),
        new Notification(Notification.Severity.SUCCESS, "Registration", "Registration successful!", false),
    };
    public static Notification[] NOTIFICATIONS = {
        new Notification(Notification.Severity.INFORMATIONAL, "Class Routine", "Class Routine is just updated", true),
        new Notification(Notification.Severity.WARNING, "Exam", "New Exam Posted", true),
        new Notification(Notification.Severity.INFORMATIONAL, "Resources", "Someone uploaded a resource", true),
        new Notification(Notification.Severity.CRITICAL, "Fee Overdue", "Contact with register office today!", true),
    };
}
