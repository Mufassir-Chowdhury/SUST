package Server;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.google.gson.*;

import javax.swing.JComponent;
import java.awt.image.BufferedImage;

import Components.Label;
import Components.pageView.Box.Line;
import Components.pageView.Box.Title;
import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.Post;
import Components.pageView.Panels.ScrollPane;
import Components.pageView.Panels.Table;
import Constants.Colors;
import Constants.Fonts;
import Constants.Icons;

public class Datapoints {

    public static interface Tilable {
        public Line getListItem();

        public String getTitle();

        public Post getPost();
    }

    public static interface JsonConversion {
        public String toJSON();

        public Object fromJSON(String json);
    }

    public static interface Information {
        public JComponent getInformation();
    }

    public static class Notification implements Serializable , JsonConversion {
        public String title, date;
        public Severity severity;
        public Boolean dismissable;

        public enum Severity {
            CRITICAL, INFORMATIONAL, SUCCESS, WARNING
        }

        public Notification(Severity severity, String title, String date, Boolean dismissable) {
            this.severity = severity;
            this.title = title;
            this.date = date;
            this.dismissable = dismissable;
        }

        @Override
        public String toJSON() {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.toJson(this);
        }

        @Override
        public Object fromJSON(String json) {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.fromJson(json, (Type) this);
        }
    }

    public enum Department {
        CSE("Computer Science and Engineering", 331, 12.5, 13.5),
        SWE("Software Engineering", 123, 12.5, 13.5),
        EEE("Electrical and Electronic Engineering", 234, 12.5, 13.5);

        private static final Map<Integer, Department> ByDeptCode = new HashMap<>();

        static {
            for (Department e : values())
                ByDeptCode.put(e.deptCode, e);
        }

        public final String fullForm;
        public final int deptCode;
        public final double theoryFee, labFee;

        private Department(String fullForm, int deptCode, double theoryFee, double labFee) {
            this.fullForm = fullForm;
            this.deptCode = deptCode;
            this.theoryFee = theoryFee;
            this.labFee = labFee;
        }

        public static String deptFullForm(int deptCode) {
            return ByDeptCode.get(deptCode).fullForm;
        }

        public static Department deptShortForm(int deptCode) {
            return ByDeptCode.get(deptCode);
        }

        public static double deptTheoryFee(int deptCode) {
            return ByDeptCode.get(deptCode).theoryFee;
        }

        public static double deptLabFee(int deptCode){
            return ByDeptCode.get(deptCode).labFee;
        }
    }

    public static class Student implements Serializable, Tilable, JsonConversion {
        public transient BufferedImage DP;
        public String registration, name, email, email2, number, blood, birthDay, hometown;
        public int deptCode;
        public String department;
        public Map<String, String[]> courses;

        

        public Student(String registration, String name, String email, String number, String blood, String birthDay,
                String hometown, String[] regular, String[] drop) {

            this.DP = Icons.DP;
            this.deptCode = getDeptCode(registration);
            this.department = Department.deptFullForm(this.deptCode);
            this.registration = registration;
            this.name = name;
            this.email = email;
            this.number = number;
            this.blood = blood;
            this.birthDay = birthDay;
            this.hometown = hometown;
            this.courses.put("regular", regular);
            this.courses.put("drop", drop);

        }

        public int getDeptCode(String registration) {
            return Integer.parseInt(registration.substring(4, 7));
        }

        @Override
        public Line getListItem() {
            return new Line(
                    registration,
                    DP,
                    name,
                    blood + " | " + birthDay + " | " + hometown,
                    email,
                    "+880" + number);
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
                    "+880" + number, false);
        }

        @Override
        public String toJSON() {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.toJson(this);
        }

        @Override
        public Object fromJSON(String json) {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.fromJson(json, (Type) this);
        }
    }

    public static class Courses implements Serializable, Information, JsonConversion {
        public String code;
        public String name;
        public String credit;
        public String grade;
        public float gpa;
        public int attendance;
        public int absent;
        public Boolean regular;
        public int leave;

        public static class EvaluationItem implements Serializable, Tilable, JsonConversion {
            public String courseName;
            public String title;
            public String date;
            public String description;
            public int totalMarks;
            public int marksObtained;

            public EvaluationItem(String courseName, String title, String date, String description, int totalMarks,
                    int marksObtained) {
                this.courseName = courseName;
                this.title = title;
                this.date = date;
                this.description = description;
                this.totalMarks = totalMarks;
                this.marksObtained = marksObtained;
            }

            @Override
            public Line getListItem() {
                return new Line(
                        title,
                        courseName,
                        date,
                        String.format("%03d", totalMarks) + "   " + String.format("%03d", marksObtained));
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
                        description, true);
            }

            @Override
            public String toJSON() {
                GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();    
                return gson.toJson(this);
            }

            @Override
            public Object fromJSON(String json) {
                GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();    
                return gson.fromJson(json, (Type) this);
            }
        }

        public static class Assignment extends EvaluationItem {
            public Assignment(String courseName, String title, String date, String description, int totalMarks,
                    int marksObtained) {
                super(courseName, title, date, description, totalMarks, marksObtained);
            }
        }

        public static class Exam extends EvaluationItem {
            public Exam(String courseName, String title, String date, String description, int totalMarks,
                    int marksObtained) {
                super(courseName, title, date, description, totalMarks, marksObtained);
            }
        }

        public static class Resource implements Serializable, JsonConversion {
            public static class Syllabus implements Serializable {
                public String title;
                public Vector<String> topics;
                public String comment;

                public Syllabus(String title, Vector<String> topics, String comment) {
                    this.title = title;
                    this.topics = topics;
                    this.comment = comment;
                }
            }

            public static class ResourceItem implements Serializable , JsonConversion{
                public String session = null;
                public String title;
                public String uploader;
                public String date;
                public String url;

                public ResourceItem(String title, String uploader, String date, String url) {
                    this.title = title;
                    this.uploader = uploader;
                    this.date = date;
                    this.url = url;
                }

                public ResourceItem(String session, String title, String uploader, String date, String url) {
                    this.session = session;
                    this.title = title;
                    this.uploader = uploader;
                    this.date = date;
                    this.url = url;
                }

                @Override
                public String toJSON() {
                    GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();        
                    return gson.toJson(this);
                }

                @Override
                public Object fromJSON(String json) {
                    GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();        
                    return gson.fromJson(json, (Type) this);
                }
            }

            public Syllabus syllabus;
            public Vector<ResourceItem> videos;
            public Vector<ResourceItem> ctQuestions;
            public Vector<ResourceItem> termFinalQuestions;
            public Vector<ResourceItem> lectureNotes;
            public Vector<ResourceItem> books;

            public Resource(Syllabus syllabus, Vector<ResourceItem> videos, Vector<ResourceItem> ctQuestions,
                    Vector<ResourceItem> termFinalQuestions, Vector<ResourceItem> lectureNotes,
                    Vector<ResourceItem> books) {
                this.syllabus = syllabus;
                this.videos = videos;
                this.ctQuestions = ctQuestions;
                this.termFinalQuestions = termFinalQuestions;
                this.lectureNotes = lectureNotes;
                this.books = books;
            }

            @Override
            public String toJSON() {
                GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();    
                return gson.toJson(this);
            }

            @Override
            public Object fromJSON(String json) {
                GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();    
                return gson.fromJson(json, (Type) this);
            }
        }

        public Vector<Assignment> assignments = new Vector<>();
        public Vector<Exam> exams = new Vector<>();
        public Resource resources;

        public Courses(Course course, Attendance rollCall, Result result, Boolean regular) {
            this.code = course.courseCode;
            this.name = course.courseTitle;
            this.credit = course.credit;
            this.attendance = rollCall.attendance;
            this.absent = rollCall.absent;
            this.leave = rollCall.leave;
            this.grade = result.grade;
            this.gpa = result.gpa;
            this.regular = regular;
            assignments.add(new Assignment(name, "Assignment 1" + this.name, this.attendance + "th April",
                    "This is assignment 1", 100, 80));
            exams.add(new Exam(name, "Exam 1" + this.name, this.attendance + "th April", "This is exam 1", 100, 80));
            exams.add(new Exam(name, "Exam 2" + this.name, this.attendance + "th April", "This is exam 2", 100, 80));
        }

        public void addAssignment(String title, String date, String description, int totalMarks, int marksObtained) {
            assignments.add(new Assignment(name, title, date, description, totalMarks, marksObtained));
        }

        public Line getAttendance() {
            return new Line(
                    name,
                    code,
                    String.valueOf(attendance),
                    String.format("%03d", absent) + "   " + String.format("%03d", leave));
        }

        public Line getResult() {
            return new Line(name, code, grade, String.format("%.2f", gpa));
        }

        @Override
        public JComponent getInformation() {
            return new Title(new Label("     " + name, Fonts.CAPTION),
                    new Label(regular.equals(false) ? "(Drop)" : "", Fonts.CAPTION, Colors.Theme.SECONDARY));
        }

        @Override
        public String toJSON() {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.toJson(this);
        }

        @Override
        public Object fromJSON(String json) {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.fromJson(json, (Type) this);
        }
    }

    public static class Link implements Serializable, JsonConversion {
        public String title;
        public String url;

        public Link(String title, String url) {
            this.title = title;
            this.url = url;
        }

        @Override
        public String toJSON() {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.toJson(this);
        }

        @Override
        public Object fromJSON(String json) {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.fromJson(json, (Type) this);
        }
    }

    public static class Event implements Serializable, Tilable, JsonConversion {
        public String title;
        public String date;
        public String description;
        public String location;
        public String duration;
        public int interested;
        public int going;

        public Event(String title, String date, String description, String location, String duration, int interested,
                int going) {
            this.title = title;
            this.date = date;
            this.description = description;
            this.location = location;
            this.duration = duration;
            this.interested = interested;
        }

        @Override
        public Line getListItem() {
            return new Line(
                    title,
                    location,
                    duration + " at  " + date,
                    String.format("%03d", interested) + "   " + String.format("%03d", going));
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
                    description, false);
        }

        @Override
        public String toJSON() {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.toJson(this);
        }

        @Override
        public Object fromJSON(String json) {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.fromJson(json, (Type) this);
        }
    }

    public static class Notice implements Serializable, Tilable, JsonConversion {
        public String title;
        public String date;
        public String description;
        public String file;

        public Notice(String title, String date, String description, String file) {
            this.title = title;
            this.date = date;
            this.description = description;
            this.file = file;
        }

        @Override
        public Line getListItem() {
            return new Line(
                    title,
                    "",
                    "",
                    date);
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
                    description, false);
        }

        @Override
        public String toJSON() {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.toJson(this);
        }

        @Override
        public Object fromJSON(String json) {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.fromJson(json, (Type) this);
        }
    }

    public static class Bus implements Serializable, Information, JsonConversion {
        public int busNo;
        public String busName;
        public String License;
        public String driverName;
        public String[] route;
        public String time;

        public Bus(int busNo, String busName, String license, String driverName, String[] route, String time) {
            this.busNo = busNo;
            this.busName = busName;
            this.route = route;
            this.time = time;
            this.License = license;
            this.driverName = driverName;
        }

        @Override
        public JComponent getInformation() {
            return new ListPanel(
                    new Label("Bus " + busNo + " - " + busName),
                    new Label(License + " - " + driverName, Fonts.CAPTION),
                    0);
        }

        @Override
        public String toJSON() {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.toJson(this);
        }

        @Override
        public Object fromJSON(String json) {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.fromJson(json, (Type) this);
        }
    }

    public static class Resource implements Serializable, Information, JsonConversion {
        public String title;
        public Object[][] data;
        public Object[] columnNames;

        public Resource(String title, Object[][] data, Object[] columnNames) {
            this.title = title;
            this.data = data;
            this.columnNames = columnNames;
        }

        public ListPanel getInformation() {
            return new ListPanel(
                    new ScrollPane(
                            new Table(data, columnNames)),
                    null,
                    0);
        }

        @Override
        public String toJSON() {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.toJson(this);
        }

        @Override
        public Object fromJSON(String json) {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.fromJson(json, (Type) this);
        }
    }

    public static class Routine implements Serializable, JsonConversion {
        public LocalDate date;
        public LocalTime startTime;
        public LocalTime endTime;
        public String courseCode;
        public String classRoom;
        public String remarks;
        public String department;

        public Routine(LocalDate date, LocalTime startTime, LocalTime endTime, String courseCode, String classRoom,
                String remarks, String department) {
            this.date = date;
            this.startTime = startTime;
            this.endTime = endTime;
            this.courseCode = courseCode;
            this.classRoom = classRoom;
            this.remarks = remarks;
            this.department = department;
        }

        @Override
        public String toJSON() {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.toJson(this);
        }

        @Override
        public Object fromJSON(String json) {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.fromJson(json, (Type) this);
        }
    }

    public static class Course {
        String courseCode, courseTitle, credit;

        public Course(String courseCode, String courseTitle, String credit) {
            this.courseCode = courseCode;
            this.courseTitle = courseTitle;
            this.credit = credit;
        }
    }

    public static class Attendance {
        int absent, leave, attendance;

        public Attendance(int attendance, int absent, int leave) {
            this.attendance = attendance;
            this.absent = absent;
            this.leave = leave;
        }
    }

    public static class Result {
        String grade;
        float gpa;
        int totalMarks;
        float marksObtained;

        public Result(int totalMarks, float marksObtained, String grade, float gpa) {
            this.grade = grade;
            this.gpa = gpa;
            this.totalMarks = totalMarks;
            this.marksObtained = marksObtained;
        }
    }
    
    
    
    public String[] route = {
            "Place", "Place", "Place", "Place", "Place", "Place", "Place"
    };

    

    

    public Bus[] BUSES = {
            new Bus(1, "busName", "license", "driverName", route, "time"),
            new Bus(2, "busName", "license", "driverName", route, "time"),
            new Bus(3, "busName", "license", "driverName", route, "time"),
            new Bus(4, "busName", "license", "driverName", route, "time"),
            new Bus(5, "busName", "license", "driverName", route, "time"),
            new Bus(6, "busName", "license", "driverName", route, "time"),
            new Bus(7, "busName", "license", "driverName", route, "time"),
    };
    public String[] USN = {
            "USN", "USN 2"
    };
    public String[] SEMESTER = {
            "Semester", "Semester 2"
    };
    public Object[][] SYLLABUS = {
            {
                    "Programming Language",
                    "Basic Concept, OverView of Programming languages, Problem solving techniques and data flow diagram"
            },
            {
                    "Operating System",
                    "Basic Concept, OverView of Operating systems, Problem solving techniques and data flow diagram"
            },
            {
                    "C-Language",
                    "Preliminaries, Arrays, Functions, Files, Pointers"
            }
    };
    public Object[][] RESOURCES = {
            {
                    "Resource 1",
                    "Uploader 1",
                    "Download Link 1"
            },
            {
                    "Resource 2",
                    "Uploader 2",
                    "Download Link 2"
            },
            {
                    "Resource 3",
                    "Uploader 3",
                    "Download Link 3"
            }
    };

    public static Event[] EVENTS = null;
    public String[] LINK_TITLES = null;
    public Link[][] LINKS = null;
    public Courses[] COURSES = null;
    public String[] DETAILS = null;
    public Notification[] EXAM = null;
    public Notification[] ASSIGNMENT = null;
    public Notification[] REGISTRATION = null;
    public Notification[] NOTIFICATION = null;
    public static Student[] STUDENTS = null;
    public static Notice[] NOTICES = null;

    private static Datapoints single_instance = null;

    public static Datapoints getInstance() {
        if (single_instance == null)
            single_instance = new Datapoints();

        return single_instance;
    }
}
