import  java.util.Scanner;
public class Driver {

    public Driver() {
        runMenu();
    }
    public static void main(String[] args) {
        new Driver();
    }
    // -=+=- Fields -=+=-
    private Scanner input = new Scanner(System.in);
    private Team team;

    // -=+=- Menu -=+=-

    private runMenu() {

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

##Option 5 - `List all players```

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
}
