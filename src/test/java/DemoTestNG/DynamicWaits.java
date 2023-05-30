package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.function.Function;

public class DynamicWaits {
    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void testExplicitWaits() {
        driver.findElement(By.linkText("Dynamic Data Loading")).click();
        driver.findElement(By.id("save")).click();
        By Image = By.xpath("//div[@id='loading']//img");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Image));

        Boolean isImageDisplayed = driver.findElement(Image).isDisplayed();
        Assert.assertTrue(isImageDisplayed, "\n Image is not displayed \n");

    }

    @Test
    public void testFluentWait() {
        driver.findElement(By.linkText("JQuery Download Progress bars")).click();
        driver.findElement(By.id("downloadButton")).click();

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(driver -> {
            WebElement progress = driver.findElement(By.xpath("//div[@id='dialog']//div[@class='progress-label']"));
            String progressBarText = progress.getText();
            if (progressBarText.equals("Complete!")) {
                System.out.println("Progress is complete!");
                return progress;
            } else {
                System.out.println(progressBarText);
                return null;
            }
        });
    }

    @Test
    public void testImplicitWait() {
        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(10)
        );
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        driver.findElement(By.partialLinkText("Example 2")).click();
        driver.findElement(By.xpath("//*[@id='start']/button")).click();
        String helloText= driver.findElement(By.xpath("//*[@id='finish']/h4")).getText();
        System.out.println(helloText);
        Assert.assertEquals(helloText,"Hello World!","\n Message is not Hello World\n");

    }


}
