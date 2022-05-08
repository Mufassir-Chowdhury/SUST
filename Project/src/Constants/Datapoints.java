package Constants;

import javax.swing.Icon;
import javax.swing.JPanel;

import pages.pageView.*;

public class Datapoints {
    public static class Page{
        public String name;
        public Icon icon;
        public JPanel panel;
        public Page(String name, Icon icon, JPanel panel){
            this.name = name;
            this.icon = icon;
            this.panel = panel;
        }
    };

    public static final String[] TITLES = { "UPDATES", "COURSE INFORMATION", "ADMINISTRIVIA", "MISCELLANEOUS" };
    public final Page[][] PAGES = {
        {new Page("Class Routines", Icons.SCHEDULE, new routine()), 
            new Page("Due Assignments", Icons.ASSIGNMENT, new assignment()),
            new Page("Upcoming Exams", Icons.EXAM, new exam()),
            new Page("Notice Board", Icons.NOTICE, new notice())},
        { new Page("Resources", Icons.RESOURCES, new resources()),
            new Page("Results", Icons.RESULT, new result()),
            new Page("Attendance", Icons.ATTENDANCE, new attendance())},
        { new Page("Payment", Icons.PAYMENT, new payment()),
            new Page("Course Registration", Icons.COURSE_REGISTRATION, new course()),
            new Page("Important Links", Icons.IMPORTANT_LINKS, new links())},
        { new Page("Bus Schedule", Icons.BUS_SCHEDULE, new bus()),
            new Page("Student Information", Icons.STUDENT_INFO, new students()),
            new Page("Events", Icons.EVENTS, new event()),
            new Page("Map", Icons.MAP, new map())},
    };

    // public static final Page[] CLIENT = {
    //     new Page("STUDENT", Icons.STUDENT, new students()),
    //     new Page("TEACHER", Icons.TEACHER, new students()),
    //     new Page("ADMINISTRATOR", Icons.ADMINISTRATOR, new students()) 
    // };

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
    
    public static class Student{
        public String registration;
        public String name;
        public String email;
        public String number;
        public String blood;
        public String birthDay;
        public String hometown;
        public Student(String registration, String name, String email, String number, String blood, String birthDay, String hometown){
            this.registration = registration;
            this.name = name;
            this.email = email;
            this.number = number;
            this.blood = blood;
            this.birthDay = birthDay;
            this.hometown = hometown;
        }
    }

    public static Student[] STUDENTS = {
        new Student("2019331053", "M. M. Kabid Hasan", "kabidhasan34@gmail.com", "1521575632", "A+", "27 October", "Rajbari"),
        new Student("2019331054", "Syed Sazid Hossain Rezvi", "fazle.rabbi.mahin.539@gmail.com", "1884374959", "O+", "12 November", "Dhamrai, Dhaka"),
        new Student("2019331055", "Niloy Roy", "niloyroy1715@gmail.com", "1705814064", "O+", "14 May, 2000", "Rangpur"),
        new Student("2019331057", "Ihsan Mirani Rumi", "ihsanmirani9865@gmail.com", "1864024910", "AB+", "5 June", "Dhaka"),
        new Student("2019331058", "Md. Shihab Raihan", "soebshihab@gmail.com", "1798942838", "O+", "23,September", "Bogra"),
        new Student("2019331059", "Mehedi Hasan", "imehedi357@gmail.com", "1706007087", "A+", "2 July", "Sirajganj"),
        new Student("2019331060", "Muktadir Ahmed Palash", "palashmuktadir84@gmail.com", "1742655094", "A+", "10 February", "Bogra"),
        new Student("2019331062", "Ariful Islam Farhad", "arifulfarhad300@gmail.com", "1856870527", "B+", "25 October", "Kishoreganj"),
        new Student("2019331063", "Rubayet Sadman Sami", "rssami.bd@gmail.com", "1754966414", "B+", "23 March", "Sylhet"),
        new Student("2019331064", "Md. Muhtasim Ahmed Bhuiyan", "muhtasim.ahmed.nhuiyan@gmail.com", "1715036340", "O+", "28 March", "Dhaka"),
        new Student("2019331065", "MD. Naimul Haque", "nhnahin65@gmail.com", "1622403404", "A-", "16 September", "Chittagong"),
        new Student("2019331067", "Mubashshira Tasneem", "mubashshiratasneem140918@gmail.com", "1761429552", "O+", "28 December,2000", "Tangail"),
        new Student("2019331068", "Abdullah All Ferdouse", "siababdullah3946@gmail.com", "1575087097", "A+", "13 November", "Dhaka"),
        new Student("2019331070", "Mostahid Hasan Fahim", "mostahidhasanFahim@gmail.com", "1759300449", "O+", "8 November", "Gaibandha"),
        new Student("2019331071", "Md Mostakim Billah", "mostakimbillah512@gmail.com", "1814560020", "B+", "15 July", "Lalmonirhat"),
    };
}
