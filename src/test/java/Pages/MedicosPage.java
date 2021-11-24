package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Codigos.CodigosUteis;
import DSL.DslClass;

public class MedicosPage {	
	private DslClass dsl;
	private CodigosUteis uteis;
	
	public MedicosPage(WebDriver driver) {
		dsl = new DslClass(driver);
		uteis = new CodigosUteis();
	}
	
	public void PreencherFormularioMedicoComDadosValidos() throws InterruptedException {
		String nome = uteis.gerarNomes();
		dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		dsl.Clicar(By.xpath("//a[text()='Médicos']"));
		dsl.Clicar(By.xpath("//a[text()='Cadastrar']"));
		dsl.Preencher(By.id("nome"), nome);
		dsl.Preencher(By.id("crm"), uteis.gerarCoren());
		dsl.Preencher(By.id("uf"), "RS");
		dsl.Preencher(By.id("cpf"), uteis.gerarCPF());
		dsl.Preencher(By.id("rg"), "123456789");
		dsl.Clicar(By.xpath("//div[text()='Selecione o sexo']"));
		Thread.sleep(300);
		dsl.Clicar(By.xpath("//*[text()='Masculino']"));
		dsl.Preencher(By.id("situacao"), "teste");
		dsl.Preencher(By.id("email"), uteis.gerarEmail());
		dsl.Preencher(By.id("senha"), "teste123");
		dsl.Preencher(By.id("dataNasc"), "10/05/1999");
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		Assert.assertEquals("Médico cadastrado com sucesso!", dsl.Assert(By.id("swal2-title")));
		String element = dsl.WaitForElement(By.id("swal2-title")).getText().toString();
		if(element.equals("Médico cadastrado com sucesso!")) {
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
	
	public void ValidarCamposObrigatorios() {
		dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		dsl.Clicar(By.xpath("//a[text()='Médicos']"));
		dsl.Clicar(By.xpath("//a[text()='Cadastrar']"));
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		Assert.assertEquals("Preencha todos os campos corretamente!", dsl.Assert(By.id("swal2-title")));
		dsl.Clicar(By.xpath("//button[text()='OK']"));
		Assert.assertEquals("O campo CRM deve conter 6 caracteres",dsl.Assert(By.xpath("//div[text()='O campo CRM deve conter 6 caracteres']")));
		Assert.assertEquals("O campo UF deve conter 2 letras",dsl.Assert(By.xpath("//div[text()='O campo UF deve conter 2 letras']")));
		Assert.assertEquals("O CPF digitado é inválido",dsl.Assert(By.xpath("//div[text()='O CPF digitado é inválido']")));
		Assert.assertEquals("O campo de RG deve conter no mínimo 7 caracteres.",dsl.Assert(By.xpath("//div[text()='O campo de RG deve conter no mínimo 7 caracteres.']")));
		Assert.assertEquals("Campo de Data de Nascimento é obrigatório",dsl.Assert(By.xpath("//div[text()='Campo de Data de Nascimento é obrigatório']")));
		Assert.assertEquals("O campo deve conter somente letras!",dsl.Assert(By.xpath("//div[text()='O campo deve conter somente letras!']")));
		Assert.assertEquals("O campo deve conter no mínimo 2 caracteres",dsl.Assert(By.xpath("//div[text()='O campo deve conter no mínimo 2 caracteres']")));
		Assert.assertEquals("Digite um e-mail válido", dsl.Assert(By.xpath("//div[text()='Digite um e-mail válido']")));
		Assert.assertEquals("Campo de senha é obrigatório", dsl.Assert(By.xpath("//div[text()='Campo de senha é obrigatório']")));
		
	}
}
