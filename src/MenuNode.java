class MenuNode {
    private String itemName;
    private int price;
    MenuNode left, right;
    public MenuNode(String itemName, int price) {
        this.itemName = itemName;
        this.price = price;
        this.left = null;
        this.right = null;
    }
    // Getters and Setters
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
class BSTTree {
    private MenuNode root;

    public void insert(String item, int price) {
        if (root == null) {
            root = new MenuNode(item, price);
            return;
        }
        MenuNode temp = root;
        while (true) {
            if (price < temp.getPrice()) {
                if (temp.left == null) {
                    temp.left = new MenuNode(item, price);
                    return;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = new MenuNode(item, price);
                    return;
                }
                temp = temp.right;
            }
        }
    }

    public void inOrder() {
        InOrder(root);
    }

    private void InOrder(MenuNode current) {
        if (current == null) return;
        InOrder(current.left);
        System.out.println(current.getItemName() + " - " + current.getPrice()
                + " rs");
        InOrder(current.right);
    }
}
