package DemoTestNG;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class RestAssuredJiraTest {

    public static void main(String[] args) {


        // given():1. Header of the request,
        //         2. Query parameters/Path parameters,
        //         3. BaseURI
        //         4. Body of the request
        // when():
        //         1. http method,
        //         2. resource
        // Then(): 1. Validate response:
        //         2. Header,
        //         3. Status code
        //         4. Response body

        RestAssured.baseURI = "http://localhost:8080";

        // POST: LOGIN Request to Jira
        String loginResponse = given().header("content-type", "application/json").body("{ \"username\": \"ahmed.usman_shani\", \"password\": \"Redhat111!\" }")
                .when().post("/rest/auth/1/session")
                .then().assertThat().statusCode(200).extract().response().asString();
        System.out.println(loginResponse);
/*

        //POST: ADD comment to issue to a JIRA issue:
        given().pathParams("id", "10007").log().all().header("Content-Type", "application/json").body("{\n" + // what ever you define here will be treated as path variable
                "    \"body\": \"RestAssured: comment added from RestAssured\",\n" +
                "    \"visibility\": {\n" +
                "        \"type\": \"role\",\n" +
                "        \"value\": \"Administrators\"\n" +
                "    }\n" +
                "}").when().post("/rest/api/2/issue/{id}/comment").
        // resource contains a path parameter so it shouldbe written with  {}
*/

    }
}
