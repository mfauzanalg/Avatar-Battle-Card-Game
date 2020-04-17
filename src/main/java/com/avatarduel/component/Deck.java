package com.avatarduel.component;
import com.avatarduel.AvatarDuel;

import java.util.*;

public class Deck {
    public static final int MAX_DECK = 60;
    public static final int MIN_DECK = 40;
    private List<Card> deck;

    public Deck(){
        this.deck  = new ArrayList<Card>();
    }

    /**Getter Initializer Deck*/
    public List<Card> getDeck(){
        return deck;
    }
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

    /**Deck Manipulation*/
    public <T extends Card> void addCardsToDeck(List<T> l){
        this.deck.addAll(l);
    }
    public void shuffleDeck(){
        Collections.shuffle(this.deck);
    }
    public <T extends Card> void addCard(T c){
        this.deck.add(c);
    }
    public <T extends Card> void addSpecificCard(List<T> l, int id){
        T c = l.stream()
                .filter(i -> i.getId() == id)
                .findAny()
                .orElse(null);
        if (c != null){
            this.addCard(c);
        }
    }
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
