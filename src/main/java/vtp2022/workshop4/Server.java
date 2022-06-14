package vtp2022.workshop4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException{

        // Instantiate the server socket class along with the port number
        ServerSocket server = new ServerSocket(3000);
        String cookieFilePath = args[0];
        // Waiting for connection from the client side
        Socket socket= server.accept();



        try {

            System.out.printf("Cookie Server Started at %s\n", server);
            
            // Invoking input stream via getInputStream()
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            String requestFromClient = dis.readUTF();
            System.out.printf("Received request from client : %s\n ", requestFromClient);
 
            if(requestFromClient.equals("get-cookie")){
                System.out.printf("file -> %s\n", cookieFilePath);
                String randomCookie = Cookie.getRandomCookie(cookieFilePath);
                System.out.println(randomCookie);
                dos.writeUTF("cookie-text "+randomCookie);
            }else{
                dos.writeUTF("Invalid command !");
            }
            
            is.close();
            os.close();
 
            // Lastly close the socket using standard close
            socket.close();
        } catch (Exception e) {
          System.out.println(e);
        }
        
        server.close();
    }
    
}
