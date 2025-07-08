import java.io.*;
import java.util.Scanner;
public class LinkedListQueue {
    private static OrderHistoryNode front, rear;
    private static int orderid = 0;
    private String customerId;
    private String[] items;
    public static boolean isEmpty() {
        return front == null;
    }
    public int insert(String id, String[] order) {
        setCustomerId(id);
        setItems(order);
        OrderHistoryNode node = new OrderHistoryNode(customerId, items,
                generateOrderId()); // Use generateOrderId here.
        if (isEmpty()) {
            front = rear = node;
        } else {
            rear.setNext(node);
            rear = node;
        }
        writeInFile(customerId, items,orderid);
        return orderid; // Return the Order ID assigned to the node.
    }
    public static void printQueue() {
        OrderHistoryNode temp = front;
        System.out.println("===============================================");
        System.out.println("|                  CAFE QUEUE                  |");
                System.out.println("===============================================");
        if(isEmpty())
        {
            System.out.println(" Cafe Queue Is Empty");
            return;
        }
        while (temp != null) {
            System.out.println("Customer ID = " +
                    temp.getCustomerid());
            System.out.println("Order ID = " + temp.getOrderID());
            System.out.println();
            temp = temp.getNext();
            System.out.println();
        }
    }
    public void writeInFile(String customerid, String[] items, int
            orderId) {
        try {
            FileWriter Writer = new FileWriter("OrderHistory.txt",
                    true);
            Writer.write("Customer ID = " + customerid + "\n");
            Writer.write("Items = \n");
            for (int i = 0; i < items.length; i++) {
                int count = 1;
                while (i < items.length - 1 && items[i].equals(items[i
                        + 1])) {
                    count++;
                    i++;
                }
                Writer.write(items[i] + ", (" + count + ")\n");
            }
            Writer.write("Order Id = " + orderId + "\n \n \n");
            Writer.close();
        }
        catch (IOException e) {
            System.out.println("An error has occurred.");
        }
    }
    public static void printOrderHistory() {
        File Obj = new File("OrderHistory.txt");
        if (!Obj.exists() || Obj.length() == 0) {
            System.out.println("Order history file is empty or does not exist.");
            return;
        }
        try (Scanner Reader = new Scanner(Obj)) {
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                System.out.println(data);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }
    public static int generateOrderId() {
        orderid++;
        saveLastId();
        return orderid;
    }
    private static void saveLastId() {
        try (PrintWriter writer = new PrintWriter(new
                FileWriter("lastOrderId.txt"))) {
            writer.println(orderid);
        } catch (IOException e) {
            System.out.println("An error occurred while saving IDs: " +
                    e.getMessage());
        }
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public void setItems(String[] items) {
        this.items = items;
    }
}