package Server;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import Server.Datapoints.*;

public class Fetcher {

    static GsonBuilder builder = new GsonBuilder();
    static Gson gson = builder.create();
    static BufferedReader bufferedReader;
    static String filePath;

    public static String login(String[] data) throws FileNotFoundException
    {
        filePath = Adder.extractFilePath(Adder.PASSWORD);
        bufferedReader = new BufferedReader(
                new FileReader(filePath));

        Map<String, Map<String, String>> passwords = new HashMap<>();
        passwords = gson.fromJson(bufferedReader, new TypeToken<Map<String, Map<String, String>>>() {
        }.getType());

        if (passwords.get(data[0]).containsKey(data[1]))
            if (passwords.get(data[0]).get(data[1]).equals(data[2]))
                return "true";        
        
        return "false";
    }

    public static void fetch(String Type) throws IOException {
        fetchDeptAndTeacherAndCourses();
        fetchLinks();
        fetchEvents(Type);
        fetchStudentDetails("2019331019");
        fetchNotice(Type);
        // fetchStudentDetails("2019331053");
    }

    private static void fetchDeptAndTeacherAndCourses() throws IOException {
        {
            filePath = Adder.extractFilePath("allDepartment.json");
            bufferedReader = new BufferedReader(new FileReader(filePath));
            Set<String> allDepartment = new HashSet<>();

            allDepartment = gson.fromJson(bufferedReader, new TypeToken<Set<String>>() {
            }.getType());

            Server.Departments = allDepartment.toArray(new String[0]);
            bufferedReader.close();
        }

        {
            for (String dept : Server.Departments) {
                Vector<Teacher> teachers = fetchPeople(dept);
                Vector<String> oneDept = new Vector<>();
                for (Teacher teacher : teachers)
                    oneDept.add(teacher.name);
                Server.TeachersName.put(dept, oneDept.toArray(new String[0]));
            }
        }

        {
            filePath = Adder.extractFilePath(Adder.COURSE_BY_DEPARTMENT);
            bufferedReader = new BufferedReader(
                    new FileReader(filePath));

            Map<String, Map<Integer, Set<String>>> allCourseList = new HashMap<>();

            allCourseList = gson.fromJson(bufferedReader, new TypeToken<Map<String, Map<Integer, Set<String>>>>() {
            }.getType());

            for (String dept : Server.Departments) 
                if(allCourseList.containsKey(dept) == false)
                    allCourseList.put(dept, new HashMap<>());

            Server.CourseCode = allCourseList;
        }

    }

    private static void fetchLinks() throws IOException {

        filePath = Adder.extractFilePath("links.json");
        bufferedReader = new BufferedReader(new FileReader(filePath));

        Map<String, Map<String, Link>> links = new HashMap<>();
        links = gson.fromJson(bufferedReader, new TypeToken<Map<String, Map<String, Link>>>() {
        }.getType());

        Vector<String> titleTypeList = new Vector<>();
        Vector<Link[]> linkList = new Vector<>();

        links.forEach((titleType, link) -> {
            titleTypeList.add(titleType);
            linkList.add(link.values().toArray(new Link[0]));
        });

        Server.LINK_TITLES = titleTypeList.toArray(new String[titleTypeList.size()]);
        Server.LINKS = linkList.toArray(new Link[linkList.size()][]);
        bufferedReader.close();

    }

    private static void fetchNotice(String command) throws IOException {
        filePath = Adder.extractFilePath(Adder.NOTICE);
        bufferedReader = new BufferedReader(new FileReader(filePath));

        Map<String, Map<String, Notice>> notices = new HashMap<>();
        notices = gson.fromJson(bufferedReader, new TypeToken<Map<String, Map<String, Notice>>>() {
        }.getType());

        if (notices == null)
            notices = new HashMap<>();

        if (command == "Student")
            Server.NOTICES = notices.get(command).values().toArray(new Notice[0]);
        if (command == "Teacher")
            Server.NOTICES = notices.get(command).values().toArray(new Notice[0]);
        if (command == "Admin") {
            Map<String, Notice> toPass = new HashMap<>();
            toPass.putAll(notices.get("Student"));
            for (Notice notice : notices.get("Teacher").values())
                if (notice.For.equals("Teacher"))
                    toPass.put(notice.title, notice);

            Server.NOTICES = toPass.values().toArray(new Notice[0]);
        }

        bufferedReader.close();
    }

    private static void fetchEvents(String command) throws IOException {
        filePath = Adder.extractFilePath("events.json");
        bufferedReader = new BufferedReader(new FileReader(filePath));

        Map<String, Map<String, Event>> events = new HashMap<>();
        events = gson.fromJson(bufferedReader, new TypeToken<Map<String, Map<String, Event>>>() {
        }.getType());

        if (command == "Student")
            Server.EVENTS = events.get(command).values().toArray(new Event[0]);
        if (command == "Teacher")
            Server.EVENTS = events.get(command).values().toArray(new Event[0]);
        if (command == "Admin") {
            Map<String, Event> toPass = new HashMap<>();
            toPass.putAll(events.get("Student"));
            for (Event event : events.get("Teacher").values())
                if (event.For.equals("Teacher"))
                    toPass.put(event.title, event);

            Server.EVENTS = toPass.values().toArray(new Event[0]);
        }

        bufferedReader.close();
    }

    private static void fetchStudentDetails(String registration) throws IOException {
        filePath = Adder.extractFilePath("allStudentsSortedByRegistration.json");
        bufferedReader = new BufferedReader(new FileReader(filePath));

        Map<String, Student> students = new HashMap<>();
        students = gson.fromJson(bufferedReader, new TypeToken<Map<String, Student>>() {
        }.getType());

        Student student = students.get(registration);
        Server.Profile = student;

        String semester = findYear(student.semester) + " year " + FindSemester(student.semester) + " semester";
        System.err.println(semester);

        String[] details = { student.name, "Student", student.department, semester };

        Server.DETAILS = details;

        Server.STUDENTS = fetchPeople(student).toArray(new Student[0]);
        Server.TEACHERS = fetchPeople(student.department).toArray(new Teacher[0]);
        bufferedReader.close();

    }

    private static Vector<Student> fetchPeople(Student student) throws IOException {
        {
            filePath = Adder.extractFilePath("allStudentsSortedByDepartment.json");
            bufferedReader = new BufferedReader(new FileReader(filePath));

            Map<String, Map<String, Set<String>>> sortedStudents = new HashMap<>();

            sortedStudents = gson.fromJson(bufferedReader, new TypeToken<Map<String, Map<String, Set<String>>>>() {
            }.getType());

            Set<String> yourBatch = sortedStudents.get(student.department).get(student.session);

            yourBatch.remove(student.registration);
            bufferedReader.close();

            return fetchBatchDetails(yourBatch);
        }
    }

    private static Vector<Teacher> fetchPeople(String department) throws IOException {
        {
            filePath = Adder.extractFilePath("allTeachersSortedByDepartment.json");
            bufferedReader = new BufferedReader(new FileReader(filePath));

            Map<String, Set<String>> sortedTeachers = new HashMap<>();

            sortedTeachers = gson.fromJson(bufferedReader, new TypeToken<Map<String, Set<String>>>() {
            }.getType());

            Set<String> yourFaculty = sortedTeachers.get(department);

            if(yourFaculty == null) 
                yourFaculty = new HashSet<>();

            if (yourFaculty.isEmpty())
                return new Vector<Teacher>();
            // yourFaculty.remove();
            bufferedReader.close();

            return fetchFacultyDetails(yourFaculty);
        }
    }

    private static Vector<Student> fetchBatchDetails(Set<String> yourPeople) throws IOException {
        filePath = Adder.extractFilePath("allStudentsSortedByRegistration.json");
        bufferedReader = new BufferedReader(new FileReader(filePath));

        Map<String, Student> students = new HashMap<>();
        students = gson.fromJson(bufferedReader, new TypeToken<Map<String, Student>>() {
        }.getType());

        Vector<Student> yourPeopleDetails = new Vector<>();

        for (String registration : yourPeople)
            yourPeopleDetails.add(students.get(registration));

        bufferedReader.close();

        return yourPeopleDetails;

    }

    private static Vector<Teacher> fetchFacultyDetails(Set<String> yourFaculty) throws IOException {
        filePath = Adder.extractFilePath("allTeachersSortedByEmail.json");
        bufferedReader = new BufferedReader(new FileReader(filePath));

        Map<String, Teacher> teachers = new HashMap<>();
        teachers = gson.fromJson(bufferedReader, new TypeToken<Map<String, Teacher>>() {
        }.getType());

        Vector<Teacher> yourFacultyDetails = new Vector<>();

        for (String email : yourFaculty)
            yourFacultyDetails.add(teachers.get(email));

        bufferedReader.close();

        return yourFacultyDetails;
    }

    private static String FindSemester(Integer semester) {
        if (semester == null)
            return "";
        if (semester % 2 == 1)
            return "1st";

        return "2nd";
    }

    private static String findYear(Integer semester) {
        if (semester == null)
            return "";
        int year = (semester + 1) / 2;
        if (year == 1)
            return "1st";
        if (year == 2)
            return "2nd";
        if (year == 3)
            return "3rd";
        if (year == 4)
            return "4th";
        return "";
    }

}
