package page_objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.GlobalVars;

public class ClickButtonsPO extends BasePO {
    public void navigateToClickButtonsPage() {
        navigateToUrl(GlobalVars.HOMEPAGE_URL + "/Click-Buttons/index.html");
    }

    private @FindBy(xpath = "//div/span[@id='button1']")
    WebElement webElementButton;

    public void clickOnWebElement() {
        webElementButton.click();
    }

    private @FindBy(xpath = "//div/h4[text()='Congratulations!']")
    WebElement successfullClickMethodText;

    public void successfulWebelementClickMessage() {
        waitFor(successfullClickMethodText);
        Assert.assertEquals(successfullClickMethodText.getText(), "Congratulations!");
    }

    private @FindBy(css = "#button2")
    WebElement javaScriptButton;

    public void clickJavaScriptButton() {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", javaScriptButton);
    }

    private @FindBy(xpath = "//div/h4[text()='It’s that Easy!! Well I think it is.....']")
    WebElement successfulJsMethodText;

    public void successfulJsMethodClickMessage() {
        waitFor(successfulJsMethodText);
        Assert.assertEquals(successfulJsMethodText.getText(), "It’s that Easy!! Well I think it is.....");
    }

    private @FindBy(id = "button3")
    WebElement moveAndClickButton;

    public void clickActionMoveAndClick() {
        new Actions(getDriver()).moveToElement(moveAndClickButton).click().perform();
    }

    private @FindBy(xpath = "//div/h4/b[text()='Action Move & Click']")
    WebElement successfulMoveAndClickMessage;

    public void successfulActionMoveAndClickMessage() {
        waitFor(successfulMoveAndClickMessage);
        Assert.assertEquals(successfulMoveAndClickMessage.getText(), "Action Move & Click");
    }
}
