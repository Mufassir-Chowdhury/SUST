package Server;

import java.io.*;
import java.net.*;

import Server.Datapoints.Link;

public class Server {
    
    public static String[] LINK_TITLES = {
        "OFFICIAL_LINKS",
        "ORGANIZATION_LINKS",
        "FACEBOOK_LINKS"
    };
    public static Link[][] LINKS = {
        {
            new Link("SUST", "https://www.sust.edu/"),
            new Link("E-Payment", "https://epayment.sust.edu/"),
            new Link("Services", "https://services.student.sust.edu/"),
            new Link("Library", "http://library.sust.edu/"),
            new Link("Course Registration", "http://services.student.sust.edu:9090/student_login.jsp"),
        },{
            new Link("IQAC-SUST", "https://iqacsust.org/"),
            new Link("ACM SUST", "https://sustsc.acm.org/"),
        },{
            new Link("SUSTian View", "https://www.facebook.com/groups/1576654242498653/"),
            new Link("Amra SUSTian", "https://www.facebook.com/groups/AMRASUSTIAN"),
        }
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
        }
        catch (IOException e) {
            System.out.println(e);
        }   

        System.out.println( "Waiting for connections. Only one connection is allowed." );

        while ( true ) {
            try {
                clientSocket = echoServer.accept();
                ServerConnection oneconnection = new ServerConnection(clientSocket, this);
                oneconnection.run();
            }   
            catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}

class ServerConnection {
    BufferedReader is;
    PrintStream os;

    ObjectOutputStream oos;
    ObjectInputStream ois;
    Socket clientSocket;
    Server server;

    public ServerConnection(Socket clientSocket, Server server) {
        this.clientSocket = clientSocket;
        this.server = server;
        System.out.println( "Connection established with: " + clientSocket );
        try {
            is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            os = new PrintStream(clientSocket.getOutputStream());
            oos = new ObjectOutputStream(clientSocket.getOutputStream());
            ois = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void run() {
        String line;
        try {
            boolean serverStop = false;

            while (true) {
                line = is.readLine();
                System.out.println( "Received " + line );
                int n = Integer.parseInt(line);
                if(n == 1){
                    oos.writeObject(Server.LINKS);
                }
                if ( n == -1 ) {
                    serverStop = true;
                    break;
                }
                if ( n == 0 ) break;
                    os.println("" + n*n ); 
            }

            System.out.println( "Connection closed." );
            is.close();
            os.close();
            clientSocket.close();

            if ( serverStop ) server.stopServer();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}