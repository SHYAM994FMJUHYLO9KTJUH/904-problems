
import java.util.*;

public class sep_one {
    static String playRound(String player, String computer) {
        if (player.equals(computer))
            return "Draw";
        if (player.equals("Rock") && computer.equals("Scissors") ||
            player.equals("Paper") && computer.equals("Rock") ||
            player.equals("Scissors") && computer.equals("Paper"))
            return "Player Wins";
        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] players = new String[5];
        String[] computers = new String[5];
        String[] results = new String[5];

        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter Rock, Paper, or Scissors: ");
            players[i] = sc.next();

            players[i] = players[i].substring(0, 1).toUpperCase()
                    + players[i].substring(1).toLowerCase();

            computers[i] = moves[r.nextInt(3)];
            results[i] = playRound(players[i], computers[i]);

            if (results[i].equals("Player Wins")) wins++;
            else if (results[i].equals("Computer Wins")) losses++;
            else draws++;

            System.out.println(results[i]);
        }

        System.out.println("\nRound\tPlayer\t\tComputer\tResult");
        for (int i = 0; i < 5; i++)
            System.out.println((i + 1) + "\t" + players[i] + "\t\t"
                    + computers[i] + "\t\t" + results[i]);

        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win Percentage: %.1f%%%n", wins * 100.0 / 5);

        sc.close();
    }
}