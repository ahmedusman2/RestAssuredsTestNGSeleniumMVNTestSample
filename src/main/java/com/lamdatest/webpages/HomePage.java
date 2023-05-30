package com.lamdatest.webpages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    // We make the variables private and methods public of HomePage
    private By bootstrapProgressBar = By.linkText("Bootstrap Progress bar");

    public BootstrapProgressBarPage clickBootstrapProgressBar() {
        click(bootstrapProgressBar);
        return new BootstrapProgressBarPage();
    }
}
