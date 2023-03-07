package sg.edu.nus.iss.app.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ReadOnlyBufferException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class ClientApp 
{
    
    public static void main( String[] args ) throws IOException
    {

        // Use Console to receive input from keyboard
        Console cons = System.console();

        // connect to server port
        Socket sock = new Socket("localhost", 3000);


        // get input data from server
        InputStream is = sock.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(is);
        DataInputStream dis = new DataInputStream(bis);


        // get output data from server
        OutputStream os = sock.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);
        DataOutputStream dos = new DataOutputStream(bos);

        // variable to store input and socket return value
        String input = "";
        String msgRc = "";
       
       while (!input.equalsIgnoreCase("quit")) {
        input = cons.readLine("Send a command to server");
        dos.writeUTF(input);
        dos.flush();

        msgRc = dis.readUTF();
        System.out.println(msgRc);
       }

       dos.close();
       bos.close();
       os.close();
       dis.close();
       bis.close();
       is.close();
       sock.close();

}
}