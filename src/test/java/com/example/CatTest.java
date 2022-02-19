package com.example;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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

    // @Mock
    //Predator predator;
   @Test
    public void getFoodReturnFoodList() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expected =  List.of("Животные", "Птицы", "Рыба");
        // Mockito.when(predator.eatMeat()).thenReturn(expected);
        List<String> actual = cat.getFood();
        Assert.assertEquals(expected, actual);

        /* просьба прокомментировать этот тест: он падает, т.к. значение Actual
        получается пустым. Кажется, что так должно быть, т.к. ни в интерфейсе Predator
        ни в классе Cat тело метода не прописано. Так ли должен проходить тест или я что-то
        не так понимаю???*/

    }
}