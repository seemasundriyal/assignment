package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ValidatePlansPage extends TestBase {
    @FindBy(id = "translation-btn")
    WebElement englishLanguage;
    @FindBy(id = "country-name")
    WebElement countryName;
    @FindBy(id = "country-selct")
    WebElement selectCountryPopup;
    @FindBy(xpath = "//div[@class='country']/span[@id='country-name']")
    WebElement selectedCountryName;
    @FindBy(xpath = "//span[contains(text(),'Bahrain')]/..")
    WebElement selectBahrain;
    @FindBy(xpath = "//span[contains(text(),'KSA')]/..")
    WebElement selectKSA;
    @FindBy(xpath = "//span[contains(text(),'Kuwait')]/..")
    WebElement selectKuwait;
    @FindBy(xpath = "//div[@class='plan-names']//strong")
    List<WebElement> PlansList;
    @FindBy(xpath = "//div[@id='country-selct']/a")
    List<WebElement> CountryList;
    @FindBy(id = "country-poppup-close")
    WebElement closeSelectCountryPopup;

    @FindBy(xpath = "//h2[text()='Choose Your Plan']")
    WebElement verifyChoosePlanText;
    @FindBy(id = "currency-lite")
    WebElement verifyLitePackageAmount;

    @FindBy(id = "currency-classic")
    WebElement verifyClassicPackageAmount;

    @FindBy(id = "currency-premium")
    WebElement verifyPremiumPackageAmount;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    public ValidatePlansPage(){
        PageFactory.initElements(driver, this);
    }
    public void clickEnglishLanguage(){
        englishLanguage.click();
    }

    public void clickSelectCountryPopupCloseBtn(){
        closeSelectCountryPopup.click();
        wait.until(ExpectedConditions.invisibilityOf(selectCountryPopup));
    }

    public void verifyDefaultCountryDisplaying(){
        String expectedCountryName = countryName.getText();
        Assert.assertEquals(expectedCountryName, "KSA");
    }

    public void verifyPackageNameList(){
            String[] expected = {"LITE", "CLASSIC", "PREMIUM"};
            if (expected.length != PlansList.size()) {
                System.out.println("fail, wrong number of plans listed");
            }
            for(int i=0; i<PlansList.size();i++) {
                String optionValue = PlansList.get(i).getText();
                if (optionValue.equals(expected[i])) {
                    System.out.println("passed on: " + optionValue);
                } else {
                    System.out.println("failed on: " + optionValue);
                }
            }
    }

    public void chooseCountryBtn(){
        countryName.click();
        wait.until(ExpectedConditions.visibilityOf(selectCountryPopup));
    }

    public void selectCountry(String countryToSelect){
        if(countryToSelect == "Bahrain") {
            selectBahrain.click();
            wait.until(ExpectedConditions.invisibilityOf(selectCountryPopup));
            wait.until(ExpectedConditions.visibilityOf(selectedCountryName));
            String selectedCountry = selectedCountryName.getText();
            Assert.assertEquals(selectedCountry, "Bahrain");
        }
        else if(countryToSelect == "KSA") {
            selectKSA.click();
            wait.until(ExpectedConditions.invisibilityOf(selectCountryPopup));
            wait.until(ExpectedConditions.visibilityOf(selectedCountryName));
            String selectedCountry = selectedCountryName.getText();
            Assert.assertEquals(selectedCountry, "KSA");
        }
        else if(countryToSelect == "Kuwait") {
            selectKuwait.click();
            wait.until(ExpectedConditions.invisibilityOf(selectCountryPopup));
            wait.until(ExpectedConditions.visibilityOf(selectedCountryName));
            String selectedCountry = selectedCountryName.getText();
            Assert.assertEquals(selectedCountry, "Kuwait");
        }
    }

    public void verifyCountryList(){
        String[] expected = {"Bahrain", "KSA", "Kuwait"};
        if (expected.length != CountryList.size()) {
            System.out.println("fail, wrong number of countries found");
        }
        for(int i=0; i<CountryList.size();i++) {
            String optionValue = CountryList.get(i).getText();
            if (optionValue.equals(expected[i])) {
                System.out.println("passed on: " + optionValue);
            } else {
                System.out.println("failed on: " + optionValue);
            }
        }
    }

    public void verifyPackageAmount(String countryName){
        String expectedLite = verifyLitePackageAmount.getText();
        String expectedClassic = verifyClassicPackageAmount.getText();
        String expectedPremium = verifyPremiumPackageAmount.getText();
        if(countryName == "KSA") {
            try {
                if (expectedLite.contains("15") && expectedLite.contains("SAR/month")) {
                    System.out.println("Price of KSA-Lite package is correct");
                }
                if (expectedClassic.contains("25") && expectedClassic.contains("SAR/month")) {
                    System.out.println("Price of KSA-Classic package is correct");
                }
                if (expectedPremium.contains("60") && expectedClassic.contains("SAR/month")) {
                    System.out.println("Price of KSA-Premium package is correct");
                }
            }
            catch(Exception e) {
                System.out.println("Incorrect price rate for KSA "+e.getMessage());
            }
        }

        if(countryName == "Bahrain") {
            try {
                if (expectedLite.contains("2") && expectedLite.contains("BHD/month")) {
                    System.out.println("Price of Bahrain-Lite package is correct");
                }
                if (expectedClassic.contains("3") && expectedClassic.contains("BHD/month")) {
                    System.out.println("Price of Bahrain-Classic package is correct");
                }
                if (expectedPremium.contains("6") && expectedClassic.contains("BHD/month")) {
                    System.out.println("Price of Bahrain-Premium package is correct");
                }
            }
            catch(Exception e) {
                System.out.println("Incorrect price rate for Bahrain "+e.getMessage());
            }
        }

        if(countryName == "Kuwait") {
            try {
                if (expectedLite.contains("1.2") && expectedLite.contains("KWD/month")) {
                    System.out.println("Price of Kuwait-Lite package is correct");
                }
                if (expectedClassic.contains("2.5") && expectedClassic.contains("KWD/month")) {
                    System.out.println("Price of Kuwait-Classic package is correct");
                }
                if (expectedPremium.contains("4.8") && expectedClassic.contains("KWD/month")) {
                    System.out.println("Price of Kuwait-Premium package is correct");
                }
            }
            catch(Exception e) {
                System.out.println("Incorrect price rate for Kuwait "+e.getMessage());
            }
        }

    }

}
