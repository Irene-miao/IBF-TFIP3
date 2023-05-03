package sg.edu.nus.iss.day23.model;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class OrderDetails {
    private int id;
    private DateTime orderDate;
    private Integer customerId;
    private Double totalDiscountedPrice;
    private Double totalCostPrice;
    
    
    public OrderDetails() {
    }


    
    public OrderDetails(int id, DateTime orderDate, Integer customerId, Double totalDiscountedPrice,
            Double totalCostPrice) {
        this.id = id;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.totalDiscountedPrice = totalDiscountedPrice;
        this.totalCostPrice = totalCostPrice;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public DateTime getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(DateTime orderDate) {
        this.orderDate = orderDate;
    }
    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public Double getTotalDiscountedPrice() {
        return totalDiscountedPrice;
    }
    public void setTotalDiscountedPrice(Double totalDiscountedPrice) {
        this.totalDiscountedPrice = totalDiscountedPrice;
    }
    public Double getTotalCostPrice() {
        return totalCostPrice;
    }
    public void setTotalCostPrice(Double totalCostPrice) {
        this.totalCostPrice = totalCostPrice;
    }


    @Override
    public String toString() {
        return "OrderDetails [id=" + id + ", orderDate=" + orderDate + ", customerId=" + customerId
                + ", totalDiscountedPrice=" + totalDiscountedPrice + ", totalCostPrice=" + totalCostPrice + "]";
    }

    public static OrderDetails create(SqlRowSet resultSet){
        OrderDetails orderDetails = new OrderDetails();
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        DateTime orderDate = formatter.parseDateTime(resultSet.getString("order_date"));


        orderDetails.setId(resultSet.getInt("order_id"));
        orderDetails.setOrderDate(orderDate);
        orderDetails.setCustomerId(resultSet.getInt("customer_id"));
        orderDetails.setTotalDiscountedPrice(resultSet.getDouble("discounted_price"));
        orderDetails.setTotalCostPrice(resultSet.getDouble("cost_price"));
        return orderDetails;
    }

    public JsonObject toJson(){
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyy");
        String orderDate = getOrderDate().toString(formatter);

        return Json.createObjectBuilder()
        .add("order_id", getId())
        .add("order_date", orderDate)
        .add("customer_id", getCustomerId())
        .add("discounted_price", getTotalDiscountedPrice().toString())
        .add("cost_price", getTotalCostPrice())
        .build();

    }

}
