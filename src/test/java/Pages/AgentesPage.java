package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Codigos.CodigosUteis;
import DSL.DslClass;

public class AgentesPage {
	private DslClass dsl;
	private WebDriver driver;
	private CodigosUteis uteis;
	private JavascriptExecutor js;
	
	public AgentesPage(WebDriver driver) {
		super();
		this.driver = driver;
		dsl = new DslClass(driver);
		uteis = new CodigosUteis();
		js = (JavascriptExecutor)this.driver;
	}
	
	public void PreencherFormularioAgentesComDadosValidos() throws InterruptedException {
		String nome = uteis.gerarNomes();
		dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		dsl.Clicar(By.xpath("//a[text()='Agentes penitenciários']"));
		dsl.Clicar(By.xpath("//a[text()='Cadastrar']"));
		dsl.Preencher(By.id("nome"), nome);
		dsl.Preencher(By.id("cpf"), uteis.gerarCPF());
		dsl.Preencher(By.id("rg"), "123456789");
		dsl.Preencher(By.id("dataNasc"), "10/05/2000");
		dsl.Clicar(By.xpath("//div[text()='Selecione o parceiro']"));
		Thread.sleep(1000);
		dsl.Clicar(By.xpath("//*[text()='parceironormal']"));
		dsl.Clicar(By.xpath("//div[text()='Selecione o sexo']"));
		Thread.sleep(1000);
		dsl.Clicar(By.xpath("//*[text()='Masculino']"));
		dsl.Preencher(By.id("cep"), "29160-752");
		dsl.Clicar(By.xpath("//button[contains(., 'Consultar')]"));
		dsl.Preencher(By.id("numero"), "10");
		dsl.Preencher(By.id("complemento"), "Com");
		dsl.Preencher(By.id("email"), uteis.gerarEmail());
		dsl.Preencher(By.id("senha"), "teste123");
		Thread.sleep(2000);
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		//Assert.assertEquals("Agente penitenciário cadastrado com sucesso!", dsl.Assert(By.id("swal2-title")));
		Assert.assertEquals("Preencha todos os campos corretamente!", dsl.Assert(By.id("swal2-title")));
		dsl.Clicar(By.xpath("//button[text()='OK']"));
		String element = dsl.WaitForElement(By.id("swal2-title")).getText().toString();
		if(element.equals("Agente penitenciário cadastrado com sucesso!")) {
			dsl.Clicar(By.xpath("//button[text()='OK']"));
			Thread.sleep(2000);
			dsl.Preencher(By.name("input-pesquisa"), nome);
			Thread.sleep(3000);
			dsl.Clicar(By.xpath("//td[text()='"+nome+"']/..//span[@class = 'MuiIconButton-label']"));
			dsl.Clicar(By.xpath("//button[text()='Desativar!']"));
			Thread.sleep(3000);
			Assert.assertEquals("Inativo", dsl.Assert(By.xpath("//b[text()='Inativo']")));
		}
	}
	
	public void ValidarCamposAgentes() throws InterruptedException {
		dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		dsl.Clicar(By.xpath("//a[text()='Agentes penitenciários']"));
		dsl.Clicar(By.xpath("//a[text()='Cadastrar']"));
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		Assert.assertEquals("Preencha todos os campos corretamente!", dsl.Assert(By.id("swal2-title")));
		dsl.Clicar(By.xpath("//button[text()='OK']"));
		//Assert.assertEquals("O campo nome deve ter pelo menos 10 caracteres", dsl.Assert(By.xpath("//div[text()='O campo nome deve ter pelo menos 10 caracteres']")));
		Assert.assertEquals("O CPF digitado é inválido", dsl.Assert(By.xpath("//div[text()='O CPF digitado é inválido']")));
		Assert.assertEquals("O campo de RG deve conter no mínimo 7 caracteres.", dsl.Assert(By.xpath("//div[text()='O campo de RG deve conter no mínimo 7 caracteres.']")));
		Assert.assertEquals("Campo de Data de Nascimento é obrigatório", dsl.Assert(By.xpath("//div[text()='Campo de Data de Nascimento é obrigatório']")));
		Assert.assertEquals("O campo CEP deve conter 8 caracteres", dsl.Assert(By.xpath("//div[text()='O campo CEP deve conter 8 caracteres']")));
		Assert.assertEquals("O campo UF deve conter 2 letras", dsl.Assert(By.xpath("//div[text()='O campo UF deve conter 2 letras']")));
		Assert.assertEquals("O campo município deve conter pelo menos 3 caracteres", dsl.Assert(By.xpath("//div[text()='O campo município deve conter pelo menos 3 caracteres']")));
		Assert.assertEquals("O campo número deve ter pelo menos 1 caractere", dsl.Assert(By.xpath("//div[text()='O campo número deve ter pelo menos 1 caractere']")));
		Assert.assertEquals("O campo deve conter no mínimo 1 letra!", dsl.Assert(By.xpath("//div[text()='O campo deve conter no mínimo 1 letra!']")));
		Assert.assertEquals("Digite um e-mail válido", dsl.Assert(By.xpath("//div[text()='Digite um e-mail válido']")));
		Assert.assertEquals("Campo de senha é obrigatório", dsl.Assert(By.xpath("//div[text()='Campo de senha é obrigatório']")));
		//Validar Parceiro
		String nome = uteis.gerarNomes();
		dsl.Preencher(By.id("nome"), nome);
		dsl.Preencher(By.id("cpf"), uteis.gerarCPF());
		dsl.Preencher(By.id("rg"), "123456789");
		dsl.Clicar(By.xpath("//div[text()='Selecione o sexo']"));
		Thread.sleep(1000);
		dsl.Clicar(By.xpath("//*[text()='Masculino']"));
		dsl.Preencher(By.id("cep"), "29160-752");
		dsl.Clicar(By.xpath("//button[contains(., 'Consultar')]"));
		dsl.Preencher(By.id("dataNasc"), "10/05/2000");
		dsl.Preencher(By.id("numero"), "10");
		dsl.Preencher(By.id("email"), uteis.gerarEmail());
		dsl.Preencher(By.id("senha"), "teste123");
		Thread.sleep(2000);
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		Assert.assertEquals("Preencha todos os campos corretamente!", dsl.Assert(By.id("swal2-title")));
		//Validar Sexo
		driver.navigate().refresh();
		dsl.Preencher(By.id("nome"), nome);
		dsl.Preencher(By.id("cpf"), uteis.gerarCPF());
		dsl.Preencher(By.id("rg"), "123456789");
		dsl.Preencher(By.id("dataNasc"), "10/05/2000");
		dsl.Clicar(By.xpath("//div[text()='Selecione o parceiro']"));
		Thread.sleep(1000);
		dsl.Clicar(By.xpath("//*[text()='parceironormal']"));
		dsl.Preencher(By.id("cep"), "29160-752");
		dsl.Clicar(By.xpath("//button[contains(., 'Consultar')]"));
		dsl.Preencher(By.id("numero"), "10");
		dsl.Preencher(By.id("email"), uteis.gerarEmail());
		dsl.Preencher(By.id("senha"), "teste123");
		Thread.sleep(2000);
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		Assert.assertEquals("Preencha todos os campos corretamente!", dsl.Assert(By.id("swal2-title")));
	}
	
}
