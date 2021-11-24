package Main.Corporativo_ADM;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.LoginPage;
import Pages.TecEnfermagemPages;

public class TecnicoEmEnfermagem {

	private WebDriver driver;
	private LoginPage loginpage;
	private TecEnfermagemPages tecenfermagem;
	
	@Before
	public void Inicializar() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\autodrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://corporativosrcolamedtest.web.app/login");
		driver.manage().window().maximize();
		loginpage = new LoginPage(driver);
		loginpage.LogarComDadosVálidos();
		tecenfermagem = new TecEnfermagemPages(driver);
	}
	
	@Ignore
	@Test
	public void PreencherFormularioTecEnfermagemComDadaosValidos() throws InterruptedException {
		tecenfermagem.PreencherFormularioTecEnfermagemComDadaosValidos();
	}
	
	@Test
	public void ValidarCamposObrigatorios() throws InterruptedException {
		tecenfermagem.ValidarCamposObrigatorios();
	}
	
	@After
	public void Ending() {
		driver.quit();
	}
}
