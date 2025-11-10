package src;
import java.util.ArrayList;

/**
 * Catalogue interface for the Library class.
 * Template given in assignment brief.
 */
interface Catalogue {

    /*
     * Interface to act as a baseline for the 'Library' class.
     */

    public void addBook(Book book);
    //add book to library

    public ArrayList<Book> getAvailableBooks();
    // gets all books that are not currently borrowed

    public ArrayList<PrintedBook> getPrintedBooks();
    //return a list of just PrintedBooks

    public ArrayList<EBook> getEBooks();
    //return a list of just EBooks

    public ArrayList<AudioBook> getAudioBooks();
    //return a list of just AudioBooks

    public Book borrow(String title, String author) ;
    //checks if a book with the title and author is available
    //return null if not found
    //let the user know if not found or just no copies available. 

    public Book borrow(String title, String author, String type) ;
    //checks if a book of that type with the title and author is available
    //return null if not found
    //let the user know if not found or just no copies available. 

    public void returnBook(Book book);
    //update the book to not borrowed

}
