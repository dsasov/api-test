import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {
    @FindBy(xpath = "//*[@id=\"nav-link-accountList\"]")
    private WebElement signInLink;

    @FindBy(xpath = "//*[@id=\"ap_email\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"ap_password\"]")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"continue\"]")
    private WebElement continueBtn;

    @FindBy(xpath = "//*[@id=\"signInSubmit\"]")
    private WebElement signInBtn;

    @FindBy(xpath = "//*[@id=\"auth-fpp-link-bottom\"]")
    private WebElement forgotPassLink;

    @FindBy(xpath = "//*[@name=\"rememberMe\"]")
    private WebElement keepSignedInCheckbox;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public void setEmailInput(WebElement emailInput) {
        this.emailInput = emailInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public void setPasswordInput(WebElement passwordInput) {
        this.passwordInput = passwordInput;
    }

    public WebElement getSignInLink() {
        return signInLink;
    }

    public WebElement getContinueBtn() {
        return continueBtn;
    }

    public WebElement getSignInBtn() {
        return signInBtn;
    }

    public WebElement getForgotPassLink() {
        return forgotPassLink;
    }

    public WebElement getKeepSignedInCheckbox() {
        return keepSignedInCheckbox;
    }
}
