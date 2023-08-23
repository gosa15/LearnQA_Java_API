import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class HelloTest {

   @Test
    public void testAPI(){
       Response response = RestAssured
               .get("https://playground.learnqa.ru/api/get_text")
               .andReturn();

       response.prettyPrint();
   }

}
