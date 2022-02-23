package com.example;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;


    @RunWith(MockitoJUnitRunner.class)
    public class CatTest extends TestCase{

     @Mock
     private Feline feline;

     @Test
     public void getSoundReturnCorrectValue() {

        Cat cat = new Cat(feline);
        String sound = cat.getSound();
        Assert.assertEquals("Мяу", sound);
    }

     @Test
     public void getFoodReturnFoodList() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expected =  List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expected);
        List<String> actual = cat.getFood();
        Assert.assertEquals(expected, actual);

        // Спасибо за разъяснения! Поняла, поправила, тест не упал. Ура!))

    }
}