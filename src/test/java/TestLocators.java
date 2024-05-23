import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class TestLocators {
    Page page;

    @Test
    public void typeLocator() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        //BrowserContext context = playwright.chromium().launchPersistentContext(Paths.get(""), new BrowserType.LaunchPersistentContextOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate("https://selectorshub.com/xpath-practice-page/");
        page.locator("[type='email']").type("hello");
    }
}
