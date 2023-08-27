import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;



public class EX5Parsing {

    @Test
    public void testAPI() {
        JsonPath response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/get_json_homework")
                .jsonPath();
        System.out.println(response.get("messages[1].message").toString());
    }

}

