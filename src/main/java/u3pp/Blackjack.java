package u3pp;
import java.util.Scanner;


public class Blackjack {
    public static final String[] SUITS = {"Clubs", "Spades", "Diamonds", "Hearts"};
    public static final String[] VALUES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    
    
    private Card[] dealerHand; 
    private Card[] playerHand; 
    Deck myDeck = new Deck();
    private boolean cont = true;
    //This should instantiate any instance variables you have, especially your `Deck`.
    public Blackjack(){
        dealerHand = new Card[8];
        playerHand = new Card[8];
        cont = true;
    }
    

    /*The method to be called to actually play a game. This is where you implement the flow of 
    the **Gameplay**. The output should clearly communicate what is happening - cards dealt, comparisons made, etc.*/
    public void play(Scanner scanner){
        String ans = "";
        String ansB = "";
        String ansC = "";
        int playerint = 2;
        int dealerint = 2;
        while (cont == true){
            playerint = 2;
            dealerint = 2;
            for(int i = 0; i < dealerHand.length; i++){
                dealerHand[i] = null;
                playerHand[i] = null;
            }
            if (myDeck.numLeft() == 0){
                myDeck.shuffle();
            }
            dealerHand[0] = myDeck.deal();
            playerHand[0] = myDeck.deal();
            dealerHand[1] = myDeck.deal();
            playerHand[1] = myDeck.deal();
            System.out.println(" you have ");
                for(int i = 0; i < playerint; i++){
                    System.out.println(playerHand[i]);
                }
            System.out.println("\n dealer has ");
                for(int i = 0; i < dealerint; i++){
                    System.out.println(dealerHand[i]);
                }
            if (isBlackjack(playerHand) == true){
                if (isBlackjack(dealerHand) == true){
                    System.out.println("ITS A PUSH. CRINGEEEEE 🤓. play again? yes/no");
                    ansC = scanner.nextLine();
                    if ( ansC.equals("yes")){
                        cont = true;
                    } else if (ansC.equals("no")){
                        cont = false;
                    }
                } else{
                    System.out.println("you win. good job play again? yes/no");
                    ansC = scanner.nextLine();
                    if ( ansC.equals("yes")){
                        cont = true;
                    } else if (ansC.equals("no")){
                        cont = false;
                    }
                }
            } else if (isBlackjack(dealerHand) == true) {
                System.out.println("dealer wins you suck. l + ratio + bozo play again? yes/no");
                ansC = scanner.nextLine();
                    if ( ansC.equals("yes")){
                        cont = true;
                    } else if (ansC.equals("no")){
                        cont = false;
                    }
            } else if (isBlackjack(dealerHand) == false && isBlackjack(playerHand) == false){
                System.out.println("will you (H)it or (S)tay?");
                ans = scanner.nextLine();
                while (ans.equals("H")){
                    playerint += 1;
                    playerHand[playerint - 1] = myDeck.deal();
                    System.out.println(" you have ");
                    for(int i = 0; i < playerint; i++){
                        System.out.println(playerHand[i]);
                    }
                    if (isBust(playerHand) == true){
                        ans = "S";
                        System.out.println("you suck so much you busted you stupid dumb idiot baffoon. you wanna lose again aye? yes / no");
                        ansB = scanner.nextLine();
                        if (ansB.equals("yes")){
                            cont = true;
                        } else if (ansB.equals("no")){
                            cont = false;
                        }
                    } else {
                    System.out.println("will you (H)it or (S)tay?");
                    ans = scanner.nextLine();
                    }
                }
                    while (shouldDealerKeepHitting(dealerHand) == true && isBust(playerHand) == false){
                        dealerint += 1;
                        dealerHand[dealerint -1] = myDeck.deal();
                        System.out.println("\n dealer has ");
                        for (int i = 0 ; i < dealerint; i ++){
                            System.out.println( dealerHand[i]);
                    }
                    if (isBust(dealerHand) == true){
                        System.out.println(" dealer busts, you won. wanna play again? yes/no");
                        ansC = scanner.nextLine();
                        if ( ansC.equals("yes")){
                            cont = true;
                        } else if (ansC.equals("no")){
                            cont = false;
                        }
                    } else if (determineResult(playerHand, dealerHand).equals("User Loses")){
                    System.out.println("You are so stupid and bad at this game! XDXDXD 😜 wanna play again? \n yes/no");
                    ansC = scanner.nextLine();
                        if ( ansC.equals("yes")){
                            cont = true;
                        } else if (ansC.equals("no")){
                            cont = false;
                        }
                } else if (determineResult(playerHand, dealerHand).equals("User Wins")){
                    System.out.println("good job! you won. play again? yes/no");
                    ansC = scanner.nextLine();
                    if ( ansC.equals("yes")){
                        cont = true;
                    } else if (ansC.equals("no")){
                        cont = false;
                    }
                } else if (determineResult(playerHand, dealerHand).equals("User Pushes")){
                    System.out.println(" you guys tied. what a bore..... play again? yes/no");
                    ansC = scanner.nextLine();
                    if ( ansC.equals("yes")){
                        cont = true;
                    } else if (ansC.equals("no")){
                        cont = false;
                    }
                }
                }
            }
        }
    }

    /*This helper method takes an array of `Card`s and returns the amount of points that hand is worth.
    Post condition: the parameter should remain unaltered.*/
    public static int calcPoints(Card[] hand){
        int points = 0;
        for(int i = 0; i < hand.length; i++){
            if (hand[i] == null){
                return points;
            }
            if (hand[i].getValue().equals(VALUES[0])){
                points += 2;
            }
            if (hand[i].getValue().equals(VALUES[1])){
                points += 3;
            }
            if (hand[i].getValue().equals(VALUES[2])){
                points += 4;
            }
            if (hand[i].getValue().equals(VALUES[3])){
                points += 5;
            }
            if (hand[i].getValue().equals(VALUES[4])){
                points += 6;
            }
            if (hand[i].getValue().equals(VALUES[5])){
                points += 7;
            }
            if (hand[i].getValue().equals(VALUES[6])){
                points += 8;
            }
            if (hand[i].getValue().equals(VALUES[7])){
                points += 9;
            }
            if (hand[i].getValue().equals(VALUES[8])){
                points += 10;
            }
            if (hand[i].getValue().equals(VALUES[9])){
                points += 10;
            }
            if (hand[i].getValue().equals(VALUES[10])){
                points += 10;
            }
            if (hand[i].getValue().equals(VALUES[11])){
                points += 10;
            }
            if (hand[i].getValue().equals(VALUES[12])){
                points += 11;
            }
        }
        
        return points;
    }

    /*Returns a `String` in one of the following formats:
    `"User Wins"`, `"User Loses"`, or `"User Pushes"`. Does not alter parameters. */
    public static String determineResult(Card[] userHand, Card[] dealerHand){
        String result = "";
        int user = calcPoints(userHand);
        int dealer = calcPoints(dealerHand);
        if (user > 21){
            result = "User Loses";
            return result;
        }
        if (dealer > 21){
            result = "User Wins";
            return result;
        }
        if( dealer == user){
            result = "User Pushes";
            return result;
        }
        if (user == 21){
            result = "User Wins";
        }
        if (user > dealer){
            result = "User Wins";
        }
        if (dealer > user){
            result = "User Loses";
        }
        
        
        return result;
    }

    //returns `true` if the hand is a *Bust*, `false` otherwise. Does not alter parameters. 
    public static boolean isBust(Card[] hand){
        int points = calcPoints(hand);
        if (points > 21){
            return true;
        }
        return false;
    }

    /*returns `true` if the hand is a *Blackjack*, `false` otherwise.
    Remember, it is only a blackjack in the opening hand (2 card hand). Does not alter parameters. */
    public static boolean isBlackjack(Card[] hand){
        int num = 0; 
        for (int i = 0; i <hand.length; i++){
            if(hand[i] == null){
                
            }
            else{
                num += 1;
            }
        }
        if (num != 2){
            return false;
        }
        int points = calcPoints(hand);
        if ( points == 21){
            return true;
        }
        return false;
    }

    /*return `true` if the dealer should keep hitting (score of hand is 16 or less), `false` otherwise. 
    Does  not alter parameters. */
    public static boolean shouldDealerKeepHitting(Card[] hand){
        int points = calcPoints(hand);
        if( points <= 16){
            return true;
        }
        return false;
    }
}

