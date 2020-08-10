package SeleniumCode.Chrome;

import Browser.BrowserFactory;
import PO.PaginaInicioPO;
import PO.SegundapagePO;
import Utiles.DatosSistemaTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test_Chrome {
    /**Definicion de variables **/
    String ciudadOrigen = DatosSistemaTest.getDatoProperties("ciudadOrigen");
    String ciudadDestino = DatosSistemaTest.getDatoProperties("CiudadDestino");
    /**Estructura**/
    String log4jConfPath = "./src/test/resources/log4j.properties";
    WebDriver driver;

    PaginaInicioPO PI;
    SegundapagePO SP;

    @Given("^como cliente ingreso a la url \"([^\"]*)\"$")
    public void como_cliente_ingreso_a_la_url(String url) throws Throwable {
        PropertyConfigurator.configure(log4jConfPath);
       /**Chrome**/
        this.driver = BrowserFactory.getBrowser ("1920,1080", "chrome");
        /**Fire Fox**/
        this.driver = BrowserFactory.getBrowser ("1920,1080", "FireFox");
        //driver = new ChromeDriver(options);
        this.PI = new PaginaInicioPO(driver);
        this.SP = new SegundapagePO(driver);
        PI.ingreso(url);

    }

    @When("^Selecciono los datos requeridos para buscar vuelo$")
    public void selecciono_los_datos_requeridos_para_buscar_vuelo() throws Exception {
        PI.ingresoOrigen(ciudadOrigen);
        PI.ingresoDestino(ciudadDestino);
        PI.fechaIda();
        PI.fechavuelta();

    }

    @When("^doy click en boton busca tu vuelo$")
    public void doy_click_en_boton_busca_tu_vuelo() throws Exception {
        PI.btnCont();
    }

    @When("^selecciono vuelo mas economico en pantalla$")
    public void selecciono_vuelo_mas_economico_en_pantalla() throws Exception {
        SP.precios();
    }

    @Then("^Se verifica monto del vuelo y que se este en el paso tres de seis$")
    public void se_verifica_monto_del_vuelo_y_que_se_este_en_el_paso_tres_de_seis() throws Exception {
        SP.confirmacionPage();
    }

}
