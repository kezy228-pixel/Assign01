import java.util.Scanner;

/**
 * The GroceryManagementSystem class provides a console-based application to manage a grocery
 * store's inventory.
 */
public class GroceryManagementSystem {

  /**
   * Runs the interactive grocery menu. Loops until the user chooses to exit, letting them view the
   * inventory or restock an item.
   *
   * @param args command-line arguments (not used).
   */
  public static void main(String[] args) {
    String[] itemNames = new String[10];
    double[] itemPrices = new double[10];
    int[] itemStocks = new int[10];

    // Sample data
    itemNames[0] = "Apple";
    itemPrices[0] = 1.20;
    itemStocks[0] = 50;
    itemNames[1] = "Banana";
    itemPrices[1] = 0.50;
    itemStocks[1] = 100;
    itemNames[2] = "Orange";
    itemPrices[2] = 1.50;
    itemStocks[2] = 0;
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("\n--- Grocery Management System ---");
      System.out.println("1. View Inventory");
      System.out.println("2. Restock Item");
      System.out.println("3. Exit");
      System.out.print("Enter your choice (1-3): ");

      String choice = scanner.nextLine();

      switch (choice) {
        case "1":
          printInventory(itemNames, itemPrices, itemStocks);
          break;
        case "2":
          System.out.print("Enter item name to restock: ");
          String target = scanner.nextLine();
          System.out.print("Enter amount to add: ");
          try {
            int amount = Integer.parseInt(scanner.nextLine());
            restockItem(itemNames, itemStocks, target, amount);
          } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Please enter a whole number.");
          }
          break;
        case "3":
          System.out.println("Exiting system. Goodbye!");
          scanner.close();
          return;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
  }

  /**
   * Prints the current inventory to the console.
   *
   * @param names Array of item names.
   * @param prices Array of item prices.
   * @param stocks Array of item stock quantities.
   */
  public static void printInventory(String[] names, double[] prices, int[] stocks) {
    for (int i = 0; i < names.length; i++) {
      if (names[i] != null) {
        System.out.printf(
            "%d. %-15s | Price: $%.2f | Stock: %d%n", (i + 1), names[i], prices[i], stocks[i]);
      } else {
        // Empty slot, skipped
      }
    }
  }

  /**
   * Restocks a specific item by adding a given amount to its current stock.
   *
   * @param names Array of item names.
   * @param stocks Array of item stock quantities.
   * @param target The name of the item to restock.
   * @param amount The amount to add to the stock.
   */
  public static void restockItem(String[] names, int[] stocks, String target, int amount) {
    boolean found = false;
    for (int i = 0; i < names.length; i++) {
      if (names[i] != null && names[i].equalsIgnoreCase(target)) {
        stocks[i] += amount;
        System.out.println("Successfully restocked " + target + ". New stock: " + stocks[i]);
        found = true;
        break;
      }
    }
    if (!found) {
      System.out.println("Item not found.");
    }
  }
}
