import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class TestMouseHover {

    @Test
    public void handlingMouseHover() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );

        Page page;
        page = browser.newPage();
        page.navigate("https://rahulshettyacademy.com/AutomationPractice/");
        page.locator("#mousehover").hover();
        page.locator("//a[contains(text(),'Top')]").click();
    }
}
