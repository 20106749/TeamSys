import java.util.Arrays;
import java.util.Objects;

public class Player {

    // -=+=- Constructor -=+=-
    public Player(String name, int playerNumber, boolean currentSquadMember) {
        // Initialize player properties
        setName(name);
        setPlayerNumber(playerNumber);
        setCurrentSquadMember(currentSquadMember);
        ratings = new int[6]; // An uninitialized int array is automatically filled with default values of 0 in each element.
    }


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
// TODO: 07/12/2023 move the scanner input from setPlayerRatings to Driver // COMPLETE
    public void setPlayerRatings(int[] newRatings) {
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

    public float getAverageRating() {
        // Calculate and return the average rating
        float ratingsTotal = 0;
        for (int i = 0; i < ratings.length; i++) {
            ratingsTotal += ratings[i];
        }
        return ratingsTotal / 6;
    }

    public boolean isCurrentSquadMember() {
        return currentSquadMember;
    }


    // -=+=- Overrides -=+=-
    @Override
    public String toString() {
        // Return a string representation of the player
        return "Player{" +
                "name='" + name + '\'' +
                ", playerNumber=" + playerNumber +
                ", ratings=" + Arrays.toString(ratings) +
                ", currentSquadMember=" + currentSquadMember +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player player)) return false;
        return getPlayerNumber() == player.getPlayerNumber() && isCurrentSquadMember() == player.isCurrentSquadMember() && Objects.equals(getName(), player.getName()) && Arrays.equals(getRatings(), player.getRatings());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getName(), getPlayerNumber(), isCurrentSquadMember());
        result = 31 * result + Arrays.hashCode(getRatings());
        return result;
    }
}
