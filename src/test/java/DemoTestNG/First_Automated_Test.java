package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class First_Automated_Test {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }

    @Test(priority = 1)
    public void testTableSortAndSearch(){
        driver.findElement(By.linkText("Table Sort & Search")).click();
        driver.findElement(By.xpath("//*[@id='example_filter']/label/input"))
                .sendKeys("A. Ramos");
    }

    @Test(priority = 2)
    public void testBootstrapDatePicker(){

       // driver.findElement(By.xpath("//div[@id='__next']//p[text()='Table']")).click();
        driver.findElement(By.linkText("Bootstrap Date Picker")).click();
        driver.findElement(By.cssSelector("#birthday")).sendKeys("11/04/1985");
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


















}
