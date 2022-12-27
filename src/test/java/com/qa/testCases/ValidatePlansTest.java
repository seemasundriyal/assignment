package com.qa.testCases;

import com.qa.base.TestBase;
import com.qa.pages.LaunchBrowserPage;
import com.qa.pages.ValidatePlansPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ValidatePlansTest extends TestBase {
    LaunchBrowserPage launchBrowser;
    ValidatePlansPage validatePlansPage;

    public ValidatePlansTest(){
        super();
    }

    @BeforeClass
    public void setup(){
        initialization();
        launchBrowser = new LaunchBrowserPage();
        validatePlansPage =  new ValidatePlansPage();
    }

    @Test(priority=1)
    public void validPageTitleTest(){
        String title = launchBrowser.validPageTitle();
        Assert.assertEquals(title, "stc tv – شاهد أفلام ومسلسلات أونلاين وبث تلفزيوني مباشر | استمتع بالفترة التجريبية");
    }

    @Test(priority=2)
    public void clickEnglishLangBtn(){
        validatePlansPage.clickEnglishLanguage();
        String title = launchBrowser.validateEnglishPagetitle();
        Assert.assertEquals(title, "stc tv - Watch Online movies, series & live TV | Enjoy Free Trial");
    }

    @Test(priority=3)
    public void verifyListAndAmountOfPackages(){
        validatePlansPage.verifyDefaultCountryDisplaying();
        validatePlansPage.verifyPackageNameList();
        validatePlansPage.verifyPackageAmount("KSA");

        validatePlansPage.chooseCountryBtn();
        validatePlansPage.selectCountry("Bahrain");
        validatePlansPage.verifyPackageNameList();
        validatePlansPage.verifyPackageAmount("Bahrain");

        validatePlansPage.chooseCountryBtn();
        validatePlansPage.selectCountry("Kuwait");
        validatePlansPage.verifyPackageNameList();
        validatePlansPage.verifyPackageAmount("Kuwait");
    }

    @Test(priority=4)
    public void verifyCountryOnSelectCountryPopup(){
        validatePlansPage.chooseCountryBtn();
        validatePlansPage.verifyCountryList();
        validatePlansPage.clickSelectCountryPopupCloseBtn();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
