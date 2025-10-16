package TM7Multithreading;
public class HareAndTortoiseRace {

    // A shared flag to indicate if a winner has been declared.
    // 'volatile' ensures that changes made by one thread are immediately visible to others.
    private static volatile boolean raceOver = false;

    // A runnable class that defines the logic for each racer.
    static class Racer implements Runnable {
        private final String name;

        Racer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int distance = 1; distance <= 100; distance++) {
                // Check if another thread has already finished the race.
                if (raceOver) {
                    System.out.println(name + " loses the race.");
                    break;
                }

                System.out.println(name + " has run " + distance + " meters.");

                // Part c: Logic for the Hare to sleep.
                if (this.name.equals("Hare") && distance == 60) {
                    try {
                        System.out.println(">>>>> The Hare is sleeping... <<<<<");
                        Thread.sleep(1000); // Sleep for 1000 milliseconds (1 second)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Check if this racer has finished.
                if (distance == 100) {
                    // Use a synchronized block to prevent a race condition
                    // where both threads might finish and declare victory simultaneously.
                    synchronized (HareAndTortoiseRace.class) {
                        if (!raceOver) {
                            raceOver = true;
                            System.out.println("\n******************************");
                            System.out.println(name + " WINS THE RACE!");
                            System.out.println("******************************");
                        }
                    }
                    return; // End the run method for the winner.
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Ready... Set... GO!");

        // Create the runnable tasks for Hare and Tortoise
        Racer hareRacer = new Racer("Hare");
        Racer tortoiseRacer = new Racer("Tortoise");

        // Create the threads from the runnable tasks
        Thread hareThread = new Thread(hareRacer, "Hare");
        Thread tortoiseThread = new Thread(tortoiseRacer, "Tortoise");

        // --- UNCOMMENT THE SECTION FOR THE SCENARIO YOU WANT TO RUN ---

        // == SCENARIO A: Default Priorities ==
        // No changes needed, threads run with default priority.

        // == SCENARIO B: Hare has High Priority ==
        // hareThread.setPriority(Thread.MAX_PRIORITY);
        // tortoiseThread.setPriority(Thread.MIN_PRIORITY);

        // == SCENARIO C: Hare Sleeps (Handled inside the Racer's run method) ==
        // No changes needed here, the logic is already in the Racer class.


        // Start both threads to begin the race
        hareThread.start();
        tortoiseThread.start();
    }
}