package Main.Corporativo_ADM;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.HipotesesPage;
import Pages.LoginPage;

public class Hip�tesesDiagn�sticas {

	private WebDriver driver;
	private LoginPage loginpage;
	private HipotesesPage hipotesespage;
	
	@Before
	public void Inicializar() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\autodrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://corporativosrcolamedtest.web.app/login");
		driver.manage().window().maximize();
		loginpage = new LoginPage(driver);
		hipotesespage = new HipotesesPage(driver);
	}
	
	@Test
	public void PreencherFormularioHipotesesComDadosValidos() throws InterruptedException {
		loginpage.LogarComDadosV�lidos();
		hipotesespage.PreencherCamposHipotesesComDadosValidos();
	}
	
	@Test
	public void ValidarCamposObrigatorios() throws InterruptedException {
		loginpage.LogarComDadosV�lidos();
		hipotesespage.ValidarCamposObrigatorios();
	}
	
	@After
	public void Ending() {
		driver.quit();
	}
}
