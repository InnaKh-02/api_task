# API Task

## Task Description
This project includes automated API tests to verify:

1. **HTTP Status Code Validation**
   - **A GET request should return HTTP status 200 OK.**
2. **HTTP Header Validation**
   - **The Content-Type header must exist.**
   - **The header value must be application/json; charset=utf-8.**
3. **Response Body Validation**
   - **The response body should contain an array of 10 users.**

## Technologies Used
- Java 17+
- JUnit 5 (Jupiter)
- Rest Assured 5.5.1
- Maven 3+
- Parallel Execution Enabled

## Running the Tests in IntelliJ IDEA

1. Open the project in **IntelliJ IDEA**.
2. Navigate to the test class (e.g., `ApiTest.java`).
3. Right-click on the class or individual test methods and select **Run** to execute the tests.

---

## Maven Commands

### Clean and Test
```bash
mvn clean test
```

### Generate Test Report
```bash
mvn surefire-report:report
```


