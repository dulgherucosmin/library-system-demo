public abstract class Book {

    /*
     * Abstract book class acting as a baseline for other types of books to
     * inherit from, such as Ebooks and PrintedBooks. Book class allows for basic information
     * such as title, author, and status (whether or not a book is borrowed) and displays information.
     */

    private String title;
    private String author;
    private boolean borrowed;

    public Book(
        String title,
        String author
    ) {
        this.title = title;
        this.author = author;
        this.borrowed = false;
    }

    // method to borrow book
    public void borrow() {
        // check if not already borrowed
        if (!this.borrowed) {
            this.borrowed = true;
        } else {
            // if borrowed, throw error message 
            throw new IllegalStateException("Book is already borrowed.");
        }
    }

    // TODO: check out 'return' not working
    public void returnBook() {
        // check if book is borrowed
        if (this.borrowed) {
            this.borrowed = false;
        } else {
            // if not borrowed, throw error message
            throw new IllegalStateException("Book has not been borrowed.");
        }
    }

    // display class info
    @Override
    public String toString() {
        return "Title: " + this.title + "\nAuthor: " + this.author + "\nBorrowed: " + this.borrowed;
    }

    /* 
     GETTERS
     */

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public boolean getBorrowed() {
        return this.borrowed;
    }

}