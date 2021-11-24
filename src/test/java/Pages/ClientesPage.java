package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Codigos.CodigosUteis;
import DSL.DslClass;

public class ClientesPage {

	private DslClass dsl;
	private CodigosUteis uteis;
	
	public ClientesPage(WebDriver driver) {
		super();
		dsl = new DslClass(driver);
		uteis = new CodigosUteis();
	}
	
	public void PreencherFormularioClienteComDadosValidos() throws InterruptedException {
		String nome = uteis.gerarNomes();
		dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		dsl.Clicar(By.xpath("//a[text()='Clientes']"));
		dsl.Clicar(By.xpath("//a[text()='Cadastrar']"));
		dsl.Preencher(By.id("nome"), nome);
		dsl.Preencher(By.id("cpf"), uteis.gerarCPF());
		dsl.Preencher(By.id("dataNasc"), "10/05/1999");
		dsl.Preencher(By.id("rg"), "123456789");
		dsl.Clicar(By.xpath("//div[text()='Selecione o sexo']"));
		Thread.sleep(300);
		dsl.Clicar(By.xpath("//*[text()='Masculino']"));
		dsl.Preencher(By.name("nomeMae"), uteis.gerarNomes());
		dsl.Preencher(By.id("cep"), "29160-752");
		dsl.Clicar(By.xpath("//button[contains(., 'Consultar')]"));
		dsl.Preencher(By.id("numero"),"12");
		dsl.Preencher(By.id("celular"), uteis.gerarCelular());
		dsl.Preencher(By.id("email"), uteis.gerarEmail());
		Thread.sleep(2000);
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		Assert.assertEquals("Cliente cadastrado com sucesso!", dsl.Assert(By.id("swal2-title")));
		String element = dsl.WaitForElement(By.id("swal2-title")).getText().toString();
		if(element.equals("Cliente cadastrado com sucesso!")) {
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
	
	public void ValidarCamposObrigatorios () {
		dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		dsl.Clicar(By.xpath("//a[text()='Clientes']"));
		dsl.Clicar(By.xpath("//a[text()='Cadastrar']"));
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		Assert.assertEquals("Preencha todos os campos corretamente!", dsl.Assert(By.id("swal2-title")));
		dsl.Clicar(By.xpath("//button[text()='OK']"));
		Assert.assertEquals("O campo nome deve ter pelo menos 10 caracteres",dsl.Assert(By.xpath("//div[text()='O campo nome deve ter pelo menos 10 caracteres']")));
		Assert.assertEquals("O CPF digitado é inválido",dsl.Assert(By.xpath("//div[text()='O CPF digitado é inválido']")));
		Assert.assertEquals("Campo de Data de Nascimento é obrigatório",dsl.Assert(By.xpath("//div[text()='Campo de Data de Nascimento é obrigatório']")));
		Assert.assertEquals("O campo nome da mãe deve ter no mínimo 10 caracteres",dsl.Assert(By.xpath("//div[text()='O campo nome da mãe deve ter no mínimo 10 caracteres']")));
		Assert.assertEquals("O campo celular deve conter 11 caracteres",dsl.Assert(By.xpath("//div[text()='O campo celular deve conter 11 caracteres']")));
		Assert.assertEquals("O campo de RG deve conter no mínimo 7 caracteres.",dsl.Assert(By.xpath("//div[text()='O campo de RG deve conter no mínimo 7 caracteres.']")));
		Assert.assertEquals("O campo CEP deve conter 8 caracteres", dsl.Assert(By.xpath("//div[text()='O campo CEP deve conter 8 caracteres']")));
		Assert.assertEquals("O campo UF deve conter 2 letras", dsl.Assert(By.xpath("//div[text()='O campo UF deve conter 2 letras']")));
		Assert.assertEquals("O campo município deve conter pelo menos 3 caracteres", dsl.Assert(By.xpath("//div[text()='O campo município deve conter pelo menos 3 caracteres']")));
		Assert.assertEquals("O campo bairro deve conter pelo menos 3 caracteres", dsl.Assert(By.xpath("//div[text()='O campo bairro deve conter pelo menos 3 caracteres']")));
		Assert.assertEquals("O campo número deve ter pelo menos 1 caractere", dsl.Assert(By.xpath("//div[text()='O campo número deve ter pelo menos 1 caractere']")));
		Assert.assertEquals("O campo logradouro deve conter pelo menos 3 caracteres", dsl.Assert(By.xpath("//div[text()='O campo logradouro deve conter pelo menos 3 caracteres']")));
		Assert.assertEquals("Digite um e-mail válido", dsl.Assert(By.xpath("//div[text()='Digite um e-mail válido']")));
	}
}
