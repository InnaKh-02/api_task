package service;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserService {
    private final String endpoint = "https://jsonplaceholder.typicode.com/users";

    public int getStatusCode() {
        return getResponse().getStatusCode();
    }

    public String getContentType() {
        return getResponse().getHeader("Content-Type");
    }

    public int getUsersCount() {
        return getResponse().jsonPath().getList("$").size();
    }

    private Response getResponse() {
        return given().when().get(endpoint);
    }
}
