package com.example;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;


@RunWith(Parameterized.class)

public class LionTest extends TestCase {

    private final String sex;
    private final boolean expected;


    public LionTest (String sex, boolean expected){
        this.sex = sex;
        this.expected = expected;

    }

    @Parameterized.Parameters
    public static Object[][] getSex() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
                {"Другое", false},
                //как протестировать исключение? так, как выше в последнем массиве??
        };
    }

    @Test
    public void doesHaveManeReturnCorrectValue() throws Exception {
        Lion lion = new Lion(sex) ;
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }

    @Test
    public void getKittensReturnValue() throws Exception{
        Lion lion = new Lion("Самец");
        int actual = lion.getKittens();
        assertEquals(1, actual);
    }


    @Test
    public void eatMeatReturnList() throws Exception{
        List<String> eat = List.of("Животные", "Птицы", "Рыба");
        Lion lion = new Lion("Самец");
        List<String> eatLion = lion.eatMeat();
        Assert.assertEquals(eat, eatLion);
    }
}