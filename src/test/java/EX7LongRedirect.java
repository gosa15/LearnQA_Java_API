import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


public class EX7LongRedirect {

    @Test
    public void testAPI(){
        String location = "https://playground.learnqa.ru/api/long_redirect";
        int statusCode = 0;

        while (statusCode != 200){
            Response response = RestAssured
                    .given()
                    .redirects()
                    .follow(false)
                    .when()
                    .get(location)
                    .andReturn();
            location = response.getHeader("Location");
            statusCode = response.getStatusCode();

            System.out.println(location);
            System.out.println(statusCode);
        }

    }

}