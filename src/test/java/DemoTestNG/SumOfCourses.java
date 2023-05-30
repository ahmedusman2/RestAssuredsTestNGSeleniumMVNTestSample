package DemoTestNG;

import com.lamdatest.webpages.PayLoad;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.*;

public class SumOfCourses {
    @Test
    public void sumOfCourses() {
        JsonPath js = new JsonPath(PayLoad.coursePrice());
        int courseSize = js.getInt("courses.size()");
        int sumOfAllCoursesPrice = 0;
        for (int k = 0; k < courseSize; k++) {
            sumOfAllCoursesPrice = sumOfAllCoursesPrice + js.getInt("courses[" + k + "].price");
        }
        System.out.println(sumOfAllCoursesPrice);
        int expectedSum = 135;
        Assert.assertEquals(sumOfAllCoursesPrice, expectedSum);

    }
}
