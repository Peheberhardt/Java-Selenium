package Main.Corporativo_ADM;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.LoginPage;
import Pages.OcorrenciasPage;

public class Ocorrencias {

	private WebDriver driver;
	private LoginPage loginpage;
	private OcorrenciasPage ocorrenciaspage;
	
	@Before
	public void Inicializar() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\autodrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://corporativosrcolamedtest.web.app/login");
		driver.manage().window().maximize();
		loginpage = new LoginPage(driver);
		ocorrenciaspage = new OcorrenciasPage(driver);
	}
	
	@Test
	public void PreencherFormularioOcorrenciasComDadosValidos() throws InterruptedException {
		loginpage.LogarComDadosVálidos();
		ocorrenciaspage.PreencherFormularioOcorrenciasComDadosValidos();
	}
	
	@Test
	public void ValidarCamposObrigatorios() throws InterruptedException {
		loginpage.LogarComDadosVálidos();
		ocorrenciaspage.ValidarCamposObrigatorios();
	}
	
	@After
	public void Ending() {
		driver.quit();
	}
}
