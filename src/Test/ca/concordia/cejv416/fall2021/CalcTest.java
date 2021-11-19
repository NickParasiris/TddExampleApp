package ca.concordia.cejv416.fall2021;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    Calc calculatorObject;

    @BeforeEach
    void setUp()
    {
        calculatorObject = new Calc();
    }

    @Test
    void addNumbers()
    {
        //Assemble
        int num1 = 2;
        int num2 = 3;
        int expectedResult = 5;

        //Act
        int result = calculatorObject.addNumbers(num1, num2);

        //Assert
        Assertions.assertEquals(expectedResult, result);

    }

    @Test
    void divideNumbers()
    {
        double num1 = 4.00;
        double num2 = 2.00;
        double expectedResult = 2.00;

        double result = calculatorObject.divideNumbers(num1, num2);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void exceptionTesting()
    {
        Exception e = assertThrows(ArithmeticException.class, () -> {
            calculatorObject.divideNumbers(10, 0);
        });

        assertEquals("/ by 0", e.getMessage());
        
    }

    @Test
    void addNumsPerformance()
    {
        int expectedResult = 5;

        int actualResult = assertTimeout(Duration.ofMillis(200), () -> {

            TimeUnit.MILLISECONDS.sleep(150);
            return calculatorObject.addNumbers(2, 3);
        });

        Assertions.assertEquals(expectedResult, actualResult);
    }
}