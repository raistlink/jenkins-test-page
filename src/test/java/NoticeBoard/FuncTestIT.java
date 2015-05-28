package NoticeBoard;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import junit.framework.TestCase;
import java.net.URL;


public class FuncTestIT extends TestCase{
    private URL siteBase;
    private WebDriver drv;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        siteBase = new URL("http://localhost:10001/");
        drv = new FirefoxDriver();
    }

    @Override
    protected  void tearDown() throws Exception{
        super.tearDown();
    }

    public void funcTest() throws Exception{
        assertTrue(drv.getPageSource().contains("New Announcement"));
    }
}
