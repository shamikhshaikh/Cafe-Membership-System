import java.io.*;
import java.util.Scanner;

public class doublelinkedlist {
    Scanner sc = new Scanner(System.in);
    private static int platinumLastId = 0;
    private static int goldLastId = 0;
    private static int silverLastId = 0;
    private static int basicLastId = 0;
    Node head, tail;

    public static void WriteToFile(String str) {
        try {
            FileWriter w = new FileWriter("Customers.txt", true);
            w.write("\n");
            w.write(str);
            w.write("\n");
            w.close();
        } catch (IOException e) {
            System.out.println("An error has occurred.");
        }
    }

    public static void loadFromFile(String fileName) {
        try {
            File f = new File(fileName);
            if (f.length() == 0) {
                System.out.println("The file " + fileName + " is empty.");
                return;
            }
            Scanner reader = new Scanner(f);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] information = line.split(",");
                for (String s : information) {
                    System.out.println(" " + s.trim());
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error has occurred: " + e.getMessage());
        }
    }

    private boolean isDuplicateCustomer(String contactNum, String customerName, String lastName) {
        try {
            File f = new File("Customers.txt");
            if (f.length() == 0) {
                System.out.println("The file is empty.");
                return false;
            }
            Scanner reader = new Scanner(f);
            while (reader.hasNextLine()) {
                String line = reader.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] fields = line.split(",");
                if (fields.length >= 5) {
                    String fileCustomerName = fields[0].trim();
                    String fileLastName = fields[1].trim();
                    String fileCustomerId = fields[3].trim();
                    String fileContactNumber = fields[4].trim();
                    if (fileContactNumber.equals(contactNum) &&
                            fileCustomerName.equalsIgnoreCase(customerName) &&
                            fileLastName.equalsIgnoreCase(lastName)) {
                        System.out.println("Duplicate customer found: " +
                                fileCustomerId + " (" + fileCustomerName + " " + fileLastName + ")");
                        reader.close();
                        return true;
                    }
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error has occurred: " + e.getMessage());
        }
        return false;
    }

    void insert(String customerName, String lastName, String membership,
                String password, String contactNumber, int price) {
        String customerId = generateCustomerId(membership);
        if (isDuplicateCustomer(contactNumber, customerName, lastName)) {
            return;
        }
        Node newNode = new Node(customerName, lastName, membership,
                customerId, password, contactNumber);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }

        while (true) {
            System.out.print("Enter Amount = ");
            double amount = sc.nextDouble();
            double change = amount - price;
            if (change >= 0) {
                System.out.print("Change = " + change);
                System.out.println();
                displayReceipt(newNode.getMembership(), amount, price, change);
                System.out.println();
                displayMembershipDetails(newNode.getCustomerName(),
                        newNode.getLastName(), newNode.getMembership(), newNode.getCustomerId(),
                        newNode.getContactNumber());
                String str = newNode.getCustomerName() + "," +
                        newNode.getLastName() + "," + newNode.getMembership() + "," +
                        newNode.getCustomerId() + "," + newNode.getContactNumber() + "," +
                        newNode.getPassword();
                WriteToFile(str);
                break;
            } else {
                System.out.println("Amount Is Insufficient. Try Again.");
            }
        }
    }

    public static void displayMembershipDetails(String fn, String ln, String membership, String id, String num) {
        System.out.println("=================================================");
        System.out.println("|              Symsical Membership Card        |");
        System.out.println("=================================================");
        System.out.println(" Customer Name      :   " + fn + " " + ln);
        System.out.println(" Membership Type    :   " + membership);
        System.out.println(" Customer ID        :   " + id);
        System.out.println(" Contact Number     :   " + num);
        System.out.println("=================================================");
    }

    public static void displayReceipt(String membership, double amount, int price, double change) {
        System.out.println("=================================================");
        System.out.println("|                SYMSICAL CAFE                 |");
        System.out.println("=================================================");
        System.out.println("|                Package Receipt               |");
        System.out.println("=================================================");
        System.out.println("  Selected Package   :   " + membership);
        System.out.println("  Price              :   " + price);
        System.out.println("  Entered Amount     :   " + amount);
        System.out.println("  Change Amount      :   " + change);
        System.out.println("=================================================");
        System.out.println("|          WELCOME TO THE SYMSICAL FAMILY      |");
        System.out.println("=================================================");
    }

    void printAllCustomers() {
        loadFromFile("Customers.txt");
    }
    void printPlatinumCustomer() {
        try {
            File f = new File("Customers.txt");
            if (f.length() == 0) {
                System.out.println("The file is empty.");
                return;
            }
            Scanner reader = new Scanner(f);
            System.out.println("Platinum Members:");
            boolean found = false;
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] information = line.split(",");
                for (String field : information) {
                    if (field.trim().equalsIgnoreCase("Platinum")) {
                        System.out.println(line.trim());
                        found = true;
                        break;
                    }
                }
            }
            if (!found) {
                System.out.println("No platinum members found.");
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error has occurred: " + e.getMessage());
        }
    }

    void printGoldCustomer() {
        try {
            File f = new File("Customers.txt");
            if (!f.exists()) {
                throw new FileNotFoundException("The file Customers.txt does not exist.");
            }
            if (f.length() == 0) {
                System.out.println("The file is empty.");
                return;
            }
            Scanner reader = new Scanner(f);
            System.out.println("Gold Members:");
            boolean found = false;
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] information = line.split(",");
                for (String field : information) {
                    if (field.trim().equalsIgnoreCase("Gold")) {
                        System.out.println(line.trim());
                        found = true;
                        break;
                    }
                }
            }
            if (!found) {
                System.out.println("No Gold members found.");
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error has occurred: " + e.getMessage());
        }
    }

    void printSilverCustomer() {
        try {
            File f = new File("Customers.txt");
            if (!f.exists()) {
                throw new FileNotFoundException("File does not exist.");
            }
            if (f.length() == 0) {
                System.out.println("Error: The file is empty.");
                return;
            }
            Scanner reader = new Scanner(f);
            System.out.println("Silver Members:");
            boolean found = false;
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] information = line.split(",");
                for (String field : information) {
                    if (field.trim().equalsIgnoreCase("Silver")) {
                        System.out.println(line.trim());
                        found = true;
                        break;
                    }
                }
            }
            if (!found) {
                System.out.println("No Silver members found.");
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error has occurred: " + e.getMessage());
        }
    }

    static {
        loadLastIds();
    }

    public static String generateCustomerId(String membership) {
        String ID = "";
        switch (membership) {
            case "Platinum":
                platinumLastId++;
                ID = "P" + platinumLastId;
                break;
            case "Gold":
                goldLastId++;
                ID = "G" + goldLastId;
                break;
            case "Silver":
                silverLastId++;
                ID = "S" + silverLastId;
                break;
            default:
                System.out.println("Invalid membership type: " + membership);
        }
        saveLastIds();
        return ID;
    }

    private static void loadLastIds() {
        try (Scanner scanner = new Scanner(new File("lastCustomerIds.txt"))) {
            if (scanner.hasNextInt()) platinumLastId = scanner.nextInt();
            if (scanner.hasNextInt()) goldLastId = scanner.nextInt();
            if (scanner.hasNextInt()) silverLastId = scanner.nextInt();
            if (scanner.hasNextInt()) basicLastId = scanner.nextInt();
        } catch (FileNotFoundException e) {
            System.out.println("ID file not found, starting with default values.");
        }
    }

    public int getLastBasicId() {
        try (Scanner scanner = new Scanner(new File("lastCustomerIds.txt"))) {
            if (scanner.hasNextInt()) platinumLastId = scanner.nextInt();
            if (scanner.hasNextInt()) goldLastId = scanner.nextInt();
            if (scanner.hasNextInt()) silverLastId = scanner.nextInt();
            if (scanner.hasNextInt()) basicLastId = scanner.nextInt();
        } catch (FileNotFoundException e) {
            System.out.println("ID file not found, starting with default values.");
        }
        basicLastId++;
        saveLastIds();
        return basicLastId;
    }

    private static void saveLastIds() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("lastCustomerIds.txt"))) {
            writer.println(platinumLastId);
            writer.println(goldLastId);
            writer.println(silverLastId);
            writer.println(basicLastId);
        } catch (IOException e) {
            System.out.println("An error occurred while saving IDs: " + e.getMessage());
        }
    }

    boolean checkCredentials(String id, String pass) {
        try {
            File f = new File("Customers.txt");
            if (f.length() == 0) {
                System.out.println("Error: The file is empty.");
                return false;
            }
            Scanner reader = new Scanner(f);
            while (reader.hasNextLine()) {
                String line = reader.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] fields = line.split(",");
                if (fields.length >= 6) {
                    String fileCustomerId = fields[3].trim();
                    String filePassword = fields[5].trim();
                    if (fileCustomerId.equals(id) && filePassword.equals(pass)) {
                        reader.close();
                        return true;
                    }
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error has occurred: " + e.getMessage());
        }
        return false;
    }

    void deleteMembership(String id, String password) {
        try {
            File f = new File("Customers.txt");
            if (f.length() == 0) {
                System.out.println("The file is empty.");
                return;
            }
            File tempFile = new File("TempCustomers.txt");
            PrintWriter writer = new PrintWriter(tempFile);
            Scanner reader = new Scanner(f);
            boolean isDeleted = false;
            while (reader.hasNextLine()) {
                String line = reader.nextLine().trim();
                String[] information = line.split(",");
                if (information.length >= 6) {
                    String fileId = information[3].trim();
                    String filePassword = information[5].trim();
                    if (fileId.equals(id) && filePassword.equals(password)) {
                        System.out.println("Member deleted: " + line);
                        isDeleted = true;
                    } else {
                        writer.println(line);
                    }
                }
            }
            reader.close();
            writer.close();
            if (!isDeleted) {
                System.out.println("No matching member found for deletion.");
            }
            if (!f.delete()) {
                System.out.println("Failed to delete the original file.");
            } else if (!tempFile.renameTo(f)) {
                System.out.println("Failed to rename the temporary file.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error has occurred: " + e.getMessage());
        }
    }
}

