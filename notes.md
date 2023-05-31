Here's the corrected version of the notes:

What is REST?
- REST stands for Representational State Transfer.
- It is a standardized architectural style for communication.
- RESTful web services use REST APIs.

Benefits of REST:
1. Simple and standardized approach to communication.
2. Scalable and stateless, allowing for growth in complexity.
3. High performance and support for caching.

Example:
- REST API: https://www.icecream.com/API/flavours

HTTP Methods/Operations:
- CRUD operations:
    - Create (POST)
    - Read (GET)
    - Update (PUT)
    - Delete (DELETE)

Request Components:
- Operations
- Endpoint
- Parameters
- Body
- Headers

Response:
- The server's response to the request.

Example: If you want to get ice cream flavors:
- Request: GET
- Endpoint: /API/flavours

Setting up Development Environment for API testing:
- Establish separate environments for QA, Development, Staging, and Production.

Principles of API Test Design:
1. Setup: Create objects, start services, initialize.
2. Execution.
3. Verification.
4. Reporting.
5. Cleanup.

Resources:
- google.com/maps
- google.com/search
- google.com/images

Parameters:
- Path parameter: Used to get a specific record.
- Query parameter: Used to filter records.

Base URL/Resource/Path or Query Parameters.

Headers/Cookies:
- Headers represent additional details in the API request and response.
- Example: Authorization details.

End Point:
- Address where the API is hosted on the server.

HTTP Methods commonly used:
- GET, POST, PUT, and DELETE.

Path Parameters:
- Variable parts of a URL path.
- Used to point to a specific resource within a collection.

Query Parameters:
- Used to sort/filter resources.

Dynamic Mock Payloads:
- Using mock JSON file input for testing APIs.

Add Book API Example:
- POST call with Body to add a book.

Please let me know if you need further clarification on any of these points.


Syntax for RestAssured:
Given: This section is used to set up the initial conditions or inputs for the API request.
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

public class RESTAssuredDynamicJsonReadFromJSONFile {
@Test(dataProvider = "BooksData")
public void addBook(String isbn, String aisle) throws IOException {

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

       // This code will read the json input from a file
       // Step 1: Read the json file first and convert that into String
       // Step 2: Convert to Byte
       // Step 3: Byte to String

       // String jsonFilePath = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/src/test/java/TestData/TestDataAddBooks.json")));
       // System.out.println("here is the path:"+jsonFilePath);

       String response = given().baseUri("http://216.10.245.166")
               .queryParam("Content-Type", "application/json")
               .body(new String(Files.readAllBytes(Paths.get("/Users/ahmedusman/Documents/03_TestNGPractice/PracticeTestNG/src/test/java/TestData/TestDataAddBooks.json"))))
               .when().post("/Library/Addbook.php")
               .then().log().all()
               .extract().response().asString();

       System.out.println(response);
       JsonPath js = ReusableMethods.rawStringToJson(response);
       String Id = js.get("ID");
       System.out.println(Id);


    }
