package Server;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.google.gson.*;
import Server.Datapoints.Link;
import Server.Datapoints.Student;

public class Experiment {
    static Map<String, Vector<Link>> links = new HashMap<>();

    public static void main(String args[]) {

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        try {

            // BufferedReader bufferedReader = new BufferedReader(
            //         new FileReader("links.json"));

            System.err.println(links.size());

            add("OFFICIAL_LINKS", new Link("SUST", "https://www.sust.edu/"));
            add("OFFICIAL_LINKS", new Link("E-Payment", "https://epayment.sust.edu/"));
            add("OFFICIAL_LINKS", new Link("Services", "https://services.student.sust.edu/"));
            add("OFFICIAL_LINKS", new Link("Library", "http://library.sust.edu/"));
            add("OFFICIAL_LINKS", new Link("Course Registration", "http://services.student.sust.edu:9090/student_login.jsp"));

            add("ORGANIZATION_LINKS",new Link("IQAC-SUST", "https://iqacsust.org/"));
            add("ORGANIZATION_LINKS",new Link("ACM SUST", "https://sustsc.acm.org/"));

            add("ORGANIZATION_LINKS",new Link("SUSTian View", "https://www.facebook.com/groups/1576654242498653/"));
            add("FACEBOOK_LINKS",new Link("Amra SUSTian", "https://www.facebook.com/groups/AMRASUSTIAN"));


            System.err.println(links.size());

            FileWriter writer = new FileWriter("links.json");
            writer.write(gson.toJson(links));
            writer.close();
            // tester.writeJSON();
            // Student student1 = tester.readJSON();
            // System.out.println(student1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void add(String s, Link l) {
        if (links.containsKey(s) == false) {
            links.put(s, new Vector<>());
            links.get(s).add(l);
        }
        links.get(s).add(l);
    }

    private void writeJSON(Student student) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        FileWriter writer = new FileWriter("student.json");
        writer.write(gson.toJson(student));
        writer.close();
    }

    private Student readJSON() throws FileNotFoundException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("links.json"));

        Student student = gson.fromJson(bufferedReader, Student.class);
        return student;
    }
}
