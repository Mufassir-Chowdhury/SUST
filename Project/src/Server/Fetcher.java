package Server;

import java.io.BufferedReader;
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

    public static void fetch(String Type) throws IOException {
        fetchDept();
        fetchLinks();
        fetchEvents(Type);
        fetchStudentDetails("2019331019");
        // fetchStudentDetails("2019331053");
    }

    private static void fetchDept() throws IOException {
        filePath = Adder.extractFilePath("allDepartment.json");
        bufferedReader = new BufferedReader(new FileReader(filePath));
        Set<String> allDepartment = new HashSet<>();

        allDepartment = gson.fromJson(bufferedReader, new TypeToken<Set<String>>() {
        }.getType());

        Server.Departments = allDepartment.toArray(new String[0]);
        bufferedReader.close();
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

    private static void fetchEvents(String command) throws IOException {
        filePath = Adder.extractFilePath("events.json");
        bufferedReader = new BufferedReader(new FileReader(filePath));

        Map<String, Map<String, Event>> events = new HashMap<>();
        events = gson.fromJson(bufferedReader, new TypeToken<Map<String, Map<String, Event>>>() {
        }.getType());

        
        if(command == "Student") Server.EVENTS = events.get(command).values().toArray(new Event[0]);
        if(command == "Teacher") Server.EVENTS = events.get(command).values().toArray(new Event[0]);
        if (command == "Admin")
        {
            Map<String, Event> toPass = new HashMap<>();
            toPass.putAll(events.get("Student"));
            for (Event event : events.get("Teacher").values())
                if(event.For.equals("Teacher"))
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
        bufferedReader.close();

    }

    private static Vector<Student> fetchPeople(Student student) throws IOException {
        filePath = Adder.extractFilePath("allStudentsSortedByDepartment.json");
        bufferedReader = new BufferedReader(new FileReader(filePath));

        Map<String, Map<String, Set<String>>> sortedStudents = new HashMap<>();

        sortedStudents = gson.fromJson(bufferedReader, new TypeToken<Map<String, Map<String, Set<String>>>>() {
        }.getType());

        Set<String> yourPeople = sortedStudents.get(student.department).get(student.session);

        yourPeople.remove(student.registration);
        bufferedReader.close();

        return fetchPeoplesDetails(yourPeople);
    }

    private static Vector<Student> fetchPeoplesDetails(Set<String> yourPeople) throws IOException {
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
