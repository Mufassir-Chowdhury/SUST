package Server;

import java.io.*;
import java.net.*;

import Server.Datapoints.*;

public class Server {

    static String[] regular = { "CSE101", "CSE201" };
    static String[] drop = { "CSE301", "CSE401" };

    public static String[] Departments;

    public static String[] LINK_TITLES;

    public static Link[][] LINKS;

    public static Event[] EVENTS;

    public static Student Profile;

    public static String[] DETAILS;

    public static Student[] STUDENTS;

    public static Teacher[] TEACHERS;

    /*
     * public static Student[] STUDENTS = {
     * new Student("2019331053", "M. M. Kabid Hasan", "kabidhasan34@gmail.com",
     * "1521575632", "A+", "27 October", "Rajbari","2019-20",3,regular, drop),
     * new Student("2019331054", "Syed Sazid Hossain 3,Rezvi",
     * "fazle.rabbi.mahin.539@gmail.com", "1884374959", "O+", "12 November",
     * "Dhamrai, Dhaka","2019-20",3,regular,drop),
     * new Student("2019331055", "Niloy Roy", "niloyroy1715@gmail.com",
     * "1705814064", "O+", "14 May, 2000", "Rangpur","2019-20",3,regular,drop),
     * new Student("2019331057", "Ihsan Mirani Rumi", "ihsanmirani9865@gmail.com",
     * "1864024910", "AB+", "5 June", "Dhaka","2019-20",3,regular,drop),
     * new Student("2019331058", "Md. Shihab Raihan", "soebshihab@gmail.com",
     * "1798942838", "O+", "23,September", "Bogra","2019-20",3,regular,drop),
     * new Student("2019331059", "Mehedi Hasan", "imehedi357@gmail.com",
     * "1706007087", "A+", "2 July", "Sirajganj","2019-20",3,regular,drop),
     * new Student("2019331060", "Muktadir Ahmed Palash",
     * "palashmuktadir84@gmail.com", "1742655094", "A+", "10 February",
     * "Bogra","2019-20",3,regular,drop),
     * new Student("2019331062", "Ariful Islam Farhad", "arifulfarhad300@gmail.com",
     * "1856870527", "B+", "25 October", "Kisho3,reganj","2019-20",3,regular,drop),
     * new Student("2019331063", "Rubayet Sadman Sami", "rssami.bd@gmail.com",
     * "1754966414", "B+", "23 March", "Sylhet","2019-20",3,regular,drop),
     * new Student("2019331064", "Md. Muhtasim Ahmed Bhuiyan",
     * "muhtasim.ahmed.nhuiyan@gmail.com", "1715036340", "O+", "28 March",
     * "Dhaka","2019-20",3,regular,drop),
     * new Student("2019331065", "MD. Naimul Haque", "nhnahin65@gmail.com",
     * "1622403404", "A-", "16 September", "Chittagong","2019-20",3,regular,drop),
     * new Student("2019331067", "Mubashshira Tasneem",
     * "mubashshiratasneem140918@gmail.com", "1761429552", "O+", "28 December,2000",
     * "Tangail","2019-20",3,regular,drop),
     * new Student("2019331068", "Abdullah All Ferdouse",
     * "siababdullah3946@gmail.com", "1575087097", "A+", "13 November",
     * "Dhaka","2019-20",3,regular,drop),
     * new Student("2019331070", "Mostahid Hasan Fahim",
     * "mostahidhasanFahim@gmail.com", "1759300449", "O+", "8 November",
     * "Gaibandha","2019-20",3,regular,drop),
     * new Student("2019331071", "Md Mostakim Billah",
     * "mostakimbillah512@gmail.com", "1814560020", "B+", "15 July",
     * "Lalmonirhat","2019-20",3,regular,drop),
     * };
     */

    public static Courses[] COURSES = {
            new Courses(new Course("CSE101", "Data Structure", "3", "Computer Science and Engineering", 2),
                    new Attendance(20, 0, 0),
                    new Result(79,
                            new Assignment("Assignment", "Assignment 1 " + "Assignment", "20" + "th April",
                                    "This is assignment 1", 100, 80)),
                    true),
            new Courses(new Course("CSE102", "Data Structure 2", "3", "Computer Science and Engineering", 1),
                    new Attendance(20, 0, 0), new Result(79, new Assignment("Assignment",
                            "Assignment 1 " + "Assignment", "20" + "th April", "This is assignment 1", 100, 80)),
                    true),
            // new Courses("CSE101", "Data Structure", "3", "A", 4.00f, 20, 0, true, 0)1
            // new Courses("CSE102", "Algorithm", "3", "A", 4.00f, 15, 5, true, 0),
            // new Courses("CSE103", "Computer Architecture", "3", "A", 4.00f, 16, 4, true,
            // 0),
            // new Courses("CSE104", "Operating System", "3", "A", 4.00f, 5, 15, true, 2),
            // new Courses("CSE105", "Computer Network", "3", "A", 4.00f, 12, 8, false, 0),
            // new Courses("CSE106", "Data Base", "3", "A", 4.00f, 10, 10, false, 2),
            // new Courses("CSE107", "Software Engineering", "3", "A", 4.00f, 16, 4, true,
            // 0),
    };

    public static Notification[] EXAM = {
            new Notification(Notification.Severity.CRITICAL, "STAT", "Today", false),
            new Notification(Notification.Severity.INFORMATIONAL, "Algo", "9th April", false),
    };
    public static Notification[] ASSIGNMENT = {
            new Notification(Notification.Severity.INFORMATIONAL, "Algo", "Tuesday", false),
    };
    public static Notification[] REGISTRATION = {
            new Notification(Notification.Severity.CRITICAL, "Fee Overdue", "Contact with register office today!",
                    false),
            new Notification(Notification.Severity.SUCCESS, "Registration", "Registration successful!", false),
    };
    public static Notification[] NOTIFICATIONS = {
            new Notification(Notification.Severity.INFORMATIONAL, "Class Routine", "Class Routine is just updated",
                    true),
            new Notification(Notification.Severity.WARNING, "Exam", "New Exam Posted", true),
            new Notification(Notification.Severity.INFORMATIONAL, "Resources", "Someone uploaded a resource", true),
            new Notification(Notification.Severity.CRITICAL, "Fee Overdue", "Contact with register office today!",
                    true),
    };

    public static Notice[] NOTICES = {
            new Notice("Example Notice 1", "14 March, 2022", "Example Notice 1\nDate : 2022/03/14 - 2022/06/30",
                    "https://www.sust.edu/uploads/notice-board/attachment-1647250167.pdf"),
            new Notice("Example Notice 2", "14 March, 2022", "Example Notice 2\nDate : 2022/03/14 - 2022/06/30",
                    "https://www.sust.edu/uploads/notice-board/attachment-1647250167.pdf"),
            new Notice("Example Notice 3", "14 March, 2022", "Example Notice 3\nDate : 2022/03/14 - 2022/06/30",
                    "https://www.sust.edu/uploads/notice-board/attachment-1647250167.pdf"),
            new Notice("Example Notice 4", "14 March, 2022", "Example Notice 4\nDate : 2022/03/14 - 2022/06/30",
                    "https://www.sust.edu/uploads/notice-board/attachment-1647250167.pdf")
    };

    public static void main(String args[]) throws ClassNotFoundException {
        int port = 6789;
        Server server = new Server(port);
        server.startServer();
    }

    ServerSocket echoServer = null;
    Socket clientSocket = null;
    int port;

    public Server(int port) {
        this.port = port;
    }

    public void stopServer() {
        System.out.println("Server cleaning up.");
        System.exit(0);
    }

    public void startServer() throws ClassNotFoundException {

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
    ObjectInputStream ois;
    ObjectOutputStream oos;
    Socket clientSocket;
    Server server;
    PrintWriter out;
    BufferedReader in;

    public ServerConnection(Socket clientSocket, Server server) {
        this.clientSocket = clientSocket;
        this.server = server;
        System.out.println("Connection established with: " + clientSocket);
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            oos = new ObjectOutputStream(clientSocket.getOutputStream());
            ois = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void run() throws ClassNotFoundException, IOException {
        Fetcher.fetch();
        try {
            System.out.println("Received connection request from - " + in.readLine());
            out.println("Welcome to SUST Online Portal");

            /**
             * 1. REQUEST LINKS
             * 2. REQUEST LINK_TITLES
             * 3. REQUEST EVENTS
             * 4. REQUEST COURSES
             * 5. REQUEST EXAM
             * 6. REQUEST ASSIGNMENT
             * 7. REQUEST REGISTRATION
             * 8. REQUEST NOTIFICATIONS
             * 9. REQUEST NOTICES
             * 10. REQUEST STUDENTS
             * 11. REQUEST DETAILS
             * 12. ADD DEPARTMENT
             * 13. ADD STUDENT
             * 14. ADD TEACHER
             * 0. TERMINATE CONNECTION
             */
            while (true) {
                String input = in.readLine();
                if (input == null)
                    break;
                switch (input) {
                    case "1":
                        oos.writeObject(Server.LINKS);
                        break;
                    case "2":
                        oos.writeObject(Server.LINK_TITLES);
                        break;
                    case "3":
                        oos.writeObject(Server.EVENTS);
                        break;
                    case "4":
                        oos.writeObject(Server.COURSES);
                        break;
                    case "5":
                        oos.writeObject(Server.EXAM);
                        break;
                    case "6":
                        oos.writeObject(Server.ASSIGNMENT);
                        break;
                    case "7":
                        oos.writeObject(Server.REGISTRATION);
                        break;
                    case "8":
                        oos.writeObject(Server.NOTIFICATIONS);
                        break;
                    case "9":
                        oos.writeObject(Server.NOTICES);
                        break;
                    case "10":
                        // oos.writeObject(Server.TEACHERS);
                        oos.writeObject(Server.STUDENTS);
                        break;
                    case "11":
                        oos.writeObject(Server.DETAILS);
                        break;
                    case "12":
                        oos.writeObject(Server.Departments);
                        break;
                    case Datapoints.ADD_STUDENT:
                        Student student = (Student) ois.readObject();
                        Adder.addNewStudent(student);
                        System.err.println("done");
                        break;
                    case Datapoints.ADD_TEACHER:
                        Teacher teacher = (Teacher) ois.readObject();
                        Adder.addNewTeacher(teacher);
                        System.err.println("done");
                        break;
                    default:
                        System.out.println("Terminating connection");
                        finalize();
                        break;
                }
            }

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