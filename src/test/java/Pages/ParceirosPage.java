package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Codigos.CodigosUteis;
import DSL.DslClass;

public class ParceirosPage {

	private CodigosUteis uteis;
	private DslClass dsl;
	
	public ParceirosPage(WebDriver driver) {
		super();
		dsl = new DslClass(driver);
		uteis = new CodigosUteis();
	}
	
	public void PreencherFormularioParceirosComDadosValidos() throws InterruptedException {
		String nome = uteis.gerarNomes();
		dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		dsl.Clicar(By.xpath("//a[text()='Parceiros']"));
		dsl.Clicar(By.xpath("//a[text()='Cadastrar']"));
		dsl.Preencher(By.id("cnpj"), uteis.gerarCNPJ() );
		dsl.Preencher(By.id("nome"), nome);
		dsl.Preencher(By.id("email"), uteis.gerarEmail());
		dsl.Preencher(By.id("telefone"), uteis.gerarTelefone());
		dsl.Preencher(By.id("cep"), "29160-752");
		dsl.Clicar(By.xpath("//button[contains(., 'Consultar')]"));
		dsl.Preencher(By.id("numero"), "29");
		Thread.sleep(1000);
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		Assert.assertEquals("Parceiro cadastrado com sucesso!", dsl.Assert(By.id("swal2-title")));
		String element = dsl.WaitForElement(By.id("swal2-title")).getText().toString();
		if(element.equals("Parceiro cadastrado com sucesso!")) {
			dsl.Clicar(By.xpath("//button[text()='OK']"));
			Thread.sleep(1000);
			dsl.Preencher(By.name("input-pesquisa"), nome);
			Thread.sleep(1000);
			dsl.Clicar(By.xpath("//td[text()='"+nome+"']/..//span[@class = 'MuiIconButton-label']"));
			dsl.Clicar(By.xpath("//button[text()='Desativar!']"));
			Thread.sleep(1500);
			Assert.assertEquals("Inativo", dsl.Assert(By.xpath("//b[text()='Inativo']")));
		}
	}
	
	public void ValidarCamposObrigatorios() throws InterruptedException {
		dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		dsl.Clicar(By.xpath("//a[text()='Parceiros']"));
		dsl.Clicar(By.xpath("//a[text()='Cadastrar']"));
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		Assert.assertEquals("Preencha todos os campos corretamente!", dsl.Assert(By.id("swal2-title")));
		dsl.Clicar(By.xpath("//button[text()='OK']"));
		Assert.assertEquals("CNPJ inválido!",dsl.Assert(By.xpath("//div[text()='CNPJ inválido!']")));
		Assert.assertEquals("O campo nome deve ter pelo menos 5 caracteres",dsl.Assert(By.xpath("//div[text()='O campo nome deve ter pelo menos 5 caracteres']")));
		Assert.assertEquals("O campo telefone deve conter 10 caracteres",dsl.Assert(By.xpath("//div[text()='O campo telefone deve conter 10 caracteres']")));
		Assert.assertEquals("O campo CEP deve conter 8 caracteres",dsl.Assert(By.xpath("//div[text()='O campo CEP deve conter 8 caracteres']")));
		Assert.assertEquals("O campo UF deve conter 2 letras",dsl.Assert(By.xpath("//div[text()='O campo UF deve conter 2 letras']")));
		Assert.assertEquals("O campo município deve conter pelo menos 3 letras",dsl.Assert(By.xpath("//div[text()='O campo município deve conter pelo menos 3 letras']")));
		Assert.assertEquals("O campo bairro deve conter pelo menos 3 caracteres",dsl.Assert(By.xpath("//div[text()='O campo bairro deve conter pelo menos 3 caracteres']")));
		Assert.assertEquals("O campo logradouro deve conter pelo menos 3 caracteres",dsl.Assert(By.xpath("//div[text()='O campo logradouro deve conter pelo menos 3 caracteres']")));
		Assert.assertEquals("O campo número deve ter pelo menos 1 caractere",dsl.Assert(By.xpath("//div[text()='O campo número deve ter pelo menos 1 caractere']")));	

	}
}
