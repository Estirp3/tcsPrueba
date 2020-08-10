package Browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;

import java.io.File;

public class FireFoxBrowser extends FirefoxDriver {

    private static WebDriver driver = null;

    public static WebDriver buildFireFoxDriver(int valor, int valor2){
        File driverFile = new File("/usr/bin/chromedriver");
        if(!driverFile.exists()) WebDriverManager.firefoxdriver().setup();

        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().window().setSize(new Dimension(valor,valor2));
        firefoxOptions.addArguments("--headless");










        return driver;
    }
}
