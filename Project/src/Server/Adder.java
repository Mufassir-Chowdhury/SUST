package Server;

import java.io.*;
import java.util.*;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import Server.Datapoints.*;

public class Adder {
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    static BufferedReader bufferedReader;
    static FileWriter writer;
    static String filePath;

    public static String LINK = "links.json";
    public static String EVENT = "events.json";
    public static String STUDENT_BY_REGISTRATION = "allStudentsSortedByRegistration.json";
    public static String STUDENT_BY_DEPARTMENT = "allStudentsSortedByDepartment.json";
    public static String TEACHER_BY_EMAIL = "allTeachersSortedByEmail.json";
    public static String TEACHER_BY_DEPARTMENT = "allTeachersSortedByDepartment.json";
    public static String PASSWORD = "password.json";
    public static String COURSE_BY_DEPARTMENT = "allCourseListDeptWise.json";
    public static String COURSE_BY_CODE = "allCourseListCourseCodeWise.json";
    public static String ASSIGNMENT_EXAM_DETAILS = "allAssignmentExamDetails.json";
    public static String ASSIGNMENT_EXAM_RESULTS = "allAssignmentExamResults.json";

    public static String extractFilePath(String file) {
        file = "src/Server/static/" + file;

        // file = "Project/" + file;

        return file;

        // String s = ClassLoader.getSystemResource(file).toString();
        // String ss = System.getProperty("user.dir").replace("\\", "/");

        // return s.replace(ss, "").replace("bin", "src").replace("file://", "");
    }

    public static void addNewLink(String title, Link link) throws IOException {
        filePath = extractFilePath(LINK);
        bufferedReader = new BufferedReader(
                new FileReader(filePath));

        Map<String, Map<String, Link>> links = new HashMap<>();
        links = gson.fromJson(bufferedReader, new TypeToken<Map<String, Map<String, Link>>>() {
        }.getType());

        if (links == null)
            links = new HashMap<>();

        if (links.containsKey(title) == false) {
            links.put(title, new HashMap<>());
            links.get(title).put(link.title, link);
        }
        links.get(title).put(link.title, link);

        FileWriter writer = new FileWriter(filePath);
        writer.write(gson.toJson(links));
        writer.close();
        bufferedReader.close();
    }

    public static void addNewEvent(Event event) throws IOException {
        filePath = extractFilePath(EVENT);
        bufferedReader = new BufferedReader(
                new FileReader(filePath));

        Map<String, Map<String, Event>> events = new HashMap<>();
        events = gson.fromJson(bufferedReader, new TypeToken<Map<String, Map<String, Event>>>() {
        }.getType());

        if (events == null)
            events = new HashMap<>();

        
        if(event.For.equals("Both")==true)
        {
            String title = event.title;
            event.title = "Student Event # " + Integer.toString(events.get("Student").size() + 1) + " (" + title + ")";
            events.get("Student").put(event.title, event);

            event.title = "Teacher Event # " + Integer.toString(events.get("Teacher").size() + 1) + " (" + title + ")";
            events.get("Teacher").put(event.title, event);
        }
        else {
            event.title =event.For+ " Event # " + Integer.toString(events.get(event.For).size() + 1) + " (" + event.title + ")";
            events.get(event.For).put(event.title, event);
        }
        
        writer = new FileWriter(filePath);
        writer.write(gson.toJson(events));
        writer.close();
        bufferedReader.close();
    }

    public static void addNewStudent(Student student) throws IOException {

        {
            filePath = extractFilePath(STUDENT_BY_REGISTRATION);
            bufferedReader = new BufferedReader(
                    new FileReader(filePath));

            Map<String, Student> students = new HashMap<>();
            students = gson.fromJson(bufferedReader, new TypeToken<Map<String, Student>>() {
            }.getType());

            if (students == null)
                students = new HashMap<>();

            if (students.containsKey(student.registration))
                return;

            students.put(student.registration, student);

            writer = new FileWriter(filePath);
            writer.write(gson.toJson(students));
            writer.close();
            bufferedReader.close();
        }

        updatePasswordDatabase("Student", student.email, student.registration);

        {
            filePath = extractFilePath(STUDENT_BY_DEPARTMENT);
            bufferedReader = new BufferedReader(
                    new FileReader(filePath));

            Map<String, Map<String, Set<String>>> sortedStudents = new HashMap<>();

            sortedStudents = gson.fromJson(bufferedReader, new TypeToken<Map<String, Map<String, Set<String>>>>() {
            }.getType());

            if (sortedStudents == null)
                sortedStudents = new HashMap<>();

            String department = student.department;
            String session = student.session;

            if (sortedStudents.containsKey(department) == false)
                sortedStudents.put(department, new HashMap<>());

            if (sortedStudents.get(department).containsKey(session) == false)
                sortedStudents.get(department).put(session, new HashSet<>());

            sortedStudents.get(department).get(session).add(student.registration);

            writer = new FileWriter(filePath);
            writer.write(gson.toJson(sortedStudents));
            writer.close();
            bufferedReader.close();
        }
    }

    public static void addNewTeacher(Teacher teacher) throws IOException {

        {
            filePath = extractFilePath(TEACHER_BY_EMAIL);
            bufferedReader = new BufferedReader(
                    new FileReader(filePath));

            Map<String, Teacher> teachers = new HashMap<>();
            teachers = gson.fromJson(bufferedReader, new TypeToken<Map<String, Teacher>>() {
            }.getType());

            if (teachers == null)
                teachers = new HashMap<>();

            if (teachers.containsKey(teacher.email))
                return;

            teachers.put(teacher.email, teacher);

            writer = new FileWriter(filePath);
            writer.write(gson.toJson(teachers));
            writer.close();
            bufferedReader.close();
        }

        updatePasswordDatabase("Teacher", teacher.email, teacher.email);

        {
            filePath = extractFilePath(TEACHER_BY_DEPARTMENT);
            bufferedReader = new BufferedReader(
                    new FileReader(filePath));

            Map<String, Set<String>> sortedTeachers = new HashMap<>();

            sortedTeachers = gson.fromJson(bufferedReader, new TypeToken<Map<String, Set<String>>>() {
            }.getType());

            if (sortedTeachers == null)
                sortedTeachers = new HashMap<>();

            String department = teacher.department;

            if (sortedTeachers.containsKey(department) == false)
                sortedTeachers.put(department, new HashSet<>());

            sortedTeachers.get(department).add(teacher.email);

            writer = new FileWriter(filePath);
            writer.write(gson.toJson(sortedTeachers));
            writer.close();
            bufferedReader.close();
        }
    }

    private static void updatePasswordDatabase(String Type, String email, String registration) throws IOException {
        
        filePath = extractFilePath(PASSWORD);
        bufferedReader = new BufferedReader(
                new FileReader(filePath));

        Map<String, Map<String, String>> passwords = new HashMap<>();
        passwords = gson.fromJson(bufferedReader, new TypeToken<Map<String, Map<String, String>>>() {
        }.getType());

        if (passwords == null)
            passwords = new HashMap<>();

        if (passwords.containsKey(Type) == false)
            passwords.put(Type, new HashMap<>());

        passwords.get(Type).put(email, registration);

        writer = new FileWriter(filePath);
        writer.write(gson.toJson(passwords));
        writer.close();
        bufferedReader.close();
    }

    public static void addCourse(Course course) throws IOException {
        {
            filePath = extractFilePath(COURSE_BY_DEPARTMENT);
            bufferedReader = new BufferedReader(
                    new FileReader(filePath));

            Map<String, Map<Integer, Set<String>>> allCourseList = new HashMap<>();

            allCourseList = gson.fromJson(bufferedReader, new TypeToken<Map<String, Map<Integer, Set<String>>>>() {
            }.getType());

            if (allCourseList == null)
                allCourseList = new HashMap<>();

            if (allCourseList.containsKey(course.department) == false)
                allCourseList.put(course.department, new HashMap<>());

            if (allCourseList.get(course.department).containsKey(course.semester) == false)
                allCourseList.get(course.department).put(course.semester, new HashSet<>());

            allCourseList.get(course.department).get(course.semester).add(course.courseCode);

            writer = new FileWriter(filePath);
            writer.write(gson.toJson(allCourseList));
            writer.close();
            bufferedReader.close();
        }

        {
            filePath = extractFilePath(COURSE_BY_CODE);
            bufferedReader = new BufferedReader(
                    new FileReader(filePath));

            Map<String, Course> allCourseList = new HashMap<>();

            allCourseList = gson.fromJson(bufferedReader, new TypeToken<Map<String, Course>>() {
            }.getType());

            if (allCourseList == null)
                allCourseList = new HashMap<>();

            if (allCourseList.containsKey(course.department) == false)
                allCourseList.put(course.courseCode, course);

            writer = new FileWriter(filePath);
            writer.write(gson.toJson(allCourseList));
            writer.close();
            bufferedReader.close();

        }

        {
            filePath = extractFilePath(ASSIGNMENT_EXAM_DETAILS);
            bufferedReader = new BufferedReader(new FileReader(filePath));

            Map<String, Map<String, Map<String, Map<String, EvaluationItem>>>> allAssignmentExamDetails = new HashMap<>();

            allAssignmentExamDetails = gson.fromJson(bufferedReader,
                    new TypeToken<Map<String, Map<String, Map<String, Map<String, EvaluationItem>>>>>() {
                    }.getType());

            if (allAssignmentExamDetails == null)
                allAssignmentExamDetails = new HashMap<>();

            if (allAssignmentExamDetails.containsKey(course.courseCode) == false) {
                allAssignmentExamDetails.put(course.courseCode, new HashMap<>());
                allAssignmentExamDetails.get(course.courseCode).put("Assignment", new HashMap<>());
                allAssignmentExamDetails.get(course.courseCode).put("Exam", new HashMap<>());
            }

            writer = new FileWriter(filePath);
            writer.write(gson.toJson(allAssignmentExamDetails));
            writer.close();
            bufferedReader.close();
        }

        {
            filePath = extractFilePath(ASSIGNMENT_EXAM_RESULTS);
            bufferedReader = new BufferedReader(new FileReader(filePath));
            Map<String, Map<String, Map<String, Map<String, Map<String, String>>>>> allAssignmentExamResults = new HashMap<>();

            allAssignmentExamResults = gson.fromJson(bufferedReader,
                    new TypeToken<Map<String, Map<String, Map<String, Map<String, Map<String, String>>>>>>() {
                    }.getType());

            if (allAssignmentExamResults == null)
                allAssignmentExamResults = new HashMap<>();

            if (allAssignmentExamResults.containsKey(course.courseCode) == false) {
                allAssignmentExamResults.put(course.courseCode, new HashMap<>());
                allAssignmentExamResults.get(course.courseCode).put("Assignment", new HashMap<>());
                allAssignmentExamResults.get(course.courseCode).put("Exam", new HashMap<>());
            }

            writer = new FileWriter(filePath);
            System.out.println("yes");
            writer.write(gson.toJson(allAssignmentExamResults));
            writer.close();
            bufferedReader.close();
        }
    }
}