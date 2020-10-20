package sample;

import java.util.Scanner;

public class stringUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static String ex1(String string){
        return "<" + string + ">";
    }

    public static String ex2(String string){
        int charCount = 0;
        // Count characters
        for (int i = 0; i < string.length(); i++){
            if (string.charAt(i) != ' '){
                charCount++;
            }
        }
        return (string + " contains " + charCount + " characters.");
    }

    public static String ex3(String string){
        String newString = "";
        for (int i = 0; i < string.length(); i++){
            if (string.charAt(i) != ' ') {
                newString = newString + string.charAt(i) + "@";
            } else if (string.charAt(i) == ' '){
                newString = newString + ' ';
            }
        }
        return newString;
    }

    public static String ex4(String string) {
        //From any user input, write the input characters backwards
        String newString = "";
        for (int i = string.length() - 1; i >= 0; i--) {
            newString = newString + string.charAt(i);
        }
        return newString;

    }

    public static String ex5(String string){
        // Make palindrome of string.
        return string + ex4(string);
    }

    public static String ex6(String string) {
        /* Check if the string contains the words "horse", "saddle" or "spores"
        and if present, substitute them with an equal amount of "*".
        e.g. "i am riding a blue horse" -> "i am riding a blue *****"
         */
        String[] word = {"horse", "saddle", "spores" };
        String[] stars = {"*****", "******", "******" };

        for (int i = 0; i < word.length; i++){
            if (string.contains(word[i])){
                string = string.replace(word[i], stars[i]);
            }
        }
        return string;
    }

    /*From any user input, make the text alternate
        caps. e.g. "hi my name is peter" -> "Hi My NaMe Is PeTeR",
        ignore spaces when using caps.
         */
    public static String ex7(String string){
        char[] newString = string.toCharArray();
            boolean upper = true;

            for (int i = 0; i < string.length(); i++){
                if (upper || string.charAt(i) == ' '){
                    newString[i] = Character.toUpperCase(newString[i]);
                    upper = false;
                } else {
                    upper = true;
                }
            }
        return String.valueOf(newString);
    }

    /*
    Make a filter that takes two inputs, a data-string and a filter-string.
    filter out every char that does not match the filter-string. e.g.
    data: "look out im falling off the horse! Or am i really dreaming",
    filter: "ng"  -> "xxxxxxxxxxxxxxxxxngxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxng"
    or data: "abcmyabc1234abmyabab", "ab" -> "abxxxabxxxxxabxxabab"
     */
    public static String ex8(String dataString){
        //String dataString = "";
        String filter = "cs";
        String newString ="";
        boolean charFound = false;



        //System.out.println("Enter Data-string:");
        //dataString = scanner.nextLine();
        //System.out.println("Enter filter-string:");
        //filter = scanner.nextLine();


        for (int i = 0; i < dataString.length(); i++){
            for (int c = 0; c < filter.length(); c++){
                if (dataString.charAt(i) == filter.charAt(c)){
                    charFound = true;
                }
            }
            if (!charFound){
                newString += "x";
            } else {
                newString += dataString.charAt(i);
                charFound = false;
            }
        }
        return newString;
    }

    /*
    Prompts for a string, and a multiplier (int). Makes a new string that is
    the input string added on to it self as many times as the multiplier specifies.
    Returns the new, multiplied string.
     */
    public static String ex9(String input){
        //String input ="";
        int multiplier = 2;
        String newString ="";

        //System.out.println("Enter String:");
        //input = scanner.nextLine();
        //System.out.println("Enter multiplier (1 or more):");
        //multiplier = scanner.nextInt();

        if (multiplier > 0){
            for (int i = 0; i < multiplier; i++){
                newString += input;
            }
        }
        return newString;
    }

    /*
    From a user input, find the longest block of same-characters.
    e.g. "hello" -> 2, "Hellooo" -> 3, "Rhelloooaaaa" -> 4, "Hi mississippi" -> 2
     */
    public static String ex10(String input){
        //String input ="";
        int charCount = 0;
        int tempCount = 0;

        //System.out.println("Enter string:");
        //input = scanner.nextLine();
        for (int i = 1; i < input.length() -1; i++){
            //char tempChar = input.charAt(i);
            if (input.charAt(i) == input.charAt(i+1)){
                tempCount++;
                if (tempCount > charCount){
                    charCount = tempCount;
                }
            } else {
                tempCount = 1;
            }
        }
        return String.valueOf(charCount);
    }
}
