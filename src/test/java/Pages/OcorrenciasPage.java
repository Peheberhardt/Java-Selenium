package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Codigos.CodigosUteis;
import DSL.DslClass;

public class OcorrenciasPage {

	private WebDriver driver;
	private DslClass dsl;
	private CodigosUteis uteis;
	private JavascriptExecutor js;

	public OcorrenciasPage(WebDriver driver) {
		super();
		this.driver = driver;
		dsl = new DslClass(driver);
		uteis = new CodigosUteis();
		js = (JavascriptExecutor)this.driver;
	}
	
	public void PreencherFormularioOcorrenciasComDadosValidos() throws InterruptedException {
		String nome = uteis.gerarNomes();
		dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		WebElement element1 = dsl.WaitForElement(By.xpath("//ul[@class = 'nav pcoded-inner-navbar']")); 
		js.executeScript("arguments[0].scrollIntoView(true);", element1);
		dsl.Clicar(By.xpath("//a[text()='Ocorrências']"));
		dsl.Clicar(By.xpath("//a[text()='Cadastrar']"));
		dsl.Preencher(By.id("titulo"), nome);
		dsl.Preencher(By.id("descricao"), "AAAAAAAAAAA");
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		Assert.assertEquals("Ocorrência cadastrada com sucesso!", dsl.Assert(By.id("swal2-title")));
		String element = dsl.WaitForElement(By.id("swal2-title")).getText().toString();
		if(element.equals("Ocorrência cadastrada com sucesso!")) {
			dsl.Clicar(By.xpath("//button[text()='OK']"));
			Thread.sleep(2000);
			dsl.Preencher(By.name("input-pesquisa"), nome);
			Thread.sleep(2000);
			dsl.Clicar(By.xpath("//td[text()='"+nome+"']/..//span[@class = 'MuiIconButton-label']"));
			dsl.Clicar(By.xpath("//button[text()='Desativar!']"));
			Thread.sleep(2000);
			Assert.assertEquals("Inativo", dsl.Assert(By.xpath("//b[text()='Inativo']")));
		}
	}
	
	public void ValidarCamposObrigatorios() {
		dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		WebElement element1 = dsl.WaitForElement(By.xpath("//ul[@class = 'nav pcoded-inner-navbar']")); 
		js.executeScript("arguments[0].scrollIntoView(true);", element1);
		dsl.Clicar(By.xpath("//a[text()='Ocorrências']"));
		dsl.Clicar(By.xpath("//a[text()='Cadastrar']"));
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		Assert.assertEquals("Preencha todos os campos corretamente!", dsl.Assert(By.id("swal2-title")));
		dsl.Clicar(By.xpath("//button[text()='OK']"));
		Assert.assertEquals("O Campo título deve ter pelo menos 5 caracteres", dsl.Assert(By.xpath("//div[text()='O Campo título deve ter pelo menos 5 caracteres']")));
		Assert.assertEquals("O campo descrição deve conter no mínimo 5 caracteres!", dsl.Assert(By.xpath("//div[text()='O campo descrição deve conter no mínimo 5 caracteres!']")));

	}
}
