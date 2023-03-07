package sg.edu.nus.iss.app.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;


public class ServerApp {
    public static String port;
    public static String cookieFile;
    public static List<String> cookies = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        

        if (args.length > 0) {
            port = args[0];
            cookieFile = args[1];
        }

        // open a server socket
        ServerSocket server = new ServerSocket(Integer.parseInt(port));
        System.out.println("Server started at port:  " + port);

        try {
            Socket sock = server.accept();

            // prepare input data
       InputStream is = sock.getInputStream();
       DataInputStream dis = new DataInputStream(is);

            // prepare output data
       OutputStream os = sock.getOutputStream();
       DataOutputStream dos = new DataOutputStream(os);

       while (true) {
// read data stream assign to variable
    
String msgRc = "";
String randomCookie = "";

msgRc = dis.readUTF();
if (msgRc.contains("quit")) {
    break;
}

if (msgRc.equalsIgnoreCase("get-cookie")) {
    randomCookie = Cookie.getRandomCookie(cookieFile);
     dos.writeUTF(randomCookie);
     break;
 } else if (msgRc.equalsIgnoreCase("get-all")) {
     cookies = Cookie.showAllCookies(cookieFile);
     for (String c : cookies) {
         dos.writeUTF(c);
     }
     break;
 }else {
     dos.writeUTF("Invalid command");
 }
       }
       sock.close();
     is.close();
     dis.close();
     os.close();
     dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
            }
            
        }
    

       