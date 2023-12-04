public class Player {
    // name
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() <= 20) {
            this.name = name;
        } else {
            this.name = name.substring(0, 19);
        }
    }

    // playerNumber
    private int playerNumber = 23;

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        if (playerNumber <= 23) {
            this.playerNumber = playerNumber;
        }
    }
/*
    // ratings
    private int[] ratings = new int[6];

    public void setPlayerRatings(int[] ratings) {
        this.ratings = ratings;
    }
*/
    // currentSquadMember
    private boolean currentSquadMember;

    public void setCurrentSquadMember(boolean currentSquadMember) {
        this.currentSquadMember = currentSquadMember;
    }

    public boolean isCurrentSquadMember() {
        return currentSquadMember;
    }
}
