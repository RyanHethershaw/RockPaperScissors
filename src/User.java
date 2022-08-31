import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private String name;
    private int roundsToPlay;
    private int playerMove;
    Scanner user_input = new Scanner(System.in);

    public void setName(String message) {
        System.out.println(message);
        this.name = user_input.next();
    }

    public String getName() {
        return name;
    }

    public void setPlayerMove(String message, List<String> validMoves) {
        // convert validMoves to lowercase
        validMoves = validMoves.stream()
                               .map(String::toLowerCase)
                               .collect(Collectors.toList());

        System.out.println(message);

        // store player move
        int moveIndex = validMoves.indexOf(user_input.next().toLowerCase());
        // handle index not found
        if (moveIndex == -1) {
            System.out.println("Oops, that's not a valid move, please enter Rock/Paper/Scissors");
            setPlayerMove(message, validMoves);
        } else {
            this.playerMove = moveIndex;
        }
    }

    public int getPlayerMove() {
        return playerMove;
    }

    public void setRoundsToPlay(String message) {
        System.out.println(message);

        try {
            int roundsEntered = Integer.parseInt(user_input.next());

            if (roundsEntered < 0) {
                System.out.println("Oops.. please enter a positive number!");
                setRoundsToPlay(message);
            } else {
                this.roundsToPlay = roundsEntered;
            }
        } catch (NumberFormatException ex) {
            System.out.println("Oops.. please enter a valid number!");
            setRoundsToPlay(message);
        }
    }

    public int getRoundsToPlay() {
        return roundsToPlay;
    }
}
