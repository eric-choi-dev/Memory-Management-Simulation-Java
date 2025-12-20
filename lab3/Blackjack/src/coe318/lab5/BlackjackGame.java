package coe318.lab5;


public class BlackjackGame {

    private CardPile deck;
    private CardPile houseCards;
    private CardPile yourCards;
    private boolean houseDone;
    private boolean playerDone;
    private UserInterface ui;
    private boolean playerBust;
    private boolean houseBust;
    private boolean playerWins;

    public BlackjackGame(UserInterface ui) {
        this.ui = ui;
        ui.setGame(this);
        deck = new CardPile();
        for (int i = 2; i < 15; i++) { // Ranks 2 to 14
            for (int j = 0; j < 4; j++) { // Suits 0 to 3
                deck.add(new Card(i, j, true));
            }
        }
        houseCards = new CardPile();
        yourCards = new CardPile();
        houseDone = false;
        playerDone = false;
        playerBust = false;
        houseBust = false;
        playerWins = false;
    }

    public void start() {
        // Deal two cards to House, one face down
        Card c1 = deck.removeRandom();
        c1.setFaceUp(false);
        houseCards.add(c1);
        Card c2 = deck.removeRandom();
        c2.setFaceUp(true);
        houseCards.add(c2);

        // Deal two cards to player, both face up
        Card c3 = deck.removeRandom();
        c3.setFaceUp(true);
        yourCards.add(c3);
        Card c4 = deck.removeRandom();
        c4.setFaceUp(true);
        yourCards.add(c4);

        ui.display();
    }

    public void play() {
        while (!houseDone || !playerDone) {
            // House's turn
            if (!houseDone) {
                int houseScore = score(houseCards);
                if (houseScore < 17) {
                    Card newCard = deck.removeRandom();
                    newCard.setFaceUp(true);
                    houseCards.add(newCard);
                    ui.display();
                } else {
                    houseDone = true;
                }
            }

            // Player's turn
            if (!playerDone) {
                int yourScore = score(yourCards);
                if (yourScore > 21) {
                    playerBust = true;
                    playerDone = true;
                    continue;
                }

                boolean hit = ui.hitMe();
                if (hit) {
                    Card newCard = deck.removeRandom();
                    newCard.setFaceUp(true);
                    yourCards.add(newCard);
                    ui.display();
                } else {
                    playerDone = true;
                }
            }
        }
        end();
    }

    public void end() {
        // Reveal House's face down card
        for (Card c : houseCards.getCards()) {
            c.setFaceUp(true);
        }

        ui.display();
        determineWinner();
        ui.gameOver();
    }

    /**
     * Determine the score of a pile of cards.
     *
     * @param p
     * @return the score
     */
    public int score(CardPile p) {
        int total = 0;
        for (Card c : p.getCards()) {
            int rank = c.getRank();
            if (rank >= 2 && rank <= 10) {
                total += rank;
            } else if (rank >= 11 && rank <= 13) { // J, Q, K
                total += 10;
            } else if (rank == 14) { // Ace
                total += 1;
            }
        }
        return total;
    }

    /**
     * Determine who wins the game and set playerWins accordingly.
     */
    public void determineWinner() {
        int yourScore = score(yourCards);
        int houseScore = score(houseCards);

        // Check for busts
        if (yourScore > 21) {
            playerWins = false;
            return;
        }
        if (houseScore > 21) {
            playerWins = true;
            return;
        }
        // If scores are equal, player loses
        if (yourScore == houseScore) {
            playerWins = false;
            return;
        }
        // Player score > House score
        if (yourScore > houseScore) {
            playerWins = true;
            return;
        }
        // House score > Player score
        playerWins = false;
    }

    /**
     * @return the houseCards
     */
    public CardPile getHouseCards() {
        return houseCards;
    }

    /**
     * @return the yourCards
     */
    public CardPile getYourCards() {
        return yourCards;
    }

    /**
     * @return playerWins
     */
    public boolean isPlayerWins() {
        return playerWins;
    }

    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame(new SimpleUI());
        game.start();
        game.play();
        // end()
    }
}