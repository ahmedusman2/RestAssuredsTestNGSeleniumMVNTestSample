package DemoTestNG;

import com.lamdatest.webpages.PayLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class RestAssured_Practice2 {


    // REST Assured works on three things
    // given -- all inputs details (query parameters, headers, body ())
    // when -- submit the (Resource and HTTP )
    // Then -- validate the response (all your assertions will go here)

    // Test Case:  Add a place, upadate place and verify that newly added place is shown in response
    public static void main(String[] args) {

        RestAssured.baseURI = "http://rahulshettyacademy.com/";
        // Get Place code start
        String response =
                given()
                        .queryParam("key", "qaclick123")
                        .header("Content-Type", "application/json")
                        .body(PayLoad.addPlace())
                        .when().post("/maps/api/place/add/json") // provide resource here
                        .then()
                        .assertThat().statusCode(200).body("scope", equalTo("APP"))
                        .header("server", "Apache/2.4.41 (Ubuntu)")
                        .extract().response().asString();
        System.out.println(response);

        JsonPath js = new JsonPath(response);
        String placeID = js.getString("place_id");
        System.out.println("\n placeID: " + placeID);

        // ----- Get Place code end

        // Update place
        given().log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(PayLoad.updatePlaceBody(placeID))
                .when().put("/maps/api/place/update/json")
                .then().assertThat().statusCode(200)
                .body("msg", equalTo("Address  successfully updated"));


    }

}
