package myapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;





public class Main {


    public static void main(String[] args) throws IOException {
        
        Map<String, AppStats> stats = new HashMap<>();
        AppStats st; 
        int discard = 0;

        /*Path p = Paths.get("src/googleplaystore.csv");
        File f = p.toFile();

        Map<String, InputStream> wordFreq = new HashMap<>();
        InputStream is = new FileInputStream(f);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
        int num = 0; 
        while ((line = br.readLine()) != null) {
            System.out.printf("%s\n", line.toUpperCase());
            String[] words = line.split(" ");
            num += words.length;

            for (String w : words) {
                int max = Integer.MAX_VALUE;
                int min = Integer.MIN_VALUE;
                if (w.equals(min)) {
                    wordFreq.put("Min", w);
                } else if (w.equals(max)) {
wordFreq.put("Max", w);
                }
                }
            }
        
        System.out.printf("Number: %d\n", num);

        Set<String> words = wordFreq.keySet();
        for (String w : words) {
            int min = wordFreq.get(min);
            System.out.printf("%d\n", w, min);
        }
        System.out.printf("%d\n", num);
        System.out.printf("%d\n", words.size());
System.out.printf("%d\n", words.size()/(float)num);
*/
    Path p = Paths.get(args[0]);
    File f = p.toFile();

    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);
    
    // Discard the header line
    br.readLine();

    String line;

    while ((line = br.readLine()) != null) {
        String[] cols = line.split(",");
        String appName = cols[0];
        String category =cols[1];
        String col3 = cols[2]; 
        float rating = 0f;

        try {
            if (col3.toLowerCase().equals("nan")) {
                discard++;
                continue;
            }
            rating = Float.parseFloat(col3);
        } catch (NumberFormatException e) {
            // Stop processing this line, read next line
            discard++;
            continue;
        }
         if (stats.containsKey(category)) {
            st = stats.get(category);
         } else {
            st = new AppStats(category);
            stats.put(category, st);
           
    }
    st.evaluate(appName, rating);
}

for (String cat : stats.keySet()) {
     st = stats.get(cat);
    System.out.printf("Category: %s\n", cat);
    System.out.printf("Average: %f\n", 
    st.getTotalRating() / st.getCount());
    System.out.printf("Highest rating: %s %f\n", 
    st.getHighestApp(), st.getHighestAppRating());
    System.out.printf("Lowest Ratings: %s %f\n", 
    st.getLowestApp(), st.getLowestAppRating());
}
System.out.printf("Discarded sample: %d\n", discard);

br.close();
}

   
}