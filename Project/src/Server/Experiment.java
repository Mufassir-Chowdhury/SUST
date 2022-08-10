package Server;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.List;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import Server.Datapoints.Event;
import Server.Datapoints.Link;
import Server.Datapoints.Student;

public class Experiment {
    static Map<String, Map<String, Link>> links = new HashMap<>();
    static Map<String, Event> events = new HashMap<>();
    public static void main(String args[]) {

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        try {


            // Adder.addNewEvent(new Event("SUSTian Event 1", "1st April", "This is event 1", "SUST", "This is event 1", 0, 0));
            // Adder.addNewEvent(new Event("SUSTian Event 2", "2nd April", "This is event 2", "SUST", "This is event 2", 0, 0));
            // Adder.addNewEvent(new Event("SUSTian Event 3", "3rd April", "This is event 3", "SUST", "This is event 3", 0, 0));
            Adder.addNewEvent(new Event("SUSTian Event 4", "4th April", "This is event 4", "SUST", "This is event 4", 0, 0));
            
            // Adder.addNewLink("OFFICIAL_LINKS", new Link("Course Registration", "http://services.student.sust.edu:9090/student_login.jsp"));
            // FileWriter writer = new FileWriter("events.json");
            // writer.write(gson.toJson(links));
            // writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void add(String s, Link l) {
        if (links.containsKey(s) == false) {
            links.put(s, new HashMap<>());
            links.get(s).put(l.title, l);
        }
        links.get(s).put(l.title, l);
    }

    // private void writeJSON(Student student) throws IOException {
    //     GsonBuilder builder = new GsonBuilder();
    //     Gson gson = builder.create();
    //     FileWriter writer = new FileWriter("student.json");
    //     writer.write(gson.toJson(student));
    //     writer.close();
    // }

    // private Student readJSON() throws FileNotFoundException {
    //     GsonBuilder builder = new GsonBuilder();
    //     Gson gson = builder.create();
    //     BufferedReader bufferedReader = new BufferedReader(
    //             new FileReader("links.json"));

    //     Student student = gson.fromJson(bufferedReader, Student.class);
    //     return student;
    // }

    
}
