package Server;

import java.io.*;
import java.net.*;

import Server.Datapoints.Courses;
import Server.Datapoints.Event;
import Server.Datapoints.Link;
import Server.Datapoints.Notice;
import Server.Datapoints.Notification;
import Server.Datapoints.Student;

public class Client {
    Socket clientSocket = null;  
    ObjectInputStream ois;
    ObjectOutputStream oos;
    PrintWriter out;
    BufferedReader in;

    public Client() throws IOException, ClassNotFoundException {
        String hostname = "localhost";
        int port = 6789;

        
        try {
            clientSocket = new Socket(hostname, port);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            ois = new ObjectInputStream(clientSocket.getInputStream());
            oos = new ObjectOutputStream(clientSocket.getOutputStream());
            
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + hostname);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " + hostname);
            System.err.println(e);
        }

        if (clientSocket == null) {
            System.err.println( "Something is wrong. One variable is null." );
            return;
        }
        out.println("2019331053");
        System.out.println("sent connection request - 2019331053");
        System.out.println("received response - " + in.readLine());

        out.println(1);
        Link[][] links = (Link[][]) ois.readObject();
        System.out.println("received links");

        out.println(2);
        String[] linkTitles = (String[]) ois.readObject();
        System.out.println("received link titles");

        out.println(3);
        Event[] events = (Event[]) ois.readObject();
        System.out.println("received events");

        out.println(4);
        Courses[] courses = (Courses[]) ois.readObject();
        System.out.println("received courses");

        out.println(5);
        Notification[] exam = (Notification[]) ois.readObject();
        System.out.println("received exam");

        out.println(6);
        Notification[] assignment = (Notification[]) ois.readObject();
        System.out.println("received assignment");

        out.println(7);
        Notification[] registration = (Notification[]) ois.readObject();
        System.out.println("received registration");

        out.println(8);
        Notification[] notification = (Notification[]) ois.readObject();
        System.out.println("received notification");

        out.println(9);
        Notice[] notices = (Notice[]) ois.readObject();
        System.out.println("received notices");

        out.println(10);
        Student[] students = (Student[]) ois.readObject();
        System.out.println("received students");

        out.println(11);
        String[] details = (String[]) ois.readObject();
        System.out.println("received details");



        Datapoints.getInstance().LINKS = links;
        Datapoints.getInstance().EVENTS = events;
        Datapoints.getInstance().LINK_TITLES = linkTitles;
        Datapoints.getInstance().COURSES = courses;
        Datapoints.getInstance().DETAILS = details;
        Datapoints.getInstance().EXAM = exam;
        Datapoints.getInstance().ASSIGNMENT = assignment;
        Datapoints.getInstance().REGISTRATION = registration;
        Datapoints.getInstance().NOTIFICATION = notification;
        Datapoints.getInstance().STUDENTS = students;
        Datapoints.getInstance().NOTICES = notices;
    }           
}

