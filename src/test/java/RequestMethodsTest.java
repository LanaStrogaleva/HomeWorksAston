import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.matchesPattern;

public class RequestMethodsTest {
    Pattern pattern = Pattern.compile("Root=1-.*");
    final String BASE_URL = "https://postman-echo.com";
    final String GET_URL = "get?foo1=bar1&foo2=bar2";
    final String POST_URL = "post";
    final String PUT_URL = "put";
    final String PATCH_URL = "patch";
    final String DELETE_URL = "delete";

    RequestSpecification requestSpec = given()
            .cookie("sails.sid=s%3Ar77mSluKZWUa6SeYcALyX4e4rTOc7iL_.RPT%2FgIEdjSZbjTPEU7TewACaewXc3WODa2fmKxSkMuw")
            .header("Cache-Control", "no-cache");

    ResponseSpecification responseSpec = expect()
            .body("headers.x-forwarded-proto", equalTo("https"))
            .body("headers.x-forwarded-port", equalTo("443"))
            .body("headers.host", equalTo("postman-echo.com"))
            .body("headers.x-amzn-trace-id", matchesPattern(pattern))
            .body("headers.cookie", equalTo("sails.sid=s%3Ar77mSluKZWUa6SeYcALyX4e4rTOc7iL_.RPT%2FgIEdjSZbjTPEU7TewACaewXc3WODa2fmKxSkMuw=null"))
            .body("headers.cache-control", equalTo("no-cache"))
            .body("headers.accept", equalTo("*/*"))
            .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.20.1)"))
            .body("headers.accept-encoding", equalTo("gzip,deflate"));


    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    public void whenGetRequest() {
        Map<String, String> expectedArgs = new LinkedHashMap<>();
        expectedArgs.put("foo1", "bar1");
        expectedArgs.put("foo2", "bar2");

        given()
                .spec(requestSpec)
                .when().get(GET_URL)
                .then()
                .log()
                .body()
                .statusCode(200)
                .and()
                .body("args", equalTo(expectedArgs))
                .and()
                .spec(responseSpec)
                .and()
                .body("url", equalTo(BASE_URL + "/" + GET_URL));
    }

    @Test
    public void whenPostRawTextRequest() {
        String expectedData = "This is expected to be sent back as part of response body.";
        Map<String, String> expectedEmptyMap = new HashMap<>();

        given()
                .log().body()
                .contentType("application/json")
                .body(expectedData)
                .cookie("sails.sid=s%3Ar77mSluKZWUa6SeYcALyX4e4rTOc7iL_.RPT%2FgIEdjSZbjTPEU7TewACaewXc3WODa2fmKxSkMuw")
                .header("Cache-Control", "no-cache")
                .when().post(POST_URL)
                .then()
                .log()
                .body()
                .statusCode(200)
                .and()
                .body("args", equalTo(expectedEmptyMap))
                .body("data", equalTo(expectedData))
                .body("files", equalTo(expectedEmptyMap))
                .body("form", equalTo(expectedEmptyMap))
                .and()
                .spec(responseSpec)
                .body("headers.content-length", equalTo("58"))
                .body("headers.content-type", equalTo("application/json"))
                .and()
                .body("json", equalTo(null))
                .body("url", equalTo(BASE_URL + "/" + POST_URL));
    }

    @Test
    public void whenPostFormDataRequest() {
        String foo1 = "bar1";
        String foo2 = "bar2";
        String body = String.format("foo1=%s&foo2=%s", foo1, foo2);

        Map<String, String> expectedEmptyMap = new HashMap<>();

        Map<String, String> expectedForm = new HashMap<>();
        expectedForm.put("foo1", "bar1");
        expectedForm.put("foo2", "bar2");

        RequestSpecification rs = RestAssured.given();
        rs.config(RestAssured.config().encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)));
        rs.header("Content-Type", "application/x-www-form-urlencoded")
                .cookie("sails.sid=s%3Ar77mSluKZWUa6SeYcALyX4e4rTOc7iL_.RPT%2FgIEdjSZbjTPEU7TewACaewXc3WODa2fmKxSkMuw")
                .header("Cache-Control", "no-cache");

        rs
                .body(body)
                .when().post(POST_URL)
                .then()
                .log()
                .body()
                .statusCode(200)
                .and()
                .body("args", equalTo(expectedEmptyMap))
                .body("data", equalTo(""))
                .body("files", equalTo(expectedEmptyMap))
                .body("form", equalTo(expectedForm))
                .and()
                .spec(responseSpec)
                .body("headers.content-length", equalTo("19"))
                .body("headers.content-type", equalTo("application/x-www-form-urlencoded"))
                .and()
                .body("json", equalTo(expectedForm))
                .body("url", equalTo(BASE_URL + "/" + POST_URL));
    }

    @Test
    public void whenPutRequest() {
        String expectedData = "This is expected to be sent back as part of response body.";
        Map<String, String> expectedEmptyMap = new HashMap<>();

        given()
                .spec(requestSpec)
                .log().body()
                .contentType("application/json")
                .body(expectedData)
                .when().put(PUT_URL)
                .then()
                .log()
                .body()
                .statusCode(200)
                .and()
                .body("args", equalTo(expectedEmptyMap))
                .body("data", equalTo(expectedData))
                .body("files", equalTo(expectedEmptyMap))
                .body("form", equalTo(expectedEmptyMap))
                .and()
                .spec(responseSpec)
                .body("headers.content-length", equalTo("58"))
                .body("headers.content-type", equalTo("application/json"))
                .and()
                .body("json", equalTo(null))
                .body("url", equalTo(BASE_URL + "/" + PUT_URL));
    }

    @Test
    public void whenPatchRequest() {
        String expectedData = "This is expected to be sent back as part of response body.";
        Map<String, String> expectedEmptyMap = new HashMap<>();

        given()
                .spec(requestSpec)
                .log().body()
                .contentType("application/json")
                .body(expectedData)
                .when().patch(PATCH_URL)
                .then()
                .log()
                .body()
                .statusCode(200)
                .and()
                .body("args", equalTo(expectedEmptyMap))
                .body("data", equalTo(expectedData))
                .body("files", equalTo(expectedEmptyMap))
                .body("form", equalTo(expectedEmptyMap))
                .and()
                .spec(responseSpec)
                .body("headers.content-length", equalTo("58"))
                .body("headers.content-type", equalTo("application/json"))
                .and()
                .body("json", equalTo(null))
                .body("url", equalTo(BASE_URL + "/" + PATCH_URL));
    }

    @Test
    public void whenDeleteRequest() {
        String expectedData = "This is expected to be sent back as part of response body.";
        Map<String, String> expectedEmptyMap = new HashMap<>();

        given()
                .spec(requestSpec)
                .log().body()
                .contentType("application/json")
                .body(expectedData)
                .when().delete(DELETE_URL)
                .then()
                .log()
                .body()
                .statusCode(200)
                .and()
                .body("args", equalTo(expectedEmptyMap))
                .body("data", equalTo(expectedData))
                .body("files", equalTo(expectedEmptyMap))
                .body("form", equalTo(expectedEmptyMap))
                .and()
                .spec(responseSpec)
                .body("headers.content-length", equalTo("58"))
                .body("headers.content-type", equalTo("application/json"))
                .and()
                .body("json", equalTo(null))
                .body("url", equalTo(BASE_URL + "/" + DELETE_URL));
    }

}
