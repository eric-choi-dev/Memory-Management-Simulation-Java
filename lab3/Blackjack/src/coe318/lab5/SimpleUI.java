package coe318.lab5;


import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user;

    public SimpleUI() {
        user = new Scanner(System.in);
    }

    @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

    @Override
    public void display() {
        System.out.println("House holds:");
        // Display house's first card as face down, others as is
        if (game.getHouseCards().getCards().size() > 0) {
            System.out.println("?");
            for (int i = 1; i < game.getHouseCards().getCards().size(); i++) {
                System.out.println(game.getHouseCards().getCards().get(i));
            }
        }

        System.out.println("You hold:");
        for (Card c : game.getYourCards().getCards()) {
            System.out.println(c);
        }
    }

    @Override
    public boolean hitMe() {
        while (true) {
            System.out.print("Another card? (y/n): ");
            String input = user.nextLine().trim().toLowerCase();
            if (input.equals("y")) {
                return true;
            } else if (input.equals("n")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
            }
        }
    }

    @Override
    public void gameOver() {
        System.out.println("Game over");
        System.out.println("House holds:");
        for (Card c : game.getHouseCards().getCards()) {
            System.out.println(c);
        }

        System.out.println("You hold:");
        for (Card c : game.getYourCards().getCards()) {
            System.out.println(c);
        }

        int yourScore = game.score(game.getYourCards());
        int houseScore = game.score(game.getHouseCards());

        System.out.println("Your score: " + yourScore + ", House score: " + houseScore);

        if (game.isPlayerWins()) { // Assume true if player wins
            System.out.println("You win");
        } else {
            System.out.println("The House wins");
        }
    }
}