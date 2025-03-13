import java.util.ArrayList;

// Create a library using the singleton pattern with lazy initialization 
public class Library {
    private static Library instance;
    private ArrayList<Item> items; // List to store library items

    // Constructor 
    private Library() {
        items = new ArrayList<>();
    }

    // Method to get instance of library 
    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    // Method to add item to library 
    public void addItem(Item item) {
        items.add(item);
    }

    // Method to list available items in library
    public void listAvailableItems() {
        System.out.println("Available Items: ");
        for (Item item : items) {
            System.out.println(item.getTitle());
        }
    }

    // Method to find item in library by title 
    public Item findItemByTitle(String title) {
        for (Item item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        } 
        System.out.println("There is no item matching that title");
        return null;
    }
}
