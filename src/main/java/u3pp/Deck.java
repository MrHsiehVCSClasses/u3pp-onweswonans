package u3pp;
import java.util.Random;

public class Deck {
    public static final String[] SUITS = {"Clubs", "Spades", "Diamonds", "Hearts"};
    public static final String[] VALUES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    Random dealer = new Random();


    public Card[] deck = new Card[52];
    private int cardsLeft = 52;
    private int draw = 0;
    
    
    public Deck(){
        int k = 0;
        
        for (int i = 0; i < SUITS.length; i++){
            for (int j = 0; j < VALUES.length; j++){
                deck[k] = new Card(SUITS[i],VALUES[j]);
                k += 1;
            }
        }
        shuffle();
    }
    // Returns how many cards have not been dealt in the `Deck`
    public int numLeft(){
        return cardsLeft;
    }
    //Takes a card off the "top" of the `Deck` and returns it.
    public Card deal(){
        draw += 1;
        cardsLeft -= 1;
        return deck[draw -1];
    
    }
    //Restores the `Deck` to "full" and randomizes the order of the `Card`s to be dealt
    public void shuffle(){
        cardsLeft = 52;
        draw = 0;
        for(int i = 0; i < deck.length; i++){
            Card tempCard = deck[i];
            int swap = dealer.nextInt(52);
            deck[i] = deck[swap];
            deck[swap] = tempCard;
        }
    }

    }

