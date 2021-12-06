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
		turnospage = new TurnosPage(driver);
	}
	
	@Test
	public void PreencherFormularioTurnosComDadosValidos() throws InterruptedException {
		loginpage.LogarComDadosVálidos();
		turnospage.PreencherFormularioTurnosComDadosValidos();
	}
	
	@Test
	public void ValidarCamposObrigatorios() throws InterruptedException {
		loginpage.LogarComDadosVálidos();
		turnospage.ValidarCamposObrigatorios();
	}
	
	@After
	public void Ending() {
		driver.quit();
	}
}
