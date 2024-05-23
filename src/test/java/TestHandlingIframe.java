import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class TestHandlingIframe {
    Page page;

    @Test
    public void handlingIframe() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );

        page = browser.newPage();
        page.navigate("https://rahulshettyacademy.com/AutomationPractice/");
        page.locator("//legend[text() = 'iFrame Example']").scrollIntoViewIfNeeded();
        page.frameLocator("//iframe[@id='courses-iframe']").first().locator("(//div[@class='navbar-collapse collapse clearfix'])[1]/child::ul/li/child::a[text()='Courses']").click( new Locator.ClickOptions().setTimeout(2000));
        Locator frame = page.locator("iframe");
        System.out.println(frame.count());
    }
}
