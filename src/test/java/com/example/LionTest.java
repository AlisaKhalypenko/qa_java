package com.example;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;

import static org.junit.Assert.assertThrows;


    @RunWith(Parameterized.class)
    public class LionTest extends TestCase {

        private final String sex;
        private final boolean expected;
        private final Feline feline;


     public LionTest (String sex, boolean expected, Feline feline){
         this.sex = sex;
         this.expected = expected;
         this.feline = feline;
    }

     @Parameterized.Parameters
     public static Object[][] getParams() {
         return new Object[][] {
                 {"Самец", true, new Feline()},
                 {"Самка", false, new Feline()},

        };
    }

     @Test
     public void doesHaveManeException() throws Exception{
         assertThrows(Exception.class, () -> new Lion("Другое", new Feline()));
    }

     @Test
     public void doesHaveManeReturnCorrectValue() throws Exception {
         Lion lion = new Lion(sex, feline) ;
         boolean actual = lion.doesHaveMane();
         assertEquals(expected, actual);
    }

     @Test
     public void getKittensReturnValue() throws Exception{
         Lion lion = new Lion("Самец", feline);
         int actual = lion.getKittens();
         assertEquals(1, actual);
    }


     @Test
     public void getFoodReturnList() throws Exception{
         List<String> eat = List.of("Животные", "Птицы", "Рыба");
         Lion lion = new Lion("Самец", feline);
         List<String> eatLion = lion.getFood();
         Assert.assertEquals(eat, eatLion);
    }
}