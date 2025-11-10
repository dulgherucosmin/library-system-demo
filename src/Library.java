package src;
import java.util.ArrayList;

/**
 * Library class implementing the Catalogue interface.
 * Represents a library with a collection of books of different types (printed, eboook, audio).
 * Provides functionality to manage books including adding, borrowing, and returning books.
 * Books can be filtered by type.
 */
public class Library implements Catalogue {
    
    private String name;
    private String location;
    private ArrayList<Book> catalogue;

    public Library(
        String name,
        String location
    ) {
        this.name = name;
        this.location = location;
        this.catalogue = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Library Information\nName: " + this.name + "\nLocation: " + this.location;
    }

    @Override
    public void addBook(Book book) {
        // add book to library
        this.catalogue.add(book);
    }

    @Override
    public ArrayList<Book> getAvailableBooks() {
        // gets all books that are not currently borrowed
        ArrayList<Book> availableBooks = new ArrayList<>();

        // cycle through all books in the catalogue
        for (Book b: this.catalogue) {
            // check if book is borrowed
            if (!b.getBorrowed()) {
                // add to the arraylist
                availableBooks.add(b);
            }
        }
        // return array list of available books
        return availableBooks;
    }

    @Override
    public ArrayList<PrintedBook> getPrintedBooks() {
        // return a list of just PrintedBooks
        ArrayList<PrintedBook> printedBooks = new ArrayList<>();

        // cycle through all books in the catalogue
        for (Book b: this.catalogue) {
            // check if book is a printed book
            if (b instanceof PrintedBook) {
                // add to the arraylist
                printedBooks.add((PrintedBook) b);
            }
        }
        // return array list of printed books
        return printedBooks;
    }

    @Override
    public ArrayList<EBook> getEBooks() {
        // return a list of just EBooks
        ArrayList<EBook> eBooks = new ArrayList<>();

        // cycle through all books in the catalogue
        for (Book b: this.catalogue) {
            // check if book is an ebook
            if (b instanceof EBook) {
                // add to the arraylist
                eBooks.add((EBook) b);
            }
        }
        // return array list of ebooks
        return eBooks;
    }

    @Override
    public ArrayList<AudioBook> getAudioBooks() {
        // return a list of just AudioBooks
        ArrayList<AudioBook> audioBooks = new ArrayList<>();

        // cycle through all books in the catalogue
        for (Book b: this.catalogue) {
            // check if book is an audiobook
            if (b instanceof AudioBook) {
                // add to the arraylist
                audioBooks.add((AudioBook) b);
            }
        }
        // return array list of ebooks
        return audioBooks;
    }

    @Override
    public Book borrow(
        String title,
        String author
    ) {
        //checks if a book with the title and author is available
        //return null if not found
        //let the user know if not found or just no copies available.

        // cycle through all books in the catalogue
        for (Book b: this.catalogue) {
            String bookTitle = b.getTitle();
            String bookAuthor = b.getAuthor();
            boolean isBorrowed = b.getBorrowed(); // 

            // check if title and author match
            if (bookTitle.equalsIgnoreCase(title) && bookAuthor.equalsIgnoreCase(author)) {
                // check if book is available (copies are there)
                if (!isBorrowed) {
                    // set status of book to borrowed
                    b.borrow();
                    // return book
                    return b;
                // book is not available (no copies)
                } else if (isBorrowed) {
                    System.out.println("No copies are available to borrow at this time.");
                    return null; // return null
                }
            }
        }
        // book not found
        System.out.println("No book found with that title and author.");
        return null;
    }

    @Override
    public Book borrow(
        String title,
        String author,
        String type
    ) {

        // switch statement for types of 
        switch (type.toLowerCase()) {
            
            case "printedbook":
                // cycle through all printed books
                for (PrintedBook b: this.getPrintedBooks()) {
                    String bookTitle = b.getTitle();
                    String bookAuthor = b.getAuthor();
                    boolean isBorrowed = b.getBorrowed();
                    
                    // check if title and author match
                    if (bookTitle.equalsIgnoreCase(title) && bookAuthor.equalsIgnoreCase(author)) {
                        // check if book is available (copies are there)
                        if (!isBorrowed) {
                            // set status of book to borrowed
                            b.borrow();
                            // return book
                            return b;
                        // book is not available (no copies)
                        } else if (isBorrowed) {
                            System.out.println("No copies are available to borrow at this time.");
                            return null;
                        }
                    }
                }
                // book not found
                System.out.println("No book found with that title and author, in that type of books.");
                return null;
            
            case "ebook":
                // cycle through all printed books
                for (EBook b: this.getEBooks()) {
                    String bookTitle = b.getTitle();
                    String bookAuthor = b.getAuthor();
                    boolean isAvailable = b.getBorrowed();
                    
                    // check if title and author match
                    if (bookTitle.equalsIgnoreCase(title) && bookAuthor.equalsIgnoreCase(author)) {
                        // check if book is available (copies are there)
                        if (isAvailable) {
                            // set status of book to borrowed
                            b.borrow();
                            // return book
                            return b;
                        // book is not available (no copies)
                        } else if (!isAvailable) {
                            System.out.println("No copies are available to borrow at this time.");
                            return null;
                        }
                    }
                }
                // book not found
                System.out.println("No book found with that title and author, in that type of books.");
                return null;

            case "audiobook":
                // cycle through all printed books
                for (AudioBook b: this.getAudioBooks()) {
                    String bookTitle = b.getTitle();
                    String bookAuthor = b.getAuthor();
                    boolean isAvailable = b.getBorrowed();
                    
                    // check if title and author match
                    if (bookTitle.equalsIgnoreCase(title) && bookAuthor.equalsIgnoreCase(author)) {
                        // check if book is available (copies are there)
                        if (isAvailable) {
                            // set status of book to borrowed
                            b.borrow();
                            // return book
                            return b;
                        // book is not available (no copies)
                        } else if (!isAvailable) {
                            System.out.println("No copies are available to borrow at this time.");
                            return null;
                        }
                    }
                }
                // book not found
                System.out.println("No book found with that title and author, in that type of books.");
                return null;

            default:
                System.out.println("Invalid parameters.");
                return null;
        }
    }

    @Override
    public void returnBook(Book book) {
        boolean isBorrowed = book.getBorrowed();

        // check if book is borrowed
        if (isBorrowed) {
            // return book
            book.returnBook();
        } else {
            // book is not currently borrowed, throw error
            throw new RuntimeException("Book is not borrowed and is still available.");
        }
    }

    /*
     * GETTERS
     */
    public String getName() {
        return this.name;
    }

    public String getLocation() {
        return this.location;
    }

    public ArrayList<Book> getCatalogue() {
        return this.catalogue;
    }

}
