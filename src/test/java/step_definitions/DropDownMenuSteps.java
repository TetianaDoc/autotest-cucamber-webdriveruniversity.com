package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.DropDownMenuPO;
import utils.GlobalVars;

public class DropDownMenuSteps {
    DropDownMenuPO dropDownMenuPO;

    public DropDownMenuSteps(DropDownMenuPO dropDownMenuPO) {
        this.dropDownMenuPO = dropDownMenuPO;
    }

    @Given("Go to Dropdown Menu, Checkbox and Radio Buttons page")
    public void goToDropdownMenuPage() {
        dropDownMenuPO.navigateToUrl(GlobalVars.HOMEPAGE_URL + "/Dropdown-Checkboxes-RadioButtons/index.html");
    }

    @When("I click on dropdown {}")
    public void clickOnDropdownMenu(String menu) {
        dropDownMenuPO.clickOnDropDown(menu);
    }

    @And("I select option {}")
    public void selectOption(String value) {
        dropDownMenuPO.clickSelectedOption(value);
    }

    @Then("The selected option {} displayed")
    public void isSelectedOptionDisplayed(String text) {
        dropDownMenuPO.isSelectedOptionDisplayed(text);
    }

    @When("I click on checkbox {}")
    public void clickOnCheckbox(String checkboxValue) {
        dropDownMenuPO.clickCheckbox(checkboxValue);
    }

    @Then("The checkbox {} selected state should be {}")
    public void validateCheckboxSelectedState(String checkboxValue, String expectedState) {
        dropDownMenuPO.validateCheckboxSelectedState(checkboxValue, Boolean.parseBoolean(expectedState));
    }

    @When("I select radio button {}")
    public void selectRadioButton(String radioValue) {
        dropDownMenuPO.selectRadioButton(radioValue);
    }

    @Then("The radio button {} is selected")
    public void isRadioButtonSelected(String radioValue) {
        dropDownMenuPO.validateRadioButtonSelected(radioValue);
    }
}
