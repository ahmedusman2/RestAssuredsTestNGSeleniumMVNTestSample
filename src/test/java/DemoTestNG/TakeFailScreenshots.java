package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TakeFailScreenshots {
    WebDriver driver;

    @BeforeMethod()
    public void setUP() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }

    @Test
    public void simpleFormDemo() {
        driver.findElement(By.linkText("Simple Form Demo")).click();
        driver.findElement(By.xpath("//p[text()='Enter Message']//following-sibling::input"))
                .sendKeys("LamdaTest Is Awesome!!!");
        driver.findElement(By.id("showInput")).click();
        String actualMsgText = driver.findElement(By.id("message")).getText();
        Assert.assertEquals(actualMsgText,
                "LamdaTest Is Awesome!!!",
                "\n Message is not Lamda test is not correct \n");

    }

    @AfterMethod
    public void takeScreenshotAfterFailure(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination =
                    new File(
                            System.getProperty("user.dir") +
                                    "/resources/screenshots/" +
                                    testResult.getName() +
                                    ".png"
                    );
            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }


    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}
