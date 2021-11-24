package Main.Corporativo_ADM;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.LoginPage;
import Pages.ParceirosPage;

public class Parceiros {

	private WebDriver driver;
	private LoginPage loginpage;
	private ParceirosPage  parceirospage;
	
	@Before
	public void Inicializar() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\autodrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://corporativosrcolamedtest.web.app/login");
		driver.manage().window().maximize();
		loginpage = new LoginPage(driver);
		loginpage.LogarComDadosVálidos();
		parceirospage = new ParceirosPage(driver);
	}
	
	@Test
	public void PreencherFormularioParceirosComDadosValidos() throws InterruptedException {
		parceirospage.PreencherFormularioParceirosComDadosValidos();
	}
	
}
