package com.lucasribeiro.webtests.steps;

import com.lucasribeiro.webtests.config.TestContext;
import com.lucasribeiro.webtests.pages.CartPage;
import com.lucasribeiro.webtests.pages.LoginPage;
import com.lucasribeiro.webtests.pages.ProductsPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions; // Importante: Usar o Assertions do JUnit 5

public class CompraSteps {

    // Nossas classes de Page Object
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;

    // Construtor: Inicializa as pages, passando o driver do nosso Contexto
    public CompraSteps() {
        this.loginPage = new LoginPage(TestContext.driver);
        this.productsPage = new ProductsPage(TestContext.driver);
        this.cartPage = new CartPage(TestContext.driver);
    }

    // --- Início das "Traduções" ---

    // A anotação @Dado "linka" este método com a frase no .feature
    // O texto deve ser *exatamente* igual.
    @Dado("que eu esteja na pagina de login do SauceDemo")
    public void queEuEstejaNaPaginaDeLoginDoSauceDemo() {
        loginPage.navegarParaLogin();
    }

    // O Cucumber entende que "standard_user" é um parâmetro
    // e o injeta na variável (String usuario)
    @Quando("eu preencher o usuario com {string}")
    public void euPreencherOUsuarioCom(String usuario) {
        loginPage.preencherUsuario(usuario);
    }

    @Quando("eu preencher a senha com {string}")
    public void euPreencherASenhaCom(String senha) {
        loginPage.preencherSenha(senha);
    }

    @Quando("eu clicar no botao de login")
    public void euClicarNoBotaoDeLogin() {
        loginPage.clicarLogin();
    }

    // Esta é a nossa primeira VERIFICAÇÃO (Assertion)
    @Entao("eu devo ser redirecionado para a pagina de produtos")
    public void euDevoSerRedirecionadoParaAPaginaDeProdutos() {
        String titulo = productsPage.getTituloPagina();
        // Verificamos se o título da página é "Products"
        Assertions.assertEquals("Products", titulo, "O título da página de produtos não foi encontrado.");
    }

    @Quando("eu adicionar o produto {string} ao carrinho")
    public void euAdicionarOProdutoAoCarrinho(String nomeProduto) {
        // No nosso caso, já "chumbamos" o botão da Backpack,
        // mas poderíamos ter uma lógica para encontrar o produto pelo nome.
        productsPage.adicionarBackpackAoCarrinho();
    }

    @Quando("eu clicar no icone do carrinho")
    public void euClicarNoIconeDoCarrinho() {
        productsPage.clicarIconeCarrinho();
    }

    // Esta é a nossa VERIFICAÇÃO FINAL
    @Entao("eu devo ver o produto {string} na pagina do carrinho")
    public void euDevoVerOProdutoNaPaginaDoCarrinho(String nomeProdutoEsperado) {
        String nomeProdutoNoCarrinho = cartPage.getNomePrimeiroItem();
        // Verificamos se o nome do produto no carrinho é o mesmo que esperamos
        Assertions.assertEquals(nomeProdutoEsperado, nomeProdutoNoCarrinho, "O produto no carrinho não é o esperado.");
    }
}