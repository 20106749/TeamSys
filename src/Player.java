public class Player {
    // fields
    private String name;
    private int playerNumber = 23;
    private int[] ratings;
    private boolean currentSquadMember;

    // setters
    public void setName(String name) {
        if (name.length() <= 20) {
            this.name = name;
        } else {
            this.name = name.substring(0, 20);
        }
    }
    public void setPlayerNumber(int playerNumber) {
        if (playerNumber <= 23) {
            this.playerNumber = playerNumber;
        }
    }
    public void setPlayerRatings(int[] ratings) {
        this.ratings = ratings;
    }
    public void setCurrentSquadMember(boolean currentSquadMember) {
        this.currentSquadMember = currentSquadMember;
    }

    // getters
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
        int ratingsTotal = 0;
        for (int i = 0; i < 6; i++) {
            ratingsTotal += ratings[i];
        }
        return ratingsTotal/6;
    }
    public boolean isCurrentSquadMember() {
        return currentSquadMember;
    }

    // constructor
    public Player(String name, int playerNumber, boolean currentSquadMember) {
        setName(name);
        setPlayerNumber(playerNumber);
        setCurrentSquadMember(currentSquadMember);
        ratings = new int[6];
    }
}
