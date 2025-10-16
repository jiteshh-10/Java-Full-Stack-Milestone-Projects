package TM2;

public class Video {
    String videoName;
    boolean checkout;
    int rating;

    // Constructor to create a new video with a given name
    public Video(String name) {
        this.videoName = name;
        this.checkout = false; // A new video is always available
        this.rating = 0;       // Default rating is 0
    }

    // Returns the name of the video
    public String getName() {
        return videoName;
    }

    // Marks the video as checked out
    public void doCheckout() {
        this.checkout = true;
    }

    // Marks the video as returned
    public void doReturn() {
        this.checkout = false;
    }

    // Sets the rating for the video
    public void receiveRating(int rating) {
        this.rating = rating;
    }

    // Returns the rating of the video
    public int getRating() {
        return rating;
    }

    // Returns the checkout status of the video
    public boolean getCheckout() {
        return checkout;
    }
}