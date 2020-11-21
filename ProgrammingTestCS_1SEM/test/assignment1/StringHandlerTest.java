package assignment1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringHandlerTest {
    private StringHandler handler;

    @BeforeEach
    public void setUp() {
        handler = new StringHandler();
    }

    //opgave 1a
    @Test
    public void testStringManipulation() {
        String str  = "citron";
        String expected = "sitron";
        String actual = handler.stringManipulation(str);
        Assertions.assertEquals(expected, actual);
    }
    
     //opgave 1a
    @Test
    public void testStringManipulationSeveralMatches() {
        String str  = "cacao";
        String expected = "sasao";
        String actual = handler.stringManipulation(str);
        Assertions.assertEquals(expected, actual);
    }
    
     //opgave 1a
    @Test
    public void testStringNoManipulation() {
        String str  = "si";
        String expected = "si";
        String actual = handler.stringManipulation(str);
        Assertions.assertEquals(expected, actual);
    }

    //opgave 1b
    @Test
    public void testStringLength() {
        int expected = 5;
        int actual = handler.stringLength("hello");
        Assertions.assertEquals(expected, actual);
    }

    //opgave 1b
    @Test
    public void testEmptyStringLength() {
        int expected = 0;
        int actual = handler.stringLength("");
        Assertions.assertEquals(expected, actual);
    }
    
     //opgave 1b
    @Test
    public void testNullStringLength() {
        int expected = 0;
        int actual = handler.stringLength(null);
        Assertions.assertEquals(expected, actual);
    }
    

    //opgave 1c
    @Test
    public void testStringLengthInArrayOneString() {
        int expected = 5;
        String[] arr = {"hello"};
        int actual = handler.stringArrayLength(arr);
        Assertions.assertEquals(expected, actual);
    }

    //opgave 1c
    @Test
    public void testStringLengthInArrayTwoStrings() {
        int expected = 10;
        String[] arr = {"hello", "world"};
        int actual = handler.stringArrayLength(arr);
        Assertions.assertEquals(expected, actual);
    }

    //opgave 1d
    @Test
    public void testStringReverse() {
        String expected = "olleh";
        String actual = handler.stringReverse("hello");
        Assertions.assertEquals(expected, actual);
    }
    
    //opgave 1e
    @Test
    public void testCharCount(){
        int expected = 3;
        int actual = handler.charCount("Ouagadougou", 'o');
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    public void testCharCountZero(){
        int expected = 0;
        int actual = handler.charCount("Hello", 'x');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testStringOfChars() {
        char c = 'q';
        int amount = 4;
        String expected = "qqqq";
        String actual = handler.stringOfChars(amount, c);
        Assertions.assertEquals(expected, actual);

        c = ' ';
        amount = 42;
        expected = "                                          ";
        actual = handler.stringOfChars(amount, c);
        Assertions.assertEquals(expected, actual);
    }

}
