package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.lang.Thread;


public class AssertionsTest {
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }

    @Test
    public void testingSingleCheckBox() {
        //driver.findElement(By.xpath("//*[@id='__next']//a[text()='Checkbox Demo']")).click();
        driver.findElement(By.linkText("Checkbox Demo")).click();
        driver.findElement(By.id("isAgeSelected")).click();
        String actualMsg = driver.findElement(By.id("txtAge")).getText();
        System.out.println(actualMsg);
        Assert.assertTrue(actualMsg.contains("Success"), "\nMessage does Not contain Success\n");
    }

    @Test
    public void testRadioButtons() {
        driver.findElement(By.linkText("Radio Buttons Demo")).click();
        driver.findElement(By.xpath("//input[@value='Other']")).click();
        driver.findElement(By.xpath("//input[@value='5 - 15']")).click();
        driver.findElement(By.xpath("//button[text()='Get values']")).click();
        String actualGender =
                driver.findElement(By.cssSelector(".genderbutton")).getText();
        String actualAgeGroup =
                driver.findElement(By.cssSelector(".groupradiobutton")).getText();
        softAssert.assertEquals(actualGender, "Other", "\nGender is not correct\n");
        softAssert.assertEquals(actualAgeGroup, "5 - 15", "\nAge Group is not correct\n");

        softAssert.assertAll("\n Test Soft Assert");
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


}
