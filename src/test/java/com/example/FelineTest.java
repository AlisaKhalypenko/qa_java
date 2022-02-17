package com.example;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;


@RunWith(Parameterized.class)
public class FelineTest extends TestCase {

    private final int getKittens;
    private final int expected;


    public FelineTest (int getKittens, int expected){
        this.getKittens = getKittens;
        this.expected = expected;

    }
    @Parameterized.Parameters
    public static Object[][] Count() {
        return new Object[][] {
                {1, 1},
                {15, 15},
        };
    }

    @Test
    public void eatMeatReturnList() throws Exception{
        Feline feline = new Feline();
        List<String> eat = List.of("Животные", "Птицы", "Рыба");
        List<String> eatFeline = feline.eatMeat();
        Assert.assertEquals(eat, eatFeline);
    }

    @Test
    public void getFamilyReturnCorrectValue() {
        Feline feline = new Feline();
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getKittensReturnCorrectValueOfKittens() {
        Feline feline = new Feline();
        int actual = feline.getKittens();
        assertEquals(1, actual);
    }


    @Test
    public void getKittensReturnCorrectNumber() {
        Feline feline = new Feline();
        int actual = feline.getKittens(getKittens);
        assertEquals(getKittens, actual);
    }
}