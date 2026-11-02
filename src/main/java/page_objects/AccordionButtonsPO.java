package page_objects;

import org.openqa.selenium.By;
import org.testng.Assert;

public class AccordionButtonsPO extends BasePO {

    public void clickAccordionButton(String accordion) {
        waitForElementAndClick(By.id(accordion));
    }

    public void isDescriptionAppears(String description) {
        By descriptionLocator = By.xpath("//*[normalize-space(text())='" + description + "']");
        waitFor(descriptionLocator);
        Assert.assertTrue(getDriver().findElement(descriptionLocator).isDisplayed());
    }
}
