package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class ParameterizedTests {
    WebDriver driver;


    @Parameters({"URL"})
    @BeforeClass
    public void setUp(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Step 1: Load the AUT (Application Under Test)
        driver.get(url);
    }


    @Test()
    @Parameters({"Task", "TestResult"})
    public void testFileDownload(String Task, String TestResult) {

        // Step 2: click the file download link
        driver.findElement(By.linkText("File Download")).click();

        // Step 3: Enter Data
        driver.findElement(By.id("textbox")).sendKeys(Task + "Execution: " + TestResult);

        // Step 4: Click the generate file button
        driver.findElement(By.id("create")).click();

        // Step 5: Click  the download link
        driver.findElement(By.id("link-to-download")).click();


    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
