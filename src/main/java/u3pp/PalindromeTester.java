package u3pp;

public class PalindromeTester {

    /**
     * Tests whether a string is a palindrome. Case insensitive. 
     * @param s  the string to test
     * @return true if the string is a palindrome
     */
    public static boolean isPalindrome(String s) {
        String str = s;
        String strr = "";
        
        str = str.toLowerCase();
        for(int i = str.length()-1; i >= 0; i--){
            strr = strr +str.charAt(i);
        }
        
        
        
        if ( str.equals(strr) ){
            return true;
        }
        else{
            return false;
        }
    }
}
