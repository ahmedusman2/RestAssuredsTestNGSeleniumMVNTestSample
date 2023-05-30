package DemoTestNG;

import com.lamdatest.webpages.PayLoad;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class RestAssured_Practice {


    // REST Assured works on three things
    // given -- all inputs details (query parameters, headers, body)
    // when -- submit the (Resource and HTTP )
    // Then -- validate the response (all your assertions will go here)

    // Verify That add place is working fine
    public static void main(String[] args) {

        RestAssured.baseURI = "http://rahulshettyacademy.com/";
        given().log().all()
                .queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body(PayLoad.addPlace())
                .when().post("/maps/api/place/add/json") // provide resource here
                .then().log().all()
                .assertThat().statusCode(200).body("scope",equalTo("APP"))
                .header("server","Apache/2.4.41 (Ubuntu)");

    }

}
