import org.testng.annotations.Test;

public class WindowHandlesTest extends  WindowHandles{

    @Test
    public void testWindowsHandle() {
        openBrowsers();
        tapAndSubmitSearchQuery();
        waitForElement();
        verifyResults();
    }

}
