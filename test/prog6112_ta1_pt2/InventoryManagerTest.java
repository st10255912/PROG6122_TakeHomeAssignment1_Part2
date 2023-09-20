package prog6112_ta1_pt2;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class InventoryManagerTest {
    
    private InventoryManager inventoryManager;

    @Before
    public void setUp() {
        // Initialize the inventory manager before each test
        inventoryManager = new InventoryManager(10); // Assuming a maximum capacity of 10 items
    }

    @Test
    public void testAddItem() {
        // Test adding an item to the inventory
        inventoryManager.addItem("Item1", 10.0, 5);
        assertEquals(1, inventoryManager.getInventory().length); // Check if an item is added
    }

    @Test
    public void testViewInventory() {
        // Test viewing the inventory
        inventoryManager.addItem("Item1", 10.0, 5);
        inventoryManager.addItem("Item2", 15.0, 3);

        String expectedOutput = "Name: Item1\n" +
                                "Price: R10.0\n" +
                                "Quantity: 5\n" +
                                "Total Value: R50.0\n" +
                                "\n" +
                                "Name: Item2\n" +
                                "Price: R15.0\n" +
                                "Quantity: 3\n" +
                                "Total Value: R45.0\n" +
                                "\n";

        assertEquals(expectedOutput, viewInventoryToString(inventoryManager.getInventory())); // Check if the output matches
    }

    @Test
    public void testUpdateQuantity() {
        // Test updating item quantity
        inventoryManager.addItem("Item1", 10.0, 5);

        // Increase the quantity of Item1 by 2
        inventoryManager.updateQuantity("Item1", 2);

        assertEquals(7, inventoryManager.getInventory()[0].getQuantity()); // Check if the quantity is updated
    }

    // Helper method to convert inventory to string for comparison
    private String viewInventoryToString(InventoryItem[] inventory) {
        StringBuilder sb = new StringBuilder();
        for (InventoryItem item : inventory) {
            sb.append("Name: ").append(item.getName()).append("\n");
            sb.append("Price: R").append(item.getPrice()).append("\n");
            sb.append("Quantity: ").append(item.getQuantity()).append("\n");
            sb.append("Total Value: R").append(item.getPrice() * item.getQuantity()).append("\n\n");
        }
        return sb.toString();
    }
    
}

