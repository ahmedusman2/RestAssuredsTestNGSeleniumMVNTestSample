package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class DataProvidersTest {
    WebDriver driver;

    @BeforeMethod
    public void setUP() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


    @DataProvider
    public Object[][] ajaxData() {
        Object[][] data = new Object[2][2]; // 2 dimensional array
        data[0][0] = "Ahmed Usman";
        data[0][1] = "Tester Ahmed Usman";
        data[1][0] = "Minha Usman";
        data[1][1] = "DingDong Minha";

        return data;
    }

    @Test(dataProvider = "ajaxData")
    public void testAjaxForm(String name, String comment) {
        System.out.println("Name: " + name);
        System.out.println("Comment: " + comment);

        driver.get("https://www.lambdatest.com/selenium-playground/ajax-form-submit-demo");
        driver.findElement(By.id("title")).sendKeys(name);
        driver.findElement(By.id("description")).sendKeys(comment);
        driver.findElement(By.id("btn-submit")).click();

    }

    // This is reading from another class (input-provider)
    @Test(dataProviderClass = DataProviderOnly.class, dataProvider = "input-provider")
    public void testInputFields(String name, String email, int inputNumber) {

        System.out.println("Input Number: " + inputNumber);
        System.out.println("Name: " + name);
        System.out.println("e- mail:: " + email);

        driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");
        driver.findElement(By.xpath("//*[@id='name']")).sendKeys(name);
        driver.findElement(By.cssSelector("#inputEmail4")).sendKeys(email);


    }

}
