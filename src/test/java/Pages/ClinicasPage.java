package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Codigos.CodigosUteis;
import DSL.DslClass;

public class ClinicasPage {
	
	private DslClass dsl;
	private CodigosUteis uteis;

	public ClinicasPage(WebDriver driver) {
		super();
		dsl = new DslClass(driver);
		uteis = new CodigosUteis();
	}
	
	public void CadastrarClinicaDigital() throws InterruptedException {
		String nome = uteis.gerarNomes();
		dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		dsl.Clicar(By.xpath("//a[text()='Clínicas digitais']"));
		dsl.Clicar(By.xpath("//a[text()='Cadastrar']"));
		dsl.Clicar(By.xpath("//div[text()='Selecione o parceiro']"));
		Thread.sleep(300);
		dsl.Clicar(By.xpath("//*[text()='parceironormal']"));
		dsl.Clicar(By.xpath("//div[text()='Selecione a estação']"));
		Thread.sleep(300);
		dsl.Clicar(By.xpath("//*[text()='teste']"));
		dsl.Clicar(By.xpath("//button[@title='Adicionar']"));
		dsl.Preencher(By.id("nome"), nome);
		dsl.Clicar(By.xpath("//label[text()='Horário de abertura']/..//label[@class='example-custom-input form-label']"));
		Thread.sleep(300);
		dsl.Clicar(By.xpath("//*[text()='14:30']"));
		dsl.Clicar(By.xpath("//label[text()='Horário de encerramento']/..//label[@class='example-custom-input form-label']"));
		Thread.sleep(300);
		dsl.Clicar(By.xpath("//*[text()='15:00']"));
		dsl.Clicar(By.id("dom"));
		dsl.Clicar(By.xpath("//div[@class='modal-footer']//button[text()='Cadastrar']"));
		Thread.sleep(600);
		dsl.Clicar(By.id("root"));
		dsl.Clicar(By.xpath("//button[@type='submit']"));
		Assert.assertEquals("Clínica digital cadastrada com sucesso", dsl.Assert(By.id("swal2-title")));
		String element = dsl.WaitForElement(By.id("swal2-title")).getText().toString();
		if(element.equals("Cliente cadastrado com sucesso!")) {
			dsl.Clicar(By.xpath("//button[text()='OK']"));
			Thread.sleep(2000);
			dsl.Preencher(By.name("input-pesquisa"), "teste");
			Thread.sleep(3000);
			dsl.Clicar(By.xpath("//td[text()='teste']/..//span[@class = 'MuiIconButton-label']"));
			dsl.Clicar(By.xpath("//button[text()='Desativar!']"));
			Thread.sleep(3000);
			Assert.assertEquals("Inativo", dsl.Assert(By.xpath("//b[text()='Inativo']")));
		}
	}
	
	public void ValidarCamposObrigatorios() throws InterruptedException {
		dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		dsl.Clicar(By.xpath("//a[text()='Clínicas digitais']"));
		dsl.Clicar(By.xpath("//a[text()='Cadastrar']"));
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		Assert.assertEquals("Selecione um Parceiro!", dsl.Assert(By.id("swal2-title")));
		dsl.Clicar(By.xpath("//button[text()='OK']"));
		Thread.sleep(300);
		dsl.Clicar(By.xpath("//div[text()='Selecione o parceiro']"));
		Thread.sleep(1000);
		dsl.Clicar(By.xpath("//*[text()='parceironormal']"));
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		Assert.assertEquals("Erro ao cadastrar clínica digital", dsl.Assert(By.id("swal2-title")));
	}
}
