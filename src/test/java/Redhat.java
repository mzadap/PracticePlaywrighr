import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class Redhat {

    Page page;

    @Test
    public void searchText() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        //BrowserContext context = playwright.chromium().launchPersistentContext(Paths.get(""), new BrowserType.LaunchPersistentContextOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate("https://access.redhat.com/");
        page.locator("input[placeholder='Search the customer portal']").fill("rhel");
        page.locator("[id = 'home-search'] .search-button").click();

    }
}
