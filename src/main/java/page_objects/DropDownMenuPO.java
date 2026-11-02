package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropDownMenuPO extends BasePO {

    private String currentMenuId;

    public void clickOnDropDown(String menu) {
        this.currentMenuId = menu;
        waitForElementAndClick(By.id(menu));
    }

    public void clickSelectedOption(String value) {
        WebElement dropdownElement = getDriver().findElement(By.id(currentMenuId));
        Select select = new Select(dropdownElement);
        select.selectByValue(value);
    }

    public void isSelectedOptionDisplayed(String text) {
        WebElement dropdownElement = getDriver().findElement(By.id(currentMenuId));
        Select select = new Select(dropdownElement);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), text);
    }

    public void clickCheckbox(String checkboxValue) {
        By checkboxLocator = By.cssSelector("#checkboxes input[value='" + checkboxValue + "']");
        waitForElementAndClick(checkboxLocator);
    }

    public void validateCheckboxSelectedState(String checkboxValue, boolean expectedSelected) {
        WebElement checkbox = getDriver().findElement(By.cssSelector("#checkboxes input[value='" + checkboxValue + "']"));
        Assert.assertEquals(checkbox.isSelected(), expectedSelected);
    }

    public void selectRadioButton(String radioValue) {
        By radioLocator = By.cssSelector("#radio-buttons input[value='" + radioValue + "']");
        waitForElementAndClick(radioLocator);
    }

    public void validateRadioButtonSelected(String radioValue) {
        WebElement radioButton = getDriver().findElement(By.cssSelector("#radio-buttons input[value='" + radioValue + "']"));
        Assert.assertTrue(radioButton.isSelected());
    }
}
