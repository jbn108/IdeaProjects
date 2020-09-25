package sample;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        //stringUtils.braceString(input);
        //stringUtils.countChars(input);
        //stringUtils.separateChars(input);
        //stringUtils.printReverse(input);
        //stringUtils.containsAndSubstitute(input);
        //stringUtils.palindrome(input);
        stringUtils.alternateCaps(input);


    }
}
