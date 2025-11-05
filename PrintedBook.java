// Dulgheru Cosmin Alexandru 3161052

public class PrintedBook extends Book {
    
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
        if (this.cover.equalsIgnoreCase("paperback") || this.cover.equalsIgnoreCase("hardback")){
            this.cover = cover;
        } else {
            // invalid cover, throw error
            throw new IllegalStateException("Cover must be either Paperback or Hardback.");
        }
        
        // validate whether page length is non negative
        if (pageLength > 0) {
            this.pageLength = pageLength;
        } else {
            // page length is non negative or zero, throw error
            throw new IllegalStateException("Page length must be an integer above 0.");
        }

    }
    // display class info
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
            throw new IllegalStateException("Cover must be either Paperback or Hardback.");
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
            throw new IllegalStateException("Page length must be an integer above 0.");
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
