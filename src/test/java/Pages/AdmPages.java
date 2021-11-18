package Pages;
import org.junit.Assert;
import org.openqa.selenium.Alert;
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
	
	public void PreencherFormularioADMComDadosValidos() throws InterruptedException {
		dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		dsl.Clicar(By.xpath("//a[text()='Administradores']"));
		dsl.Clicar(By.xpath("//a[text()='Cadastrar']"));
		dsl.Preencher(By.id("nome"), uteis.gerarNomes());
		dsl.Preencher(By.id("cpf"), uteis.gerarCPF());
		dsl.Clicar(By.xpath("//div[text()='Selecione o sexo']"));
		Thread.sleep(1000);
		dsl.Clicar(By.xpath("//*[text()='Masculino']"));
		dsl.Preencher(By.id("dataNasc"), "10-05-1999");
		dsl.Preencher(By.id("telefone"), uteis.gerarTelefone());
		dsl.Preencher(By.id("celular"), uteis.gerarCelular());
		dsl.Preencher(By.id("email"), uteis.gerarEmail());
		dsl.Preencher(By.id("senha"), "teste123");
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		Assert.assertEquals("Administrador cadastrado com sucesso!", dsl.Assert(By.id("swal2-title")));
	}
	
	public void ValidarCamposADM() {
		dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		dsl.Clicar(By.xpath("//a[text()='Administradores']"));
		dsl.Clicar(By.xpath("//a[text()='Cadastrar']"));
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		Assert.assertEquals("Preencha todos os campos corretamente!", dsl.Assert(By.id("swal2-title")));
		dsl.Clicar(By.xpath("//button[text()='OK']"));
		
	}
}
