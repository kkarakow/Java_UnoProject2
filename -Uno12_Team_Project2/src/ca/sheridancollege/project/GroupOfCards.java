/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you
 * might want to subclass this more than once. The group of cards has a maximum
 * size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Fiaz Syed Feb 2020
 */
public class GroupOfCards extends Card {

    final private static int MAXCARDS = 108;
    private static ArrayList<Card> deck = new ArrayList<Card>();
    private static ArrayList<Card> wildCardDeck = new ArrayList<Card>();
    private static ArrayList<Card> normalCardDeck = new ArrayList<Card>();

    public GroupOfCards(CardValue cardValue, CardColour cardColour) {
        super(cardValue, cardColour);
    }

    public ArrayList<Card> startDeck() {
        startCards();
        shuffleCards();
        return deck;
    }

    public ArrayList<Card> startDeckWildCard() {
        startWildCards();
        shuffleCards();
        return wildCardDeck;
    }

    public ArrayList<Card> startDeckNormalCard() {
        startNormalCards();
        shuffleCards();
        return normalCardDeck;
    }

    public void startCards() {
        for (CardColour cardColour : CardColour.values()) {
            for (int i = 0; i < 2; i++) {
                for (CardValue cardValue : Card.CardValue.values()) {
                    if (i == 1 && cardValue.equals(CardValue.ZERO)
                            || i == 1 && (cardValue.equals(CardValue.WILD)
                            || cardValue.equals(CardValue.WILD_FOUR))) {
                        continue;
                    } else if (cardValue.equals(CardValue.WILD)
                            || cardValue.equals(CardValue.WILD_FOUR)) {
                        deck.add(new Card(cardValue, null));
                    } else {
                        deck.add(new Card(cardValue, cardColour));
                    }
                }
            }
        }
    }

    public void startWildCards() {
        for (CardColour cardColour : CardColour.values()) {
            for (int i = 0; i < 2; i++) {
                for (CardValue cardValue : Card.CardValue.values()) {
                    if (i == 1 && (cardValue.equals(CardValue.WILD)
                            || cardValue.equals(CardValue.WILD_FOUR))) {
                        continue;
                    } else if (cardValue.equals(CardValue.WILD)
                            || cardValue.equals(CardValue.WILD_FOUR)) {
                        wildCardDeck.add(new Card(cardValue, null));
                    } else if (cardValue.equals(CardValue.PICK_TWO)
                            || cardValue.equals(CardValue.REVERSE)
                            || cardValue.equals(CardValue.SKIP)) {
                        wildCardDeck.add(new Card(cardValue, cardColour));
                    }
                }
            }
        }
    }

    public void startNormalCards() {
        for (CardColour cardColour : CardColour.values()) {
            for (int i = 0; i < 2; i++) {
                for (CardValue cardValue : Card.CardValue.values()) {
                    if (i == 1 && cardValue.equals(CardValue.ZERO)) {
                        continue;
                    } 
                    if (!(cardValue.equals(CardValue.WILD)
                            || cardValue.equals(CardValue.REVERSE)
                            || cardValue.equals(CardValue.PICK_TWO)
                            || cardValue.equals(CardValue.WILD_FOUR)
                            || cardValue.equals(CardValue.SKIP))) {
                        normalCardDeck.add(new Card(cardValue, cardColour));
                    }
                }
            }
        }
    }
    
    public boolean canPlay(ArrayList<Card> cardStack, Card card){
        
        for (int i = 0; i < cardStack.size(); i++){
            if (((Card)cardStack.get(i)).canPlay(card)){
                return true;
            }
        }
        return false;
    }
    
    public boolean canPlay(Card card, Card topCard){
        if (card.canPlay(topCard)){
            return true;
        }
        return false;
    }
    
    public boolean canPlayColour(ArrayList<Card> cardStack, CardColour topCardColour){
        for (Card takenCard : cardStack){
            if (takenCard.cardColour.equals(topCardColour)){
                return true;
            }
        }
        return false;
    }
    
    public void shuffleCards(){
        Collections.shuffle(deck);
        Collections.shuffle(wildCardDeck);
        Collections.shuffle(normalCardDeck);
    }
    
//    //The group of cards, stored in an ArrayList
//    private ArrayList<Card> cards;
//    private int size;//the size of the grouping
//
//    public GroupOfCards(int size) {
//        this.size = size;
//    }
//
//    /**
//     * A method that will get the group of cards as an ArrayList
//     *
//     * @return the group of cards.
//     */
//    public ArrayList<Card> getCards() {
//        return cards;
//    }
//
//    public void shuffle() {
//        Collections.shuffle(cards);
//    }
//
//    /**
//     * @return the size of the group of cards
//     */
//    public int getSize() {
//        return size;
//    }
//
//    /**
//     * @param size the max size for the group of cards
//     */
//    public void setSize(int size) {
//        this.size = size;
//    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}//end class
