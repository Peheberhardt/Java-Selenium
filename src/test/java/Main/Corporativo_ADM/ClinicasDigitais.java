package Main.Corporativo_ADM;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.ClinicasPage;
import Pages.LoginPage;

public class ClinicasDigitais {

	private WebDriver driver;
	private LoginPage loginpage;
	private ClinicasPage clinicaspage;
	
	@Before
	public void Inicializar() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\autodrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://corporativosrcolamedtest.web.app/login");
		driver.manage().window().maximize();
		loginpage = new LoginPage(driver);
		loginpage.LogarComDadosVálidos();
		clinicaspage = new ClinicasPage(driver);
	}
	
	@Test
	public void CadastrarClinicaDigital() throws InterruptedException {
		clinicaspage.CadastrarClinicaDigital();
	}
	
	@After
	public void Ending() {
		driver.quit();
	}
}
