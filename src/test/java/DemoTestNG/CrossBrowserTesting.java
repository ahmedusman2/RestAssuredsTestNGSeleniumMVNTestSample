/*
package DemoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CrossBrowserTesting {
    public WebDriver driver;
    private String username = "ahmed.usman_shani";
    private String accesskey = "BID7Y6joURsuEe4wPad5WizE0vMC5EzQ83KcD6KL90l063fVqh";
    private String hub = "@hub.lambdatest.com/wd/hub";
    DesiredCapabilities caps = new DesiredCapabilities();
*/
/*
    @Parameters(value={"Browser", "Version", "Platform"})
    @BeforeMethod
    public void setUp(String browser, String version, String platform) {
        caps.setCapability("build", "2.1");
        caps.setCapability("name", "Cross Browser Testing");
        caps.setCapability("browserName", browser);
        caps.setCapability("version", version);
        caps.setCapability("platform", platform);
        caps.setCapability("network", true);
        caps.setCapability("console", true);
        caps.setCapability("visual", true);

        try {
            driver  = new RemoteWebDriver(new URL("https://" +
                    username + ":" + accessKey + hub),caps);
        }
        catch (MalformedURLException exc) {
            exc.printStackTrace();
        }
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }
*//*

    @Parameters(value={"Browser", "Version", "Platform"})
    @BeforeTest
    public void setUp(String browser, String platformVersion, String platform) throws Exception {
        try {

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("version", "70.0");
            capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get the any available one
            capabilities.setCapability("build", "LambdaTestSampleApp");
            capabilities.setCapability("name", "LambdaTestJavaSample");


            hub = "https://" + username + ":" + accesskey + "@" + gridURL + "/wd/hub";
            driver = new RemoteWebDriver(new URL(hub), caps);


        } catch (
                MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception f) {
            System.out.println(f);
        }
        driver.get("https://www.lambdatest.com/selenium-playground/");

    }
    @Test
    public void testDropDowns() {
        driver.findElement(By.linkText("Select Dropdown List")).click();
        WebElement findDropDown = driver.findElement(By.id("select-demo"));
        Select dayDropDown = new Select(findDropDown);
        dayDropDown.selectByVisibleText("Saturday");
    }

    @Test
    public void testDragAndDrop() {
        driver.findElement(By.linkText("Drag and Drop")).click();
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions act = new Actions(driver);
        act.dragAndDrop(source, target).perform();
    }
}*/
