package Main.Corporativo_ADM;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.LoginPage;
import Pages.TurnosPage;

public class Turnos {

	private WebDriver driver;
	private LoginPage loginpage;
	private TurnosPage turnospage;
	
	@Before
	public void Inicializar() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\autodrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://corporativosrcolamedtest.web.app/login");
		driver.manage().window().maximize();
		loginpage = new LoginPage(driver);
		loginpage.LogarComDadosVálidos();
		turnospage = new TurnosPage(driver);
	}
	
	@Test
	public void PreencherFormularioTurnosComDadosValidos() throws InterruptedException {
		turnospage.PreencherFormularioTurnosComDadosValidos();
	}
	
	@Test
	public void ValidarCamposObrigatorios() {
		turnospage.ValidarCamposObrigatorios();
	}
	
	@After
	public void Ending() {
		driver.quit();
	}
}
