package sample;

public class stringUtils {


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

    public static void alternateCaps(String string){
        /*From any user input, make the text alternate
        caps. e.g. "hi my name is peter" -> "Hi My NaMe Is PeTeR",
        ignore spaces when using caps.
         */
        char[] newString = string.toCharArray();

            for (int i = 0; i < string.length(); i++){
                if (i == 0){
                    newString[i] = Character.toUpperCase(newString[i]);
                } else if (string.charAt(i-1) == ' ' || Character.isLowerCase(newString[i-1])){
                    newString[i] = Character.toUpperCase(newString[i]);
                }
            }

        System.out.println(newString);
    }

}
