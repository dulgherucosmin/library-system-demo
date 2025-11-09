/**
 * Audiobook class for handling 'audiobook' type data in the library system.
 * Inherits from the 'Book' abstract class and adds the ability to handle narrator, audio length (in hours), and size (in MB).
 */
public class AudioBook extends Book {

    private String narrator;
    private double audioLength; // in hours
    private double size; // in MB

    public AudioBook(
        String title,
        String author,
        String narrator,
        double audioLength,
        double size
    ) {
        super(title, author);
        this.narrator = narrator;

        // validate whether audio length is non negative
        if (audioLength > 0) {
            this.audioLength = audioLength;
        } else {
            // audio length is non negative or zero, throw error
            throw new RuntimeException("Audio length must be a number above 0.");
        }

        // validsate whether size is non negative
        if (size > 0) {
            this.size = size;
        } else {
            // size is non negative or zero, throw error
            throw new RuntimeException("Size must be a number 0 MB.");
        }
    }

    // override toString method to display class info 
    @Override
    public String toString() {
        return "Title: " + super.getTitle() + "\nAuthor: " + super.getAuthor() + "\nNarrator: " + this.narrator + "\nAudio Length: " + this.audioLength + " hours" + "\nSize: " + this.size + " MB";
    }

    /*
     * SETTERS
     */
    public void setNarrator(String newNarrator) {
        this.narrator = newNarrator;
    }

    public void setAudioLength(double newAudioLength) {
        // validate whether audio length is non negative
        if (newAudioLength > 0) {
            this.audioLength = newAudioLength;
        } else {
            // audio length is non negative or zero, throw error
            throw new RuntimeException("Audio length must be a number above 0.");
        }
    }

    public void setSize(double newSize) {
        // validate whether size is non negative
        if (newSize > 0) {
            this.size = newSize;
        } else {
            // size is non negative or zero, throw error
            throw new RuntimeException("Size must be a number 0 MB.");
        }
    }

    /*
     * GETTERS
     */
    public String getNarrator() {
        return this.narrator;
    }

    public double getAudioLength() {
        return audioLength;
    }

    public double getSize() {
        return this.size;
    }

}
