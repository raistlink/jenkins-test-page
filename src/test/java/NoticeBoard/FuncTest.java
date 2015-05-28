package NoticeBoard;

import org.junit.Test;
import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import junit.framework.TestCase;
import java.net.URL;

/**
 * Created by Boots on 28/05/2015.
 */
public class FuncTest extends TestCase{
    private URL siteBase;
    private WebDriver drv;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        siteBase = new URL("http://localhost:10001/");
        drv = new FirefoxDriver();
    }
    @Test
    public void funcTest() throws Exception{
        assertTrue(drv.getPageSource().contains("New Announcement"));
    }
}
