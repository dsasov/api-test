import org.junit.Assert;
import org.junit.Test;

public class SeleniumTest extends StepHooks {

    @Test
    public void loginTest() throws InterruptedException{
        LoginPage lp = new LoginPage(driver);

        lp.getSignInLink().click();

        Assert.assertEquals(true, lp.getEmailInput().isDisplayed());
    }

}
