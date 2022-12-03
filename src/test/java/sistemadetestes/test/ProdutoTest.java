package sistemadetestes.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.hamcrest.CoreMatchers.*;

import sistemadetestes.pageObject.ProdutoPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest extends BaseTest{
	
	private static ProdutoPO produtoPage;
	private final String IDCODIGO01 = "12345";
	private final String IDCODIGO02 = "12346";

	
	@BeforeClass
	public static void prepararTestes() {
		produtoPage = new ProdutoPO(driver);
	}
	
	@Test
	public void TC001_deveTerTodosOsCamposPreenchidosNaCriacao() {
		
		produtoPage.cadastraProdutoComTodosOsCamposPreenchidos("12345", "Maçã", "1000", "5,00", "2022-09-12");
		
		assertThat(IDCODIGO01, is("12345"));

	}
	
	@Test
	public void TC002_deveExcluirUmProdutoCriado() {
		
		produtoPage.buttonExcluir.click();
		
		boolean resultadoDaConferencia = produtoPage.confere(produtoPage.valorCodigo);
	
		assertFalse(resultadoDaConferencia);
	}
	
	@Test
	public void TC003_naoDeveCadastrarProdutoComCodigoEmBranco() {
		
		produtoPage.cadastarProdutoComCampoVazio("123456", "Laranja", "1001", "6,00", "");
		
		String mensagem = produtoPage.obterMensagem();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
		
	}
}

