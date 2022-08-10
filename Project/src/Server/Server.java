package Server;

import java.io.*;
import java.net.*;

import Server.Datapoints.Courses;
import Server.Datapoints.Event;
import Server.Datapoints.Link;
import Server.Datapoints.Notice;
import Server.Datapoints.Notification;
import Server.Datapoints.Student;

public class Server {

    public static String[] LINK_TITLES;
    
    public static Link[][] LINKS;

    public static Event[] EVENTS;
    
    public static Courses[] COURSES = {
        new Courses("CSE101", "Data Structure", "3", "A", 4.00f, 20, 0, true, 0),
        new Courses("CSE102", "Algorithm", "3", "A", 4.00f, 15, 5, true, 0),
        new Courses("CSE103", "Computer Architecture", "3", "A", 4.00f, 16, 4, true, 0),
        new Courses("CSE104", "Operating System", "3", "A", 4.00f, 5, 15, true, 2),
        new Courses("CSE105", "Computer Network", "3", "A", 4.00f, 12, 8, false, 0),
        new Courses("CSE106", "Data Base", "3", "A", 4.00f, 10, 10, false, 2),
        new Courses("CSE107", "Software Engineering", "3", "A", 4.00f, 16, 4, true, 0),
    };
    public static String[] DETAILS = {
        "Mufassir Ahmad Chowdhury",
        "Student",
        "Computer Science and Engineering",
        "2nd year 1st semester"
    };
    
    public static Notification[] EXAM = {
        new Notification(Notification.Severity.CRITICAL, "STAT", "Today", false),
        new Notification(Notification.Severity.INFORMATIONAL, "Algo", "9th April", false),
    };
    public static Notification[] ASSIGNMENT = {
        new Notification(Notification.Severity.INFORMATIONAL, "Algo", "Tuesday", false),
    };
    public static Notification[] REGISTRATION = {
        new Notification(Notification.Severity.CRITICAL, "Fee Overdue", "Contact with register office today!", false),
        new Notification(Notification.Severity.SUCCESS, "Registration", "Registration successful!", false),
    };
    public static Notification[] NOTIFICATIONS = {
        new Notification(Notification.Severity.INFORMATIONAL, "Class Routine", "Class Routine is just updated", true),
        new Notification(Notification.Severity.WARNING, "Exam", "New Exam Posted", true),
        new Notification(Notification.Severity.INFORMATIONAL, "Resources", "Someone uploaded a resource", true),
        new Notification(Notification.Severity.CRITICAL, "Fee Overdue", "Contact with register office today!", true),
    };
    public static Student[] STUDENTS = {
        new Student("2019331053", "M. M. Kabid Hasan", "kabidhasan34@gmail.com", "1521575632", "A+", "27 October", "Rajbari"),
        new Student("2019331054", "Syed Sazid Hossain Rezvi", "fazle.rabbi.mahin.539@gmail.com", "1884374959", "O+", "12 November", "Dhamrai, Dhaka"),
        new Student("2019331055", "Niloy Roy", "niloyroy1715@gmail.com", "1705814064", "O+", "14 May, 2000", "Rangpur"),
        new Student("2019331057", "Ihsan Mirani Rumi", "ihsanmirani9865@gmail.com", "1864024910", "AB+", "5 June", "Dhaka"),
        new Student("2019331058", "Md. Shihab Raihan", "soebshihab@gmail.com", "1798942838", "O+", "23,September", "Bogra"),
        new Student("2019331059", "Mehedi Hasan", "imehedi357@gmail.com", "1706007087", "A+", "2 July", "Sirajganj"),
        new Student("2019331060", "Muktadir Ahmed Palash", "palashmuktadir84@gmail.com", "1742655094", "A+", "10 February", "Bogra"),
        new Student("2019331062", "Ariful Islam Farhad", "arifulfarhad300@gmail.com", "1856870527", "B+", "25 October", "Kishoreganj"),
        new Student("2019331063", "Rubayet Sadman Sami", "rssami.bd@gmail.com", "1754966414", "B+", "23 March", "Sylhet"),
        new Student("2019331064", "Md. Muhtasim Ahmed Bhuiyan", "muhtasim.ahmed.nhuiyan@gmail.com", "1715036340", "O+", "28 March", "Dhaka"),
        new Student("2019331065", "MD. Naimul Haque", "nhnahin65@gmail.com", "1622403404", "A-", "16 September", "Chittagong"),
        new Student("2019331067", "Mubashshira Tasneem", "mubashshiratasneem140918@gmail.com", "1761429552", "O+", "28 December,2000", "Tangail"),
        new Student("2019331068", "Abdullah All Ferdouse", "siababdullah3946@gmail.com", "1575087097", "A+", "13 November", "Dhaka"),
        new Student("2019331070", "Mostahid Hasan Fahim", "mostahidhasanFahim@gmail.com", "1759300449", "O+", "8 November", "Gaibandha"),
        new Student("2019331071", "Md Mostakim Billah", "mostakimbillah512@gmail.com", "1814560020", "B+", "15 July", "Lalmonirhat"),
    };
    public static Notice[] NOTICES = {
        new Notice("Example Notice 1", "14 March, 2022", "Example Notice 1\nDate : 2022/03/14 - 2022/06/30", "https://www.sust.edu/uploads/notice-board/attachment-1647250167.pdf"),
        new Notice("Example Notice 2", "14 March, 2022", "Example Notice 2\nDate : 2022/03/14 - 2022/06/30", "https://www.sust.edu/uploads/notice-board/attachment-1647250167.pdf"),
        new Notice("Example Notice 3", "14 March, 2022", "Example Notice 3\nDate : 2022/03/14 - 2022/06/30", "https://www.sust.edu/uploads/notice-board/attachment-1647250167.pdf"),
        new Notice("Example Notice 4", "14 March, 2022", "Example Notice 4\nDate : 2022/03/14 - 2022/06/30", "https://www.sust.edu/uploads/notice-board/attachment-1647250167.pdf")
    };
    public static void main(String args[]) {
        int port = 6789;
        Server server = new Server( port );
        server.startServer();
    }

    ServerSocket echoServer = null;
    Socket clientSocket = null;
    int port;

    public Server( int port ) {
        this.port = port;
    }

    public void stopServer() {
        System.out.println( "Server cleaning up." );
        System.exit(0);
    }

    public void startServer() {

        try {
            echoServer = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println(e);
        }

        System.out.println("Waiting for connections. Only one connection is allowed.");

        while (true) {
            try {
                clientSocket = echoServer.accept();
                ServerConnection oneConnection = new ServerConnection(clientSocket, this);
                oneConnection.run();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}

class ServerConnection {
    ObjectOutputStream oos;
    Socket clientSocket;
    Server server;

    public ServerConnection(Socket clientSocket, Server server) {
        this.clientSocket = clientSocket;
        this.server = server;
        System.out.println( "Connection established with: " + clientSocket );
        try {
            oos = new ObjectOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void run() throws FileNotFoundException {
        Fetcher.fetch();
        try {
            oos.writeObject(Server.LINKS);
            oos.writeObject(Server.LINK_TITLES);
            oos.writeObject(Server.EVENTS);
            oos.writeObject(Server.COURSES);
            oos.writeObject(Server.DETAILS);
            oos.writeObject(Server.EXAM);
            oos.writeObject(Server.ASSIGNMENT);
            oos.writeObject(Server.REGISTRATION);
            oos.writeObject(Server.NOTIFICATIONS);
            oos.writeObject(Server.STUDENTS);
            oos.writeObject(Server.NOTICES);

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    protected void finalize() {
        try {
            System.out.println("Connection closed.");
            oos.close();
            clientSocket.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    
}