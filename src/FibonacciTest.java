import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test()
    void getFibonacciForZero(){
        Assertions.assertThrows(NotImplementedException.class, () -> Fibonacci.getFibonacci(0));
    }

    @Test
    void getFibonacciForNonZero() {

        Assertions.assertEquals(0, Fibonacci.getFibonacci(1));
        Assertions.assertEquals(1, Fibonacci.getFibonacci(2));
        Assertions.assertEquals(1, Fibonacci.getFibonacci(3));
        Assertions.assertEquals(2, Fibonacci.getFibonacci(4));
        Assertions.assertEquals(3, Fibonacci.getFibonacci(5));
        Assertions.assertEquals(5, Fibonacci.getFibonacci(6));
        Assertions.assertEquals(8, Fibonacci.getFibonacci(7));
        Assertions.assertEquals(13, Fibonacci.getFibonacci(8));

    }
}