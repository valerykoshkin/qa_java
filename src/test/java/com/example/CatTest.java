package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;
    private Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(feline);
    }

    @Test
    public void catGetFoodTest() throws Exception {

        when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = cat.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void catGetSoundTest(){
        Cat cat = new Cat(feline);
        String expected = "Мяу";
        String actual = cat.getSound();
        Assert.assertEquals(expected, actual);
    }
}