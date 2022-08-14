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
                        Adder.addNewNotice(new Notice("Student", "Course Registraton", "Make it before 29 August", "Admin", "1/1/2022"));
                //         new Notice("Example Notice 1", "14 March, 2022", "Example Notice 1\nDate : 2022/03/14 - 2022/06/30",
                //         "https://www.sust.edu/uploads/notice-board/attachment-1647250167.pdf"),
                // new Notice("Example Notice 2", "14 March, 2022", "Example Notice 2\nDate : 2022/03/14 - 2022/06/30",
                //         "https://www.sust.edu/uploads/notice-board/attachment-1647250167.pdf"),
                // new Notice("Example Notice 3", "14 March, 2022", "Example Notice 3\nDate : 2022/03/14 - 2022/06/30",
                //         "https://www.sust.edu/uploads/notice-board/attachment-1647250167.pdf"),
                // new Notice("Example Notice 4", "14 March, 2022", "Example Notice 4\nDate : 2022/03/14 - 2022/06/30",
                //         "https://www.sust.edu/uploads/notice-board/attachment-1647250167.pdf")
                        // Adder.addNewEvent(new Event("Student", "Job Fair", "25 June", "We have arranged a Job Fair for Students", "Central Auditorium", "9AM - 5PM", "Sust", "Admin", "13/8/2022",0 , 0));
                        // Adder.addNewEvent(new Event("Teacher", "Re-union for Physics Department", "27 August", "At last we are meeting after 10 years", "Central Auditorium", "9AM - 5PM", "Physics Department", "Admin", "13/8/2022",0 , 0));
                        // Adder.addCourse(new Course("CSE101", "CSE 1", "3", "Computer Science and Engineering", 3));
                        Adder.addCourse(new Course("CSE250", "Project 250", "1", "Computer Science and Engineering", "2-2", "Lab", "syllabus"));

                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

}
