package sg.edu.nus.iss.day30.model;

import java.util.List;

import org.bson.Document;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

public class AggregrationRSVP {
    private String _id;
    private List<String> name;
    private Integer count;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


    
    @Override
    public String toString() {
        return "AggregrationRSVP [_id=" + _id + ", name=" + name + ", count=" + count + "]";
    }

    public static AggregrationRSVP create(Document d){
        AggregrationRSVP a = new AggregrationRSVP();
        a.set_id(d.getString("_id"));
        a.setName(d.getList("name", String.class));
        a.setCount(d.getInteger("count"));
        return a;
    }

    public JsonObject toJSON(){

        JsonObjectBuilder builder = Json.createObjectBuilder();
        builder.add("_id", get_id());
        // TODO handle this list ...
        builder.add("name", getName().toString());
        builder.add("count", getCount());
        
        return builder.build();
    }


}
