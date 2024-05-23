import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownTest {
    Page page;

    @Test
    public void dropDownTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        page = browser.newPage();
        page.navigate("https://www.wikipedia.org/");
        //select by value
        page.selectOption("select", "hi");

        //select by text
        page.selectOption("select", new SelectOption().setLabel("Eesti"));
        //select by index
        page.selectOption("select", new SelectOption().setIndex(3));

        //Locator values = page.locator("//select[@id='searchLanguage']/option");
        /*System.out.println(values.count());
        for (int i =0; i<values.count(); i++) {
            System.out.println(values.nth(i).innerText() + "----" + values.nth(i).getAttribute("lang"));
        }*/
        List<ElementHandle> list = page.querySelectorAll("//select[@id='searchLanguage']/option");
        for (ElementHandle values : list) {
            System.out.println(values.innerText() + "----" + values.getAttribute("lang"));
        }
    }
}
