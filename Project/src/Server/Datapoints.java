package Server;

import java.io.IOException;
import java.io.Serializable;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.JPanel;

import Constants.Icons;
import pages.pageView.*;

public class Datapoints{
    public static class Page{
        public String name;
        public Icon icon;
        public JPanel panel;
        public Page(String name, Icon icon, JPanel panel)  throws ClassNotFoundException, IOException{
            this.name = name;
            this.icon = icon;
            this.panel = panel;
        }
    };
    public Page[][] getPages() throws ClassNotFoundException, IOException{
        return new Page[][]{
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
    
    public static class Student  implements Serializable{
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

    public static class Courses  implements Serializable{
        public class Assignment implements Serializable{
            public String title;
            public String date;
            public String description;
            public int totalMarks;
            public int marksObtained;
            public Assignment(String title, String date, String description, int totalMarks, int marksObtained){
                this.title = title;
                this.date = date;
                this.description = description;
                this.totalMarks = totalMarks;
                this.marksObtained = marksObtained;
            }
        }
        public class Exam implements Serializable{
            public String title;
            public String date;
            public String description;
            public int totalMarks;
            public int marksObtained;
            public Exam(String title, String date, String description, int totalMarks, int marksObtained){
                this.title = title;
                this.date = date;
                this.description = description;
                this.totalMarks = totalMarks;
                this.marksObtained = marksObtained;
            }
        }
        public class Resource implements Serializable{
            public class Syllabus implements Serializable{
                public String title;
                public Vector<String> topics;
                public String comment;
                public Syllabus(String title, Vector<String> topics, String comment){
                    this.title = title;
                    this.topics = topics;
                    this.comment = comment;
                }
            }
            public class Videos implements Serializable{
                public String title;
                public String url;
                public String uploader;
                public String date;
                public Videos(String title, String url, String uploader, String date){
                    this.title = title;
                    this.url = url;
                    this.uploader = uploader;
                    this.date = date;
                }
            }
            public class ResourceItem implements Serializable{
                public String session;
                public String title;
                public String uploader;
                public String date;
                public String url;
                public ResourceItem(String session, String title, String uploader, String date, String url){
                    this.session = session;
                    this.title = title;
                    this.uploader = uploader;
                    this.date = date;
                    this.url = url;
                }
            }
            public Syllabus syllabus;
            public Vector<Videos> videos;
            public Vector<ResourceItem> ctQuestions;
            public Vector<ResourceItem> termFinalQuestions;
            public Vector<ResourceItem> lectureNotes;
            public Vector<ResourceItem> books;
            public Resource(Syllabus syllabus, Vector<Videos> videos, Vector<ResourceItem> ctQuestions, Vector<ResourceItem> termFinalQuestions, Vector<ResourceItem> lectureNotes, Vector<ResourceItem> books){
                this.syllabus = syllabus;
                this.videos = videos;
                this.ctQuestions = ctQuestions;
                this.termFinalQuestions = termFinalQuestions;
                this.lectureNotes = lectureNotes;
                this.books = books;
            }
        }

        public String code;
        public String name;
        public String credit;
        public String grade;
        public float gpa;
        public int attendance;
        public int absent;
        public Boolean regular;
        public int leave;
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
            assignments.add(new Assignment("Assignment 1" + this.name, this.attendance + "th April", "This is assignment 1", 100, 80));
            assignments.add(new Assignment("Assignment 2" + this.name, this.attendance + "th April", "This is assignment 2", 100, 80));
            assignments.add(new Assignment("Assignment 3" + this.name, this.attendance + "th April", "This is assignment 3", 100, 80));
            exams.add(new Exam("Exam 1" + this.name, this.attendance + "th April", "This is exam 1", 100, 80));
            exams.add(new Exam("Exam 2" + this.name, this.attendance + "th April", "This is exam 2", 100, 80));
            exams.add(new Exam("Exam 3" + this.name, this.attendance + "th April", "This is exam 3", 100, 80));
        }
        public void addAssignment(String title, String date, String description, int totalMarks, int marksObtained){
            assignments.add(new Assignment(title, date, description, totalMarks, marksObtained));
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

    public static class Event implements Serializable{
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
    }
    public static String[] TITLES = { "UPDATES", "COURSE INFORMATION", "ADMINISTRIVIA", "MISCELLANEOUS" };
    public static Event[] EVENTS = null;
    public static String[] LINK_TITLES = null;
    public static Link[][] LINKS = null;
    public static Courses[] COURSES = null;
    public static String[] DETAILS = null;
    public static Notification[] EXAM = null;
    public static Notification[] ASSIGNMENT = null;
    public static Notification[] REGISTRATION = null;
    public static Notification[] NOTIFICATION = null;
    public static Student[] STUDENTS = null;
}
