package ru.yandex;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;

@RunWith(Parameterized.class)
public class AgeTest {
    
    private final int age;
    private final boolean result;
    private final String message;
    
    public AgeTest(int age, boolean result, String message) {
        this.age =  age;
        this.result = result;
        this.message = message;
    }
    
    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][] {
            {19, true, "Передан возраст совершеннолетнего 19 лет"},
            {18, true, "Передан возраст совершеннолетнего 18 лет"},
            {17, false, "Передан возраст несовершеннолетнего 17 лет"},
            {21, true, "Передан возраст совершеннолетнего 21 год"},
        };
    }
    
    @Test
    public void checkIsAdultWhenAgeThenResult() {
        Age program = new Age();
        // Передай сюда возраст пользователя
        boolean isAdult = program.isAdult(age);
        // Сравни полученный и ожидаемый результаты, не забудь про сообщение об ошибке
        assertEquals(message,result,isAdult);
    }
}