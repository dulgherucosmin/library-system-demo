public class PrintedBook extends Book {
    
    /*
     * PrintedBook class for handling 'paperback / hardback' type data in the library system.
     * Inherits from the 'Book' abstract class and adds the ability to handle type of cover (Paperback/Hardback) and page length.
     */

    private int pageLength;
    private String cover; // 'PaperBack' or 'HardBack'

    public PrintedBook(
        String title,
        String author,
        String cover,
        int pageLength
    ) {
        super(title, author);
        // validate whether cover is 'paperback' or 'hardback'
        if (cover.equalsIgnoreCase("paperback") || cover.equalsIgnoreCase("hardback")){
            this.cover = cover;
        } else {
            // invalid cover, throw error
            throw new RuntimeException("Cover must be either Paperback or Hardback.");
        }
        
        // validate whether page length is non negative
        if (pageLength > 0) {
            this.pageLength = pageLength;
        } else {
            // page length is non negative or zero, throw error
            throw new RuntimeException("Page length must be an integer above 0.");
        }

    }

    // override toString method to display class info 
    @Override
    public String toString() {
        return "Title: " + super.getTitle() + "\nAuthor: " + super.getAuthor() + "\nPage Length: " + this.pageLength + "\nCover: " + this.cover + "\nBorrowed: " + super.getBorrowed();
    }
    
    /*
     * SETTERS
     */
    public void setCover(
        String newCover
    ) {
        // validate whether cover is 'paperback' or 'hardback'
        if (newCover.equalsIgnoreCase("paperback") || newCover.equalsIgnoreCase("hardback")) {
            this.cover = newCover;
        } else {
            // invalid cover, throw error
            throw new RuntimeException("Cover must be either Paperback or Hardback.");
        }
    }

    public void setPageLength(
        int newPageLength
    ) {
        // validate whether page length is non negative
        if (newPageLength > 0) {
            this.pageLength = newPageLength;
        } else {
            // page length is non negative or zero, throw error
            throw new RuntimeException("Page length must be an integer above 0.");
        }
    }

    /*
     * GETTERS
     */

    public String getCover() {
        return this.cover;
    }

    public int getPageLength() {
        return this.pageLength;
    }
    
}
