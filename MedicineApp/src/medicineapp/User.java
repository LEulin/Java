package medicineapp;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
import medicineapp.Medicine;

public class User {

    Scanner input = new Scanner(System.in);
    private String userName;
    private String passWord;
    private int age;
    private double money;
    private int id;
    ArrayList<User> userList = new ArrayList<User>();

    public User() {
    }
    
    public User(User e){
        this(e.id,e.userName,e.passWord,e.age,e.money);
    
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public User(String userName, String passWord, int age, double money) {
        this.userName = userName;
        this.passWord = passWord;
        this.age = age;
        this.money = money;
    }

    public User(int id, String userName, String passWord, int age, double money) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.age = age;
        this.money = money;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }
    
    public User register(User e){
        int count = 0;
        System.out.print("Enter Username: ");
        String uName = input.nextLine();
        while(count!=userList.size()){
            if(userList.get(count).getUserName().equals(uName)==true){
                count = 0;
                System.out.println("Username already exist!");
                System.out.print("Enter Username again: ");
                uName = input.nextLine();
            }
            else{
                count++;
            }
        }
        
        
        System.out.print("Enter Password: ");
        String pWord = input.nextLine();
        System.out.print("Confirm Password: ");
        String conPassword = input.nextLine();
        while(conPassword.equals(pWord) == false){
            System.out.println("Password did not match!");
            System.out.print("Confirm Password again: ");
            conPassword = input.nextLine();
            if(conPassword.equals(pWord)== true){
                break;
            }
        }
        System.out.print("Enter age: ");
        String userAge = input.nextLine();
        while(Integer.valueOf(userAge)<18){
            System.out.println("Too young to register!");
            System.out.print("Input age again: ");
            userAge = input.nextLine();
            if(Integer.valueOf(userAge)>=18 == true){
                break;
            }
        }
        System.out.print("Deposit money to your account: ");
        String userMoney = input.nextLine();
        if(Integer.valueOf(userAge)>=60){
            e = new SeniorCitizen(userList.size()+1,uName,pWord,Integer.valueOf(userAge),Integer.valueOf(userMoney));
        }
        else{
            e = new Adult(userList.size()+1,uName,pWord,Integer.valueOf(userAge),Integer.valueOf(userMoney));
        }
        return e;
    }
    
    
    

    public User login(User e) {

        System.out.print("Input Username: ");
        String name = input.nextLine();
        int counts = 0;
        for (int i = 0; i < userList.size(); i++) {
            if (name.equals(userList.get(i).getUserName()) == false) {
                counts += 1;
                if (counts == userList.size()) {
                    error();
            }
            } else {
                int count = 0;
                System.out.println("Username matched!");
                while (count != 3) {
                    System.out.print("Input Password: ");
                    String pass = input.nextLine();
                    for (int j = 0; j < userList.size(); j++) {
                        if (pass.equals(userList.get(i).getPassWord()) == true) {
                            e = userList.get(i);
                            System.out.println("Logged in!");
                            System.out.println("Welcome " + userList.get(i).getUserName() + "!");
                            return e;
                        }
                    }
                    count += 1;
                }
                if (count == 3) {
                    error();
                }
            }
        }
        return e;
    }
    
//    public User updateMoney(User e, int num, Orders b,int count, Medicine med, double moneyy){
//        for(int i = 0; i<count+1; i++){
//            System.out.println(b.getOrderList().get(i).getId());
//            if(b.getOrderList().get(i).getId()==num){
//                moneyy = moneyy - b.getOrderList().get(i).getAmount();
//                e.setMoney(moneyy);
//                System.out.println(e.getMoney());
//                return e = new User(e.getId(),e.getUserName(),e.getPassWord(),e.getAge(),moneyy);
//            }
//        }
//        System.out.println("Money is: "+moneyy);
//        return e = new User(e.getId(),e.getUserName(),e.getPassWord(),e.getAge(),moneyy);
//    }

    public User changePass(User e) {
        System.out.print("Type current password: ");
        String oldPass = input.nextLine();
        if (oldPass.equals(e.getPassWord())) {
            System.out.print("Enter new password: ");
            String newPass = input.nextLine();
            System.out.print("Confirm new password: ");
            String conpass = input.nextLine();
            if (newPass.equals(conpass) == true) {
                e.setPassWord(newPass);
                System.out.println(e.getPassWord());
                System.out.println("Successfully changed password!");
                return e;
            } else {
                wrong();
            }

        } else {
            wrong();
        }
        return e;
    }

    public void error() {
        System.out.println("Error Logging in! Please try again later!");
        System.exit(0);

    }

    public void wrong() {
        System.out.println("Wrong Password!");
    }

    public void displayMedicines(Medicine med) {
        //Medicine med = new Medicine();
        System.out.printf("%10s %5s %30s %5s %20s %5s %20s %5s %15s %5s %10s", "ID", "|", "Generic Name", "|", "Brand Name", "|", "Type of Medicine", "|", "Price", "|", "Stock (Pieces)\n");
        System.out.printf("%s", "------------------------------------------------------------------------------------------------------------------------------------------------\n");
        for (int i = 0; i < med.getMedicineList().size(); i++) {
            System.out.printf("%10s %5s %30s %5s %20s %5s %20s %5s %15s %5s %10s \n", med.getMedicineList().get(i).getId(), "|", med.getMedicineList().get(i).getGenericName(), "|", med.getMedicineList().get(i).getBrandName(), "|", med.getMedicineList().get(i).getMedicineType(), "|", med.getMedicineList().get(i).getPrice(), "|", med.getMedicineList().get(i).getStock());
        }
//        System.out.printf("%30s %5s %20s %5s %20s %5s %15s %5s %10s", "Generic Name", "|", "Brand Name", "|","Type of Medicine","|", "Price","|", "Stock (Pieces)\n");
//        System.out.printf("%s", "-------------------------------------------------------------------------------------------------------------------------------\n");
//        for(int i=0; i<med.getMedicineList().size();i++){
//            System.out.printf("%30s %5s %20s %5s %20s %5s %15s %5s %10s", med.getMedicineList().get(i).getGenericName(), "|", med.getMedicineList().get(i).getBrandName(), "|",med.getMedicineList().get(i).getMedicineType(),"|", med.getMedicineList().get(i).getPrice(),"|", med.getMedicineList().get(i).getStock()+"\n");
//        }
    }

    public void displayOrders(Orders a, User e) {
        int count = 0;
        System.out.println("Your orders: ");
        System.out.printf("| %10s %5s %10s %5s %20s %5s %10s %5s %10s |\n", "Order Id", "|", "User Id", "|", "Ordered Item", "|", "Quantity", "|", "Amount");
        System.out.printf("%s \n", "--------------------------------------------------------------------------------------------");
        for (int i = 0; i < a.getOrderList().size(); i++) {
            if (e.getId() == a.getOrderList().get(i).getUserId()) {
                count += 1;
                System.out.printf("| %10s %5s %10s %5s %20s %5s %10s %5s %10s |\n", a.getOrderList().get(i).getId(), "|", a.getOrderList().get(i).getUserId(), "|", a.getOrderList().get(i).getOrderedName(), "|", a.getOrderList().get(i).getQuantity(), "|", a.getOrderList().get(i).getAmount());
            }
        }

        if (count == 0) {
            System.out.println("You have no any orders!");
        }
    }

    public Orders payOrder(Orders a, int inputs) {
        Orders b = new Orders();
        for (int j = 0; j < a.getOrderList().size(); j++) {
            if (a.getOrderList().get(j).getId() == inputs) {
                b = a.getOrderList().get(j);
            }
        }
        return b;
    }
    
    public User decMoney(Orders a, User b,int count){
        for(int i = 0;i<count;i++){
            for(int j = 0; j < b.getUserList().size();j++){
                if(a.getOrderList().get(i).getUserId() == b.getId()){
                    b.setMoney(b.getMoney() - a.getOrderList().get(i).getAmount());
                
                }
            }
        }
    
        return b;
    }

    public User deposit(User e) {
        System.out.print("Enter amount to deposit: ");
        double deposit = input.nextInt();
        e.setMoney(e.getMoney() + deposit);
        System.out.println("Your balance now is: " + e.getMoney());
        return e;
    }

//    public Orders orderItem(Orders e, User a, Medicine b){
//        int max = 10; 
//        int min = 1; 
//        int range = max - min + 1;
//        int num = (int)(Math.random() * range) + min;
//        System.out.println("Choose by entering item ID!");
//        System.out.print("Enter ID for the item: ");
//        int option = input.nextInt();
//        System.out.print("Enter quantity: ");
//        int qty = input.nextInt();
//        for(int i = 0; i<b.getMedicineList().size();i++){
//            if(option == b.getMedicineList().get(i).getId()){ 
//                if(a instanceof Adult == true){
//                    e = new Orders(num, a.getUserName(),b.getMedicineList().get(i).getBrandName(),qty,qty*b.getMedicineList().get(i).getPrice());
//                    System.out.println("Successfully Ordered! ");
//                    return e;
//                }
//                else if(a instanceof SeniorCitizen == true){
//                    e = new Orders(num, a.getUserName(),b.getMedicineList().get(i).getBrandName(),qty,qty*(b.getMedicineList().get(i).getPrice()*0.2));
//                    System.out.println("Successfully Ordered! ");
//                    return e;
//                }
//            }
//        }
//        return e;
//    }
}
