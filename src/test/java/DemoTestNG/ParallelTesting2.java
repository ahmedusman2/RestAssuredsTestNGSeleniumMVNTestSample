package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelTesting2 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }

    @Test(threadPoolSize = 3,invocationCount = 4)
    public void test3_BootStrapAlerts() {
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        System.out.println(Thread.currentThread().getId()+
                ": Rahul Shetty Academy Page");
    }

    @Test
    public void test4_DragDropRangeSlider() {
        driver.get("https://www.lambdatest.com/selenium-playground/drag-drop-range-sliders-demo");
        System.out.println(Thread.currentThread().getId()+
                ": Drag And Drop Range Sliders Page");
    }

}




















