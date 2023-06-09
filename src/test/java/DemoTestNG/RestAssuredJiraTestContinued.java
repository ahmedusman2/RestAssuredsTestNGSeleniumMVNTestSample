package DemoTestNG;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.io.File;

import static io.restassured.RestAssured.given;

public class RestAssuredJiraTestContinued {

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

        // Practice Example of parsing a complex json
        // In this class we will:
        // 1. login to jira and extract the cookie and then use it in other subsiquent requests.
        // 2. Add a comment and gets its ID and then try to verify that our added response in present in the body
        // 3. We will parse the response and verify that our request exists.

        RestAssured.baseURI = "http://localhost:8080";
        SessionFilter session = new SessionFilter();

        // POST: Login to jira to create session
        String loginResponse = given().relaxedHTTPSValidation()
                .header("Content-Type", "application/json")
                .body("{ \"username\": \"ahmed.usman_shani\", \"password\": \"Redhat111!\" }").log().all()
                .filter(session)
                .when()
                .post("/rest/auth/1/session")
                .then()
                .assertThat().statusCode(200).extract().response().asString();

        System.out.println(loginResponse);
        String expectedMsg = "Comment added from RestAssured";


        // POST: ADD comment to issue to a JIRA issue:
        // what ever you define here will be treated as path variable
        String addCommentResponse = given().pathParams("id", "10007").log().all().header("Content-Type", "application/json").body("{\n" +
                        "    \"body\": \"" + expectedMsg + "\",\n" +
                        "    \"visibility\": {\n" +
                        "        \"type\": \"role\",\n" +
                        "        \"value\": \"Administrators\"\n" +
                        "    }\n" +
                        "}").filter(session)
                .when().post("/rest/api/2/issue/{id}/comment").then().assertThat().statusCode(201).extract().asString();
        System.out.println("===>addCommentResponse: " + addCommentResponse);
        JsonPath js = new JsonPath(addCommentResponse);


        // GET: Get issues form Jira with query parameters
        String getIssueDetails = given().pathParams("id", "10007").log().all()
                .header("Content-Type", "application/json")
                .filter(session)
                .queryParam("fields", "comment")
                .when().get("/rest/api/2/issue/{id}")
                .then().assertThat().statusCode(200).log().all().extract().response().asString();

        System.out.println(getIssueDetails);
        JsonPath js1 = new JsonPath(getIssueDetails);
        int commentsCount = js1.getInt("fields.comment.comments.size()");
        System.out.println("===> commentsCount: " + commentsCount);

        for (int i = 0; i < commentsCount; i++) {
            // First get the comment id
            String commentID = js1.get("fields.comment.comments[" + i + "].id").toString();
            if (getIssueDetails.equalsIgnoreCase(commentID)) {
                String actualMessage = js1.get("fields.comment.comments[" + i + "].body").toString();
                System.out.println("actualMessage: " + actualMessage);
                System.out.println("expectedMsg: " + expectedMsg);
                Assert.assertEquals(actualMessage, expectedMsg);

            }
        }

    }


}
