package driver;

import test.Property;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    public WebDriver driverCreate(DriverType driverType) {
        WebDriver driver;

        switch(driverType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver",Property.readProperties().getProperty("chromeDriver"));
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            case IE:
                driver = new InternetExplorerDriver();
                break;
            default:
                driver = new ChromeDriver();
        }

        return driver;
    }

}
