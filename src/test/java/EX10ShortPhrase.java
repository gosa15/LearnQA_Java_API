import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class EX10ShortPhrase {

    @ParameterizedTest
    @ValueSource (strings = {"","1","qazxswedcvfrtgb","qazxswedcvfrtg","qaztxswedcvfrtgb"})
    @Test
    public void testPhrase(String phrase){
        System.out.println("Длина строки равна: "+phrase.length());

        assertTrue(phrase.length() > 15, "Фраза меньше 15 символов");
    }



}
