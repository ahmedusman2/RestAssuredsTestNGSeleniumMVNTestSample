package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderOnly {
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


    @DataProvider(name= "input-provider")
    public static Object[][] inputData() {
        Object[][] data = new Object[2][3]; // 2 dimensional array
        data[0][0] = "Ahmed Usman";         data[0][1] = "ahmed@ahmed.com";         data[0][2] = 1;
        data[1][0] = "Minha Usman";         data[1][1] = "minha@minha.com";         data[1][2] = 2;

        return data;
    }



}
