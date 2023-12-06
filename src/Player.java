import java.util.Arrays;
import java.util.Scanner;

public class Player {
    // -=+=- Fields -=+=-
    private String name;
    private int playerNumber = 23;
    private int[] ratings;
    private boolean currentSquadMember;

    // -=+=- Setters -=+=-
    public void setName(String name) {
        // Ensure the name does not exceed 20 characters
        if (name.length() <= 20) {
            this.name = name;
        } else {
            // If longer than 20 characters, truncate it
            this.name = name.substring(0, 20);
        }
    }

    public void setPlayerNumber(int playerNumber) {
        // Ensure player number is not greater than 23
        if (playerNumber <= 23) {
            this.playerNumber = playerNumber;
        }
    }

    public void setPlayerRatings() {
        Scanner scanner = new Scanner(System.in);
        int[] newRatings = new int[6];

        for (int i = 0; i < 6; i++) {
            // Ask the user for input
            System.out.print("Enter rating for index " + i + " (between 0 and 5 inclusive): ");

            // Validate the input
            while (true) {
                String input = scanner.next();
                try {
                    newRatings[i] = Integer.parseInt(input);

                    // Validate the input range
                    if (newRatings[i] < 0 || newRatings[i] > 5) {
                        System.out.println("Invalid rating value. Please enter a value between 0 and 5.");
                        continue; // Ask the user again for a valid input
                    }

                    // Break out of the loop if the input is valid
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an integer value.");
                }
            }
        }

        // Set the validated ratings to the player
        this.ratings = newRatings;
    }

    public void setCurrentSquadMember(boolean currentSquadMember) {
        // Set whether the player is a current squad member
        this.currentSquadMember = currentSquadMember;
    }

    // -=+=- Getters -=+=-
    public String getName() {
        return name;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public int[] getRatings() {
        return ratings;
    }

    public int getAverageRating() {
        // Calculate and return the average rating
        int ratingsTotal = 0;
        for (int i = 0; i < ratings.length; i++) {
            ratingsTotal += ratings[i];
        }
        return ratingsTotal / 6;
    }

    public boolean isCurrentSquadMember() {
        return currentSquadMember;
    }

    // -=+=- Constructor -=+=-
    public Player(String name, int playerNumber, boolean currentSquadMember) {
        // Initialize player properties
        setName(name);
        setPlayerNumber(playerNumber);
        setCurrentSquadMember(currentSquadMember);
        ratings = new int[6]; // An uninitialized int array is automatically filled with default values of 0 in each element.
    }

    // -=+=- toString -=+=-
    public String toString() {
        // Return a string representation of the player
        return "Player{" +
                "name='" + name + '\'' +
                ", playerNumber=" + playerNumber +
                ", ratings=" + Arrays.toString(ratings) +
                ", currentSquadMember=" + currentSquadMember +
                '}';
    }

    // -=+=- Main method for testing -=+=-
    public static void main(String[] args) {
        // Create a player, set ratings, and print the player details
        Player player = new Player("John", 7, true);
        player.setPlayerRatings();
        System.out.println(player.toString());
    }
}
