package com.github.jinahya.test.math;

import org.apache.commons.math3.util.ArithmeticUtils;
import org.junit.jupiter.api.Test;

import static java.util.concurrent.ThreadLocalRandom.current;
import static org.junit.jupiter.api.Assertions.*;

public class GcdTest {

    @Test
    void commons() {
        // -------------------------------------------------------------------------------------------------------------
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
            assertNotSame(0, x);
            assertNotSame(Integer.MIN_VALUE, x);
            assertEquals(x, ArithmeticUtils.gcd(x, x));
            assertEquals(x, ArithmeticUtils.gcd(x, 0));
            assertEquals(x, ArithmeticUtils.gcd(0, x));
        }
        {
            assertEquals(0, ArithmeticUtils.gcd(0, 0));
        }
        // -------------------------------------------------------------------------------------------------------------
        {
            assertThrows(ArithmeticException.class, () -> ArithmeticUtils.gcd(Long.MIN_VALUE, Long.MIN_VALUE));
            assertThrows(ArithmeticException.class, () -> ArithmeticUtils.gcd(Long.MIN_VALUE, 0));
            assertThrows(ArithmeticException.class, () -> ArithmeticUtils.gcd(0, Long.MIN_VALUE));
        }
        {
            long x = 0L;
            while (x == 0L || x == Long.MIN_VALUE) {
                x = current().nextLong();
            }
            assertNotSame(0L, x);
            assertNotSame(Long.MIN_VALUE, x);
            assertEquals(x, ArithmeticUtils.gcd(x, x));
            assertEquals(x, ArithmeticUtils.gcd(x, 0L));
            assertEquals(x, ArithmeticUtils.gcd(0L, x));
        }
        {
            assertEquals(0L, ArithmeticUtils.gcd(0L, 0L));
        }
    }
}
