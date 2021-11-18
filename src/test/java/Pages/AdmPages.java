package Pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Codigos.CodigosUteis;
import DSL.DslClass;
	
	public class AdmPages {
	
	private WebDriver driver;
	private DslClass dsl;
	private CodigosUteis uteis;
	
	public AdmPages(WebDriver driver) {
		super();
		dsl = new DslClass(driver);
		uteis = new CodigosUteis();
	}
	
	public void PreencherFormularioComDadosValidos() throws InterruptedException {
		dsl.ClicarXpath("//span[text()='Cadastros']");
		dsl.ClicarXpath("//a[text()='Administradores']");
		dsl.ClicarXpath("//a[text()='Cadastrar']");
		dsl.PreencherIdFormulario("nome", uteis.gerarNomes());
		dsl.PreencherIdFormulario("cpf", uteis.gerarCPF());
		dsl.ClicarXpath("//div[text()='Selecione o sexo']");
		Thread.sleep(1000);
		dsl.ClicarXpath(("//*[text()='Masculino']"));
		dsl.PreencherIdFormulario("dataNasc", "10-05-1999");
		dsl.PreencherIdFormulario("telefone", uteis.gerarTelefone());
		dsl.PreencherIdFormulario("celular", uteis.gerarCelular());
		dsl.PreencherId("email", uteis.gerarEmail());
		dsl.PreencherId("senha", "teste123");
		dsl.ClicarXpath("//button[text()='Cadastrar']");
		Assert.assertEquals("Administrador cadastrado com sucesso!", dsl.AssertById("swal2-title"));
	}
}
