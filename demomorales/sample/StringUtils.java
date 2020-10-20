package sample;

import javax.swing.*;

public abstract class StringUtils {

    public static String exc1(String input) {
        return ("<" + input + ">");
    }

    public static String exc2(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ')
                count++;

        }
        return "there are " + count + " letters in your text";
    }

    public static String exc3(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (i > 0) {
                result.append("@");
            }
            result.append(input.charAt(i));
        }
        return (result.toString());
    }

    public static String exc4(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static String exc5(String input) {
        String output = "";
        int x = input.length();
        input = input.toLowerCase();
        char[] letters = input.toCharArray();
        String[] english = {" ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
                "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

        String[] morse = {" /", ". ___", "___ . . .", "___ . ___ .", "___ . .", ".", ". . ___ .", "___ ___ .",
                ". . . .", ". .", ". ___ ___ ___", "___ . ___", ". ___ . .", "___ ___", "___ .", "___ ___ ___",
                ". ___ ___ .", "___ ___ . ___", ". ___ .", ". . .", "_", ". . ___", ". . . ___", ". ___ ___",
                "___ . . ___", "___ . ___ ___", "___ ___ . .", ". ___ ___ ___ ___", ". . ___ ___ ___",
                ". . . ___ ___", ". . . . ___", ". . . . .", "___ . . . .", "___ ___ . . .", "___ ___ ___ . .",
                "___ ___ ___ ___ .", "___ ___ ___ ___ ___"};

        String[] text = new String[x];
        String[] text2 = new String[x];

        for (int i = 0; i < x; i++) {
            text[i] = Character.toString(letters[i]);
            for (int n = 0; n < morse.length; n++) {
                if (english[n].contains(text[i])) {
                    text2[i] = morse[n];
                }
                if (text2[i] == null) {
                    text2[i] = "";
                }
            }
        }
        for (int n = 0; n < x; n++) {
            output += text2[n] + " ";
            if (n == x - 1) {
                return "Whatever you wrote in morse: " + output;
            }
        }
        return "something went wrong";
    }

    public static String exc6(String input) {
        String[] contains = {"horse", "saddle", "spores", "bitch"};
        String[] replace = {"*****", "******", "******", "*****"};
        {
            for (int i = 0; i < contains.length; i++) {
                if (input.contains(contains[i])) {
                    input = input.replace(contains[i], replace[i]);
                }
            }
        }
        return input;
    }

    public static String exc7(String input)
        {
          return input + exc4(input);
        }

    public static String exc8(String input) {
        char[] newString = input.toCharArray();
        for (int i = 0; i < input.length(); i++) {
            if (i == 0) {
                newString[i] = Character.toUpperCase(newString[i]);
            } else if (input.charAt(i - 1) == ' ' || Character.isLowerCase(newString[i - 1])) {
                newString[i] = Character.toUpperCase(newString[i]);
            }
        }
        input = input + newString;
        return input;

    }
}
