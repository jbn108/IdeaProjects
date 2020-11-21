package assignment2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class FlipCoinTest {

    //opgave 2
    @Test
    public void testFlipCoin() {
        FlipCoin coin = new FlipCoin();
        int zero = 0;
        int one = 0;
        int none = 0;
        for (int i = 0; i < 10000; i++) {
            int result = coin.flipCoin();
            switch (result) {
                case 0 -> zero++;
                case 1 -> one++;
                default -> none++;
            }
        }
        Assertions.assertTrue(zero > 10);
        Assertions.assertTrue(one > 10);
        Assertions.assertEquals(none, 0);
        int diff = Math.abs(zero - one);
        Assertions.assertTrue(diff < 100, "The difference in coin flips should be less than 100 on 10000 coin flips");
    }
}
