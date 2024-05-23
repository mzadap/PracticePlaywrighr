import com.microsoft.playwright.*;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.util.List;
import java.util.function.Consumer;

public class FirstScriptInPlaywright {

    public static void main(String[] args) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int aDouble = dimension.height;
        int w = dimension.width;
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(aDouble, w));
        Page page = context.newPage();
        page.navigate("https://www.google.com");
        page.locator("anc").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        page.url();
        page.title();
        page.close();
        playwright.close();
    }
}
