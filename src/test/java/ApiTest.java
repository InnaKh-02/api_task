import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class ApiTest {

    private final String endpointUsers = "https://jsonplaceholder.typicode.com/users";
    private final String endpointPosts = "https://jsonplaceholder.typicode.com/posts";

    @Test
    @DisplayName("Verify that the response status code is 200 OK")
    public void testStatusCodeIs200() {
        given().
            when().
                get(endpointUsers).
        then().
            assertThat().
                statusCode(200);
    }

    @Test
    @DisplayName("Verify that the Content-Type header is 'application/json; charset=utf-8'")
    public void testContentTypeHeader() {
        given().
            when().
                get(endpointUsers).
        then().
            assertThat().
                header("Content-Type", notNullValue()).
                header("Content-Type", equalTo("application/json; charset=utf-8"));
    }

    @Test
    @DisplayName("Verify that the response body contains 10 users")
    public void testResponseBodyHas10Users() {
        given().
            when().
                get(endpointUsers).
        then().
            assertThat().
                body("size()", equalTo(10));
    }

    @Test
    @DisplayName("Verify that a post is deleted successfully")
    public void testAbsentPost() {
        int postId = 1;
        given()
        .when()
            .delete(endpointPosts + "/" + postId)
        .then().
            assertThat()
                .statusCode(200);
    }


    @Test
    @DisplayName("Verify that a post is updated successfully")
    public void testUpdatePost() {
        int postId = 20;
        String body = """
            {
            "userId": 3,
            "id": 20,
            "title": "doloribus ad provident suscipit at",
            "body": "qui consequuntur ducimus possimus quisquam amet similique\\nsuscipit porro ipsam amet\\neos veritatis officiis exercitationem vel fugit aut necessitatibus totam\\nomnis rerum consequatur expedita quidem cumque explicabo"
            }
            """;
        given()
            .header("Content-Type", "application/json; charset=UTF-8")
            .body(body)
        .when()
            .put(endpointPosts + "/" + postId)
        .then()
            .assertThat()
                .statusCode(200)
                .body("userId", equalTo(3))
                .body("id", equalTo(20))
                .body("title", equalTo("doloribus ad provident suscipit at"))
                .body("body", equalTo("qui consequuntur ducimus possimus quisquam amet similique\nsuscipit porro ipsam amet\neos veritatis officiis exercitationem vel fugit aut necessitatibus totam\nomnis rerum consequatur expedita quidem cumque explicabo"));
    }
}
