import java.util.Arrays;
import java.util.Objects;

public class Team {
    private Player[] players;

    public Team(int numPlayers) {
        players = new Player[numPlayers];
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

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






    private int total;
    // public void setPlayers(Player[] players, int x) {} // what's the int for
    public String listOfPlayerwithAverageRating() {
        if (isEmpty()) {
            return "No players on the team";
        } else {
            String listOfPlayers = "";
            for (int i = 0; i < total; i++) {
                listOfPlayers += i + ": " + players[i].getName() +
                        " " + players[i].getAverageRating()+ "\n";
            }
            return listOfPlayers;
        }
    }
    public String listPlayers() {
        if (isEmpty()) {
            return "No players on the team";
        } else {
            String listOfPlayers = "";
            for (int i = 0; i < total; i++) {
                listOfPlayers += i + ": " + players[i].toString() + "\n";
            }
            return listOfPlayers;
        }
    }
    public int getTotal() {
        return total;
    }
    public Player playerWithHighestAverageRating() {
        double highest = 0;
        Player highPlay = null;
        for (int i = 0; i < players.length; i++) {
            if (highest < players[i].getAverageRating()) {
                highest = players[i].getAverageRating();
                highPlay= players[i];
            }
        }
        return highPlay;
    }
    public Player getPlayer(int index) {
        if(index >= 0 && index < total)
            return players[index];
        return null; } // int for? is it for the index of the player? // yep, if theres a player at "index" return that player, else return null
    public boolean add(Player player) {
        if (isFull()) {
            return false;
        } else {
            players[total] = player;
            total++;
            return true;
        }
    }
    public boolean isEmpty() {
        return total == 0;
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
            if (listOfPlayers.isEmpty()){
                return "No players are in our current squad";
            }
            else{
                return listOfPlayers;
            }
        }
    }
    /*public void setTotal(int total) {
        return;
    }*/ // not needed
    public double averageofPlayersAvgRating() {
        // Calculate and return the average of players average rating
        double ratingsTotal = 0;
        for (int i = 0; i < total; i++) {
            ratingsTotal += players[i].getAverageRating();
        }
        return ratingsTotal / total;
    }
    public Player addPlayerToSquad(int index) {
        Player found = players[index];
        found.setCurrentSquadMember(true);
        return found;

    } // index. if player found add them to the squad

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

    public boolean isFull() {
        return total == players.length;
    }
    public String listPlayersAboveGivenAverageRating(double averageRating) {
        if (isEmpty()) {
            return "No players on the team";
        } else {
            String listOfPlayers = "";
            for (int i = 0; i < total; i++) {
                if (players[i].getAverageRating() > averageRating)
                    listOfPlayers += i + ": " + players[i] + "\n";
            }
            if (listOfPlayers.isEmpty()){
                return "No players averageRating above given averageRating";
            }
            else{
                return listOfPlayers;
            }
        }
    }/*{
        Player[] above = new Player[total];


        return Arrays.toString(above);
    }*/
    public Player playerWithLowestAverageRating() {
        double lowest = Integer.MAX_VALUE;
        Player lowPlay = null;
        for (int i = 0; i < total; i++) {
            if (lowest > players[i].getAverageRating()) {
                lowest = players[i].getAverageRating();
                lowPlay= players[i];
            }
        }
        return lowPlay;
    }
    public Player removePlayerFromSquad(int index) {
        Player found = players[index];
        found.setCurrentSquadMember(false);
        return found;
    } // int for index of player, if found remove from squad




}
