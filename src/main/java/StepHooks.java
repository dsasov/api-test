import driver.DriverFactory;
import driver.DriverType;
import org.openqa.selenium.WebDriver;

public class StepHooks {

    private DriverFactory driverFactory = new DriverFactory();
    WebDriver driver = driverFactory.driverCreate(DriverType.CHROME);

    @org.junit.Before
    public void beforeAll() {
        driver.get("https://www.amazon.com");
    }

    @org.junit.After
    public void afterAll() {
        driver.quit();
    }
}
