import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestHandlingLinks {

    Page page;

    @Test
    public void typeLocator() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        //BrowserContext context = playwright.chromium().launchPersistentContext(Paths.get(""), new BrowserType.LaunchPersistentContextOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate("https://www.wikipedia.org/");
        Locator links = page.locator("a");
        System.out.println(links.count());
        /*for (int i =0; i<links.count(); i++) {
            System.out.println(links.nth(i).innerText() + " URL " + links.nth(i).getAttribute("href"));
        }*/

        Locator links1 = page.locator("//*[@class='central-featured']/div/a");
        System.out.println();
        System.out.println("Hello this is new " + links1.count());
        List<String> list = new ArrayList<>();
        for (int i = 0; i< links1.count(); i++) {
            list.add(links1.nth(i).innerText());
            System.out.println(links1.nth(i).innerText() +"---" + links1.nth(i).getAttribute("href"));
        }

        System.out.println("this is list " + list);
        List<String> list1 = new ArrayList<>();
        for (String s : list) {
            list1.add(s.replaceAll("[^a-z A-Z]", ""));
            //list1.add(s.split("[^\\w']+"));
        }

        System.out.println("This is replace list " + list1);
    }

}
