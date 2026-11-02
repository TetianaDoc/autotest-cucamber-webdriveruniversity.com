package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static utils.GlobalVars.DEFAULT_EXPLICIT_TIMEOUT;

public class ToDoListPO extends BasePO {
    private static final String LIST_ITEMS_XPATH = "//ul/li";

    private @FindBy(xpath = LIST_ITEMS_XPATH)
    WebElement item;

    public void clickOnItemToBeCompleted() {
        waitForElementAndClick(item);
    }

    private @FindBy(css = ".completed")
    WebElement completedElement;

    public void isItemCompleted() {
        waitFor(completedElement);
        Assert.assertTrue(completedElement.isDisplayed());
    }

    private @FindBy(css = "input[placeholder='Add new todo']")
    WebElement placeholderInput;

    public int numberOfItems() {
        return unorderedList.size();
    }

    public void addNewItem() {
        String text = "It is New To-Do Item";
        sendKeys(placeholderInput, text);
        placeholderInput.sendKeys(Keys.RETURN);
        waitFor(addedNewItemText);
    }

    private @FindBy(xpath = "//*[text()=' It is New To-Do Item']")
    WebElement addedNewItemText;

    public void isItemAdded(int before, int after) {
        Assert.assertEquals(after, before + 1);
    }

    private @FindBy(xpath = "//*[text()=' It is New To-Do Item']/span/i")
    WebElement trash;

    private @FindBy(xpath = LIST_ITEMS_XPATH)
    List<WebElement> unorderedList;

    public int getSizeOfList() {
        return unorderedList.size();
    }

    public void deleteItem() {
        int currentCount = numberOfItems();
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", trash);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath(LIST_ITEMS_XPATH), currentCount));
    }

    public void isItemDeleted(int before, int after) {
        Assert.assertEquals(before, after + 1);
    }
}
