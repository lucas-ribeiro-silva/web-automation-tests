package com.lucasribeiro.webtests.hooks;

import com.lucasribeiro.webtests.config.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions; // Importe esta classe

import java.time.Duration;

public class BrowserHooks {

    @Before // Isto roda ANTES de cada cenário
    public void setup() {
        // 1. O WebDriverManager "mágico" baixa e configura o chromedriver
        WebDriverManager.chromedriver().setup();

        // --- INÍCIO DA MODIFICAÇÃO (LÓGICA HEADLESS) ---

        // 2. Criamos um objeto de Opções do Chrome
        ChromeOptions options = new ChromeOptions();

        // 3. Verificamos se estamos num ambiente de CI (Integração Contínua)
        //    O GitHub Actions (e outros) define a variável de ambiente "CI" como "true"
        String environment = System.getenv("CI");

        if (Boolean.parseBoolean(environment)) {
            System.out.println(">>> DETECTADO AMBIENTE DE CI. RODANDO EM MODO HEADLESS <<<");
            // Se for CI, adiciona os argumentos para rodar sem tela
            options.addArguments("--headless"); // O argumento principal
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080"); // Define um tamanho de tela
            options.addArguments("--no-sandbox"); // Necessário para rodar no Linux
            options.addArguments("--disable-dev-shm-usage"); // Necessário no Linux
        }

        // 4. Iniciamos o Chrome com as opções
        //    (Se não for CI, 'options' estará vazio e o Chrome abrirá normalmente)
        TestContext.driver = new ChromeDriver(options);

        // --- FIM DA MODIFICAÇÃO ---

        // 5. Boas práticas: maximizar (se não for headless) e definir espera
        if (!Boolean.parseBoolean(environment)) {
            TestContext.driver.manage().window().maximize();
        }
        TestContext.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After // Isto roda DEPOIS de cada cenário
    public void tearDown() {
        // 6. Se o driver foi iniciado, fecha o navegador
        if(TestContext.driver != null) {
            TestContext.driver.quit();
        }
    }
}