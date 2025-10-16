package TM2;


public class VideoStore {
    private Video[] store; // Array to hold the inventory of videos
    private int videoCount;  // To keep track of the number of videos currently in the store

    // Constructor
    public VideoStore() {
        // Let's assume the store can hold a maximum of 10 videos
        this.store = new Video[10];
        this.videoCount = 0;
    }

    // Add a new video to the store
    public void addVideo(String name) {
        if (videoCount < store.length) {
            store[videoCount] = new Video(name);
            videoCount++;
            System.out.println("Video \"" + name + "\" added successfully.");
        } else {
            System.out.println("The store is full, cannot add more videos.");
        }
    }

    // Find a video by name and check it out
    public void doCheckout(String name) {
        for (int i = 0; i < videoCount; i++) {
            if (store[i].getName().equals(name)) {
                store[i].doCheckout();
                System.out.println("Video \"" + name + "\" checked out successfully.");
                return;
            }
        }
        System.out.println("Sorry, could not find the video \"" + name + "\".");
    }

    // Find a video by name and return it
    public void doReturn(String name) {
        for (int i = 0; i < videoCount; i++) {
            if (store[i].getName().equals(name)) {
                store[i].doReturn();
                System.out.println("Video \"" + name + "\" returned successfully.");
                return;
            }
        }
        System.out.println("Sorry, could not find the video \"" + name + "\".");
    }

    // Find a video by name and set its rating
    public void receiveRating(String name, int rating) {
        for (int i = 0; i < videoCount; i++) {
            if (store[i].getName().equals(name)) {
                store[i].receiveRating(rating);
                System.out.println("Rating \"" + rating + "\" has been mapped to the Video \"" + name + "\".");
                return;
            }
        }
        System.out.println("Sorry, could not find the video \"" + name + "\".");
    }

    // List all videos in the inventory
    public void listInventory() {
        if (videoCount == 0) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("----------------------------------------------------------");
        System.out.printf("%-20s | %-15s | %-10s\n", "Video Name", "Checkout Status", "Rating");
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < videoCount; i++) {
            System.out.printf("%-20s | %-15s | %-10d\n", store[i].getName(), store[i].getCheckout(), store[i].getRating());
        }
        System.out.println("----------------------------------------------------------");
    }
}