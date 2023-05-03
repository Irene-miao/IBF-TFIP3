package sg.edu.nus.iss.day27.model;


import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Games {
    private Integer limit;
    private Integer offset;
    private Integer total;
    private LocalDate timeStamp;
    private List<Game> gamesList = new ArrayList<Game>();
    
    public Integer getLimit() {
        return limit;
    }
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
    public Integer getOffset() {
        return offset;
    }
    public void setOffset(Integer offset) {
        this.offset = offset;
    }
    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }
    public LocalDate getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }
    public List<Game> getGamesList() {
        return gamesList;
    }
    public void setGamesList(List<Game> gamesList) {
        this.gamesList = gamesList;
    }
    
    public Games() {
    }
    public Games(Integer limit, Integer offset, Integer total, LocalDate timeStamp) {
        this.limit = limit;
        this.offset = offset;
        this.total = total;
        this.timeStamp = timeStamp;
      
    }

    @Override
    public String toString() {
        return "Games [limit=" + limit + ", offset=" + offset + ", total=" + total + ", timeStamp=" + timeStamp
                + ", gamesList=" + gamesList + "]";
    }

    public JsonObject toJson(){
        return Json.createObjectBuilder()
        .add("games", getGamesList().toString())
        .add("offset", getOffset())
        .add("limit", getLimit())
        .add("total", getTotal())
        .add("timestamp", getTimeStamp().toString())
        .build();
    }

}
