package Server;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import Server.Datapoints.*;

public class Fetcher {

    static GsonBuilder builder = new GsonBuilder();
    static Gson gson = builder.create();
    static BufferedReader bufferedReader;
    
    public static void fetch() throws FileNotFoundException
    {
        fetchDept();
        fetchLinks();
        fetchEvents();
        fetchStudentDetails("2019332064");
        // fetchStudentDetails("2019331053");
    }
    
    private static void fetchDept() throws FileNotFoundException {
        bufferedReader = new BufferedReader(new FileReader("allDepartment.json"));
        Set<String> allDepartment = new HashSet<>();

        allDepartment = gson.fromJson(bufferedReader, new TypeToken<Set<String>>() {
        }.getType());

        Server.Departments = allDepartment.toArray(new String[0]);
    }

    private static void fetchLinks() throws FileNotFoundException {
        
        bufferedReader = new BufferedReader(new FileReader("links.json"));

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
    }
    
    private static void fetchEvents() throws FileNotFoundException {
        bufferedReader = new BufferedReader(new FileReader("events.json"));

        Map<String, Event> events = new HashMap<>();
        events = gson.fromJson(bufferedReader, new TypeToken<Map<String, Event>>() {
        }.getType());

        Server.EVENTS = events.values().toArray(new Event[0]);
    }

    private static void fetchStudentDetails(String registration) throws FileNotFoundException {
        bufferedReader = new BufferedReader(new FileReader("students.json"));

        Map<String, Student> students = new HashMap<>();
        students = gson.fromJson(bufferedReader, new TypeToken<Map<String, Student>>() {
        }.getType());

        Student student = students.get(registration);
        Server.Profile = student;

        String semester = findYear(student.semester) + " year " + FindSemester(student.semester) + " semester";

        String[] details = { student.name, "Student", student.department, semester };

        Server.DETAILS = details;

        Server.STUDENTS = fetchPeople(student).toArray(new Student[0]);

    }
    
    private static Vector<Student> fetchPeople(Student student) throws FileNotFoundException
    {
        bufferedReader = new BufferedReader(new FileReader("peoples.json"));
        
        Map<String, Map<String, Set<String>>> sortedStudents = new HashMap<>();

        sortedStudents = gson.fromJson(bufferedReader, new TypeToken<Map<String, Map<String, Set<String>>>>() {
        }.getType());

        Set<String> yourPeople = sortedStudents.get(student.department).get(student.session);

        yourPeople.remove(student.registration);

        return fetchPeoplesDetails(yourPeople);
    }

    private static Vector<Student> fetchPeoplesDetails(Set<String> yourPeople) throws FileNotFoundException
    {
        bufferedReader = new BufferedReader(new FileReader("students.json"));

        Map<String, Student> students = new HashMap<>();
        students = gson.fromJson(bufferedReader, new TypeToken<Map<String, Student>>() {
        }.getType());

        Vector<Student> yourPeopleDetails = new Vector<>();

        for(String registration : yourPeople)
            yourPeopleDetails.add(students.get(registration));
        
        return yourPeopleDetails;
    }
    
    private static String FindSemester(int semester) {
        return (semester % 2 == 1) ? "1st" : "2nd";
    }

    private static String findYear (int semester)
    {
        int year = (semester + 1) / 2;
        if (year == 1)
            return "1st";
        if (year == 2)
            return "2nd";
        if (year == 1)
            return "3rd";
        if (year == 1)
            return "4th";
        return null;
    }
    
}
