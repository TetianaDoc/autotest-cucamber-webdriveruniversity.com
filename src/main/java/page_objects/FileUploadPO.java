package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.GlobalVars;

import java.nio.file.Path;

public class FileUploadPO extends BasePO {
    private static final Path DEFAULT_UPLOAD_FILE = Path.of(
            System.getProperty("user.dir"), "files_for_upload", "photo.png"
    );

    public void navigateToFileUploadPage() {
        navigateToUrl(GlobalVars.HOMEPAGE_URL + "/File-Upload/index.html");
    }

    private @FindBy(id = "myFile")
    WebElement chooseFileButton;

    private @FindBy(id = "submit-button")
    WebElement submitFileUploadButton;

    public void openFile() {
        chooseFileButton.sendKeys(DEFAULT_UPLOAD_FILE.toString());
        waitForElementAndClick(submitFileUploadButton);
    }

    public void clickOnSubmitButton() {
        waitForElementAndClick(submitFileUploadButton);
    }

    public void successfulUploadMessage() {
        waitForAlertAndValidateText("Your file has now been uploaded!");
    }

    public void unsuccessfulUploadMessage() {
        waitForAlertAndValidateText("You need to select a file to upload!");
    }
}
