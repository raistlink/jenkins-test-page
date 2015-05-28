package NoticeBoard;

import static org.junit.Assert.*;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.net.URL;

import org.junit.Test;

public class FuncTestIT{
    @Ignore("Webdriver not working")
    @Test
    public void mainPageTest() throws Exception{

        ChromeDriverManager.setup();
        WebDriver drv = new ChromeDriver();
        URL siteBase = new URL("http://localhost:10001/");


        drv.get(siteBase.toString());
        assertTrue(drv.getPageSource().contains("Notice Board"));
    }
}
