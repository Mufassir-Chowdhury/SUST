package Server;

import java.io.*;
import java.net.*;

import Server.Datapoints.Link;

public class Client {
    Socket clientSocket = null;  
    DataOutputStream os = null;
    BufferedReader is = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;

    public Link[][] getLinks() throws ClassNotFoundException, IOException{
        os.writeBytes( "1" + "\n" );
        Link[][] links = (Link[][]) ois.readObject();
 

        return links;
    }

    public Client() throws IOException, ClassNotFoundException {
        String hostname = "localhost";
        int port = 6789;


        try {
            clientSocket = new Socket(hostname, port);
            os = new DataOutputStream(clientSocket.getOutputStream());
            is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            oos = new ObjectOutputStream(clientSocket.getOutputStream());
            ois = new ObjectInputStream(clientSocket.getInputStream());
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + hostname);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " + hostname);
            System.err.println(e);
        }

        if (clientSocket == null || os == null || is == null) {
            System.err.println( "Something is wrong. One variable is null." );
            return;
        }

        // try {
        //     while ( true ) {
        //         System.out.print( "Enter an integer (0 to stop connection, -1 to stop server): " );
        //         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //         String keyboardInput = br.readLine();
        //         os.writeBytes( keyboardInput + "\n" );

        //         int n = Integer.parseInt( keyboardInput );
        //         if ( n == 0 || n == -1 ) {
        //             break;
        //         }
        //         if(n == 1){
        //             Link[][] links = (Link[][]) ois.readObject();
        //             for(Link[] link : links){
        //                 for(Link l : link){
        //                     System.out.println(l.title + " " + l.url);
        //                 }
        //             }
        //         } else{
        //             String responseLine = is.readLine();
        //             System.out.println("Server returns its square as: " + responseLine);

        //         }
        //     }

        // } catch (UnknownHostException e) {
            //     System.err.println("Trying to connect to unknown host: " + e);
            // } catch (IOException e) {
                //     System.err.println("IOException:  " + e);
                // }
            }           
}

