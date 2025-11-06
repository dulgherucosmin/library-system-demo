public class EBook extends Book {

    /*
     * TODO: comment about Ebook class
     */

    private String format;
    private int pageLength;
    private double size; // in MB

    public EBook(
        String title,
        String author,
        String format,
        int pageLength,
        double size
    ) {
        super(title, author);
        this.format = format;

        // validate whether page length is non negative
        if (pageLength > 0) {
            this.pageLength = pageLength;
        } else {
            // page length is non negative or zero, throw error
            throw new IllegalStateException("Page length must be an integer above 0.");
        }

        // validsate whether size is non negative
        if (size > 0) {
            this.size = size;
        } else {
            // size is non negative or zero, throw error
            throw new IllegalStateException("Size must be a number 0 MB.");
        }
    }

    /*
     * SETTERS
     */
    public void setFormat(String newFormat) {
        this.format = newFormat;
    }

    public void setPageLength(int newPageLength) {
        // validate whether page length is non negative
        if (newPageLength > 0) {
            this.pageLength = newPageLength;
        } else {
            // page length is non negative or zero, throw error
            throw new IllegalStateException("Page length must be an integer above 0.");
        }
    }

    public void setSize(double newSize) {
        // validsate whether size is non negative
        if (newSize > 0) {
            this.size = newSize;
        } else {
            // size is non negative or zero, throw error
            throw new IllegalStateException("Size must be a number 0 MB.");
        }
    }

    /*
     * GETTERS
     */
    public String getFormat() {
        return this.format;
    }

    public int pageLength() {
        return this.pageLength;
    }

    public double getSize() {
        return this.size;
    }

}
