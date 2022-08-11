package Server;

import java.io.*;
import java.util.*;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import Server.Datapoints.Course;
import Server.Datapoints.Event;
import Server.Datapoints.Link;
import Server.Datapoints.Student;

public class Adder {
    static GsonBuilder builder = new GsonBuilder();
    static Gson gson = builder.create();
    static BufferedReader bufferedReader;
    static FileWriter writer;

    public static void addNewLink(String title, Link link) throws IOException
    {
        
        bufferedReader = new BufferedReader(
                new FileReader("links.json"));

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

        FileWriter writer = new FileWriter("links.json");
        writer.write(gson.toJson(links));
        writer.close();
    }
    
    public static void addNewEvent(Event event) throws IOException
    {
        bufferedReader = new BufferedReader(
                new FileReader("events.json"));

        Map<String, Event> events = new HashMap<>();
        events = gson.fromJson(bufferedReader, new TypeToken<Map<String, Event>>() {
        }.getType());

        if (events == null)
            events = new HashMap<>();

        events.put(event.title, event);

        writer = new FileWriter("events.json");
        writer.write(gson.toJson(events));
        writer.close();
    }

    public static void addNewStudent(Student student) throws IOException
    {
        {
            bufferedReader = new BufferedReader(
                    new FileReader("students.json"));

            Map<String, Student> students = new HashMap<>();
            students = gson.fromJson(bufferedReader, new TypeToken<Map<String, Student>>() {
            }.getType());

            if (students == null)
                students = new HashMap<>();

            if (students.containsKey(student.registration))
                return;

            students.put(student.registration, student);

            writer = new FileWriter("students.json");
            writer.write(gson.toJson(students));
            writer.close();
        }
        
        {
            bufferedReader = new BufferedReader(
                    new FileReader("password.json"));

            Map<String, String> passwords = new HashMap<>();
            passwords = gson.fromJson(bufferedReader, new TypeToken<Map<String, String>>() {
            }.getType());

            if (passwords == null)
                passwords = new HashMap<>();

            passwords.put(student.registration, student.registration);

            writer = new FileWriter("password.json");
            writer.write(gson.toJson(passwords));
            writer.close();
        }

        {
            bufferedReader = new BufferedReader(
                    new FileReader("peoples.json"));

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

            writer = new FileWriter("peoples.json");
            writer.write(gson.toJson(sortedStudents));
            writer.close();
        }
    } 

    public static void addCourse(Course course) throws IOException
    {
        {
            bufferedReader = new BufferedReader(
                    new FileReader("allCourseListDeptWise.json"));

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

            writer = new FileWriter("allCourseListDeptWise.json");
            writer.write(gson.toJson(allCourseList));
            writer.close();
        }
        
        {
            bufferedReader = new BufferedReader(
                    new FileReader("allCourseListCourseCodeWise.json"));

            Map<String, Course> allCourseList = new HashMap<>();

            allCourseList = gson.fromJson(bufferedReader, new TypeToken<Map<String, Course>>() {
            }.getType());

            if (allCourseList == null)
                allCourseList = new HashMap<>();

            if (allCourseList.containsKey(course.department) == false)
                allCourseList.put(course.courseCode, course);

            writer = new FileWriter("allCourseListCourseCodeWise.json");
            writer.write(gson.toJson(allCourseList));
            writer.close();

        }
    }
}
