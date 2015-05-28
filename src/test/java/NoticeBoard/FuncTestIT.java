package NoticeBoard;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.net.URL;

import org.junit.Test;

public class FuncTestIT{

    @Test
    public void mainPageTest() throws Exception{

        URL siteBase = new URL("http://localhost:10001/");
        WebDriver drv = new FirefoxDriver();

        drv.get(siteBase.toString());
        assertTrue(drv.getPageSource().contains("Notice Board"));
    }
}
