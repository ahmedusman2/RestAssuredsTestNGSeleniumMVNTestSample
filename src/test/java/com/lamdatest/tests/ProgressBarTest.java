package com.lamdatest.tests;

import com.lamdatest.webpages.BootstrapProgressBarPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProgressBarTest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();
    BootstrapProgressBarPage progressBarPage = new BootstrapProgressBarPage();

    @Test
    public void testProgressBarPercentage() {
        progressBarPage = homePage.clickBootstrapProgressBar();
        progressBarPage.clickStartDownloadButton();
        String actualMessage = progressBarPage.getCompletedMsg();
        String actualPercentage = progressBarPage.getProgressBarPercentage();
        String expectedMessage = "Dowload completed!";
        String expectedPercentage = "1000%";

        softAssert.assertEquals(actualMessage, expectedMessage,
                "\n The Message is not correct or complete \n");
        softAssert.assertEquals(actualPercentage, expectedPercentage,
                "\n The Percentage is not 100 % \n");
        softAssert.assertAll();

    }


}
