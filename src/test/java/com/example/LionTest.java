package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test(expected = Exception.class)
    public void lionCostructorShouldBeNegativeTest() throws Exception {
        new Lion("Кот", feline);
    }

    @Test
    public void lionGetFoodTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expected,lion.getFood());
    }

    @Test
    public void lionGetKittensTest() throws Exception {
        Lion lion = new Lion("Самец",feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expected = 1;
        int actual = lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
        Assert.assertEquals(expected, actual);
    }
}