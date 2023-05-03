package sg.edu.nus.iss.day22.model;

import java.io.ByteArrayInputStream;


import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.joda.time.format.DateTimeFormat;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class RSVP {
    private int id;
    private String name;
    private String email;
    private String phone;
    private DateTime confirmationDate;
    private String comments;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public DateTime getConfirmationDate() {
        return confirmationDate;
    }
    public void setConfirmationDate(DateTime confirmationDate) {
        this.confirmationDate = confirmationDate;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    
    public RSVP() {
    }
    
    public RSVP(int id, String name, String email, String phone, DateTime confirmationDate, String comments) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.confirmationDate = confirmationDate;
        this.comments = comments;
    }
    
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone
                + ", confirmationDate=" + confirmationDate + ", comments=" + comments + "]";
    }
    
    // create POJO from mysql
    public static RSVP create(SqlRowSet rs){
        RSVP rsvp = new RSVP();

        rsvp.setId(rs.getInt("id"));
        rsvp.setName(rs.getString("name"));
        rsvp.setEmail(rs.getString("email"));
        rsvp.setPhone(rs.getString("phone"));
        rsvp.setConfirmationDate(new DateTime(DateTimeFormat.forPattern("dd/MM/yyyy").parseDateTime(rs.getString("confirmation_date"))));
        rsvp.setComments(rs.getString("comments"));

        return rsvp;
        
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
        .add("id", getId())
        .add("name", getName())
        .add("email", getEmail())
        .add("confirmation_date", getConfirmationDate().toString(DateTimeFormat.forPattern("dd-MM-yyyy")))
        .add("comments", getComments())
        .build();

    }
    
    private static RSVP create(JsonObject readObject){
        RSVP rsvp = new RSVP();

        rsvp.setName(readObject.getString("name"));
        rsvp.setEmail(readObject.getString("email"));
        rsvp.setPhone(readObject.getString("phone"));
        rsvp.setConfirmationDate(new DateTime(Instant.parse(readObject.getString("confirmation_date"))));
        rsvp.setComments(readObject.getString("comments"));

        return rsvp;
        
    }

    // create POJO from json string
    public static RSVP create(String json){
        JsonReader reader = Json.createReader(new ByteArrayInputStream(json.getBytes()));
        return create(reader.readObject());
    }
}
