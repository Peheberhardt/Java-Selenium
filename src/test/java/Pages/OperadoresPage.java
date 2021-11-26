package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Codigos.CodigosUteis;
import DSL.DslClass;

public class OperadoresPage {

	public WebDriver driver;
	public DslClass dsl;
	public CodigosUteis uteis;
	
	public OperadoresPage(WebDriver driver) {
		super();
		this.driver = driver;
		dsl = new DslClass(driver);
		uteis = new CodigosUteis();
	}
	
	public void PreencherFormularioOperadoresComDadosValidos() throws InterruptedException {
		String nome = uteis.gerarNomes();
		dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		dsl.Clicar(By.xpath("//a[text()='Operadores']"));
		dsl.Clicar(By.xpath("//a[text()='Cadastrar']"));
		dsl.Preencher(By.id("nome_completo"), nome);
		dsl.Clicar(By.xpath("//div[text()='Selecione o sexo']"));
		Thread.sleep(1000);
		dsl.Clicar(By.xpath("//*[text()='Masculino']"));
		dsl.Preencher(By.id("cpf"), uteis.gerarCPF());
		dsl.Preencher(By.id("dataNasc"), "10/05/1999");
		dsl.Preencher(By.id("celular"), uteis.gerarCelular());
		dsl.Preencher(By.id("telefone"), uteis.gerarTelefone());
		dsl.Clicar(By.xpath("//div[text()='Selecione o(s) Parceiro(s)']"));
		Thread.sleep(1000);
		dsl.Clicar(By.xpath("//*[text()='parceironormal']"));
		dsl.Preencher(By.id("email"), uteis.gerarEmail());
		dsl.Preencher(By.id("senha"), "teste123");
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		Assert.assertEquals("Operador cadastrado com sucesso", dsl.Assert(By.id("swal2-title")));
		String element = dsl.WaitForElement(By.id("swal2-title")).getText().toString();
		if(element.equals("Operador cadastrado com sucesso")) {
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

	public void ValidarCamposObrigatorios() throws InterruptedException {
		dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		dsl.Clicar(By.xpath("//a[text()='Operadores']"));
		dsl.Clicar(By.xpath("//a[text()='Cadastrar']"));
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		Assert.assertEquals("Preencha todos os campos corretamente!", dsl.Assert(By.id("swal2-title")));
		dsl.Clicar(By.xpath("//button[text()='OK']"));
		Assert.assertEquals("O campo nome deve ter pelo menos 10 caracteres",dsl.Assert(By.xpath("//div[text()='O campo nome deve ter pelo menos 10 caracteres']")));
		Assert.assertEquals("Campo de Data de Nascimento é obrigatório",dsl.Assert(By.xpath("//div[text()='Campo de Data de Nascimento é obrigatório']")));
		Assert.assertEquals("O CPF digitado é inválido",dsl.Assert(By.xpath("//div[text()='O CPF digitado é inválido']")));
		Assert.assertEquals("O campo celular deve conter 11 caracteres",dsl.Assert(By.xpath("//div[text()='O campo celular deve conter 11 caracteres']")));
		Assert.assertEquals("O campo telefone deve conter 10 caracteres",dsl.Assert(By.xpath("//div[text()='O campo telefone deve conter 10 caracteres']")));
		Assert.assertEquals("Digite um e-mail válido",dsl.Assert(By.xpath("//div[text()='Digite um e-mail válido']")));
		Assert.assertEquals("Campo de senha é obrigatório",dsl.Assert(By.xpath("//div[text()='Campo de senha é obrigatório']")));
		//Validar campo sexo
		String nome = uteis.gerarNomes();
		dsl.Preencher(By.id("nome_completo"), nome);
		dsl.Preencher(By.id("cpf"), uteis.gerarCPF());
		dsl.Preencher(By.id("dataNasc"), "10/05/1999");
		dsl.Preencher(By.id("celular"), uteis.gerarCelular());
		dsl.Preencher(By.id("telefone"), uteis.gerarTelefone());
		dsl.Clicar(By.xpath("//div[text()='Selecione o(s) Parceiro(s)']"));
		Thread.sleep(1000);
		dsl.Clicar(By.xpath("//*[text()='parceironormal']"));
		dsl.Preencher(By.id("email"), uteis.gerarEmail());
		dsl.Preencher(By.id("senha"), "teste123");
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		Assert.assertEquals("Preencha todos os campos corretamente!", dsl.Assert(By.id("swal2-title")));
		dsl.Clicar(By.xpath("//button[text()='OK']"));
		//Validar campo parceiros
		driver.navigate().refresh();
		dsl.Preencher(By.id("nome_completo"), nome);
		dsl.Preencher(By.id("cpf"), uteis.gerarCPF());
		dsl.Preencher(By.id("dataNasc"), "10/05/1999");
		dsl.Preencher(By.id("celular"), uteis.gerarCelular());
		dsl.Preencher(By.id("telefone"), uteis.gerarTelefone());
		dsl.Clicar(By.xpath("//div[@class = 'css-2oti52 select__multi-value__remove']"));
		dsl.Clicar(By.xpath("//div[text()='Selecione o sexo']"));
		Thread.sleep(1000);
		dsl.Clicar(By.xpath("//*[text()='Masculino']"));
		dsl.Preencher(By.id("email"), uteis.gerarEmail());
		dsl.Preencher(By.id("senha"), "teste123");
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		Assert.assertEquals("Preencha todos os campos corretamente!", dsl.Assert(By.id("swal2-title")));
		dsl.Clicar(By.xpath("//button[text()='OK']"));
	}
}
