package sg.edu.nus.iss.app;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IdiomService implements Runnable{
    

    final Socket socket;

    private String fullFileName;

    private List<String> idioms;
    private String oneRandomIdiom;


    public IdiomService(Socket s, String fullPathFileName) {
this.socket = s;
this.fullFileName = fullPathFileName;
    };



    // read file method
    public List<String> readFile(String fullPathFileName) throws IOException {

        // open a file for reading line by line
        File file = new File(fullPathFileName);
        BufferedReader br = new BufferedReader(new FileReader(file));

        // create empty list
        List<String> idiomList = new ArrayList<String>();

        // read each line in file
        String line = "";

        // store each line in list
        while ((line = br.readLine()) != null) {
            idiomList.add(line);
        }

        br.close();

        return idiomList; // return list value

    }


    // Pick random idiom method
    public String randomIdiom(List<String> idioms) {

        Random rand = new Random();

    String idiom = "";

    // args not empty, get random idioms index no , get idiom
    if (idioms != null || idioms.size() > 0) {
        Integer idiomIndex = rand.nextInt(idioms.size());
        idiom = idioms.get(idiomIndex);
    } else {
        idiom = "No idiom found!";
    }

    return idiom;
    }


    
    // show all idioms method
    public void showAllIdioms(List<String> idioms) {

        idioms.forEach(System.out::println);
    }
    

@Override
public void run() {
    try {
        InputStream is = socket.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(is);
        DataInputStream dis = new DataInputStream(bis);  // turn into clear text

        OutputStream os = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);
        DataOutputStream dos = new DataOutputStream(bos);

        this.readFile(fullFileName);

        String msgRec = "";
        while(!msgRec.equalsIgnoreCase("quit")) {
            msgRec = dis.readUTF();


            if (msgRec.equalsIgnoreCase("get-cookie")){
                oneRandomIdiom = this.randomIdiom(idioms);
            }
    
            dos.writeUTF(oneRandomIdiom);
            dos.flush();
        }

        dos.close();
        bos.close();
        os.close();
        dis.close();
        bis.close();
        is.close();   
        

    } catch (Exception e) {
        e.printStackTrace();
    }
}


}
