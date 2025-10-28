package com.lucasribeiro.webtests.config;

import org.openqa.selenium.WebDriver;

public class TestContext {
    // Usamos 'static' para que o driver seja o mesmo
    // durante todo o ciclo de vida do cenário.
    public static WebDriver driver;
}