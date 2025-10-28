package com.lucasribeiro.webtests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;

    // --- Mapeamento dos Elementos ---

    @FindBy(className = "inventory_item_name")
    private WebElement nomePrimeiroItem;

    // --- Construtor ---
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // --- Ações da Página ---

    public String getNomePrimeiroItem() {
        return nomePrimeiroItem.getText();
    }
}