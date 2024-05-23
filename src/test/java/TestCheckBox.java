import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class TestCheckBox {


    Page page;

    @Test
    public void dropDownTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        page = browser.newPage();
        page.navigate("https://rahulshettyacademy.com/AutomationPractice/");
        Locator block = page.locator("//*[@id=\"checkbox-example\"]");
        Locator checkbox = block.locator("[type='checkbox']");
        for (int i =0; i<checkbox.count(); i++) {
            checkbox.nth(i).click();
        }

        System.out.println(checkbox.count());
    }

}
