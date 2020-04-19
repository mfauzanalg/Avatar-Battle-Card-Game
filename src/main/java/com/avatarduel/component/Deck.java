package com.avatarduel.component;
import com.avatarduel.AvatarDuel;

import java.util.*;

public class Deck {
    public static final int MAX_DECK = 60;
    public static final int MIN_DECK = 0;
    private List<Card> deck;

    /**
     * Creates a blank Deck
     */
    public Deck(){
        this.deck  = new ArrayList<Card>();
    }

    //Getter Initializer Deck

    /**
     * Get the Deck List of Card
     * @return Decks List of Card
     */
    public List<Card> getDeck(){
        return deck;
    }

    /**
     * Initialize the Deck List of Card based on the amount of each type of card.
     * @param nChar Character card amount
     * @param nAura Aura skill card amount
     * @param nLand Land card amount
     * @param nDestroy Destroy skill card amount
     * @param nPowerUp Power up skill card amount
     */
    public void initializeDeck(int nChar, int nAura, int nLand, int nDestroy, int nPowerUp){
        int totalCard = nChar + nAura + nLand + nDestroy + nPowerUp;
        if ((totalCard > MAX_DECK) || (totalCard < MIN_DECK)){
            System.out.println("Card amount not valid");
        }
        else{
            this.addRandomCards(AvatarDuel.charData, nChar);
            this.addRandomCards(AvatarDuel.auraData, nAura);
            this.addRandomCards(AvatarDuel.landData, nLand);
            for (int i = 0; i < nDestroy; i++){
                this.addCard(AvatarDuel.destroyCard);
            }
            for (int i = 0; i < nPowerUp; i++){
                this.addCard(AvatarDuel.powerUpCard);
            }
            this.shuffleDeck();
        }
    }

    //Deck Manipulation

    /**
     * Add cards from a List of T extends Card to the Deck
     * @param l List of T
     * @param <T> A class that extends Card
     */
    public <T extends Card> void addCardsToDeck(List<T> l){
        this.deck.addAll(l);
    }

    /**
     * Shuffle the Deck
     */
    public void shuffleDeck(){
        Collections.shuffle(this.deck);
    }

    /**
     * Add a single card to the Deck
     * @param c added card
     * @param <T> A class that extends Card
     */
    public <T extends Card> void addCard(T c){
        this.deck.add(c);
    }

    /**
     * Add a specific card to the Deck based on the id
     * @param l List of T
     * @param id The card's id that want to be added
     * @param <T> A class that extends Card
     */
    public <T extends Card> void addSpecificCard(List<T> l, int id){
        T c = l.stream()
                .filter(i -> i.getId() == id)
                .findAny()
                .orElse(null);
        if (c != null){
            this.addCard(c);
        }
    }

    /**
     * Add random cards from a List of T to the Deck
     * @param l List of T
     * @param quantity The amount of cards that want to be added
     * @param <T> A class that extends Card
     */
    public <T extends Card> void addRandomCards(List<T> l, int quantity){
        List<T> l1 = l;
        int count = 0;
        while (count != quantity){
            Collections.shuffle(l1);
            Card c = l1.get(0);
            this.addCard(c);
            count++;
        }
    }
}
