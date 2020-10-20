package sample;

import java.util.Scanner;

public class stringUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static void braceString(String string){
        String brace = "<";
        String brace2 = ">";

        System.out.println(brace + string + brace2);
    }

    public static void countChars(String string){
        int charCount = 0;
        // Count characters
        for (int i = 0; i < string.length(); i++){
            if (string.charAt(i) != ' '){
                charCount++;
            }
        }
        System.out.println(string + " countains " + charCount + " characters.");
    }

    public static void separateChars(String string){

        for (int i = 0; i < string.length(); i++){
            if (string.charAt(i) != ' ') {
                System.out.print(string.charAt(i));
                System.out.print("@");
            } else if (string.charAt(i) == ' '){
                System.out.print(" ");
            }
        }
        System.out.println("");
    }

    public static void printReverse(String string) {
        //From any user input, write the input characters backwards
        for (int i = string.length() - 1; i >= 0; i--) {
            System.out.print(string.charAt(i));
        }
        System.out.println();

    }

    public static void palindrome(String string){
        System.out.print(string);
        printReverse(string);
    }

    public static void containsAndSubstitute(String string) {
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
        System.out.println(string);
    }

    /*From any user input, make the text alternate
        caps. e.g. "hi my name is peter" -> "Hi My NaMe Is PeTeR",
        ignore spaces when using caps.
         */
    public static String alternateCaps(String string){
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
    public static String stringFilter(){
        String dataString = "";
        String filter = "";
        String newString ="";
        boolean charFound = false;



        System.out.println("Enter Data-string:");
        dataString = scanner.nextLine();
        System.out.println("Enter filter-string:");
        filter = scanner.nextLine();


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
    public static String expander(){
        String input ="";
        int multiplier;
        String newString ="";

        System.out.println("Enter String:");
        input = scanner.nextLine();
        System.out.println("Enter multiplier (1 or more):");
        multiplier = scanner.nextInt();

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
    public static int sameCharCounter(){
        String input ="";
        int charCount = 0;
        int tempCount = 0;

        System.out.println("Enter string:");
        input = scanner.nextLine();
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
        return charCount;
    }
}
