package DemoTestNG;

import com.lamdatest.webpages.PayLoad;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;


// Dummy response practice
// 1. Print No of courses returned by API
//
//2.Print Purchase Amount
//
//3. Print Title of the first course
//
//4. Print All course titles and their respective Prices
//
//5. Print no of copies sold by RPA Course
//
//6. Verify if Sum of all Course prices matches with Purchase Amount
public class ComplexJSONParsing {
    public static void main(String[] args) {
        JsonPath js = new JsonPath(PayLoad.coursePrice());

        // How to get total number for courses
        // 1. Print No of courses returned by API
        int courseSize = js.getInt("courses.size()");
        System.out.println("No of courses returned by API: " + courseSize);

        //2. Print Purchase Amount
        int purchaseAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println("Purchase Amount: " + purchaseAmount);

        //3. Print Title of the first course
        String titleOfFirstCourse = js.getString("courses[0].title");
        System.out.println("Title of the first course: " + titleOfFirstCourse);

        //4. Print All course titles and their respective Prices
        for (int i = 0; i < courseSize; i++) {
            String courseTitle = js.getString("courses[" + i + "].title");
            int coursePrice = js.getInt("courses[" + i + "].price");
            System.out.println("Course title: " + courseTitle);
            System.out.println("Course price: " + coursePrice);

        }

        //5. Print no of copies sold by RPA Course

        for (int j = 0; j < courseSize; j++) {
            // Step 1  get course title first
            String courseTitles = js.getString("courses[" + j + "].title");

            if (courseTitles.equalsIgnoreCase("RPA")) {
                js.getInt("courses[" + j + "].copies");
                break;
            }
        }

        //6. Verify if Sum of all Course prices matches with Purchase Amount

        int sumOfAllCoursesPrice = 0;
        for (int k = 0; k < courseSize; k++) {
            sumOfAllCoursesPrice = sumOfAllCoursesPrice + js.getInt("courses[" + k + "].price");
        }
        System.out.println(sumOfAllCoursesPrice);
        int expectedSum = 35;
        if (expectedSum == sumOfAllCoursesPrice) {
            System.out.println("sum is correct");
        } else {
            System.out.println("sum is not correct");
        }


    }
}
