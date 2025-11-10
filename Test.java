import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    
    public static void main(String[] args) {
        
        // initialise library
        Library library = new Library("Cosmin's Library", "Dublin, Ireland");
        String libraryName = library.getName();
        String libraryLocation = library.getLocation();

        // add different books to the library
        library.addBook(
            new AudioBook("The Final Empire", "Brandon Sanderson", "Michael Kramer", 25, 20)
        );

        library.addBook(
            new AudioBook("The Dragon Republic", "R.F Kuang", "Morag Sims", 18.5, 15)
        );

        library.addBook(
            new EBook("Oathbringer", "Brandon Sanderson", "pdf", 1258, 5.2)
        );

        library.addBook(
            new EBook("Yellowface", "R.F Kuang", "pdf", 559, 2.3)
        );

        library.addBook(
            new PrintedBook("The Way of Kings", "Brandon Sanderson", "Paperback", 1258)
        );

        library.addBook(
            new PrintedBook("Words of Radiance", "Brandon Sanderson", "Hardback", 1258)
        );

        library.addBook(
            new PrintedBook("Katabasis", "R.F Kuang", "Paperback", 541)
        );
        library.addBook(
            new PrintedBook("The Poppy War", "R.F Kuang", "Hardback", 560)
        );

        Scanner sc = new Scanner(System.in);
        String input, title, author, type;
        Book borrowing;

        while (true) {
            System.out.println("------------------------------------");
            System.out.println("Welcome to " + libraryName);
            System.out.println(libraryLocation);
            System.out.println("------------------------------------");
            System.out.println("Please select one of the following:");
            System.out.println("------------------------------------");
            System.out.println("1. See all available books.");
            System.out.println("2. Filter books by type. (Audiobooks, Ebooks, Printed Books)");
            System.out.println("3. Borrow a book.");
            System.out.println("4. Borrow a book of a certain type.");
            System.out.println("5. Return a book.");
            System.out.println("6. Quit.");
            System.out.println("------------------------------------");

            input = sc.nextLine();

            switch (input) {
                // all available books
                case "1": 
                    System.out.println("\n\nDisplaying all available books..");
                    // get arraylist of all available books in the catalogue
                    ArrayList<Book> availableBooks = library.getAvailableBooks();
                    
                    // loop through all the available books
                    for (Book b: availableBooks) {
                        // print out book info using toString method
                        System.out.println(b.toString() + "\n");
                    }

                    break;
                
                // filter book by type (audio, ebook, printed)
                case "2":
                    System.out.println("What type of books would you like to see? (Audiobook, Ebook, PrintedBook)");
                    String filter = sc.nextLine();

                    // filter by audio books
                    if (filter.equalsIgnoreCase("audiobook") || filter.equalsIgnoreCase("audiobooks")) {
                        // get arraylist of all available books that are 'audio' books
                        ArrayList<AudioBook> books = library.getAudioBooks();

                        // loop through the books
                        for (AudioBook b: books) {
                            // print out book info using toString method
                            System.out.println(b.toString() + "\n");
                        }
                    }
                    // filter by ebook books
                    else if (filter.equalsIgnoreCase("ebook") || filter.equalsIgnoreCase("ebooks")) {
                        // get arraylist of all available books that are 'audio' books
                        ArrayList<EBook> books = library.getEBooks();

                        // loop through the books
                        for (EBook b: books) {
                            // print out book info using toString method
                            System.out.println(b.toString() + "\n");
                        }
                    } 
                    // filter by printed books
                    else if (filter.equalsIgnoreCase("printedbook") || filter.equalsIgnoreCase("printedbooks")) {
                        // get arraylist of all available books that are 'audio' books
                        ArrayList<PrintedBook> books = library.getPrintedBooks();

                        // loop through the books
                        for (PrintedBook b: books) {
                            // print out book info using toString method
                            System.out.println(b.toString() + "\n");
                        }
                    }
                    // default case, break back to menu 
                    else { break; }

                    break;

                // borrow a book
                case "3":
                    // ask the user to input details of the book they want to borrow
                    System.out.println("Enter the title of the book you would like to borrow.");
                    title = sc.nextLine();
                    System.out.println("Enter the author of the book you would like to borrow.");
                    author = sc.nextLine();

                    // borrow book
                    borrowing = library.borrow(title, author);
                    
                    // book successfully borrowed
                    if (borrowing != null) {
                        System.out.println("\nBorrowed book.\n");
                    }

                    break;
                
                // borrow book of a certain type
                case "4":
                    // ask the user to input details of the book they want to borrow
                    System.out.println("Enter the type of the book you would like to borrow. (Audiobook, EBook, PrintedBook)");
                    type = sc.nextLine();
                    System.out.println("Enter the title of the book you would like to borrow.");
                    title = sc.nextLine();
                    System.out.println("Enter the author of the book you would like to borrow.");
                    author = sc.nextLine();

                    // borrow book
                    borrowing = library.borrow(title, author, type);
                    
                    
                    // book successfully borrowed
                    if (borrowing != null) {
                        System.out.println("\nBorrowed book.\n");
                    }

                    break;

                // return a book
                case "5":
                    // ask the user to input details of the book they want to return
                    System.out.println("Enter the title of the book you would like to return.");
                    title = sc.nextLine();
                    System.out.println("Enter the author of the book you would like to return.");
                    author = sc.nextLine();

                    ArrayList<Book> allBooks = library.getCatalogue();

                    // loop through all books
                    for (Book b: allBooks) {
                        String bookTitle = b.getTitle();
                        String bookAuthor = b.getAuthor();

                        // check if user inputs and book match
                        if (bookTitle.equalsIgnoreCase(title) && bookAuthor.equalsIgnoreCase(author)) {
                            // set status of the book to available / return book
                            library.returnBook(b);
                            System.out.println("Returned book");
                        }
                    }

                    break;

                // quit
                case "6":
                    sc.close();
                    return;
            }
        }

    }

}
