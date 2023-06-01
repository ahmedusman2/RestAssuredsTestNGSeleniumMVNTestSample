package DemoTestNG;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

import java.io.File;

import static io.restassured.RestAssured.given;

public class RestAssuredJiraTest {

    public static void main(String[] args) {


        // given():1. Header of the request,
        //         2. Query parameters/Path parameters,
        //         3. BaseURI
        //         4. Body of the request (if any)
        //         5. Session filter (if any)
        //         6. Multi Path for attachments(if any)
        // when():
        //         1. http method,
        //         2. resource
        // Then(): 1. Validate response:
        //         2. Header,
        //         3. Status code
        //         4. Response body

        RestAssured.baseURI = "http://localhost:8080";
        SessionFilter session = new SessionFilter();


        String loginResponse = given()
                .header("Content-Type", "application/json")
                .body("{ \"username\": \"ahmed.usman_shani\", \"password\": \"Redhat111!\" }").log().all()
                .filter(session)
                .when()
                .post("/rest/auth/1/session")
                .then()
                .assertThat().statusCode(200).extract().response().asString();

        System.out.println(loginResponse);


        //POST: ADD comment to issue to a JIRA issue:
        given().pathParams("id", "10007").log().all().header("Content-Type", "application/json").body("{\n" + // what ever you define here will be treated as path variable
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


    }



}
