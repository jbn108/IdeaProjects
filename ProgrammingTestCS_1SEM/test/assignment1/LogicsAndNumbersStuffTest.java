package assignment1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LogicsAndNumbersStuffTest {

    @Test
    void diffMultipliedByC() {
        int a = 5;
        int b = 3;
        int c = 21;
        int expected = 42;
        LogicsAndNumbersStuff instance = new LogicsAndNumbersStuff();
        int result = instance.diffMultipliedByC(a,b,c);
        Assertions.assertEquals(expected, result, "The expected result is 42, since (5-3)*21=42");

        a = 4;
        b = 8;
        c = 10;
        expected = -40;
        result = instance.diffMultipliedByC(a,b,c);
        Assertions.assertEquals(expected, result, "The expected result is -4 since (4-8)*10 = -40");
    }

    @Test
    void canYouStayInBed() {
        boolean weekday = true;
        boolean vacation = false;
        boolean expected = false;
        LogicsAndNumbersStuff instance = new LogicsAndNumbersStuff();
        boolean actual = instance.canYouStayInBed(weekday, vacation);
        Assertions.assertEquals(expected, actual, "Can't stay in bed on weekdays if you are not on vacation");

        weekday = false;
        vacation = false;
        expected = true;
        actual = instance.canYouStayInBed(weekday, vacation);
        Assertions.assertEquals(expected, actual, "If it's not a weekday you can always stay in bed");

        weekday = true;
        vacation = true;
        expected = true;
        actual = instance.canYouStayInBed(weekday, vacation);
        Assertions.assertEquals(expected, actual, "If you are on vacation you can always stay in bed");

        weekday = false;
        vacation = true;
        expected = true;
        actual = instance.canYouStayInBed(weekday, vacation);
        Assertions.assertEquals(expected, actual, "If you are on vacation you can always stay in bed");
    }

    @Test
    void sumOfNumbers() {
        int[] numbers = {2,4,4};
        int expected = 10;
        LogicsAndNumbersStuff instance = new LogicsAndNumbersStuff();
        int actual = instance.sumOfNumbers(numbers);
        Assertions.assertEquals(expected, actual);

        int[] numbersTwo = {2,-4,4,8,32};
        expected = 42;
        actual = instance.sumOfNumbers(numbersTwo);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void averageOfNumber() {
        int[] numbers = {2,4,4,6};
        double expected = 4.0;
        LogicsAndNumbersStuff instance = new LogicsAndNumbersStuff();
        double actual = instance.averageOfNumber(numbers);
        Assertions.assertEquals(expected, actual);

        int[] numbersTwo = {2,-4,4,6,2};
        expected = 2.0;
        actual = instance.averageOfNumber(numbersTwo);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void numberWithMostOccurrences() {
        int[] numbers = {2,4,4,6};
        int expected = 4;
        LogicsAndNumbersStuff instance = new LogicsAndNumbersStuff();
        int actual = instance.numberWithMostOccurrences(numbers);
        Assertions.assertEquals(expected, actual);

        int[] numbersTwo = {2,1983,4,6,6,6,6,1983,1983,1983};
        expected = 1983;
        actual = instance.numberWithMostOccurrences(numbersTwo);
        Assertions.assertEquals(expected, actual);
    }

}