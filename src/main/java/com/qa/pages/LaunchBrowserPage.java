package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class LaunchBrowserPage extends TestBase {
    public LaunchBrowserPage(){
        PageFactory.initElements(driver, this);
    }

    //validate page title
    public String validPageTitle() {
        return driver.getTitle();
    }

    public String validateEnglishPagetitle(){
        return driver.getTitle();
    }
}
