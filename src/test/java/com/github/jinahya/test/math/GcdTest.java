package com.github.jinahya.test.math;

import org.apache.commons.math3.util.ArithmeticUtils;
import org.junit.jupiter.api.Test;

import static java.util.concurrent.ThreadLocalRandom.current;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GcdTest {

    @Test
    void commons() {
        {
            assertThrows(ArithmeticException.class, () -> ArithmeticUtils.gcd(Integer.MIN_VALUE, Integer.MIN_VALUE));
            assertThrows(ArithmeticException.class, () -> ArithmeticUtils.gcd(Integer.MIN_VALUE, 0));
            assertThrows(ArithmeticException.class, () -> ArithmeticUtils.gcd(0, Integer.MIN_VALUE));
        }
        {
            int x = 0;
            while (x == 0 || x == Integer.MIN_VALUE) {
                x = current().nextInt();
            }
            assertEquals(x, ArithmeticUtils.gcd(x, x));
            assertEquals(x, ArithmeticUtils.gcd(x, 0));
            assertEquals(x, ArithmeticUtils.gcd(0, x));
        }
        {
            assertEquals(0, ArithmeticUtils.gcd(0, 0));
        }
    }
}
