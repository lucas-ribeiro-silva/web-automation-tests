package com.lucasribeiro.webtests.hooks;

import com.lucasribeiro.webtests.config.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BrowserHooks {

    @Before // Isto roda ANTES de cada cenário
    public void setup() {
        // 1. O WebDriverManager "mágico" baixa e configura o chromedriver
        WebDriverManager.chromedriver().setup();

        // 2. Iniciamos o Chrome e guardamos no nosso "Contexto"
        TestContext.driver = new ChromeDriver();

        // 3. Boas práticas: maximizar janela e definir um tempo de espera
        TestContext.driver.manage().window().maximize();
        TestContext.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After // Isto roda DEPOIS de cada cenário
    public void tearDown() {
        // 4. Se o driver foi iniciado, fecha o navegador
        if(TestContext.driver != null) {
            TestContext.driver.quit();
        }
    }
}