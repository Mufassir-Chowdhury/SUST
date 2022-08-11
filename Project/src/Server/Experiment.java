package Server;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

// import com.google.gson.*;

import Server.Datapoints.*;

public class Experiment {
        static Map<String, Map<String, Link>> links = new HashMap<>();
        static Map<String, Event> events = new HashMap<>();
        static String[] regular = { "CSE101", "CSE201" };
        static String[] drop = { "CSE301", "CSE401" };

        public static void main(String args[]) {

                // GsonBuilder builder = new GsonBuilder();
                // Gson gson = builder.create();

                try {

                        Adder.addCourse(new Course("CSE101", "CSE 1", "3", "Computer Science and Engineering", 3));
                        

                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

}
