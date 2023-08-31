import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;


public class EX12Header {
    Headers responseHeaders;
    @BeforeEach
    public void homeworkHeader(){
        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/homework_header")
                .andReturn();

        this.responseHeaders = response.getHeaders();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Date","Content-Length","Keep-Alive","Expires"})
    public void testAssertTrue(String name) {

        assertTrue(responseHeaders.hasHeaderWithName(name), "Заголовка "+name+" нет в ответе");
        assertNotNull(responseHeaders.getValue(name));

    }

    @Test
    public void testAssertEquals() {

        assertEquals("application/json", responseHeaders.getValue("Content-Type"), "Значение заголовка  Content-Type отличается от application/json");
        assertEquals("keep-alive", responseHeaders.getValue("Connection"), "Значение заголовка  Content-Type отличается от application/json");
        assertEquals("Apache", responseHeaders.getValue("Server"), "Значение заголовка  Content-Type отличается от application/json");
        assertEquals("Some secret value", responseHeaders.getValue("x-secret-homework-header"), "Значение заголовка  Content-Type отличается от application/json");
        assertEquals("max-age=0", responseHeaders.getValue("Cache-Control"), "Значение заголовка  Content-Type отличается от application/json");

    }

}
