public class app {
    public static void main(String[] args){
        // insert players name and introduction
        User inGameUser = new User ();
        System.out.println("Hello " + inGameUser.getName() + "! Welcome to Rock, Paper, Scissors");
        inGameUser.setName("Enter your name...");
        inGameUser.setRoundsToPlay("How many rounds would you like to play?");

        // play game
        new Game().playGame(inGameUser);
    }
}
