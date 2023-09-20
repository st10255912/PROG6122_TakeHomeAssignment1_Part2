package prog6112_ta1_pt2;

import java.util.Arrays;


public class InventoryManager {
    //setting up variables
    private InventoryItem[] items;
    private int itemCount;
    
    //stores the quantity of items
    public InventoryManager(int maxItems) {
        items = new InventoryItem[maxItems];
        itemCount = 0;
    }
    
    /*
        checks, if the quantity of items is still lower than the max then
        sets the items at that specific item count to what the user inputs
        when the method from the inventoryItem class is called. The user is
        then shown a message letting them know that the item has been added
        
    
        otherwise, in the case that the maximum quantity of items has already
        been reached, the user will be shown a message indicating that the maximum
        number of items has been added.
    */
    public void addItem(String name, double price, int quantity) {
        if(itemCount < items.length) {
            items[itemCount] = new InventoryItem(name, price, quantity);
            itemCount++;
            System.out.println("Item added to the inventory.");
        } else {
            System.out.println("Inventory is full. Cannot add more items.");
        }
    }
    
    public InventoryItem[] getInventory() {
        return Arrays.copyOf(items, itemCount);
    }   
    
    //prints out all the items and their corresponding details in order
    public void viewInventory() {
        System.out.println("");
        System.out.println("Inventory Items:");
        for(int i = 0; i < itemCount; i++) {
            InventoryItem item = items[i];
            System.out.println("Name: " + item.getName());
            System.out.println("Price: R" + item.getPrice());
            System.out.println("Quantity: " + item.getQuantity());
            System.out.println("Total Value: R" + item.getPrice() * item.getQuantity());
            System.out.println();
        }
    }
    
    /*
        the method will look through all the items stored and check
        if the item name that the user enters matches any item that 
        is stored. If it does then the item at that specific position
        in storage will be updated using the updateQuantity method from
        the inventoryItem class. The user is then shown a message letting
        them know that the quantity has been updated.
    
        if the method cannot find anything in storage that matches the item
        name entered, then it will show a message letting the user know that
        the item cannot be found.
    */
    public void updateQuantity(String itemName, int quantity) {
        for(int i = 0; i < itemCount; i++) {
            if(items[i].getName().equalsIgnoreCase(itemName)) {
                items[i].updateQuantity(quantity);
                System.out.println("Quantity updated successfully.");
                return;
            }
        }
        System.out.println("Item not found.");
    }
}

