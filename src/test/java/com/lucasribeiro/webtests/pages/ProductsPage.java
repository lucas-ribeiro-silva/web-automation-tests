package com.lucasribeiro.webtests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    private WebDriver driver;

    // --- Mapeamento dos Elementos ---

    @FindBy(className = "title")
    private WebElement tituloPagina;

    // Este ID é específico para o produto "Backpack"
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement botaoAddBackpack;

    @FindBy(className = "shopping_cart_link")
    private WebElement iconeCarrinho;

    // --- Construtor ---
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // --- Ações da Página ---

    public String getTituloPagina() {
        return tituloPagina.getText();
    }

    public void adicionarBackpackAoCarrinho() {
        botaoAddBackpack.click();
    }

    public void clicarIconeCarrinho() {
        iconeCarrinho.click();
    }
}