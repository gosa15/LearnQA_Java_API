import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


public class EX6Redirect {

    @Test
    public void testAPI(){
        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get("https://playground.learnqa.ru/api/long_redirect")
                .andReturn();


        String locationHeaders = response.getHeader("Location");
        System.out.println(locationHeaders);

        String body = response.getBody().asString();

        System.out.println(body);
    }

}