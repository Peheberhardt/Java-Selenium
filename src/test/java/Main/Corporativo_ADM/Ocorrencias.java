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
		loginpage.LogarComDadosVálidos();
		ocorrenciaspage = new OcorrenciasPage(driver);
	}
	
	@Test
	public void PreencherFormularioOcorrenciasComDadosValidos() throws InterruptedException {
		ocorrenciaspage.PreencherFormularioOcorrenciasComDadosValidos();
	}
	
	@Test
	public void ValidarCamposObrigatorios() {
		ocorrenciaspage.ValidarCamposObrigatorios();
	}
	
	@After
	public void Ending() {
		driver.quit();
	}
}
