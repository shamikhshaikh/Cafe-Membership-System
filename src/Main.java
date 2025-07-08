
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        doublelinkedlist dll = new doublelinkedlist();
        String AdminPassword = "SYMSICAL";
        String AdminID = "A0415";
        String person;
        String choice;
        String ch;
        String choi;
        String membership_package;

        while (true) {
            System.out.println();
            System.out.println("===============================================");
            System.out.println("|           WELCOME TO SYMSICAL CAFE          |");
            System.out.println("===============================================");
            System.out.println(" 0. Exit");
            System.out.println(" 1. Login As Admin");
            System.out.println(" 2. Login As Customer");
            System.out.println("-----------------------------------------------");
            System.out.print(" Enter your choice: ");
            person = sc.nextLine();

            if (person.equals("0")) {
                System.exit(0);
            } else if (person.equals("1")) {
                // Admin Login
                while (true) {
                    System.out.println("===============================================");
                    System.out.println("|                 LOGIN PAGE                  |");
                    System.out.println("===============================================");
                    System.out.print(" Enter ID (0 to return): ");
                    String id = sc.nextLine();
                    if (id.equals("0")) break;

                    System.out.print(" Enter Password: ");
                    String pass = sc.nextLine();

                    if (id.equals(AdminID) && pass.equals(AdminPassword)) {
                        while (true) {
                            System.out.println();
                            System.out.println("===============================================");
                            System.out.println("|               ADMIN OPTIONS                 |");
                            System.out.println("===============================================");
                            System.out.println(" 0. Exit");
                            System.out.println(" 1. View Customers With Membership");
                            System.out.println(" 2. View Cafe Queue");
                            System.out.println(" 3. View Order History");
                            System.out.println(" 4. Logout");
                            System.out.println("-----------------------------------------------");
                            System.out.print(" Enter your choice: ");
                            choice = sc.nextLine();

                            if (choice.equals("0")) {
                                System.exit(0);
                            } else if (choice.equals("1")) {
                                while (true) {
                                    System.out.println("===============================================");
                                    System.out.println("|          VIEW MEMBERSHIP CUSTOMERS         |");
                                    System.out.println("===============================================");
                                    System.out.println(" 0. Exit");
                                    System.out.println(" 1. View All Membership Customers");
                                    System.out.println(" 2. View Platinum Membership Customers");
                                    System.out.println(" 3. View Gold Membership Customers");
                                    System.out.println(" 4. View Silver Membership Customers");
                                    System.out.println(" 5. Return");
                                    System.out.println("-----------------------------------------------");
                                    System.out.print(" Enter your choice: ");
                                    ch = sc.nextLine();

                                    if (ch.equals("0")) {
                                        System.exit(0);
                                    } else if (ch.equals("1")) {
                                        dll.printAllCustomers();
                                    } else if (ch.equals("2")) {
                                        dll.printPlatinumCustomer();
                                    } else if (ch.equals("3")) {
                                        dll.printGoldCustomer();
                                    } else if (ch.equals("4")) {
                                        dll.printSilverCustomer();
                                    } else if (ch.equals("5")) {
                                        break;
                                    } else {
                                        System.out.println("Invalid input. Try again.");
                                    }
                                }
                            } else if (choice.equals("2")) {
                                LinkedListQueue.printQueue();
                            } else if (choice.equals("3")) {
                                LinkedListQueue.printOrderHistory();
                            } else if (choice.equals("4")) {
                                System.out.println("Logout Successful");
                                break;
                            } else {
                                System.out.println("Invalid input. Try again.");
                            }
                        }
                    } else {
                        System.out.println("ID / Password incorrect. Try again.");
                    }
                }             } else if (person.equals("2")) {
                while (true) {
                    System.out.println();
                    System.out.println("===============================================");
                    System.out.println("|              CUSTOMER OPTIONS              |");
                    System.out.println("===============================================");
                    System.out.println(" 0. Exit");
                    System.out.println(" 1. Sign Up");
                    System.out.println(" 2. Sign In");
                    System.out.println(" 3. Regular Customer");
                    System.out.println(" 4. Return");
                    System.out.println("-----------------------------------------------");
                    System.out.print(" Enter your choice: ");
                    choice = sc.nextLine();

                    switch (choice) {
                        case "0":
                            System.exit(0);
                        case "1":
                            while (true) {
                                System.out.println();
                                System.out.println("===============================================");
                                System.out.println("|             MEMBERSHIP PACKAGES            |");
                                System.out.println("===============================================");
                                System.out.println(" 0. Exit");
                                System.out.println(" 1. Platinum  : 15% Discount + Deals Menu (3000)");
                                System.out.println(" 2. Gold      : 10% Discount + Deals Menu (2000)");
                                System.out.println(" 3. Silver    : 7% Discount (1000)");
                                System.out.println(" 4. Return");
                                System.out.println("-----------------------------------------------");
                                System.out.print(" Enter Membership Package: ");
                                membership_package = sc.nextLine();

                                switch (membership_package) {
                                    case "0":
                                        System.exit(0);
                                    case "1": {
                                        String[] info = informationInput();
                                        String fn = info[0];
                                        String ln = info[1];
                                        String pass = getPassword();
                                        String num = getContactNum();
                                        dll.insert(fn, ln, "Platinum", pass, num, 3000);
                                        break;
                                    }
                                    case "2": {
                                        String[] info = informationInput();
                                        String fn = info[0];
                                        String ln = info[1];
                                        String pass = getPassword();
                                        String num = getContactNum();
                                        dll.insert(fn, ln, "Gold", pass, num, 2000);
                                        break;
                                    }
                                    case "3": {
                                        String[] info = informationInput();
                                        String fn = info[0];
                                        String ln = info[1];
                                        String pass = getPassword();
                                        String num = getContactNum();
                                        dll.insert(fn, ln, "Silver", pass, num, 1000);
                                        break;
                                    }
                                    case "4":
                                        break;
                                    default:
                                        System.out.println("Invalid input. Try again.");
                                }
                                break;
                            }
                            break;
                        case "2":
                            while (true) {
                                System.out.println();
                                System.out.println("===============================================");
                                System.out.println("|                 LOGIN PAGE                 |");
                                System.out.println("===============================================");
                                System.out.print(" Enter ID (0 to return): ");
                                String id = sc.nextLine();
                                if (id.equals("0")) {
                                    break;
                                }
                                System.out.print(" Enter Password: ");
                                String pass = sc.nextLine();
                                boolean flag = dll.checkCredentials(id, pass);

                                if (flag) {
                                    while (true) {
                                        System.out.println();
                                        System.out.println("===============================================");
                                        System.out.println("|               OPTIONS MENU                 |");
                                        System.out.println("===============================================");
                                        System.out.println(" 0. Exit");
                                        System.out.println(" 1. Display Menu");
                                        System.out.println(" 2. Delete Membership");
                                        System.out.println(" 3. Logout");
                                        System.out.println("-----------------------------------------------");
                                        System.out.print(" Enter your choice: ");
                                        choi = sc.nextLine();

                                        if (choi.equals("0")) {
                                            System.exit(0);
                                        } else if (choi.equals("1")) {
                                            if (id.startsWith("P") || id.startsWith("G")) {
                                                displayDealsMenu();
                                                ordersInput(id);
                                            } else if (id.startsWith("S")) {
                                                displayMenu();
                                                ordersInput(id);
                                            } else {
                                                System.out.println("Invalid membership ID format.");
                                            }
                                        } else if (choi.equals("2")) {
                                            dll.deleteMembership(id, pass);
                                            break;
                                        } else if (choi.equals("3")) {
                                            System.out.println("Logout Successful.");
                                            break;
                                        } else {
                                            System.out.println("Invalid input. Try again.");
                                        }
                                    }
                                } else {
                                    System.out.println("ID / Password incorrect. Try again.");
                                }
                            }
                            break;
                        case "3":
                            displayMenu();
                            String basicid = "B" + dll.getLastBasicId();
                            ordersInput(basicid);
                            break;
                        case "4":
                            break;
                        default:
                            System.out.println("Invalid input. Try again.");
                    }
                }
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
    }
    public static String[] informationInput() {
        Scanner sc = new Scanner(System.in);
        String[] information = new String[2];
        System.out.println();
        System.out.println("===============================================");
        System.out.println("|         ENTER CUSTOMER INFORMATION         |");
        System.out.println("===============================================");
        System.out.print(" Enter First Name: ");
        information[0] = sc.nextLine();
        System.out.print(" Enter Last Name: ");
        information[1] = sc.nextLine();
        return information;
    }

    public static String getPassword() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(" Enter Password: ");
            String pass = sc.nextLine();
            if (pass.length() < 6 || pass.length() > 8) {
                System.out.println(" Password must be between 6 and 8 characters. Try again.");
            } else {
                return pass;
            }
        }
    }

    public static String getContactNum() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(" Enter Contact Number: ");
            String contactNumber = sc.nextLine();
            if (contactNumber.length() != 11) {
                System.out.println(" Contact number must be exactly 11 characters. Try again.");
            } else if (!contactNumber.startsWith("03")) {
                System.out.println(" Contact number must start with '03'. Try again.");
            } else {
                return contactNumber;
            }
        }
    }

    public static void displayMenu() {
        BSTTree startersTree = new BSTTree();
        BSTTree mainCourseTree = new BSTTree();
        BSTTree drinksTree = new BSTTree();

        System.out.println();
        System.out.println("=================================================");
        System.out.println("|                    MENU                      |");
        System.out.println("=================================================");
        System.out.println();
        System.out.println("-------------------- STARTERS --------------------");
        startersTree.insert("4. Mozzarella Sticks", 899);
        startersTree.insert("2. Onion Rings", 799);
        startersTree.insert("3. Spring Rolls", 850);
        startersTree.insert("1. French Fries", 499);
        startersTree.inOrder();
        System.out.println("------------------- MAIN COURSE ------------------");
        mainCourseTree.insert("5. Sandwich", 1499);
        mainCourseTree.insert("7. Burger", 1799);
        mainCourseTree.insert("8. Pizza", 2000);
        mainCourseTree.insert("6. Pasta", 1500);
        mainCourseTree.inOrder();
        System.out.println("--------------------- DRINKS ---------------------");
        drinksTree.insert("13. Coffee", 1050);
        drinksTree.insert("11. Tea", 799);
        drinksTree.insert("10. Fresh Juice", 350);
        drinksTree.insert("12. Shake", 999);
        drinksTree.insert("9. Soft Drink", 299);
        drinksTree.inOrder();
    }

    public static void displayDealsMenu() {
        BSTTree startersTree = new BSTTree();
        BSTTree mainCourseTree = new BSTTree();
        BSTTree drinksTree = new BSTTree();
        BSTTree platinumDealsTree = new BSTTree();

        System.out.println();
        System.out.println("=================================================");
        System.out.println("|                    MENU                      |");
        System.out.println("=================================================");
        System.out.println();
        System.out.println("-------------------- STARTERS --------------------");
        startersTree.insert("4. Mozzarella Sticks", 899);
        startersTree.insert("2. Onion Rings", 799);
        startersTree.insert("3. Spring Rolls", 850);
        startersTree.insert("1. French Fries", 499);
        startersTree.inOrder();
        System.out.println("------------------- MAIN COURSE ------------------");
        mainCourseTree.insert("5. Sandwich", 1499);
        mainCourseTree.insert("7. Burger", 1799);
        mainCourseTree.insert("8. Pizza", 2000);
        mainCourseTree.insert("6. Pasta", 1500);
        mainCourseTree.inOrder();
        System.out.println("--------------------- DRINKS ---------------------");
        drinksTree.insert("13. Coffee", 1050);
        drinksTree.insert("11. Tea", 799);
        drinksTree.insert("10. Fresh Juice", 350);
        drinksTree.insert("12. Shake", 999);
        drinksTree.insert("9. Soft Drink", 299);
        drinksTree.inOrder();
        System.out.println("---------------------- DEALS ----------------------");
        platinumDealsTree.insert("14. Burger + Fries + Soft Drink", 2300);
        platinumDealsTree.insert("15. Sandwich + Onion Rings + Shake", 3000);
        platinumDealsTree.insert("16. Pizza + Mozzarella Sticks + Shake", 3500);
        platinumDealsTree.inOrder();
    }

    public static void ordersInput(String customerID) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int bill = 0;
        String[] order = new String[0];

        while (true) {
            try {
                System.out.print(" Enter Item (Press 0 to checkout): ");
                int ch = sc.nextInt();

                if ((customerID.charAt(0) == 'S' || customerID.charAt(0) == 'B') && ch > 13) {
                    System.out.println("Invalid Input. Try Again.");
                } else {
                    if (ch == 0) {
                        if (count == 0) {
                            System.out.println("No items in cart.");
                        } else {
                            cart(order, bill, customerID);
                            break;
                        }
                    } else if (ch == 1) {
                        while (true) {
                            try {
                                System.out.print("Enter quantity: ");
                                int q = sc.nextInt();
                                if (q <= 0) {
                                    System.out.println("Quantity invalid. Try again.");
                                } else {
                                    for (int i = 0; i < q; i++) {
                                        order = orderInsert("French Fries", order, count++);
                                        bill += 499;
                                    }
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid Quantity. Please enter a number.");
                                sc.next();
                            }
                        }
                    } else if (ch == 2) {
                        while (true) {
                            try {
                                System.out.print("Enter quantity: ");
                                int q = sc.nextInt();
                                if (q <= 0) {
                                    System.out.println("Quantity invalid. Try again.");
                                } else {
                                    for (int i = 0; i < q; i++) {
                                        order = orderInsert("Onion Rings", order, count++);
                                        bill += 799;
                                    }
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid Quantity. Please enter a number.");
                                sc.next();
                            }
                        }
                    } else if (ch == 3) {
                        while (true) {
                            try {
                                System.out.print("Enter quantity: ");
                                int q = sc.nextInt();
                                if (q <= 0) {
                                    System.out.println("Quantity invalid. Try again.");
                                } else {
                                    for (int i = 0; i < q; i++) {
                                        order = orderInsert("Spring Rolls", order, count++);
                                        bill += 850;
                                    }
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid Quantity. Please enter a number.");
                                sc.next();
                            }
                        }
                    } else if (ch == 4) {
                        while (true) {
                            try {
                                System.out.print("Enter quantity: ");
                                int q = sc.nextInt();
                                if (q <= 0) {
                                    System.out.println("Quantity invalid. Try again.");
                                } else {
                                    for (int i = 0; i < q; i++) {
                                        order = orderInsert("Mozzarella Sticks", order, count++);
                                        bill += 899;
                                    }
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid Quantity. Please enter a number.");
                                sc.next();
                            }
                        }
                    } else if (ch == 5) {
                        while (true) {
                            try {
                                System.out.print("Enter quantity: ");
                                int q = sc.nextInt();
                                if (q <= 0) {
                                    System.out.println("Quantity invalid. Try again.");
                                } else {
                                    for (int i = 0; i < q; i++) {
                                        order = orderInsert("Sandwich", order, count++);
                                        bill += 1499;
                                    }
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid Quantity. Please enter a number.");
                                sc.next();
                            }
                        }
                    } else if (ch == 6) {
                        while (true) {
                            try {
                                System.out.print("Enter quantity: ");
                                int q = sc.nextInt();
                                if (q <= 0) {
                                    System.out.println("Quantity invalid. Try again.");
                                } else {
                                    for (int i = 0; i < q; i++) {
                                        order = orderInsert("Pasta", order, count++);
                                        bill += 1500;
                                    }
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid Quantity. Please enter a number.");
                                sc.next();
                            }
                        }
                    } else if (ch == 7) {
                        while (true) {
                            try {
                                System.out.print("Enter quantity: ");
                                int q = sc.nextInt();
                                if (q <= 0) {
                                    System.out.println("Quantity invalid. Try again.");
                                } else {
                                    for (int i = 0; i < q; i++) {
                                        order = orderInsert("Burger", order, count++);
                                        bill += 1799;
                                    }
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid Quantity. Please enter a number.");
                                sc.next();
                            }
                        }
                    } else if (ch == 8) {
                        while (true) {
                            try {
                                System.out.print("Enter quantity: ");
                                int q = sc.nextInt();
                                if (q <= 0) {
                                    System.out.println("Quantity invalid. Try again.");
                                } else {
                                    for (int i = 0; i < q; i++) {
                                        order = orderInsert("Pizza", order, count++);
                                        bill += 2000;
                                    }
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid Quantity. Please enter a number.");
                                sc.next();
                            }
                        }
                    } else if (ch == 9) {
                        while (true) {
                            try {
                                System.out.print("Enter quantity: ");
                                int q = sc.nextInt();
                                if (q <= 0) {
                                    System.out.println("Quantity invalid. Try again.");
                                } else {
                                    for (int i = 0; i < q; i++) {
                                        order = orderInsert("Soft Drink", order, count++);
                                        bill += 299;
                                    }
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid Quantity. Please enter a number.");
                                sc.next();
                            }
                        }
                    } else if (ch == 10) {
                        while (true) {
                            try {
                                System.out.print("Enter quantity: ");
                                int q = sc.nextInt();
                                if (q <= 0) {
                                    System.out.println("Quantity invalid. Try again.");
                                } else {
                                    for (int i = 0; i < q; i++) {
                                        order = orderInsert("Fresh Juice", order, count++);
                                        bill += 350;
                                    }
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid Quantity. Please enter a number.");
                                sc.next();
                            }
                        }
                    } else if (ch == 11) {
                        while (true) {
                            try {
                                System.out.print("Enter quantity: ");
                                int q = sc.nextInt();
                                if (q <= 0) {
                                    System.out.println("Quantity invalid. Try again.");
                                } else {
                                    for (int i = 0; i < q; i++) {
                                        order = orderInsert("Tea", order, count++);
                                        bill += 799;
                                    }
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid Quantity. Please enter a number.");
                                sc.next();
                            }
                        }
                    } else if (ch == 12) {
                        while (true) {
                            try {
                                System.out.print("Enter quantity: ");
                                int q = sc.nextInt();
                                if (q <= 0) {
                                    System.out.println("Quantity invalid. Try again.");
                                } else {
                                    for (int i = 0; i < q; i++) {
                                        order = orderInsert("Shake", order, count++);
                                        bill += 999;
                                    }
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid Quantity. Please enter a number.");
                                sc.next();
                            }
                        }
                    } else if (ch == 13) {
                        while (true) {
                            try {
                                System.out.print("Enter quantity: ");
                                int q = sc.nextInt();
                                if (q <= 0) {
                                    System.out.println("Quantity invalid. Try again.");
                                } else {
                                    for (int i = 0; i < q; i++) {
                                        order = orderInsert("Coffee", order, count++);
                                        bill += 1050;
                                    }
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid Quantity. Please enter a number.");
                                sc.next();
                            }
                        }
                    } else if (ch == 14) {
                        while (true) {
                            try {
                                System.out.print("Enter quantity: ");
                                int q = sc.nextInt();
                                if (q <= 0) {
                                    System.out.println("Quantity invalid. Try again.");
                                } else {
                                    for (int i = 0; i < q; i++) {
                                        order = orderInsert("Deal 1", order, count++);
                                        bill += 2300;
                                    }
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid Quantity. Please enter a number.");
                                sc.next();
                            }
                        }
                    } else if (ch == 15) {
                        while (true) {
                            try {
                                System.out.print("Enter quantity: ");
                                int q = sc.nextInt();
                                if (q <= 0) {
                                    System.out.println("Quantity invalid. Try again.");
                                } else {
                                    for (int i = 0; i < q; i++) {
                                        order = orderInsert("Deal 2", order, count++);
                                        bill += 3000;
                                    }
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid Quantity. Please enter a number.");
                                sc.next();
                            }
                        }
                    } else if (ch == 16) {
                        while (true) {
                            try {
                                System.out.print("Enter quantity: ");
                                int q = sc.nextInt();
                                if (q <= 0) {
                                    System.out.println("Quantity invalid. Try again.");
                                } else {
                                    for (int i = 0; i < q; i++) {
                                        order = orderInsert("Deal 3", order, count++);
                                        bill += 3500;
                                    }
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid Quantity. Please enter a number.");
                                sc.next();
                            }
                        }
                    } else {
                        System.out.println("Invalid input. Try again.");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }
        }
    }


    public static String[] orderInsert(String item, String[] order, int count) {
        if (count == order.length) {
            String[] temp = new String[order.length + 1];
            for (int i = 0; i < order.length; i++) {
                temp[i] = order[i];
            }
            order = temp;
            order[count] = item;
        }
        else {
            order[count] = item;
        }
        return order;
    }
    public static void cart(String[] order, int bill, String customerId) {
        Scanner sc = new Scanner(System.in);
        LinkedListQueue q = new LinkedListQueue();
        int totalBill = bill;

        while (true) {
            shellSort(order);
            System.out.println("===============================================");
            System.out.println("|                     CART                    |");
            System.out.println("===============================================");
            System.out.println(" ITEMS: ");
            int s = 0;
            for (int i = 0; i < order.length; i++) {
                int count = 1;
                while (i < order.length - 1 && order[i].equals(order[i + 1])) {
                    count++;
                    i++;
                }
                s++;
                System.out.println(" " + s + ". " + order[i] + " (" + count + ")");
            }
            System.out.println();
            System.out.println(" 1. Proceed to payment");
            System.out.println(" 2. Delete Items");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                totalBill = applyDiscount(totalBill, customerId);
                break;
            } else if (choice.equals("2")) {
                order = deleteItems(sc, order);
                totalBill = recalculateBill(order);
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        processPayment(order, totalBill, customerId);
    }

    private static int applyDiscount(int bill, String customerId) {
        int totalBill = bill;
        System.out.println(" Total Bill = " + bill);

        if (customerId.charAt(0) == 'P') {
            totalBill -= bill * 0.15;
            System.out.println(" After discount (15%) = " + totalBill);
        } else if (customerId.charAt(0) == 'G') {
            totalBill -= bill * 0.10;
            System.out.println(" After discount (10%) = " + totalBill);
        } else if (customerId.charAt(0) == 'S') {
            totalBill -= bill * 0.07;
            System.out.println(" After discount (7%) = " + totalBill);
        } else {
            System.out.println(" No discount applied.");
        }

        return totalBill;
    }

    private static String[] deleteItems(Scanner sc, String[] order) {
        if (order.length == 0) {
            System.out.println("Your cart is already empty.");
            return order;
        }

        while (true) {
            System.out.println("Choose an item number to delete:");
            for (int i = 0; i < order.length; i++) {
                System.out.println((i + 1) + ". " + order[i]);
            }

            int itemIndex = sc.nextInt() - 1;
            sc.nextLine();

            if (itemIndex < 0 || itemIndex >= order.length) {
                System.out.println("Invalid input. Try again.");
            } else {
                String[] updatedOrder = new String[order.length - 1];
                for (int i = 0, j = 0; i < order.length; i++) {
                    if (i == itemIndex) continue;
                    updatedOrder[j++] = order[i];
                }
                System.out.println("Item deleted successfully.");
                return updatedOrder;
            }
        }
    }

    private static int recalculateBill(String[] order) {
    int newBill = 0;
    for (String item : order) {
        newBill += getItemPrice(item);
    }
    return newBill;
}
private static int getItemPrice(String item) {
    return switch (item) {
        case "French Fries" -> 499;
        case "Onion Rings" -> 799;
        case "Spring Rolls" -> 850;
        case "Mozzarella Sticks" -> 899;
        case "Sandwich" -> 1499;
        case "Pasta" -> 1500;
        case "Burger" -> 1799;
        case "Pizza" -> 2000;
        case "Soft Drink" -> 299;
        case "Fresh Juice" -> 350;
        case "Tea" -> 799;
        case "Shake" -> 999;
        case "Coffee" -> 1050;
        case "Deal 1" -> 2300;
        case "Deal 2" -> 3000;
        case "Deal 3" -> 3500;
        default -> 0;
    };
}
    private static void processPayment(String[] order, int totalBill, String customerId) {
        System.out.println("===============================================");
        System.out.println("|               PAYMENT PROCESS               |");
        System.out.println("===============================================");

        Scanner sc = new Scanner(System.in);
        LinkedListQueue q = new LinkedListQueue();

        while (true) {
            System.out.print(" Enter Amount: ");
            int amount = sc.nextInt();
            if (amount < totalBill) {
                System.out.println("Amount insufficient. Please try again.");
            } else {
                int change = amount - totalBill;
                System.out.println(" Change = " + change);
                int orderId = q.insert(customerId, order);
                generateReceipt(order, totalBill, amount, change, orderId);
                break;
            }
        }
    }

    private static void generateReceipt(String[] order, int totalBill, int amount, int change, int orderId) {
        System.out.println("===============================================");
        System.out.println("|                ORDER RECEIPT                |");
        System.out.println("===============================================");
        System.out.println();
        System.out.println("               Order ID: " + orderId);
        System.out.println("-----------------------------------------------");
        System.out.println();
        System.out.println(" ITEMS: ");
        for (int i = 0; i < order.length; i++) {
            int count = 1;
            while (i < order.length - 1 && order[i].equals(order[i + 1])) {
                count++;
                i++;
            }
            System.out.println(" " + order[i] + " (" + count + ")");
        }
        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.println(" Total Bill: " + totalBill);
        System.out.println(" Amount Paid: " + amount);
        System.out.println(" Change: " + change);
        System.out.println("===============================================");
        System.out.println("|         THANK YOU FOR ORDERING              |");
        System.out.println("===============================================");
    }

private static void shellSort(String[] order) {
    int n = order.length;
    for (int gap = n / 2; gap > 0; gap /= 2) {
        for (int i = gap; i < n; i++) {
            String temp = order[i];
            int j;
            for (j = i; j >= gap && order[j -
                    gap].compareTo(temp) > 0; j -= gap) {
                order[j] = order[j - gap];
            }
            order[j] = temp;
        }
    }
  }
}

