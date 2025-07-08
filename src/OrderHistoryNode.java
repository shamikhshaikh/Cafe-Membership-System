public class OrderHistoryNode {
    private String customerid;
private String[] items;
private int orderID;
        private OrderHistoryNode next, rear;
OrderHistoryNode(String customerid, String[] items, int orderID)
{
    this.customerid = customerid;
    this.items = new String[10];
    this.orderID = orderID;
    next = null;
    rear = null;
}
public String getCustomerid() {
    return customerid;
}
public OrderHistoryNode getNext() {
    return next;
}
public void setNext(OrderHistoryNode next) {
    this.next = next;
}
public int getOrderID() {
    return orderID;
}
}
