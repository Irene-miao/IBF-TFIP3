package sg.edu.nus.iss.day27.model;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

public class Review extends EditedComment{
    
    private String username;
    private String name;
    private Integer gid;
    private List<EditedComment> e = new ArrayList<>();
    
   
public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }


    public Integer getGid() {
        return gid;
    }


    public void setGid(Integer gid) {
        this.gid = gid;
    }



    public List<EditedComment> getEditedComment() {
        return e;
    }



    public void setEditedComment(List<EditedComment> e) {
        this.e = e;
    }

    

    public void addEditedComment(EditedComment e) {
        this.e.add(e);
    }
    
    

@Override
    public String toString() {
        return "Review [username=" + username + ", name=" + name + ", gid=" + gid + ", e=" + e + "]";
    }


public Review create(Document d){
    Review r = new Review();
    r.setGid(d.getInteger("gid"));
    r.setComment(d.getString("c_text"));
    r.setRating(d.getInteger("rating"));
    r.setUsername(d.getString("user"));
    r.setPosted(LocalDateTime.now());
    r.setCid(d.getString("c_id"));
    return r;
}

// convert POJO to jsonObject
public JsonObject toJson(){
    return Json.createObjectBuilder()
    .add("gid", getGid())
    .add("c_text", getComment())
    .add("rating", getRating())
    .add("user", getUsername())
    .add("posted", getPosted().toString())
    .add("name", getName())
    .add("cid", getCid())
    .build();
}

public JsonObject toJsonEdited(){
    boolean isEditComments  = false;
        if(this.getEditedComment() != null){
            List<JsonObjectBuilder> editComments = this.getEditedComment()
                .stream()
                .map(t -> t.toJSON())
                .toList();
            if(editComments.size() > 0){
                isEditComments = true;
            }
        }
            
        return Json.createObjectBuilder()
                .add("gid", getGid())
                .add("c_text", getComment())
                .add("rating", getRating())
                .add("user", getUsername())
                .add("posted", getPosted().toString())
                .add("name", getName())
                .add("edited", isEditComments)
                .add("timestamp", LocalDateTime.now().toString())
                .build();
}

public JsonObject toJsonEditedWithList() {
    JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
    List<JsonObjectBuilder> editComments = this.getEditedComment()
        .stream()
        .map(t -> t.toJSON())
        .toList();
    System.out.println(editComments.size());
    for(JsonObjectBuilder x: editComments)
        arrBuilder.add(x);
    return Json.createObjectBuilder()
            .add("gid", getGid())
            .add("c_text", getComment())
            .add("rating", getRating())
            .add("user", getUsername())
            .add("posted", getPosted().toString())
            .add("name", getName())
            .add("edited", arrBuilder)
            .add("timestamp", LocalDateTime.now().toString())
            .build();
}
    
}
