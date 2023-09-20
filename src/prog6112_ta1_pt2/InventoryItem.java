package prog6112_ta1_pt2;

public class InventoryItem {
    //Setting up variables
    private String name;
    private double price;
    private int quantity;
    
    //instead of making multiple set methods, just used one for all variables
    public InventoryItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    //get method for the name of the item
    public String getName() {
        return name;
    }
    
    //get method for the price of the item
    public double getPrice() {
        return price;
    }
    
    //get method for the quantity of items
    public int getQuantity() {
        return quantity;
    }
    
    //calls the quantity variable and add the additional quantity to it
    public void updateQuantity(int quantity) {
        this.quantity += quantity;
    }
}
