package sg.edu.nus.iss.day19.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.StringReader;
import java.net.URLDecoder;
import java.security.SecureRandom;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;



public class Love implements Serializable{

    

    @NotNull(message = "Fill in the male name")
    @Size(min=3, message="Must be more than 3 characters")
    private String fsname;

    @NotNull(message = "Fill in the female name")
    @Size(min=3, message="Must be more than 3 characters")
    private String sname;

    private int percentage;

    private String id;

    private String result;


    public String getFsname() {
        return fsname;
    }
    public void setFsname(String fsname) {
        this.fsname = fsname;
    }
    public String getSname() {
        return sname;
    }
    public void setSname(String sname) {
        this.sname = sname;
    }
    public int getPercentage() {
        return percentage;
    }
    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }


    public Love() {
        this.id = generateId(8);
    }


    public Love(String fsname, String sname, String id) {
        this.fsname = fsname;
        this.sname = sname;
        this.id = generateId(8);
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    // convert POJO to json string
    /*public String create(Love love){
        JsonObject json = Json.createObjectBuilder()
        .add("fsname", love.getFsname())
        .add("sname", love.getSname())
        .add("percentage", love.getPercentage())
        .add("result", love.getResult())
        .build();
        String jsonLove = json.toString();
        return jsonLove;
    }*/


    // convert  json string to POJO
    public static Love create(String json) throws IOException {
        Love love = new Love();
       try (InputStream is = new ByteArrayInputStream(json.getBytes())){
        JsonReader r = Json.createReader(is);
        JsonObject o = r.readObject();
        // remove encoding chars from API
        String fsname = URLDecoder.decode(o.getString("fsname"), "UTF-8");
        String sname = URLDecoder.decode(o.getString("sname"), "UTF-8");

        love.setFsname(fsname);
        love.setSname(sname);
        love.setPercentage(Integer.parseInt(o.getString("percentage")));
        love.setResult(o.getString("result"));
       }
       return love;
    }


    private synchronized String generateId(int numOfChar){
        SecureRandom sr = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        while(sb.length() < numOfChar){
            sb.append(Integer.toHexString(sr.nextInt()));
        }
        return sb.toString().substring(0, numOfChar);
    }
    
    
 
    
}
