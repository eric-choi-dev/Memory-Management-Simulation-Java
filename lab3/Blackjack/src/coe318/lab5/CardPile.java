package coe318.lab5;


import java.util.ArrayList;
import java.util.Random;

public class CardPile {
    private ArrayList<Card> cards;
    private Random random;

    public CardPile() {
        cards = new ArrayList<>();
        random = new Random();
    }

    /**
     * Adds a card to the pile.
     *
     * @param c the card to add
     */
    public void add(Card c) {
        cards.add(c);
    }

    /**
     * Removes and returns a random card from the pile.
     *
     * @return the removed card
     * @throws IllegalStateException if the pile is empty
     */
    public Card removeRandom() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("No cards left in the pile.");
        }
        int index = random.nextInt(cards.size());
        return cards.remove(index);
    }

    /**
     * Returns the list of cards in the pile.
     *
     * @return the list of cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card c : cards) {
            sb.append(c.toString()).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CardPile pile = new CardPile();
        pile.add(new Card(5, Card.CLUB, true));
        pile.add(new Card(14, Card.SPADE, false));
        pile.add(new Card(10, Card.HEART, true));
        System.out.println("Initial pile:");
        System.out.println(pile);

        Card removed = pile.removeRandom();
        System.out.println("Removed card: " + removed);

        System.out.println("Pile after removal:");
        System.out.println(pile);
    }
}