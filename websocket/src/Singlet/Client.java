package Singlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client  {
    public void run() throws UnknownHostException, IOException {
        int port = 2020;
        InetAddress address = InetAddress.getByName("localhost");
        Socket socket = new Socket(address,port);
        PrintWriter toScoket = new PrintWriter(socket.getOutputStream());
        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        toScoket.println("hello from client");
        String line = fromSocket.readLine();
        System.out.println("response from the socket " + line);
        toScoket.close();
        fromSocket.close();
        socket.close();
    }
    public static void main(String[] args) {
        try{
            Client client = new Client();
            client.run();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
