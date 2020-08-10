package Browser;

import org.openqa.selenium.WebDriver;

public class BrowserFactory {
    public static WebDriver getBrowser(String pantalla, String navegador) throws Throwable {
        String desiredBrowserName =  System.getProperty("browser" , navegador);
        WebDriver desiredBrowser = null;
        switch (desiredBrowserName){

            case "chrome":
                desiredBrowser = ChromeBrowser.buildChromeBrowser(pantalla);
                break;
            case "FireFox":
                String[] parts = pantalla.split(",");
                String height = parts[0];
                String width = parts[1];
                int valor = Integer.parseInt(height);
                int valor2 = Integer.parseInt(width);
                desiredBrowser = FireFoxBrowser.buildFireFoxDriver(valor,valor2);
                break;
            case "IE":
                int w=0;
                int h=0;
                String [] IEpart =  pantalla.split(",");
                w= Integer.parseInt(IEpart[0]);
                h= Integer.parseInt(IEpart[1]);
                desiredBrowser = IEBrowser.buildIEBrowser(w,h);
                break;
            default:
                // TODO: 12/07/19 Estirpe
                break;
        }
        return desiredBrowser;
    }
}

