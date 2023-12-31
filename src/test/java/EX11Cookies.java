import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class EX11Cookies {
    @Test
    public void testAPI() {
        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/homework_cookie")
                .andReturn();
        Map<String, String> responseCookies = response.getCookies();
        List<String> keyCookies = new ArrayList<>(response.getCookies().keySet());

        assertEquals("hw_value", responseCookies.get("HomeWork"), "Значение куки не совпадает");
        assertEquals("HomeWork", keyCookies.get(0), "Название куки не совпадает");


    }
}
