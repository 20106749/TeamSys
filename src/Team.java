import java.util.Arrays;
import java.util.Objects;

public class Team {

    public Team(int numPlayers) {
        players = new Player[numPlayers];
    }
    // -=+=- Fields -=+=-
    private Player[] players;
    private int total = 0;

    // -=+=- Team Size -=+=-
    private boolean isEmpty() {
        return total == 0;
    }

    private boolean isFull() {
        return total == players.length;
    }

    // -=+=- Getters and Setters -=+=-
    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public int getTotal() { // also kina part of -=+=- Team Size -=+=-
        return total;
    }

    // -=+=- Player Operations -=+=-
    public boolean add(Player player) {
        if (isFull()) {
            return false;
        } else {
            players[total] = player;
            total++;
            return true;
        }
    }

    public Player getPlayer(int index) {
        if (index >= 0 && index < total)
            return players[index];
        return null;
    }

    public Player addPlayerToSquad(int index) {
        Player found = players[index];
        found.setCurrentSquadMember(true);
        return found;
    }

    public Player removePlayerFromSquad(int index) {
        Player found = players[index];
        found.setCurrentSquadMember(false);
        return found;
    }

    // -=+=- Team Information -=+=-
    public String listPlayers() {
        if (isEmpty()) {
            return "No players on the team";
        } else {
            String listOfPlayers = "";
            for (int i = 0; i < total; i++) {
                listOfPlayers += i + ": " + players[i] + "\n";
            }
            return listOfPlayers;
        }
    }

    public String listCurrentPlayers() {
        if (isEmpty()) {
            return "No players on the team";
        } else {
            String listOfPlayers = "";
            for (int i = 0; i < total; i++) {
                if (players[i].isCurrentSquadMember())
                    listOfPlayers += i + ": " + players[i] + "\n";
            }
            if (listOfPlayers.isEmpty()) {
                return "No players are in our current squad";
            } else {
                return listOfPlayers;
            }
        }
    }

    public String listPlayersAboveGivenAverageRating(double averageRating) {
        if (isEmpty()) {
            return "No players on the team";
        } else {
            String listOfPlayers = "";
            for (int i = 0; i < total; i++) {
                if (players[i].getAverageRating() > averageRating)
                    listOfPlayers += i + ": " + players[i] + " " + players[i].getAverageRating() + "\n";
            }
            if (listOfPlayers.isEmpty()) {
                return "No players averageRating above given averageRating";
            } else {
                return listOfPlayers;
            }
        }
    }

    public String listOfPlayerwithAverageRating() {
        if (isEmpty()) {
            return "No players on the team";
        } else {
            String listOfPlayers = "";
            for (int i = 0; i < total; i++) {
                listOfPlayers += i + ": " + players[i].getName() +
                        " " + players[i].getAverageRating() + "\n";
            }
            return listOfPlayers;
        }
    }

    // -=+=- Player Statistics -=+=-
    public double averageofPlayersAvgRating() {
        double ratingsTotal = 0;
        for (int i = 0; i < total; i++) {
            ratingsTotal += players[i].getAverageRating();
        }
        return ratingsTotal / total;
    }

    public Player playerWithHighestAverageRating() {
        double highest = 0;
        Player highPlay = null;
        for (int i = 0; i < players.length; i++) {
            if (highest < players[i].getAverageRating()) {
                highest = players[i].getAverageRating();
                highPlay = players[i];
            }
        }
        return highPlay;
    }

    public Player playerWithLowestAverageRating() {
        double lowest = Integer.MAX_VALUE;
        Player lowPlay = null;
        for (int i = 0; i < total; i++) {
            if (lowest > players[i].getAverageRating()) {
                lowest = players[i].getAverageRating();
                lowPlay = players[i];
            }
        }
        return lowPlay;
    }

    // -=+=- Overrides -=+=-
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Team team)) return false;
        return getTotal() == team.getTotal() && Arrays.equals(getPlayers(), team.getPlayers());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getTotal());
        result = 31 * result + Arrays.hashCode(getPlayers());
        return result;
    }

    @Override
    public String toString() {
        return "Team{" +
                "players=" + Arrays.toString(players) +
                ", total=" + total +
                ", playerWithLowestAverageRating=" + playerWithLowestAverageRating() +
                ", playerWithHighestAverageRating=" + playerWithHighestAverageRating() +
                ", averageofPlayersAvgRating=" + averageofPlayersAvgRating() +
                '}';
    }
}
