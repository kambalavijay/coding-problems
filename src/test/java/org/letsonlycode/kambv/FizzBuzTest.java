package org.letsonlycode.kambv;

import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FizzBuzTest {

    private final FizzBuz fizzBuzz;
    private final int number;
    private final String expected;

    public FizzBuzTest(int number, String expected) {

        this.fizzBuzz = new FizzBuz();
        this.number = number;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 5, "Fizz" }, { 3, "Buzz" },{ 1, "No" }, { 15, "FizzBuzz" }
        });
    }

    @Test
    public void isFizzBuzzTest() {
        String actual = fizzBuzz.isFuzzBuzz(number);
        Assert.assertEquals("expected and actual values are not equal",expected, actual);
    }

    /*@Test
    public void isFizzBuzzTest2() {
        String actual = fizzBuzz.isFuzzBuzz(5);
        Assert.assertEquals("expected and actual values are not equal","Fizz", actual);
    }

    @Test
    public void isFizzBuzzTest3() {
        String actual = fizzBuzz.isFuzzBuzz(9);
        Assert.assertEquals("expected and actual values are not equal","Buzz", actual);
    }

    @Test
    public void isFizzBuzzTest4() {
        String actual = fizzBuzz.isFuzzBuzz(8);
        Assert.assertEquals("expected and actual values are not equal","No", actual);
    }*/

}