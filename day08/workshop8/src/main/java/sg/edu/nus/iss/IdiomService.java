package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IdiomService {
    public List<String> readFile(String fullPathFileName) throws IOException {

        // open a file for reading line by line 
        File file = new File(fullPathFileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        
        // store read idiom line from file
        List<String> idiomList = new ArrayList<String>();

        // for reading each line to the file
        String line = "";

        // If line exists, add to list
        while ((line = br.readLine()) != null) {
            idiomList.add(line);
        }

        // close reader
        br.close();

        return idiomList;

    }

    public String randomIdiom(List<String> idioms) {
        Random rand = new Random();
        
        String idiom = "";
        if (idioms != null || idioms.size() > 0) {
            Integer idiomIndex = rand.nextInt(idioms.size());
            idiom = idioms.get(idiomIndex);
        } else {
            idiom = " No idiom found!";
        }
        return idiom;
    }

    public void showAllIdioms(List<String> idioms) {
        // idioms forEach -> System.out.println(i);
        idioms.forEach(System.out::println);
    }
}
