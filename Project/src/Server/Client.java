package Server;

import java.io.*;
import java.net.*;

import Server.Datapoints.Courses;
import Server.Datapoints.Event;
import Server.Datapoints.Link;
import Server.Datapoints.Notification;
import Server.Datapoints.Student;

public class Client {
    Socket clientSocket = null;  
    ObjectInputStream ois = null;

    public Client() throws IOException, ClassNotFoundException {
        String hostname = "localhost";
        int port = 6789;


        try {
            clientSocket = new Socket(hostname, port);
            ois = new ObjectInputStream(clientSocket.getInputStream());
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
        Link[][] links = (Link[][]) ois.readObject();
        String[] linkTitles = (String[]) ois.readObject();
        Event[] events = (Event[]) ois.readObject();
        Courses[] courses = (Courses[]) ois.readObject();
        String[] details = (String[]) ois.readObject();
        Notification[] exam = (Notification[]) ois.readObject();
        Notification[] assignment = (Notification[]) ois.readObject();
        Notification[] registration = (Notification[]) ois.readObject();
        Notification[] notification = (Notification[]) ois.readObject();
        Student[] students = (Student[]) ois.readObject();
        Datapoints.LINKS = links;
        Datapoints.EVENTS = events;
        Datapoints.LINK_TITLES = linkTitles;
        Datapoints.COURSES = courses;
        Datapoints.DETAILS = details;
        Datapoints.EXAM = exam;
        Datapoints.ASSIGNMENT = assignment;
        Datapoints.REGISTRATION = registration;
        Datapoints.NOTIFICATION = notification;
        Datapoints.STUDENTS = students;
    }           
}

