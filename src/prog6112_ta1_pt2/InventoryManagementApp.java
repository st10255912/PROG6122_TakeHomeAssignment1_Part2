package prog6112_ta1_pt2;

import java.util.Scanner;


public class InventoryManagementApp {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Welcome to the Inventory Management System!");

        /*
            creating the inventoryManager object, setting the limit to 50 simply because its a project
            and there's no need to make it any larger. 
        
            This program could be used in other ways, for example, it could be adjusted to be used as
            an inventory manager of a simple game. However, in this specific program it is used as an
            inventory manager for a small shop/store. Such stores have limited space, so having a limit
            is actually very important, it allows the store to know when it has reached the maximum amount
            of stock it can store.
        */
        InventoryManager inventoryManager = new InventoryManager(50);
        
        /*
            The user will be shown a menu, from which they can select the proceeding action.
            
            1. Allows the user to add a new item to the inventory or the same item at a different price point
            2. Simply prints out all of the items in the inventory
            3. Allows the user the update the quantity of the item that is in stock, it will automatically update
               the total price of the item quantity.
            4. Exits the program.
        */
        while(true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add an Item to Inventory");
            System.out.println("2. View Inventory");
            System.out.println("3. Update Item Quantity");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = kb.nextInt();
            kb.nextLine(); // Consume the newline character
            
            /*
                switch case for whichever option the user selected from the menu
            
                1. ask the user for the item name, price and quantity and then adds it using a method 
                   from the inventoryManager class.
                2. calls the viewInventory method from the inventoryManager class
                3. ask the user what item they would like to update and by how much they would like to update it by
                   then calls the updateQuantity method from the inventoryManger class to search and see if the item
                   the user entered matches any item that is in the inventory, if there is a match then the user will
                   be shown a message to let them know that the quantity has been updated. If there is no match, then
                   the user will be shown a message to let them know that the item that they searched for is not in stock.
                4. shows a goodbye message to the user and then exits the program.
            */
            switch(choice) {
                case 1:
                    System.out.println("");
                    System.out.print("Enter item name: ");
                    String itemName = kb.nextLine();
                    System.out.print("Enter item price: R");
                    double itemPrice = kb.nextDouble();
                    System.out.print("Enter item quantity: ");
                    int itemQuantity = kb.nextInt();
                    inventoryManager.addItem(itemName, itemPrice, itemQuantity);
                    break;
                case 2:
                    inventoryManager.viewInventory();
                    break;
                case 3:
                    System.out.print("Enter item name to update quantity: ");
                    String updateItemName = kb.nextLine();
                    System.out.print("Enter quantity change (+/-): ");
                    int quantityChange = kb.nextInt();
                    inventoryManager.updateQuantity(updateItemName, quantityChange);
                    break;
                case 4:
                    System.out.println("Thank you for using the Inventory Management System!");
                    kb.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
