package sistemadetestes.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoPO extends BasePO {
	
	public ProdutoPO(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="btn-adicionar")
	public WebElement buttonCriar;
	
	@FindBy(id="codigo")
	public WebElement inputCodigo;
	
	@FindBy(id="nome")
	public WebElement inputNome;
	
	@FindBy(id="quantidade")
	public WebElement inputQuantidade;
	
	@FindBy(id="valor")
	public WebElement inputValor;
	
//	@FindBy(css = "div.alert>span")
//	public WebElement spanMensagem;
	
	@FindBy(id="data")
	public WebElement inputData;
	
	@FindBy(xpath = "//*[@id=\"btn-salvar\"]")
	public WebElement buttonSalvar;
	
//	@FindBy(xpath = "/html/body/div/div[2]/table/thead/tr/th[2]")
//	public WebElement atributoNome;
	
	@FindBy(xpath = "//*[@id=\"cadastro-produto\"]/div/div/div[1]/button")
	public WebElement buttonXModal;
	
//	@FindBy(xpath = "/html/body/div/div[2]/table/tbody/tr/td[6]/button[1]")
//	public WebElement buttonEditar;
	
	@FindBy(xpath = "/html/body/div/div[2]/table/tbody/tr/td[6]/button[2]")
	public WebElement buttonExcluir;
	
//	@FindBy(xpath = "/html/body/div/div[2]/table/tbody/tr")
//	public WebElement linhaDoProduto;
	
	@FindBy(xpath = "/html/body/div/div[2]/table/tbody/tr/td[1]")
	public WebElement valorCodigo;
	
//	@FindBy(xpath = "//*[@id=\"btn-sair\"]")
//	public WebElement buttonSairModal;
	
//	@FindBy(xpath = "//*[@id=\"mensagem\"]")
//	@FindBy(css = "form.form-login>div.alert>span")
	@FindBy(id = "mensagem")
	public WebElement mensagemDeCampoVazio;
	
	public void escrever(WebElement input, String texto) {
		input.clear();
		input.sendKeys(texto + Keys.TAB);
	}
	
	public boolean confere(WebElement valor) {
		String valorDaLinha = valor.getText();
		if(valorDaLinha == "") {
			System.out.println("Produto excluído.");
			return true;
		} else {
			System.out.println("Falha ao excluir.");
			return false;
		}
	}
	
//	public boolean conferirCadastro(WebElement codigo) {
//		String codigoDaLinha = codigo.getText();
//		if(codigoDaLinha == "") {
//			System.out.println("Produto não cadastrado.");
//			return false;
//		} else {
//			System.out.println("Produto cadastrado.");
//			return true;
//		}
//	}
	
	public String obterMensagem() {
		return this.mensagemDeCampoVazio.getText();
	}
	
	public void cadastraProdutoComTodosOsCamposPreenchidos(String codigo, String nome, String quantidade, String valor, String data ) {
		buttonCriar.click();
		buttonCriar.click();
		escrever(this.inputCodigo, codigo);
		escrever(this.inputNome, nome);
		escrever(this.inputQuantidade, quantidade);
		escrever(this.inputValor, valor);
		escrever(this.inputData, data);
		buttonSalvar.click();	
		buttonXModal.click();
	}

	public void cadastarProdutoComCampoVazio(String codigo, String nome, String quantidade, String valor, String data ) {
		buttonCriar.click();
		escrever(this.inputCodigo, codigo);
		escrever(this.inputNome, nome);
		escrever(this.inputQuantidade, quantidade);
		escrever(this.inputValor, valor);
		escrever(this.inputData, data);
		buttonSalvar.click();
	}
}
