package tp4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;
import java.lang.String;


public class Server {

    static final int port = 1200;

    public static void main(String[] args) throws Exception {

        // Listen to a specific port

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Waiting for connection");
        Socket socClient = serverSocket.accept(); // Accept a client socket
        System.out.println("Connection established");

        // Initialize in / out
        BufferedReader inServer = new BufferedReader(new InputStreamReader(socClient.getInputStream()));
        PrintWriter outServer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socClient.getOutputStream())), true);

        // Write message to the client


        // ****** if you're using DataInputStream & DataOutputStream ******
        String s=inServer.readLine().toUpperCase(Locale.ROOT);
        //String c=inServer.readLine().toUpperCase(Locale.ROOT);
       // int a=s.indexOf(c);
        String ch="";
        for (int i=0; i<s.length(); i++)
        {
            ch=s.charAt(i)+ch;
        }

        outServer.println(ch);



         //DataInputStream  inServer = new DataInputStream(socClient.getInputStream());
        // DataOutputStream outServer = new DataOutputStream(socClient.getOutputStream());

        // Read message sent by the client
        // String s = inServer.readUTF();
         //String strUpper = str.toUpperCase();
         //System.out.println("The msg was " + strUpper);

        // ****** if you're using DataInputStream & DataOutputStream ******

        // Close in / out

        inServer.close();
        outServer.close();

        // Close client socket
        socClient.close();
        serverSocket.close();
    }
}
