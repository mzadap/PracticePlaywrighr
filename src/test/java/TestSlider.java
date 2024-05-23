import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class TestSlider {

    @Test
    public void handlingMouseHover() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );

        Page page;
        page = browser.newPage();
        page.navigate("https://jqueryui.com/resources/demos/slider/default.html");
        Locator locator = page.locator("#slider");
        page.mouse().move(locator.boundingBox().x + locator.boundingBox().width/2, locator.boundingBox().y +
                locator.boundingBox().height/2);
        page.mouse().down();
        page.mouse().move(locator.boundingBox().x + 500, locator.boundingBox().y+locator.boundingBox().height/2);
        page.mouse().up();
    }
}
