import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {

    static ArrayList<Integer> playerCards = new ArrayList<Integer>();
    static ArrayList<Integer> dealerCards = new ArrayList<Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize player cards
        playerCards.add((int) (Math.random() * 10) + 1);
        playerCards.add((int) (Math.random() * 10) + 1);

        // Initialize dealer cards
        dealerCards.add((int) (Math.random() * 10) + 1);
        dealerCards.add((int) (Math.random() * 10) + 1);

        // Print initial cards
        System.out.println("Player's cards: " + playerCards);
        System.out.println("Dealer's cards: " + dealerCards.get(0) + " and [hidden]");

        // Player's turn
        while (true) {
            System.out.print("Would you like to hit or stay? (h/s): ");
            String input = sc.nextLine();

            if (input.equals("h")) {
                int newCard = (int) (Math.random() * 10) + 1;
                playerCards.add(newCard);
                System.out.println("Player's cards: " + playerCards);

                if (getSum(playerCards) == 21) {
                    break;
                }

                if (getSum(playerCards) > 21) {
                    System.out.println("Player busts!");
                    break;
                }
            } else if (input.equals("s")) {
                break;
            }
        }

        // Dealer's turn
        while (getSum(dealerCards) <= 17) {
            int newCard = (int) (Math.random() * 10) + 1;
            dealerCards.add(newCard);
        }

        // Print final cards and scores
        System.out.println("Player's cards: " + playerCards);
        System.out.println("Player's score: " + getSum(playerCards));
        System.out.println("Dealer's cards: " + dealerCards);
        System.out.println("Dealer's score: " + getSum(dealerCards));

        // Determine winner
        if (getSum(playerCards) > 21 && getSum(dealerCards) < getSum(playerCards)) {
            System.out.println("Player loses!");
        } else if (getSum(dealerCards) > 21 && getSum(dealerCards) > getSum(playerCards)) {
            System.out.println("Player wins!");
        } else if (getSum(playerCards) > getSum(dealerCards) && getSum(playerCards) <= 21) {
            System.out.println("Player wins!");
        } else if (getSum(playerCards) < getSum(dealerCards) && getSum(dealerCards) <= 21) {
            System.out.println("Player loses!");
        } else {
            System.out.println("It's a tie!");
        }
      
    }

    public static int getSum(ArrayList<Integer> cards) {
        int sum = 0;

        for (int card : cards) {
            sum += card;
        }

        return sum;
    }

}