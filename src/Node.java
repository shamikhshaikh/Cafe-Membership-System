public class Node {
    private String customerName;
    private String lastName;
    private String membership;
    private String customerId;
    private String password;
    private String contactNumber;
    private Node next, prev;

    Node(String customerName, String lastName, String membership,
         String customerId, String password, String contactNumber) {
        this.customerName = customerName;
        this.lastName = lastName;
        this.membership = membership;
        this.customerId = customerId;
        this.password = password;
        this.contactNumber = contactNumber;
        next = null;
        prev = null;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMembership() {
        return membership;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getPassword() {
        return password;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
