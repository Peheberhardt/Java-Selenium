package Main.Corporativo_ADM;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.AdmPage;
import Pages.LoginPage;

public class Administradores {
	
	private WebDriver driver;
	private LoginPage loginpage;
	private AdmPage admpage;
	
	@Before
	public void Inicializar() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\autodrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://corporativosrcolamedtest.web.app/login");
		driver.manage().window().maximize();
		loginpage = new LoginPage(driver);
		admpage = new AdmPage(driver);
		loginpage.LogarComDadosVálidos();
	}
	@Test
	public void PreencherFormularioADM() throws InterruptedException {
		admpage.PreencherFormularioADMComDadosValidos();
	}
	
	@Test
	public void ValidarCamposObrigatoriosADM() throws InterruptedException {
		admpage.ValidarCamposADM();
	}

	@After
	public void Ending() {
		driver.quit();
	}
	
}
