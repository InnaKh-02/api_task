import org.junit.jupiter.api.*;
import service.UserService;
import static org.junit.jupiter.api.Assertions.*;

public class ApiTest {
    private UserService userService;

    @BeforeEach
    public void setup() {
        userService = new UserService();
    }

    @Test
    @DisplayName("Verify that the response status code is 200 OK")
    public void testStatusCodeIs200() {
        int statusCode = userService.getStatusCode();
        assertEquals(200, statusCode, "Status code should be 200");
    }

    @Test
    @DisplayName("Verify that the Content-Type header is 'application/json; charset=utf-8'")
    public void testContentTypeHeader() {
        String contentType = userService.getContentType();
        assertNotNull(contentType, "Content-Type header should exist");
        assertEquals("application/json; charset=utf-8", contentType, "Content-Type value should match expected");
    }

    @Test
    @DisplayName("Verify that the response body contains 10 users")
    public void testResponseBodyHas10Users() {
        int userCount = userService.getUsersCount();
        assertEquals(10, userCount, "User count should be 10");
    }
}