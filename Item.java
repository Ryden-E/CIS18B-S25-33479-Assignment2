// Base class with title and publication year attributes
public class Item {
    private String title; 
    private int publicationYear;

    // Constructor 
    public Item(String title, int year) {
        this.title = title;
        publicationYear = year;
    }

    // Getter methods 
    public String getTitle() {
        return title;
    }

    public int getYear() {
        return publicationYear;
    }
}

// Create an interface to borrow and return items
interface Iborrowable{
    void borrowItem(String borrower);
    void returnItem();
    boolean isBorrowed();
}

// Create subclass of item that adds author and ISBN
class Book extends Item implements Iborrowable { // Implement Iborrowable interface in Book
    private String author;
    private String ISBN;
    private String borrower;

    // Constructor 
    public Book(String title, int year, String author, String ISBN) {
        super(title, year);
        this.author = author;
        this.ISBN = ISBN;
    }

    // Getter methods 
    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    // Method to borrow items
    public void borrowItem(String borrower) {
        if (this.borrower == null) { // Checks if item is already borrowed
            this.borrower = borrower;
        } else {
            System.out.println("This item has already been borrowed");
        }
    }

    // Method to return items
    public void returnItem() {
        this.borrower = null;
    }

    public boolean isBorrowed() {
       return this.borrower != null;
    }
}

// Create subclass of item that adds issueNumber
class Magazine extends Item {
    private int issueNumber;

    // Constructor
    public Magazine(String title, int year, int issueNumber) {
        super(title, year);
        this.issueNumber = issueNumber;
    }

    // Getter Method
    public int getIssue() {
        return issueNumber;
    }
}


