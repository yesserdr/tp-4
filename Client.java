package tp4;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    static final int port = 1200;

    public static void main(String[] args) throws Exception {

        System.out.println("connection request");

        //Create a client socket
        Socket socket = new Socket("127.0.0.1", port);
        System.out.println("Connection established");

        // create in / out
        BufferedReader inClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outClient = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);


        Scanner scanner = new Scanner(System.in);
        String a=scanner.nextLine();
       // scanner = new Scanner(System.in);
        //String c=scanner.nextLine();
        outClient.println(a);
        String ch=inClient.readLine();
        //String s=inClient.readLine();
        if (ch==a) outClient.println("palindrome");
        else outClient.println("non palindrome");

        //outClient.println(c);
        //int s=Integer.parseInt(inClient.readLine());
         //System.out.println(s);

        //****** if you're using DataInputStream & DataOutputStream ******

        //DataInputStream inClient = new DataInputStream(socket.getInputStream());
        //DataOutputStream outClient = new DataOutputStream(socket.getOutputStream());

        //System.out.println("Enter your msg");
        //String str = new Scanner(System.in).nextLine();
        //outClient.writeUTF(str);
        //outClient.flush();

        //****** if you're using DataInputStream & DataOutputStream ******

        //close in / out
        inClient.close();
        outClient.close();


        // close client socket
        socket.close();
    }
}
