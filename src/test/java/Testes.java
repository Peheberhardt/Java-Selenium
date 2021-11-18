import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import DSL.DslClass;
import Pages.AdmPages;
import Pages.LoginPage;

public class Testes {
	private WebDriver driver;
	private DslClass dsl;
	private LoginPage loginpage;
	private AdmPages admpage;
		
	@Before
	public void Inicializar() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\autodrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://corporativosrcolamedtest.web.app/login");
		driver.manage().window().maximize();
		dsl = new DslClass(driver);
		loginpage = new LoginPage(driver);
		admpage = new AdmPages(driver);
		loginpage.LogarComDadosV�lidos();
	}
	
	@Test
	public void PreenhcerFormularioADM() throws InterruptedException {
		admpage.PreencherFormularioComDadosValidos();
	}

}
