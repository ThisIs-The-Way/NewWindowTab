
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class WindowHandles extends BaseWindowHandles {
    private static final String AMAZON_MAIN_PAGE_URL = "https://www.amazon.com/";
    private static final String LIBRARY_SEARCH_PAGE_URL = "https://1lib.us/";
    private static final String LIBRARY_SEARCH_XPATH = "//input[@id='searchFieldx']";
    public static final String AMAZON_SEARCH_XPATH = "//input[@id='twotabsearchtextbox']";
    public static final String NAME_OF_ITEM = "Cracking the coding interview";
    private static final String VERIFICATION_LINC = "Cracking the Coding Interview:"
            + " 189 Programming Questions and Solutions";


    public void tapAndSubmitSearchQuery() {
        tapAndSubmitSearchQueries(driver1, AMAZON_MAIN_PAGE_URL,
                AMAZON_SEARCH_XPATH, NAME_OF_ITEM);
        tapAndSubmitSearchQueries(driver2, LIBRARY_SEARCH_PAGE_URL,
                LIBRARY_SEARCH_XPATH, NAME_OF_ITEM);
    }

    public void waitForElement() {
        waitForElements(driver1, VERIFICATION_LINC);
        waitForElements(driver2, VERIFICATION_LINC);
    }

    public void verifyResults() {
        verifyResult(driver1, VERIFICATION_LINC);
        verifyResult(driver2, VERIFICATION_LINC);
    }

    private void verifyResult(WebDriver driver, String s) {
        WebElement element = driver.findElement(By.linkText(s));
        boolean displayed = element.isDisplayed();
        Assert.assertTrue(displayed);
    }

    private void tapAndSubmitSearchQueries(WebDriver driver, String mainPage, String search, String name) {
        driver.get(mainPage);
        driver.findElement(By.xpath(String.valueOf(search)))
                .sendKeys(name);
        driver.findElement(By.xpath(String.valueOf(search))).submit();

    }


    public void waitForElements(WebDriver driver, String string){
        (new WebDriverWait(driver,20))
                .until(ExpectedConditions.elementToBeClickable(By.linkText(string)));
    }
}
