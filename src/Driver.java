import  java.util.Scanner;
public class Driver {

    // -=+=- Constructor -=+=-
    public Driver() {
        setTeamSize();
        runMenu();
    }


    // -=+=- Main Method -=+=-
    public static void main(String[] args) {
        new Driver();
    }

    // -=+=- Fields -=+=-
    private Scanner input = new Scanner(System.in);
    private Team team;

    // initialise team
    private void setTeamSize() {
        System.out.println("How many players do you want on the team [max 40]");
        int teamSize = input.nextInt();
        if (teamSize > 40) {
            System.out.println("number entered is larger than 40, setting team size to 40");
            teamSize = 40;
        }
        team = new Team(teamSize);
    }

    // -=+=- Menu -=+=-
    private int mainMenu() { // shows the menu
        System.out.println("""
                    TEAM SYSTEM
                --------------------------------------------------
                1) Add a player
                2) Add player ratings
                3) Add a player to the squad
                4) Remove a player from the squad
                5) List all players
                6) List the players currently on this season's squad
                7) List players whose average rating is greater than a given rating
                8) List the players names with their average rating
                9) Display average player rating
                10) Display player with the lowest average rating
                11) Display player with the highest average rating
                    
                0) Exit
                ==>>
                """);
        return input.nextInt();
    }

    private void runMenu() { // uses the choice from mainMenu()
        int choice = mainMenu();
        while (choice != 0) {
            switch (choice) {
                case 1 -> addPlayer();
                case 2 -> addPlayerRatings();
//                case 3 -> addPlayerToSquad();
//                case 4 -> removePlayerFromSquad();
                case 5 -> listPlayers();
//                case 6 -> listAllPlayersOnSquad();
//                case 7 -> listAllPlayersWithAvgRatingHigherThanGiven();
//                case 8 -> listPlayerNamesAndAverageRating();
//                case 9 -> averageRatingOfAllPlayersAverageRating();
//                case 10 -> DisplayPlayerWithTheLowestAverageRating();
//                case 11 -> DisplayPlayerWithTheHighestAverageRating();
                default -> System.out.println("input not recognised, try again");
            }
            System.out.println("\nPress enter to continue");
            input.nextLine();
            input.nextLine();

            choice = mainMenu();
        }
        System.out.println("yeet!");
        System.exit(0);
    }

    // -=+=- Methods -=+=-
    private void addPlayer() {
        input.nextLine();  //dummy read of String to clear the buffer - bug in Scanner class.

        System.out.print("Enter the Player's Name:  ");
        String name = input.nextLine();
        System.out.print("Enter the Player's number:  ");
        int playerNumber = validateInt();
        System.out.print("Is this player in your current lineup (y/n): ");
        char member = input.next().charAt(0);
        boolean currentSquadMember = (member == 'y') || (member == 'Y');
        boolean isAdded = team.add(new Player(name, playerNumber, currentSquadMember));
        if (isAdded){
            System.out.println("Player Added Successfully");
        }
        else{
            System.out.println("No Player Added");
        }
    }

    private int validateInt() {
        Scanner scanner = new Scanner(System.in);
        int newInt = 0;
        // Validate the input
        while (true) {
            String input = scanner.next();
            try {
                newInt = Integer.parseInt(input);

                // Validate the input is above 0
                if (newInt < 0) {
                    System.out.println("Invalid value. Please enter a positive integer.");
                    continue; // Ask the user again for a valid input if not
                }

                // Break out of the loop if the input is valid
                break;
            } catch (NumberFormatException e) { // if the input isn't an integer, catch the exception
                System.out.println("Invalid input. Please enter an integer value.");
            }
        }
        return newInt;
    }

    private void addPlayerRatings() {
        listPlayers();
        System.out.println("Enter index of player to change ratings");
        int index = validateInt();
        int[] newRatings = new int[6];
        for (int i = 0; i < 6; i++) {
            // Ask the user for input
            // System.out.print("Enter rating for index " + i + " (between 0 and 5 inclusive): ");
            System.out.print("Enter rating " + (i+1) + " (between 0 and 5 inclusive): ");

            // Validate the input
            while (true) {
                String in = input.next();
                try {
                    newRatings[i] = Integer.parseInt(in);

                    // Validate the input range
                    if (newRatings[i] < 0 || newRatings[i] > 5) {
                        System.out.print("Invalid rating value. Please enter a value between 0 and t.");
                        continue; // Ask the user again for a valid input
                    }

                    // Break out of the loop if the input is valid
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an integer value.");
                }
            }
        }
        boolean added = team.addPlayerRatings(index, newRatings);
//        team.addPlayerRatings(newRatings);
        if (added) {
            System.out.println("ratings added");
        }
        else {
            System.out.println("ratings not added");
        }
    }

    private void listPlayers() {
        System.out.println(team.listPlayers());
    }
}
    /*

    TEAM SYSTEM Options
Option 1 - Add a Player
Take in all the values for the player (apart from their ratings) and create and add this player to the array of players.

Option 2 - Add player ratings
Firstly the user should be shown a list of al players, then asked which player number they wish to add ratings to. (index number should be part of the listing). Then the user is asked to input 6 values (ratings) for this player. All values should be between 0 and 5 inclusive.

Option 3 - Add a player to the squad
Firstly the user should be shown a list of al players, then asked which player number they wish to add to the squad (using index number). This player’s information should be updated to reflect this.

Option 4 - Remove a player from the squad
Firstly the user should be shown a list of al players, then asked which player number they wish to remove from the squad (using index number). This player’s information should be updated to reflect this.

Option 5 - List all players
List all details (including index and each rating) of all players.

Option 6 - List all players currently on the squad
List all details (including each rating) of all players that are currently on the squad.

Option 7 - List players whose average rating is greater than a given average
Ask the user to enter a value, then calculate and print out all the players whose average is above this value.

Option 8 - List the players names with their average ratings
List all players, with the following details (only):

name
average rating

Option 9 - Display average player rating
Calculate and display the average rating over all the players.

Option 10 - Display player with the lowest average rating
Calculate the player with the lowest average rating in the array of players. All of this players’ details should be printed to the screen.

Option 11 - Display player with the highest average rating
Calculate the player with the highest average rating in the array of players. All of this players’ details should be printed to the screen.

Option 0 - Exit
This option exits the application.

    */

