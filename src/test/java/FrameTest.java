import com.microsoft.playwright.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class FrameTest {
    static  Page page;

    @BeforeClass
    public void setup() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        page = browser.newPage();
        //page = context.newPage();
    }

    @Test
    public void test() {
        page.navigate("https://www.google.com/chrome/browser/canary.html" );
        Frame frame = page.mainFrame();
        List frame1 = frame.childFrames();
        System.out.println(frame1);
    }
}
