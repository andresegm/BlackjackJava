import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {

    //Function that allows us to add cards to get total score
      public static int getSum(ArrayList<Integer> cards) {
        int sum = 0;
        for (int card : cards) {
            sum += card;
        }
        return sum;
    }

    //These two arrays represent the player's cards, and the dealer's cards, which are initially empty
    static ArrayList<Integer> playerCards = new ArrayList<Integer>();
    static ArrayList<Integer> dealerCards = new ArrayList<Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //This code prompts the user for their name, which is used through the game
        System.out.println("What is your name? ");
        Scanner inputName = new Scanner(System.in);
        String playerName = inputName.nextLine();
  
      
        // Initialize player's cards, dealing two random cards between 1 and 10 to the player
        playerCards.add((int) (Math.random() * 10) + 1);
        playerCards.add((int) (Math.random() * 10) + 1);

        // Initialize dealer cards, dealing two random cards between 1 and 10 to the dealer
        dealerCards.add((int) (Math.random() * 10) + 1);
        dealerCards.add((int) (Math.random() * 10) + 1);

        // Print initial cards. Note that the dealer's second card is not displayed 
        System.out.println(playerName + "'s cards: " + playerCards);
        System.out.println(playerName + "'s score: " + getSum(playerCards));
        System.out.println("Dealer's cards: " + dealerCards.get(0) + " and [hidden]");

        // Player's turn. The player is prompted to type "h" (hit) or "s" (stay)
        // The player's turn continues until he types "s" or busts (goes over 21)
        while (true) {
            System.out.print("Would you like to hit or stay? (h/s): ");
            String input = sc.nextLine();

            if (input.equals("h")) {
                int newCard = (int) (Math.random() * 10) + 1;
                playerCards.add(newCard);
                System.out.println(playerName + "'s cards: " + playerCards);
                System.out.println(playerName + "'s score: " + getSum(playerCards));

                if (getSum(playerCards) == 21) {
                    break;
                }

                if (getSum(playerCards) > 21) {
                    System.out.println(playerName + " busts!");
                    break;
                }
            } else if (input.equals("s")) {
                break;
            }
        }

        // Dealer's turn. The dealer only draws if their score is equal to or less than 17, and the player did not bust.
        while (getSum(dealerCards) <= 17 && getSum(playerCards) < 22) {
            int newCard = (int) (Math.random() * 10) + 1;
            dealerCards.add(newCard);
        }

        // Print final cards and scores
        System.out.println(playerName + "'s cards: " + playerCards);
        System.out.println(playerName + "'s score: " + getSum(playerCards));
        System.out.println("Dealer's cards: " + dealerCards);
        System.out.println("Dealer's score: " + getSum(dealerCards));

        // Determine winner by comparing the player's score and dealer's score. If the player bust, they automatically lose.
        if (getSum(playerCards) > 21) {
            System.out.println(playerName + " loses!");
        } else if (getSum(playerCards) > getSum(dealerCards) && getSum(playerCards) <= 21) {
            System.out.println(playerName + " wins!");
        } else if (getSum(playerCards) < getSum(dealerCards) && getSum(dealerCards) <= 21) {
            System.out.println(playerName + " loses!");
        } else if (getSum(playerCards) < getSum(dealerCards) && getSum(dealerCards) > 21) {
            System.out.println(playerName + " wins!");
        } else {
            System.out.println("It's a tie!");
        }
      
    }
}

//Please note that this is a simple version of the game and there are many more rules and variations in actual Blackjack game.