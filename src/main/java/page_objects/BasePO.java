package page_objects;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static utils.GlobalVars.DEFAULT_EXPLICIT_TIMEOUT;

public class BasePO {

    public BasePO() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public void navigateToUrl(String url) {
        getDriver().get(url);
    }

    public void sendKeys(By by, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);
    }

    public void sendKeys(WebElement element, String textToType){
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
    }

    public void waitForElementAndClick(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void waitForElementAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitForAlertAndValidateText(String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.alertIsPresent());
        String alertMessageText = getDriver().switchTo().alert().getText();
        Assert.assertEquals(alertMessageText, text);
    }

    public void waitFor(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void waitFor(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String generateRandomNumber(int length) {
        return RandomStringUtils.insecure().nextNumeric(length);
    }

    public String generateRandomString(int length) {
        return RandomStringUtils.insecure().nextAlphabetic(length);
    }

}
