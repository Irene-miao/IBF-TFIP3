package sg.edu.nus.iss.app.server;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Cookie {
    
    

    public static String getRandomCookie(String filePathName) throws IOException {
        String randomCookie = "";
        List<String> cookies = new LinkedList<>();

try {
    FileReader fs = new FileReader(filePathName);
    BufferedReader br = new BufferedReader(fs);

    String line;
    while ((line = br.readLine()) != null) {
        cookies.add(line);
    }

    Random rand = new Random();
    int cookieIndex = rand.nextInt(cookies.size());
    System.out.println(cookieIndex);

    randomCookie = cookies.get(cookieIndex);
    System.out.println(randomCookie);
} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}
      
        return randomCookie;  
    }

    public static List<String> showAllCookies(String filePathName) throws FileNotFoundException, IOException {
        List<String> cookies = new LinkedList<>();
        
        try {
            FileReader fs = new FileReader(filePathName);
            BufferedReader br = new BufferedReader(fs);
    
            String line;
            while ((line = br.readLine()) != null) {
                cookies.add(line);
    
                br.close();
            }
    
            System.out.println(cookies);
            Collections.sort(cookies);
            System.out.println(cookies);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        
        return cookies;

    }
}
