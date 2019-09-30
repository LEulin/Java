package medicineapp;

import java.util.ArrayList;

public class Orders {
    
    private int id;
    private String orderedName;
    private int userId;
    private double amount;
    private int quantity;
    ArrayList<Orders> orderList = new ArrayList<Orders>();
    
    public Orders(){}
    
    public Orders(int id, int userId, String orderedName, int quantity, double amount){
        this.id = id;
        this.userId = userId;
        this.orderedName = orderedName;
        this.quantity = quantity;
        this.amount = amount;
    }
    
    public Orders(Orders e){
        this(e.getId(), e.getUserId(), e.orderedName, e.quantity, e.getAmount());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOrderedName() {
        return orderedName;
    }

    public void setOrderedName(String orderedName) {
        this.orderedName = orderedName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ArrayList<Orders> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Orders> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return String.format("%10s %5s %20s %5s %20s %5s %15s %5s %10s", id , userId, orderedName, quantity,amount);
    }
    
    
    
    
    
}
