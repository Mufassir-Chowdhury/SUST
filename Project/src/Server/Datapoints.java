package Server;

import java.io.IOException;
import java.io.Serializable;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JPanel;

import Components.Label;
import Components.ListItem;
import Components.pageView.Box.Line;
import Components.pageView.Box.ResultSummary;
import Components.pageView.Box.Title;
import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.Post;
import Components.pageView.Panels.ViewPortBasicPanel;
import Constants.Colors;
import Constants.Fonts;
import Constants.Icons;
import pages.pageView.course_information.*;
import pages.pageView.administrivia.*;
import pages.pageView.misc.*;
import pages.pageView.misc.bus.bus;
import pages.pageView.updates.routine.routine;

public class Datapoints{
    public static interface Tilable{
        public Line getListItem();
        public String getTitle();
        public Post getPost();
    }
    public static interface Information{
        public JComponent getInformation();
    }


    public static class Page{
        public String name;
        public Icon icon;
        public JPanel panel;
        public Page(String name, Icon icon, JPanel panel)  throws ClassNotFoundException, IOException{
            this.name = name;
            this.icon = icon;
            this.panel = panel;
        }
        @Override
        public String toString(){
            return name;
        }
    };
    public Page[][] getPages() throws ClassNotFoundException, IOException{
        return new Page[][]{
            {new Page("Class Routines", Icons.SCHEDULE, new routine()), 
                new Page("Due Assignments", Icons.ASSIGNMENT, new ViewPortBasicPanel("Assignment", Components.pageView.Box.MainCardListItem.Type.ASSIGNMENT)),
                new Page("Upcoming Exams", Icons.EXAM, new ViewPortBasicPanel("Exam", Components.pageView.Box.MainCardListItem.Type.EXAM)),
                new Page("Notice Board", Icons.NOTICE, new ViewPortBasicPanel("Notices", NOTICES))},
            { new Page("Resources", Icons.RESOURCES, new resources()),
                new Page("Results", Icons.RESULT, new ViewPortBasicPanel("Results", new ResultSummary(), Components.pageView.Box.MainCardListItem.Type.RESULT)),
                new Page("Attendance", Icons.ATTENDANCE, new ViewPortBasicPanel("Attendance", null, Components.pageView.Box.MainCardListItem.Type.ATTENDANCE))},
            { new Page("Payment", Icons.PAYMENT, new payment()),
                new Page("Course Registration", Icons.COURSE_REGISTRATION, new course()),
                new Page("Important Links", Icons.IMPORTANT_LINKS, new links())},
            { new Page("Bus Schedule", Icons.BUS_SCHEDULE, new bus()),
                new Page("Student Information", Icons.STUDENT_INFO, new ViewPortBasicPanel("Students", STUDENTS)),
                new Page("Events", Icons.EVENTS, new ViewPortBasicPanel("Events", EVENTS)),
                new Page("Map", Icons.MAP, new map())},
        };
    }
    // public static final Page[] CLIENT = {
    //     new Page("STUDENT", Icons.STUDENT, new students()),
    //     new Page("TEACHER", Icons.TEACHER, new students()),
    //     new Page("ADMINISTRATOR", Icons.ADMINISTRATOR, new students()) 
    // };

    public static class Notification  implements Serializable{
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
    public static class Student implements Serializable, Tilable{
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
        @Override
        public Line getListItem() {
            return new Line(new ListItem(
                name, 
                blood + " | " + birthDay + " | " + hometown, 
                email, 
                "+880" + number));
        }
        @Override
        public String getTitle() {
            return name;
        }
        @Override
        public Post getPost() {
            return new Post(
                name, 
                blood + " | " + birthDay + " | " + hometown, 
                email, 
                "+880" + number);
        }
    }

    public static class Courses  implements Serializable, Information{
        public String code;
        public String name;
        public String credit;
        public String grade;
        public float gpa;
        public int attendance;
        public int absent;
        public Boolean regular;
        public int leave;

        public static class EvaluationItem implements Serializable, Tilable{
            public String courseName;
            public String title;
            public String date;
            public String description;
            public int totalMarks;
            public int marksObtained;
            public EvaluationItem(String courseName, String title, String date, String description, int totalMarks, int marksObtained){
                this.courseName = courseName;
                this.title = title;
                this.date = date;
                this.description = description;
                this.totalMarks = totalMarks;
                this.marksObtained = marksObtained;
            }
            @Override
            public Line getListItem() {
                return new Line(new ListItem(
                    title, 
                    courseName,
                    date, 
                    String.format("%03d", totalMarks) + "   " + String.format("%03d", marksObtained)));
            }
            @Override
            public String getTitle() {
                return title;
            }
            @Override
            public Post getPost() {
                return new Post(
                    title,
                    "Due Date: " + date, 
                    "Total Marks: " + totalMarks, 
                    description);
            }
        }
        public static class Assignment extends EvaluationItem{
            public Assignment(String courseName, String title, String date, String description, int totalMarks, int marksObtained){
                super(courseName, title, date, description, totalMarks, marksObtained);
            }
        }
        public static class Exam extends EvaluationItem{
            public Exam(String courseName, String title, String date, String description, int totalMarks, int marksObtained){
                super(courseName, title, date, description, totalMarks, marksObtained);
            }
        }
        public static class Resource implements Serializable{
            public static class Syllabus implements Serializable{
                public String title;
                public Vector<String> topics;
                public String comment;
                public Syllabus(String title, Vector<String> topics, String comment){
                    this.title = title;
                    this.topics = topics;
                    this.comment = comment;
                }
            }
            public static class ResourceItem implements Serializable{
                public String session = null;
                public String title;
                public String uploader;
                public String date;
                public String url;
                public ResourceItem(String title, String uploader, String date, String url){
                    this.title = title;
                    this.uploader = uploader;
                    this.date = date;
                    this.url = url;
                }
                public ResourceItem(String session, String title, String uploader, String date, String url){
                    this.session = session;
                    this.title = title;
                    this.uploader = uploader;
                    this.date = date;
                    this.url = url;
                }
            }
            public Syllabus syllabus;
            public Vector<ResourceItem> videos;
            public Vector<ResourceItem> ctQuestions;
            public Vector<ResourceItem> termFinalQuestions;
            public Vector<ResourceItem> lectureNotes;
            public Vector<ResourceItem> books;
            public Resource(Syllabus syllabus, Vector<ResourceItem> videos, Vector<ResourceItem> ctQuestions, Vector<ResourceItem> termFinalQuestions, Vector<ResourceItem> lectureNotes, Vector<ResourceItem> books){
                this.syllabus = syllabus;
                this.videos = videos;
                this.ctQuestions = ctQuestions;
                this.termFinalQuestions = termFinalQuestions;
                this.lectureNotes = lectureNotes;
                this.books = books;
            }
        }

        public Vector<Assignment> assignments = new Vector<>();
        public Vector<Exam> exams = new Vector<>();
        public Resource resources;
        public Courses(String code, String name, String credit, String grade, float gpa, int attendance, int absent, Boolean regular, int leave){
            this.code = code;
            this.name = name;
            this.credit = credit;
            this.grade = grade;
            this.gpa = gpa;
            this.attendance = attendance;
            this.absent = absent;
            this.regular = regular;
            this.leave = leave;
            assignments.add(new Assignment(name, "Assignment 1" + this.name, this.attendance + "th April", "This is assignment 1", 100, 80));
            exams.add(new Exam(name, "Exam 1" + this.name, this.attendance + "th April", "This is exam 1", 100, 80));
            exams.add(new Exam(name, "Exam 2" + this.name, this.attendance + "th April", "This is exam 2", 100, 80));
        }
        public void addAssignment(String title, String date, String description, int totalMarks, int marksObtained){
            assignments.add(new Assignment(name, title, date, description, totalMarks, marksObtained));
        }
        public Line getAttendance(){
            return new Line(new ListItem(
                name, 
                code, 
                String.valueOf(attendance), 
                String.format("%03d", absent) + "   " + String.format("%03d", leave)));
        }
        public Line getResult(){
            return new Line(new ListItem(name, code, grade, String.format("%.2f", gpa)));
        }
        @Override
        public JComponent getInformation() {
            return new Title("     " + name, Fonts.CAPTION, new Label(regular.equals(false) ? "(Drop)" : "", Fonts.CAPTION, Colors.SECONDARY));
        }
    }

    public static class Link implements Serializable{
        public String title;
        public String url;
        public Link(String title, String url){
            this.title = title;
            this.url = url;
        }
    }

    public static class Event implements Serializable, Tilable{
        public String title;
        public String date;
        public String description;
        public String location;
        public String duration;
        public int interested;
        public int going;
        public Event(String title, String date, String description, String location, String duration, int interested, int going){
            this.title = title;
            this.date = date;
            this.description = description;
            this.location = location;
            this.duration = duration;
            this.interested = interested;
        }
        @Override
        public Line getListItem() {
            return new Line(new ListItem(
                title, 
                location, 
                duration + " at  " + date, 
                String.format("%03d", interested) + "   " + String.format("%03d", going)));
        }
        @Override
        public String getTitle() {
            return title;
        }
        @Override
        public Post getPost() {
            return new Post(
                title,
                "Date: " + date, 
                "Location: " + location, 
                description);
        }
    }
    public static class Notice implements Serializable, Tilable{
        public String title;
        public String date;
        public String description;
        public String file;
        public Notice(String title, String date, String description, String file){
            this.title = title;
            this.date = date;
            this.description = description;
            this.file = file;
        }
        @Override
        public Line getListItem() {
            return new Line(new ListItem(
                title, 
                "", 
                "", 
                date));
        }
        @Override
        public String getTitle() {
            return title;
        }
        @Override
        public Post getPost() {
            return new Post(
                title,
                date, 
                "", 
                description);
        }
    }

    public static class Bus implements Serializable, Information{
        public int busNo;
        public String busName;
        public String Liscense;
        public String driverName;
        public String[] route;
        public String time;
        public Bus(int busNo, String busName, String liscence, String driverName, String[] route, String time){
            this.busNo = busNo;
            this.busName = busName;
            this.route = route;
            this.time = time;
            this.Liscense = liscence;
            this.driverName = driverName;
        }
        @Override
        public JComponent getInformation() {
            return new ListPanel(
                new Label("Bus " + busNo + " - " + busName),
                new Label(Liscense + " - " + driverName, Fonts.CAPTION));
        }
    }
    public String[] route = {
        "Place", "Place", "Place","Place", "Place", "Place","Place"
    };
    public Bus[] BUSES = {
        new Bus(1, "busName", "liscence", "driverName", route, "time"),
        new Bus(2, "busName", "liscence", "driverName", route, "time"),
        new Bus(3, "busName", "liscence", "driverName", route, "time"),
        new Bus(4, "busName", "liscence", "driverName", route, "time"),
        new Bus(5, "busName", "liscence", "driverName", route, "time"),
        new Bus(6, "busName", "liscence", "driverName", route, "time"),
        new Bus(7, "busName", "liscence", "driverName", route, "time"),
    };
    public String[] USN = {
        "USN", "USN 2"
    };
    public String[] SEMESTER = {
        "Semester", "Semester 2"
    };
    public String[] RESOURCES = {"Syllabus",
                                "Class Videos",
                                "CT Questions",
                                "Term Final Questions",
                                "Lecture Notes",
                                "Books",};
    public String[] PAYMENT = {
        "Registration Fee",
        "Library Fine",
        "Migration Fee",
        "Credit Fee",
        "Documents Fee",
        "Apply for Transcript",
    };
    public String[] TITLES = { "UPDATES", "COURSE INFORMATION", "ADMINISTRIVIA", "MISCELLANEOUS" };
    public Event[] EVENTS = null;
    public String[] LINK_TITLES = null;
    public Link[][] LINKS = null;
    public Courses[] COURSES = null;
    public String[] DETAILS = null;
    public Notification[] EXAM = null;
    public Notification[] ASSIGNMENT = null;
    public Notification[] REGISTRATION = null;
    public Notification[] NOTIFICATION = null;
    public Student[] STUDENTS = null;
    public Notice[] NOTICES =  null;

    private static Datapoints single_instance = null;
  
    public static Datapoints getInstance(){
        if (single_instance == null)
            single_instance = new Datapoints();
  
        return single_instance;
    }
}
