import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract class Page {
    public WebDriver driver;

    public Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
