import com.microsoft.playwright.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DialogTest {
    static Page page;

    @Test
    public void dialogTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        BrowserContext context = playwright.chromium().launchPersistentContext(Paths.get(""), new BrowserType.LaunchPersistentContextOptions().setHeadless(false));
        page = context.newPage();
        page.navigate("http://autopract.com/selenium/alert5/");
        page.waitForLoadState();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/xyz221.png"))
                .setFullPage(true));
        page.locator("//button[text()='Trigger an Alert']").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/abc.png")));
        page.waitForLoadState();
        page.onceDialog(Dialog::accept);
        Locator test = page.locator("//button[text()='Trigger a Confirmation']");
        test.click();
        ///page.locator(D)
        page.setInputFiles("lac", Paths.get("C:\\Users\\nzadap\\Desktop\\DemoTesting\\PracticePlaywrighr\\src\\test\\screenshots\\abc.png"));
        page.locator("ab").setInputFiles(
                new Path[] {Paths.get("abc"), Paths.get("aa")}
        );
        //page.
       /* //page.onDialog(dialog -> dialog.message().equals("how are"));
        page.onDialog(Dialog::accept);
        page.locator("//button[text()='Trigger a Prompt']");
        page.onDialog(dialog -> dialog.accept("12"));
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/screenshots/xy2z.jpeg"))
                .setFullPage(true));*/

    }

    private String str;

    //Constructor
    public DialogTest(String str) {
        this.str = str;
    }

    @Test
    public void TestMethod() {
        System.out.println(str);
    }

    public class TestFactory {
        //The test methods in class TestClass will run twice with data "k1" and "k2"
        @Factory
        public Object[] factoryMethod() {
            return new Object[]{new DialogTest("K1"), new DialogTest("k2")};
        }
    }
}
