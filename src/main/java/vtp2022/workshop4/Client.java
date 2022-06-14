package vtp2022.workshop4;

import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) 
    {
        System.out.printf("Connect to server localhost on port 3000");
        // Creating Socket class object and initializing Socket
 
        // Try block to check if exception occurs (OutputStream os= socket.getOutputStream())
        try {
            Socket socket = new Socket("localhost", 3000);
            System.out.println("Connected to Client...");


            InputStream is = socket.getInputStream();
            DataInputStream dis= new DataInputStream(is);

            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            Console cons = System.console();
            String input = cons.readLine("Send command to server > ");

            dos.writeUTF(input);
            dos.flush();

            String response = dis.readUTF();
            if(response.contains("cookie-text")){
                System.out.println(response);
                String[] cookieValue = response.split(" ");
                System.out.printf("Cookie from server >> %s\n", cookieValue[1]);
            }else{
                System.out.println("Invalid Command!");
            }

            is.close();
            os.close();

            socket.close();
        } catch (UnknownHostException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
}
