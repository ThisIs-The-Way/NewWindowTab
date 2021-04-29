
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class BaseWindowHandles {

    WebDriver driver1;
    WebDriver driver2;

    public void openBrowsers() {
        driver1 = new FirefoxDriver();
        driver2 = new FirefoxDriver();
    }


    @AfterClass
    public void afterClass() {
        driver1.manage().deleteAllCookies();
        driver2.manage().deleteAllCookies();
        driver1.close();
        driver2.close();
    }
}
