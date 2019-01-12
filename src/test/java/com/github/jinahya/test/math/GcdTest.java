package com.github.jinahya.test.math;

import com.google.common.math.IntMath;
import com.google.common.math.LongMath;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.junit.jupiter.api.Test;

import static java.util.concurrent.ThreadLocalRandom.current;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Greatest common deivisor.
 */
public class GcdTest {

    // -----------------------------------------------------------------------------------------------------------------
    /**
     * Tests {@link ArithmeticUtils#gcd(int, int)}.
     */
    @Test
    public void commonsInt() {
        {
            assertThrows(ArithmeticException.class, () -> ArithmeticUtils.gcd(Integer.MIN_VALUE, Integer.MIN_VALUE));
            assertThrows(ArithmeticException.class, () -> ArithmeticUtils.gcd(Integer.MIN_VALUE, 0));
            assertThrows(ArithmeticException.class, () -> ArithmeticUtils.gcd(0, Integer.MIN_VALUE));
        }
        {
            int x;
            do {
                x = current().nextInt();
            } while (x == 0 || x == Integer.MIN_VALUE);
            assertNotEquals(0, x);
            assertNotEquals(Integer.MIN_VALUE, x);
            assertEquals(Math.abs(x), ArithmeticUtils.gcd(x, x));
            assertEquals(Math.abs(x), ArithmeticUtils.gcd(x, 0));
            assertEquals(Math.abs(x), ArithmeticUtils.gcd(0, x));
        }
        {
            assertEquals(0, ArithmeticUtils.gcd(0, 0));
        }
    }

    /**
     * Tests {@link ArithmeticUtils#gcd(long, long)}.
     */
    @Test
    public void commonsLong() {
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
            assertNotEquals(0L, x);
            assertNotEquals(Long.MIN_VALUE, x);
            assertEquals(Math.abs(x), ArithmeticUtils.gcd(x, x));
            assertEquals(Math.abs(x), ArithmeticUtils.gcd(x, 0L));
            assertEquals(Math.abs(x), ArithmeticUtils.gcd(0L, x));
        }
        {
            assertEquals(0L, ArithmeticUtils.gcd(0L, 0L));
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    /**
     * Tests {@link IntMath#gcd(int, int)}.
     */
    @Test
    public void guavaInt() {
        {
            assertThrows(IllegalArgumentException.class, () -> IntMath.gcd(
                    current().nextInt() | Integer.MIN_VALUE, current().nextInt() >>> 1));
            assertThrows(IllegalArgumentException.class, () -> IntMath.gcd(
                    current().nextInt() >>> 1, current().nextInt() | Integer.MIN_VALUE));
            assertThrows(IllegalArgumentException.class, () -> IntMath.gcd(
                    current().nextInt() | Integer.MIN_VALUE, current().nextInt() | Integer.MIN_VALUE));
        }
        {
            int x;
            do {
                x = current().nextInt();
            } while (x <= 0);
            assertEquals(x, IntMath.gcd(x, x));
            assertEquals(x, IntMath.gcd(x, 0));
            assertEquals(x, IntMath.gcd(0, x));
        }
        {
            assertEquals(0, IntMath.gcd(0, 0));
        }
    }

    /**
     * Tests {@link LongMath#gcd(long, long)}.
     */
    @Test
    public void guavaLong() {
        {
            assertThrows(IllegalArgumentException.class, () -> LongMath.gcd(
                    current().nextLong() | Long.MIN_VALUE, current().nextLong() >>> 1));
            assertThrows(IllegalArgumentException.class, () -> LongMath.gcd(
                    current().nextLong() >>> 1, current().nextLong() | Long.MIN_VALUE));
            assertThrows(IllegalArgumentException.class, () -> LongMath.gcd(
                    current().nextLong() | Long.MIN_VALUE, current().nextLong() | Long.MIN_VALUE));
        }
        {
            long x;
            do {
                x = current().nextLong();
            } while (x <= 0L);
            assertEquals(x, LongMath.gcd(x, x));
            assertEquals(x, LongMath.gcd(x, 0L));
            assertEquals(x, LongMath.gcd(0L, x));
        }
        {
            assertEquals(0L, LongMath.gcd(0L, 0L));
        }
    }
}
