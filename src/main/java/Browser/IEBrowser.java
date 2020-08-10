package Browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.InterfaceImplementation;


public class IEBrowser  extends InternetExplorerDriver{


    public static WebDriver buildIEBrowser(int w, int h)  {

        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        InternetExplorerOptions cap = new InternetExplorerOptions();
        cap.setCapability(IGNORE_ZOOM_SETTING,true);
        driver.manage().window().setSize(new Dimension(w,h));

        return driver;
    }
}