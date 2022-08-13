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
    
    public static <K, V> Map<K, V> getFromJson(String file) throws IOException{
        filePath = extractFilePath(file);
        bufferedReader = new BufferedReader(
            new FileReader(filePath)
        );
        Map<K, V> object = new HashMap<>();
        object = gson.fromJson(bufferedReader, new TypeToken<Map<K, V>>(){}.getType());
        if(object == null){
            object = new HashMap<>();
        }
        bufferedReader.close();
        return object;
    }
    public static <T> void writeFile(String file, T object) throws IOException{
        filePath = extractFilePath(file);
        writer = new FileWriter(filePath);
        writer.write(gson.toJson(object));
        writer.close();
    }

    public static void addNewLink(String title, Link link) throws IOException {
        Map<String, Map<String, Link>> links = getFromJson(LINK);

        if (links.containsKey(title) == false) {
            links.put(title, new HashMap<>());
            links.get(title).put(link.title, link);
        }
        links.get(title).put(link.title, link);

        writeFile(LINK, links);
    }

    public static void addNewEvent(Event event) throws IOException {
        Map<String, Map<String, Event>> events = getFromJson(EVENT);
        
        if(event.For.equals("Both")==true){
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
        
        writeFile(EVENT, events);
    }

    public static void addNewStudent(Student student) throws IOException {

        {
            Map<String, Student> students = getFromJson(STUDENT_BY_REGISTRATION);

            if (students.containsKey(student.registration))
                return;

            students.put(student.registration, student);

            writeFile(STUDENT_BY_REGISTRATION, students);
        }

        updatePasswordDatabase("Student", student.email, student.registration);

        {
            Map<String, Map<String, Set<String>>> sortedStudents = getFromJson(STUDENT_BY_DEPARTMENT);

            String department = student.department;
            String session = student.session;

            if (sortedStudents.containsKey(department) == false)
                sortedStudents.put(department, new HashMap<>());

            if (sortedStudents.get(department).containsKey(session) == false)
                sortedStudents.get(department).put(session, new HashSet<>());

            sortedStudents.get(department).get(session).add(student.registration);

            writeFile(STUDENT_BY_DEPARTMENT, sortedStudents);
        }
    }

    public static void addNewTeacher(Teacher teacher) throws IOException {

        {
            Map<String, Teacher> teachers = getFromJson(TEACHER_BY_EMAIL);

            if (teachers.containsKey(teacher.email))
                return;

            teachers.put(teacher.email, teacher);

            writeFile(TEACHER_BY_EMAIL, teachers);
        }

        updatePasswordDatabase("Teacher", teacher.email, teacher.email);

        {
            Map<String, Set<String>> sortedTeachers = getFromJson(TEACHER_BY_DEPARTMENT);

            String department = teacher.department;

            if (sortedTeachers.containsKey(department) == false)
                sortedTeachers.put(department, new HashSet<>());

            sortedTeachers.get(department).add(teacher.email);

            writeFile(TEACHER_BY_DEPARTMENT, sortedTeachers);
        }
    }

    private static void updatePasswordDatabase(String Type, String email, String registration) throws IOException {
        System.err.println("calling");
        Map<String, Map<String, String>> passwords = getFromJson(PASSWORD);

        if (passwords.containsKey(Type) == false)
            passwords.put(Type, new HashMap<>());

        passwords.get(Type).put(email, registration);

        writeFile(PASSWORD, passwords);
    }

    public static void addCourse(Course course) throws IOException {
        {
            Map<String, Map<Integer, Set<String>>> allCourseList = getFromJson(COURSE_BY_DEPARTMENT);

            if (allCourseList.containsKey(course.department) == false)
                allCourseList.put(course.department, new HashMap<>());

            if (allCourseList.get(course.department).containsKey(course.semester) == false)
                allCourseList.get(course.department).put(course.semester, new HashSet<>());

            allCourseList.get(course.department).get(course.semester).add(course.courseCode);

            writeFile(COURSE_BY_DEPARTMENT, allCourseList);
        }

        {
            Map<String, Course> allCourseList = getFromJson(COURSE_BY_CODE);

            if (allCourseList.containsKey(course.department) == false)
                allCourseList.put(course.courseCode, course);

            writeFile(COURSE_BY_CODE, allCourseList);
        }

        {
            Map<String, Map<String, Map<String, Map<String, EvaluationItem>>>> allAssignmentExamDetails = getFromJson(ASSIGNMENT_EXAM_DETAILS);

            if (allAssignmentExamDetails.containsKey(course.courseCode) == false) {
                allAssignmentExamDetails.put(course.courseCode, new HashMap<>());
                allAssignmentExamDetails.get(course.courseCode).put("Assignment", new HashMap<>());
                allAssignmentExamDetails.get(course.courseCode).put("Exam", new HashMap<>());
            }

            writeFile(ASSIGNMENT_EXAM_DETAILS, allAssignmentExamDetails);
        }

        {
            Map<String, Map<String, Map<String, Map<String, Map<String, String>>>>> allAssignmentExamResults = getFromJson(ASSIGNMENT_EXAM_RESULTS);

            if (allAssignmentExamResults.containsKey(course.courseCode) == false) {
                allAssignmentExamResults.put(course.courseCode, new HashMap<>());
                allAssignmentExamResults.get(course.courseCode).put("Assignment", new HashMap<>());
                allAssignmentExamResults.get(course.courseCode).put("Exam", new HashMap<>());
            }

            writeFile(ASSIGNMENT_EXAM_RESULTS, allAssignmentExamResults);
        }
    }
}
