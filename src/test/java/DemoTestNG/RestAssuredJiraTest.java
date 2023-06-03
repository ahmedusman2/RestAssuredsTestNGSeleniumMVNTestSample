package DemoTestNG;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

import java.io.File;

import static io.restassured.RestAssured.given;

public class RestAssuredJiraTest {

    public static void main(String[] args) {


        // Given():
        //         1. Header of the request,
        //         2. Query parameters/Path parameters,
        //         3. BaseURI
        //         4. Body of the request (if any)
        //         5. Session filter (if any)
        //         6. Multi Path for attachments(if any)
        // When():
        //         1. http method,
        //         2. Resource
        // Then(): 1. Validate response:
        //         2. Header,
        //         3. Status code
        //         4. Response body

        RestAssured.baseURI = "http://localhost:8080";
        SessionFilter session = new SessionFilter();

        // POST: Login to jira to create session
        String loginResponse = given()
                .header("Content-Type", "application/json")
                .body("{ \"username\": \"ahmed.usman_shani\", \"password\": \"Redhat111!\" }").log().all()
                .filter(session)
                .when()
                .post("/rest/auth/1/session")
                .then()
                .assertThat().statusCode(200).extract().response().asString();

        System.out.println(loginResponse);


        // POST: ADD comment to issue to a JIRA issue:
        // what ever you define here will be treated as path variable
        given().pathParams("id", "10007").log().all().header("Content-Type", "application/json").body("{\n" +
                        "    \"body\": \"RestAssured: comment added from RestAssured2\",\n" +
                        "    \"visibility\": {\n" +
                        "        \"type\": \"role\",\n" +
                        "        \"value\": \"Administrators\"\n" +
                        "    }\n" +
                        "}").filter(session)
                .when().post("/rest/api/2/issue/{id}/comment").then().assertThat().statusCode(201);

        // POST: Add attachment to a Jira issue
        given().header("X-Atlassian-Token", "no-check").filter(session).pathParams("id", "10007")
                .header("Content-Type", "multipart/form-data")
                .multiPart("file", new File("jiraDummyattachmentTextFile.txt"))
                .when().post("/rest/api/2/issue/{id}/attachments")
                .then().log().all().assertThat().statusCode(200);


        // GET: Get issues form Jira
        String getResponseAllIssueDetails = given().pathParams("key", "RAP-2").log().all()
                .header("Content-Type", "application/json")
                .filter(session)
                .when().get("/rest/api/2/issue/{key}")
                .then().assertThat().statusCode(200).log().all().extract().response().asString();

        System.out.println(getResponseAllIssueDetails);


        // GET: Get issues form Jira with query parameters
        String getIssueResponseWithQueryParameters = given().pathParams("key", "RAP-3").log().all()
                .header("Content-Type", "application/json")
                .filter(session)
                .queryParam("fields", "comment")
                .queryParam("expand", "changelog")
                .when().get("/rest/api/2/issue/{key}")
                .then().assertThat().statusCode(200).log().all().extract().response().asString();

        System.out.println(getIssueResponseWithQueryParameters);


    }


}
