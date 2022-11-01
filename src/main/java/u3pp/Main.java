package u3pp;
import java.util.Scanner;
public class Main 
{
    public static void main(String[] args) {
        PalindromeTester myPal = new PalindromeTester();
        System.out.println(myPal.isPalindrome( "Pop"));
        Scanner scamp = new Scanner(System.in);
        Blackjack myGame = new Blackjack();
        myGame.play(scamp);

    
    }

}
