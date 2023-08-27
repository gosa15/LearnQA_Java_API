import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import static java.lang.Thread.*;


public class EX8Tokens {

    @Test
    public void testAPI(){
        String location = "https://playground.learnqa.ru/ajax/api/longtime_job";
        String tokens = "";
        String status = "";
        String eqlStatus = "Job is NOT ready";
        int seconds = 0;

        JsonPath response = RestAssured
                .given()
                .when()
                .get(location)
                .jsonPath();

        tokens = response.get("token");
        seconds = response.get("seconds");
        System.out.println(tokens);
        System.out.println(seconds);

        response = RestAssured
                .given()
                .queryParam("token", tokens)
                .when()
                .get(location)
                .jsonPath();

        status = response.get("status");
        System.out.println(status);

        if (status.equals(eqlStatus)) {

            try {
                Thread.sleep(seconds * 1000);
            } catch (InterruptedException ie) {
                //Handle exception
            }

            response = RestAssured
                    .given()
                    .queryParam("token", tokens)
                    .when()
                    .get(location)
                    .jsonPath();

            status = response.get("status");
            System.out.println(status);
        }
    }

}