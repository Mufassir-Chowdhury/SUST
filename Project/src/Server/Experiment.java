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

            Adder.addCourse(new Course("CSE101", "CSE 1", "3", "Computer Science and Engineering",3));
            Adder.addCourse(new Course("CSE102", "CSE 2", "3", "Computer Science and Engineering",3));
            Adder.addCourse(new Course("CSE103", "CSE 3", "3", "Computer Science and Engineering",3));
            Adder.addCourse(new Course("PHY102", "PHY 2", "3", "Physics",3));
            Adder.addCourse(new Course("PHY103", "PHY 3", "3", "Physics",3));
            Adder.addCourse(new Course("SOC102", "SOC 2", "3", "Sociology",3));
            Adder.addCourse(new Course("SOC101", "SOC 1", "3", "Sociology",3));
            Adder.addCourse(new Course("SOC103", "SOC 3", "3", "Sociology",3));
            Adder.addCourse(new Course("EEE102", "EEE 2", "3", "Electrical and Electronics Engineering",3));
            Adder.addCourse(new Course("EEE105", "EEE 5", "3", "Electrical and Electronics Engineering",3));
            // addNewStudent();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void addNewStudent() throws IOException
    {
        Adder.addNewStudent(new Student("2019331053", "M. M. Kabid Hasan", "kabidhasan34@gmail.com", "1521575632",
                    "A+", "27 October", "Rajbari", "2019-20", 3, regular, drop));
        Adder.addNewStudent(new Student("2019331054", "Syed Sazid Hossain Rezvi", "fazle.rabbi.mahin.539@gmail.com",
                "1884374959", "O+", "12 November", "Dhamrai, Dhaka", "2019-20", 3, regular, drop));
        Adder.addNewStudent(new Student("2019331055", "Niloy Roy", "niloyroy1715@gmail.com", "1705814064", "O+",
                "14 May, 2000", "Rangpur", "2019-20", 3, regular, drop));
        Adder.addNewStudent(new Student("2019331057", "Ihsan Mirani Rumi", "ihsanmirani9865@gmail.com",
                "1864024910", "AB+", "5 June", "Dhaka", "2019-20", 3, regular, drop));
        Adder.addNewStudent(new Student("2019132058", "Md. Shihab Raihan", "soebshihab@gmail.com", "1798942838",
                "O+", "23,September", "Bogra", "2019-20", 3, regular, drop));
        Adder.addNewStudent(new Student("2019132059", "Mehedi Hasan", "imehedi357@gmail.com", "1706007087", "A+",
                "2 July", "Sirajganj", "2019-20", 3, regular, drop));
        Adder.addNewStudent(new Student("2019232060", "Muktadir Ahmed Palash", "palashmuktadir84@gmail.com",
                "1742655094", "A+", "10 February", "Bogra", "2016-17", 3, regular, drop));
        Adder.addNewStudent(new Student("2019232062", "Ariful Islam Farhad", "arifulfarhad300@gmail.com",
                "1856870527", "B+", "25 October", "Kishoreganj", "2017-18", 3, regular, drop));
        Adder.addNewStudent(new Student("2019232063", "Rubayet Sadman Sami", "rssami.bd@gmail.com", "1754966414",
                "B+", "23 March", "Sylhet", "2019-20", 3, regular, drop));
        Adder.addNewStudent(
                new Student("2019332064", "Md. Muhtasim Ahmed Bhuiyan", "muhtasim.ahmed.nhuiyan@gmail.com",
                        "1715036340", "O+", "28 March", "Dhaka", "2019-20", 3, regular, drop));
        Adder.addNewStudent(new Student("2019332065", "MD. Naimul Haque", "nhnahin65@gmail.com", "1622403404", "A-",
                "16 September", "Chittagong", "2019-20", 3, regular, drop));
        Adder.addNewStudent(new Student("2019338067", "Mubashshira Tasneem", "mubashshiratasneem140918@gmail.com",
                "1761429552", "O+", "28 December,2000", "Tangail", "2019-20", 3, regular, drop));
        Adder.addNewStudent(new Student("2019331068", "Abdullah All Ferdouse", "siababdullah3946@gmail.com",
                "1575087097", "A+", "13 November", "Dhaka", "2019-19", 3, regular, drop));
        Adder.addNewStudent(new Student("2019331070", "Mostahid Hasan Fahim", "mostahidhasanFahim@gmail.com",
                "1759300449", "O+", "8 November", "Gaibandha", "2018-19", 3, regular, drop));
        Adder.addNewStudent(new Student("2019331071", "Md Mostakim Billah", "mostakimbillah512@gmail.com",
                "1814560020", "B+", "15 July", "Lalmonirhat", "2018-19", 3, regular, drop));
    }

    // private static void add(String s, Link l) {
    //     if (links.containsKey(s) == false) {
    //         links.put(s, new HashMap<>());
    //         links.get(s).put(l.title, l);
    //     }
    //     links.get(s).put(l.title, l);
    // }

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
