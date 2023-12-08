import java.util.Arrays;

public class Team {
    Player[] players;

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
        return Arrays.equals(getPlayers(), team.getPlayers());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getPlayers());
    }






    private int total;
    // public void setPlayers(Player[] players, int x) {} // what's the int for
    public String listOfPlayerwithAverageRating() {}
    public String listPlayers() {}
    public int getTotal() {}
    public Player playerWithHighestAverageRating() {}
    public Player getPlayer(int num) {} // int for? is it for the index of the player
    public boolean add(Player player) {}
    public boolean isEmpty() {}
    public String listCurrentPlayers() {}
    public void setTotal(int total) {}
    public double averageofPlayersAvgRating() {}
    public Player addPlayerToSquad(int index) {} // index. if player found add them to the squad
    public String toString() {}
    public boolean isFull() {}
    public String listPlayersAboveGivenAverageRating(double averageRating) {}
    public Player playerWithLowestAverageRating() {}
    public Player removePlayerFromSquad(int index) {} // int for index of player, if found remove from squad




}
