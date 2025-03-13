// Create Factory Patter for Item Creation
public class LibraryItemFactory {
    
    // Creates item based on type
    public static Item createItem(String type, String title, int publicationYear, String extraData) {

        // Creates a book
        if (type.equalsIgnoreCase("book")) {
            return new Book(title, publicationYear, extraData, "ISBN22");
        } else if (type.equalsIgnoreCase("magazine")) { // Creates a magazine
            return new Magazine(title, publicationYear, Integer.parseInt(extraData));
        } else { // Null if different type
            return null;
        }
    } 
}
