package Main.Corporativo_ADM;

import org.junit.After;
import org.junit.Before;
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
		tecenfermagem = new TecEnfermagemPages(driver);
	}
	
	@Test
	public void PreencherFormularioTecEnfermagemComDadaosValidos() throws InterruptedException {
		loginpage.LogarComDadosVálidos();
		tecenfermagem.PreencherFormularioTecEnfermagemComDadaosValidos();
	}
	
	@Test
	public void ValidarCamposObrigatorios() throws InterruptedException {
		loginpage.LogarComDadosVálidos();
		tecenfermagem.ValidarCamposObrigatorios();
	}
	
	@After
	public void Ending() {
		driver.quit();
	}
}
