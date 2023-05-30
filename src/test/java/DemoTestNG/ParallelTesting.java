package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelTesting {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }

    @Test
    public void test_JQueryDatePicker() {
        driver.get("https://www.lambdatest.com/selenium-playground/");
        System.out.println(Thread.currentThread().getId()+
                ": JQuery DatePicker Page");
    }

    @Test
    public void test2_DataListFilter() {
        driver.get("https://www.lambdatest.com/selenium-playground/data-list-filter-demo");
        System.out.println(Thread.currentThread().getId()+
                ": Data List Filter Demo");
    }

}




















