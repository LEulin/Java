package medicineapp;

import java.util.ArrayList;

public class UserAndOrder {
    
    private double money;
    private int id;
    private int id2;
    private String name;
    private int qty;
    private double amount;
    ArrayList<UserAndOrder> uaoList = new ArrayList<UserAndOrder>();
    
    public UserAndOrder(){}
            
    public UserAndOrder(double money, Orders e){
        this(money, e.getId(),e.getUserId(),e.getOrderedName(),e.getQuantity(),e.getAmount());
    }
    
    public UserAndOrder(double money, int id, int id2, String name, int qty, double amount){
        this.money = money;
        this.id = id;
        this.id2 = id2;
        this.name = name;
        this.qty = qty;
        this.amount = amount;
    }

    public double getMoney() {
        return money;
    }

    public int getId() {
        return id;
    }

    public int getId2() {
        return id2;
    }

    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }

    public double getAmount() {
        return amount;
    }

    public ArrayList<UserAndOrder> getUaoList() {
        return uaoList;
    }

 
}
