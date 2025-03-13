import java.util.Scanner;
// Main Class
public class LibraryTest {
    public static void main(String[] args) {
        // Get singleton instance of library 
        Library library = Library.getInstance();

        // Create two books and one magazine
        Item book1 = LibraryItemFactory.createItem("book" , "The Lightning Thief", 2005, "Rick Riordan");
        Item book2 = LibraryItemFactory.createItem("book", "The Catcher in the Rye", 1951, "J. D. Salinger");
        Item magazine1 = LibraryItemFactory.createItem("magazine", "Vogue", 2025, "22");

        // Add to library
        library.addItem(book1);
        library.addItem(book2);
        library.addItem(magazine1);

        Scanner scanner = new Scanner(System.in);
        
        // Create User Menu
        while (true) {
            System.out.println("---Welcome to the Library---");
            System.out.println("1. View Available Items");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search by Title");
            System.out.println("5. Exit Library");
            System.out.println("Enter your choice:");
            
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number 1-5.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt(); // Reads choice
            scanner.nextLine();

            switch(choice) {
                case 1: 
                // Display avaliable items
                    library.listAvailableItems();
                    break;
                case 2:
                // Borrow a book
                    System.out.println("Enter the title of the book you want to borrow:");
                    String borrowTitle = scanner.nextLine();
                    Item borrowItem = library.findItemByTitle(borrowTitle);
                    if (borrowItem instanceof Book) {
                    System.out.print("Enter your name: ");
                    String borrowerName = scanner.nextLine();
                    ((Book) borrowItem).borrowItem(borrowerName);
                    }
                    break;
                case 3:
                // Return a book
                    System.out.print("Enter the title of the item you want to return:");
                    String returnTitle = scanner.nextLine();
                    Item returnItem = library.findItemByTitle(returnTitle);
                    if (returnItem instanceof Book) {
                        ((Book) returnItem).returnItem();
                        System.out.println("Item returned");
                    }
                    break;
                case 4:
                // Search for an item
                    System.out.print("Enter the title of the item:");
                    String searchTitle = scanner.nextLine();
                    Item searchItem = library.findItemByTitle(searchTitle);
                    if (searchItem != null) {
                        System.out.println("Item found: " + searchItem.getTitle());
                    } else {
                        System.out.println("That item could not be found");
                    }
                    break;
                case 5:
                // Exit Library system
                    System.out.println("Exiting Library. Come again!");
                    scanner.close();
                    return;
                default:
                // Error if something other than 1-5 is pressed
                    System.out.println("Invalid choice. Please enter a number 1-5");
            }
        }
    }
}
