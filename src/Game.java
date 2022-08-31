import java.util.Random;
import java.util.List;

public class Game {
    private final List<String> validMoves = List.of("Rock", "Paper", "Scissors");
    private User inGameUser;
    private int computerMove;
    private int roundsPlayed;
    private int wins;
    private int losses;

    public void playGame(User currentUser) {
        // store user for easy access by all methods
        this.inGameUser = currentUser;

        // start game
        startGame();
    }

    public void startGame() {
        // display round number
        int roundNumber = roundsPlayed + 1;
        System.out.println("Round " + roundNumber + "!");

        // player chooses their move
        inGameUser.setPlayerMove("Enter your move (Rock/Paper/Scissors)", validMoves);
        System.out.println("You played " + validMoves.get(inGameUser.getPlayerMove()) + "!");

        // generate computer move
        computerMove();
        System.out.println("Computer played " + validMoves.get(computerMove) + "!");

        // calculate result
        String result = calculateResult();

        // end round
        endRound(result);

        // next round
        nextRound();
    }

    public void computerMove() {
        Random rand = new Random();
        this.computerMove = rand.nextInt(validMoves.size());
    }

    public String calculateResult() {
        int playerMove = inGameUser.getPlayerMove();

        // determine result
        if (playerMove == computerMove) {
            return "Draw";
        } else if (playerMove - computerMove == -2) {
            return "Win";
        } else if (playerMove - computerMove == 1) {
            return "Win";
        } else {
            return "Lose";
        }
    }

    public void endRound(String result) {
        String playersMove = validMoves.get(inGameUser.getPlayerMove());
        String computersMove = validMoves.get(computerMove);

        if (result.equals("Win")) {
            System.out.println("You Win!");
            System.out.println(playersMove + " beats " + computersMove + "!");
            this.roundsPlayed++;
            this.wins++;
        } else if (result.equals("Lose")) {
            System.out.println(computersMove + " beats " + playersMove + "!");
            System.out.println("You Lose!");
            this.roundsPlayed++;
            this.losses++;
        } else {
            System.out.println("You both played " + playersMove + "!");
            System.out.println("It's a draw! Rematch!");
        }
    }

    public void nextRound() {
        if (roundsPlayed < inGameUser.getRoundsToPlay()) {
            System.out.println("...");
            System.out.println("Let's play again!");
            System.out.println("...");

            // start the next round
            startGame();
        } else {
            if (wins > losses) {
                System.out.println("And that's that! You won! Nice one!");
            } else if (wins == losses) {
                System.out.println("And that's that! You drew! Close one!");
            } else {
                System.out.println("And that's that! You lost! Boohoo!");
            }

            // calculate win percentage
            int winPercentage =  (wins * 100) / roundsPlayed;
            System.out.println("You won " + wins + " of the "
                               + roundsPlayed + " rounds! That's "
                               + winPercentage + "%!");
        }
    }
}
