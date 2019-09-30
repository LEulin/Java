package medicineapp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        UserAndOrder uao = new UserAndOrder();
        User user = new User();
        Adult adult = new Adult();
        Admin admin = new Admin();
        SeniorCitizen sc = new SeniorCitizen();
        Medicine med = new Medicine();
        Orders order = new Orders();
        int count = 0;

        user.getUserList().add(new Adult(1, "Patchan", "Gwapoako", 19, 1000));
        user.getUserList().add(new Adult(2, "Patrick", "Pogiako", 19, 5000));
        user.getUserList().add(new SeniorCitizen(3, "Patik", "P@ssw0rd", 62, 5000));
        user.getUserList().add(new Admin("Patchut", "P@ssw0rd"));

//        for(int i = 0; i<user.getUserList().size();i++){
//            System.out.println("ID: "+user.getUserList().get(i).getId()+"Username: "+user.getUserList().get(i).getUserName() + "\nPassword: "+ user.getUserList().get(i).getPassWord());
//        }
        med.getMedicineList().add(new BodyPain(1, "Ibuprofen + Paracetamol", "Alaxan", "Body Pain", 8.25, 100));
        med.getMedicineList().add(new BodyPain(2, "Paracetamol Caffeine", "Rexidol", "Body Pain", 15.50, 75));
        med.getMedicineList().add(new BodyPain(3, "Ibuprofen", "Medicol Advance", "Body Pain", 6.00, 100));

        med.getMedicineList().add(new Allergies(4, "Cetirizine", "Allerkid", "Allergies", 8, 50));
        med.getMedicineList().add(new Allergies(5, "Loratadine", "Allerta", "Allergies", 16, 50));
        med.getMedicineList().add(new Allergies(6, "Mometasone Furoate", "Allerta Dermatec", "Allergies", 24, 50));

        med.getMedicineList().add(new Cough(7, "Carbocisteine", "Solmux", "Cough", 17, 50));
        med.getMedicineList().add(new Cough(8, "Ambroxol", "Myracof", "Cough", 22, 50));
        med.getMedicineList().add(new Cough(9, "Ambroxol", "Expel OD", "Cough", 29, 50));

        med.getMedicineList().add(new Headache(10, "Paracetamol", "Biogesic 325", "Headache", 6, 50));
        med.getMedicineList().add(new Headache(11, "Paracetamol", "Biogesic", "Headache", 8, 50));
        med.getMedicineList().add(new Headache(12, "Paracetamol", "UHP Fevertab", "Headache", 5, 50));

        order.getOrderList().add(new Orders(110, 1, "Alaxan", 4, 33));
        order.getOrderList().add(new Orders(11, 3, "Rexidol", 6, 50));
        order.getOrderList().add(new Orders(91, 2, "Biogesic", 6, 40));

        for (int i = 0; i < order.getOrderList().size(); i++) {
            System.out.println("[ Int ID: " + order.getOrderList().get(i).getId() + ", User ID: " + order.getOrderList().get(i).getUserId() + ", Ordered Name: " + order.getOrderList().get(i).getOrderedName() + ", Quantity: " + order.getOrderList().get(i).getQuantity() + ", Total Amount: " + order.getOrderList().get(i).getAmount() + " ]");
        }

//        System.out.printf("%30s %5s %20s %5s %20s %5s %15s %5s %10s", "Generic Name", "|", "Brand Name", "|", "Type of Medicine", "|", "Price", "|", "Stock (Pieces)\n");
//        System.out.printf("%s", "-------------------------------------------------------------------------------------------------------------------------------\n");
//        for (int i = 0; i < med.getMedicineList().size(); i++) {
//            System.out.printf("%30s %5s %20s %5s %20s %5s %15s %5s %10s", med.getMedicineList().get(i).getGenericName(), "|", med.getMedicineList().get(i).getBrandName(), "|", med.getMedicineList().get(i).getMedicineType(), "|", med.getMedicineList().get(i).getPrice(), "|", med.getMedicineList().get(i).getStock() + "\n");
//        }
//        for(int i = 0; i<med.getMedicineList().size();i++){
//            if(med.getMedicineList().get(i) instanceof BodyPain == true){
//                med.getMedicineList().get(i) = new BodyPain(med.setId(i+1),med.getGenericName(),med.getBrandName(),med.getMedicineType(),med.getPrice(),med.getStock());
//            }
//            else if(med.getMedicineList().get(i) instanceof Allergies == true){
//                med = new Allergies(medic.setId(i+1),medic.getGenericName(),medic.getBrandName(),medic.getMedicineType(),medic.getPrice(),medic.getStock());
//            }
//            else if(med.getMedicineList().get(i) instanceof Cough == true){
//                med = new Cough(medic.setId(i+1),medic.getGenericName(),medic.getBrandName(),medic.getMedicineType(),medic.getPrice(),medic.getStock());
//            }
//            else if(med.getMedicineList().get(i) instanceof Headache == true){
//                med = new Headache(medic.setId(i+1),medic.getGenericName(),medic.getBrandName(),medic.getMedicineType(),medic.getPrice(),medic.getStock());
//            }
//        }
//        for(int i = 0; i<med.getMedicineList().size();i++){
//            System.out.println(med.getMedicineList().get(i).getId());
//        }
        while (true) {
            System.out.println("1. Log in\n2. Register \n");
            System.out.print("Enter choice: ");
            int regOrLogIn = input.nextInt();
            if (regOrLogIn == 2) {
                User newUser = user.register(user);
                user.getUserList().add(newUser);
                System.out.println("ID: " + newUser.getId() + "\nUsername: " + newUser.getUserName() + "\nPassword: " + newUser.getPassWord() + "\nAge: " + newUser.getAge() + "\nMoney: " + newUser.getMoney());
                //System.out.println(user.toString());
                for (int i = 0; i < user.getUserList().size(); i++) {
                    System.out.println("[ User ID: " + user.getUserList().get(i).getId() + ", Username: " + user.getUserList().get(i).getUserName()+ ", Password: " + user.getUserList().get(i).getPassWord() + ", Age: " + user.getUserList().get(i).getAge()+ ", Balance: " + user.getUserList().get(i).getMoney()+ ", Registered as: "+user.getUserList().get(i).getClass().getSimpleName()+" ]");
                }
            } else if(regOrLogIn==1){
                User a = user.login(user);

                if (a instanceof Admin == true) {
                    System.out.println("Your account is now logged in as an Administrator! ");
                    System.out.println("-------------------------------------------------------------------------------");
                    System.out.println("Choose transactions:\n0. Add Medicine\n1. Remove Medicine\n2. Display Medicines\n3. View Orders\n4. Logout");
                    while (true) {
                        System.out.print("Enter your choice: ");
                        int option = input.nextInt();
                        if (option == 0) {
                            Admin gwapo = new Admin();
                            med.getMedicineList().add(gwapo.addMedicine(med));
                        } else if (option == 1) {
                            Admin gwapo = new Admin();
                            med.getMedicineList().remove(gwapo.removeMedicine(med));
                            for (int i = 0; i < med.getMedicineList().size(); i++) {
                                med.getMedicineList().get(i).setId(i + 1);
                            }
                        } else if (option == 2) {
                            System.out.printf("%10s %5s %30s %5s %20s %5s %20s %5s %15s %5s %10s", "ID", "|", "Generic Name", "|", "Brand Name", "|", "Type of Medicine", "|", "Price", "|", "Stock (Pieces)\n");
                            System.out.printf("%s", "------------------------------------------------------------------------------------------------------------------------------------------------\n");
                            for (int i = 0; i < med.getMedicineList().size(); i++) {
                                System.out.printf("%10s %5s %30s %5s %20s %5s %20s %5s %15s %5s %10s \n", med.getMedicineList().get(i).getId(), "|", med.getMedicineList().get(i).getGenericName(), "|", med.getMedicineList().get(i).getBrandName(), "|", med.getMedicineList().get(i).getMedicineType(), "|", med.getMedicineList().get(i).getPrice(), "|", med.getMedicineList().get(i).getStock());
                            }

                            //a.displayMedicines();
                        } else if (option == 3) {
                            System.out.printf("%15s %5s %20s %5s %25s %5s %15s %5s %10s", "ID", "|", "Name" , "|" , "Ordered Generic Name" , "|" , "Quantity" , "|" , "Amount\n");
                            System.out.printf("%s", "-------------------------------------------------------------------------------------------------------------------------------\n");
                            for (int i = 0; i < order.getOrderList().size(); i++) {
                                System.out.printf("%15s %5s %20s %5s %25s %5s %15s %5s %10s \n", order.getOrderList().get(i).getId(), "|", order.getOrderList().get(i).getUserId(), "|", order.getOrderList().get(i).getOrderedName(), "|", order.getOrderList().get(i).getQuantity(), "|", order.getOrderList().get(i).getAmount());
                            }
                        } else if (option == 4) {
                            System.out.println("You are now logged out!");
                            break;
                        } else {
                            System.out.println("Invalid input!");
                        }
                    }
                } else {

                    System.out.println("You're logged in as " + a.getClass().getSimpleName() + "!");
                    System.out.println("-------------------------------------------------------------------------------");
                    System.out.println("Choose transaction:\n0. View balance \n1. Deposit balance\n2. Order\n3. View Medicines\n4. View Orders\n5. Change Password\n6. Pay Order\n7. Log out");
                    while (true) {

                        System.out.print("Enter your choice: ");
                        int option = input.nextInt();
                        if (option == 0) {
                            System.out.println("Your balance is: Php" + a.getMoney());
                        } else if (option == 1) {
                            a.deposit(a);
                        } else if (option == 2) {
                            count++;
                            System.out.printf("%10s %5s %30s %5s %20s %5s %20s %5s %15s %5s %10s", "ID", "|", "Generic Name", "|", "Brand Name", "|", "Type of Medicine", "|", "Price", "|", "Stock (Pieces)\n");
                            System.out.printf("%s", "------------------------------------------------------------------------------------------------------------------------------------------------\n");
                            for (int i = 0; i < med.getMedicineList().size(); i++) {
                                System.out.printf("%10s %5s %30s %5s %20s %5s %20s %5s %15s %5s %10s \n", med.getMedicineList().get(i).getId(), "|", med.getMedicineList().get(i).getGenericName(), "|", med.getMedicineList().get(i).getBrandName(), "|", med.getMedicineList().get(i).getMedicineType(), "|", med.getMedicineList().get(i).getPrice(), "|", med.getMedicineList().get(i).getStock());
                            }

                            int max = 150;
                            int min = 15;
                            int range = max - min + 1;
                            int num = (int) (Math.random() * range) + min;
                            System.out.println("Choose by entering item ID!");
                            System.out.print("Enter ID for the item: ");
                            int option123 = input.nextInt();
                            System.out.print("Enter quantity: ");
                            int qty = input.nextInt();
                            for (int i = 0; i < med.getMedicineList().size(); i++) {
                                if (option123 == med.getMedicineList().get(i).getId()) {
                                    if (a instanceof Adult == true) {
                                        order.getOrderList().add(new Orders(num, a.getId(), med.getMedicineList().get(i).getBrandName(), qty, qty * med.getMedicineList().get(i).getPrice()));
                                        System.out.println("Successfully Ordered! ");

                                    } else if (a instanceof SeniorCitizen == true) {
                                        order.getOrderList().add(new Orders(num, a.getId(), med.getMedicineList().get(i).getBrandName(), qty, qty * (med.getMedicineList().get(i).getPrice() * 0.2)));
                                        System.out.println("Successfully Ordered! ");

                                    }
                                }
                            }

                        } else if (option == 3) {
                            a.displayMedicines(med);
                        } else if (option == 4) {
                            a.displayOrders(order, a);
                        } else if (option == 5) {
                            a.changePass(a);
                        } else if (option == 6) {
                            User gwapos = new User();
                            System.out.print("Enter Order ID to choose item to pay: ");
                            int inputs = input.nextInt();
                            a.displayOrders(order, a);
                            double moneyy = 0;
                            for (int i = 0; i < count; i++) {
                                if (order.getOrderList().get(i).getId() == inputs) {
                                    if (order.getOrderList().get(i).getUserId() == a.getId()) {
                                        moneyy = a.getId() - order.getOrderList().get(i).getAmount();
                                        a.setMoney(moneyy);
                                        System.out.println(a.getMoney());
                                        a = new User(a.getId(), a.getUserName(), a.getPassWord(), a.getAge(), moneyy);
                                    }

                                }
                            }
                            System.out.println("Money is: " + moneyy);

                            for (int i = 0; i < count; i++) {
                                System.out.println("Order ID: " + order.getOrderList().get(i).getId());
                            }

//                        for(int i = 0; i<count;i++){
//                            System.out.println(order.getOrderList().get(i).getAmount());
//                        }
                            order.getOrderList().remove(gwapos.payOrder(order, inputs));
//                        for (int i = 0; i < med.getMedicineList().size(); i++) {
//                            for (int j = i; j < count; j++) {
//                                if (med.getMedicineList().get(i).getBrandName().equals(order.getOrderList().get(j).getOrderedName()) == true) {
//                                    med.getMedicineList().get(i).setStock(med.getMedicineList().get(i).getStock() - order.getOrderList().get(j).getQuantity());
//                                    System.out.println("Stock left: " + med.getMedicineList().get(i).getStock());
//                                }
//                            }
//                        }

//                        double mon = a.getMoney();
//                        User z = new User(a.updateMoney(a, inputs, order, count, med, mon));
//                        a = z;
                        } else if (option == 7) {
                            System.out.println("You are now logged out!");
                            break;
                        } else {
                            System.out.println("Input Error!");
                        }
                    }

                }

            }
            
            else {
                System.out.println("Invalid Input!");
            }

        }

    }

}
