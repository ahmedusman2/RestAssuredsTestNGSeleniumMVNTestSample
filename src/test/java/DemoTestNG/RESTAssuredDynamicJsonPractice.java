package DemoTestNG;

import com.lamdatest.webpages.PayLoad;
import com.lamdatest.webpages.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class RESTAssuredDynamicJsonPractice {
    @Test(dataProvider = "BooksData")
    public void addBook(String isbn, String aisle) {

/** Given: This section is used to set up the initial conditions or inputs for the API request.
 *  It includes details like base URI, headers, query parameters, request body, etc.
 *  Remember that "given" is followed by a dot (.) to chain the methods.

 When: This section is used to specify the action or the API request itself.
 It includes the HTTP method (GET, POST, PUT, DELETE, etc.) and the resource endpoint.
 Remember that "when" is followed by a dot (.) to chain the methods.

 Then: This section is used to verify the response received from the API.
 It includes assertions to check the status code, response body, headers, etc.
 Remember that "then" is followed by a dot (.) to chain the methods.

 given()
 .<setup initial conditions>
 when()
 .<perform action>
 then()
 .<verify response>

 so simpl :
 given: 1. BaseURI, 2. query parameters, 3. body of the request for POST CALL
 when: 1. http methods : GET,POST,PUT,DELETE 2. RESOURCE end point
 Then: validate response: 1. header, 2. body 3. status code

 given: inputs: 1.BaseURI 2. parameters 2. body
 when:  actions: 1. Http method name 2. resource name
 then: response validations: 1. headers, status code, body
 *
 * */

        //RestAssured.baseURI = "http://216.10.245.166";

        String response = given().baseUri("http://216.10.245.166")
                .queryParam("Content-Type", "application/json")
                .body(PayLoad.addBook(isbn, aisle))
                .when().post("/Library/Addbook.php")
                .then().log().all()
                .extract().response().asString();

        System.out.println(response);
        JsonPath js = ReusableMethods.rawStringToJson(response);
        String Id = js.get("ID");
        System.out.println(Id);


    }

    // one way of creating a 2 dimensional array for entering book data
 /*   @DataProvider(name = "BooksData")
    public Object[][] getData() {
        Object[][] data = new Object[2][2];
        data[0][0] = "dede";
        data[0][1] = "ffr";
        data[1][0] = "wefw";
        data[1][1] = "gdxgd";
        data[2][0] = "334dfs";
        data[2][1] = "dadf";

        return data;
    }*/

    @DataProvider(name = "BooksData")
    public Object[][] getData() {
        return new Object[][]{{"random101", "random102"}, {"random201", "random202"}, {"random301", "random303"}};

    }


}