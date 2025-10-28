package com.lucasribeiro.webtests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    // --- Mapeamento dos Elementos (Locators) ---

    // @FindBy é o "localizador". O Selenium procura um elemento com id="user-name"
    @FindBy(id = "user-name")
    private WebElement campoUsuario;

    @FindBy(id = "password")
    private WebElement campoSenha;

    @FindBy(id = "login-button")
    private WebElement botaoLogin;

    // --- Construtor ---
    // Quando criamos um LoginPage, passamos o driver e
    // pedimos ao PageFactory para "inicializar" os elementos (@FindBy)
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // --- Ações da Página ---

    public void navegarParaLogin() {
        driver.get("https://www.saucedemo.com/");
    }

    public void preencherUsuario(String usuario) {
        campoUsuario.sendKeys(usuario);
    }

    public void preencherSenha(String senha) {
        campoSenha.sendKeys(senha);
    }

    public void clicarLogin() {
        botaoLogin.click();
    }
}