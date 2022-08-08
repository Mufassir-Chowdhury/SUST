package Server;

import java.awt.*;
import java.io.BufferedReader; 
import java.io.FileNotFoundException; 
import java.io.FileReader; 
import java.io.FileWriter; 
import java.io.IOException;

import com.google.gson.*; 

public class Experiment {
    public static void main(String args[]) {

        Experiment tester = new Experiment();
        try {
            Name name = new Name("asanul", "haque");
            ParentsName parentsName = new ParentsName("mojammel haque", "ayasha siddika");
            Date birthday = new Date(2000, 12, 03);
            String[] courses = new String[] { "cse137", "cse223" };
            String image = "image";
            Student student = new Student("2019331013", "2019-20", name, parentsName, "Rajshahi", birthday, "A+", "2 1", "Computer Science and Engineering", courses, image);
            tester.writeJSON(student);
            Student student1 = tester.readJSON();
            System.out.println(student1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                new FileReader("student.json"));

        Student student = gson.fromJson(bufferedReader, Student.class);
        return student;
    }
}

class Name {
    private String firstName, LastName;

    Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.LastName = lastName;
    }
}

class ParentsName {
    private String fatherName, motherName;

    ParentsName(String fatherName, String motherName) {
        this.fatherName = fatherName;
        this.motherName = motherName;
    }
}

class Date {
    private int year, month, day;

    Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
}

class Student {
    private String registrationNo, session;
    private Name name;
    private ParentsName parentsName;
    private String Hometown;
    private Date birthday;
    private String bloodGroup;
    private String currentSemester;
    private String departmentName;
    private String[] courses;
    private String image;

    Student(String registrationNo, String session, Name name,
    ParentsName parentsName, String Hometown, Date birthday,
    String bloodGroup, String currentSemester, String departmentName,
    String[] courses, String image)
    {
        this.registrationNo = registrationNo;
        this.session = session;
        this.parentsName = parentsName;
        this.Hometown = Hometown;
        this.birthday = birthday;
        this.bloodGroup = bloodGroup;
        this.currentSemester = currentSemester;
        this.departmentName = departmentName;
        this.courses = courses;
        this.image = image;
    }
}