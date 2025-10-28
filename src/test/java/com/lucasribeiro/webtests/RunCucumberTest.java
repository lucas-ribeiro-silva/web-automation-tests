package com.lucasribeiro.webtests;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber") // Diz ao JUnit para usar o Cucumber
@SelectClasspathResource("features") // Diz onde achar os arquivos .feature
@ConfigurationParameter(
        key = GLUE_PROPERTY_NAME,
        value = "com.lucasribeiro.webtests" // Diz onde achar a "cola" (Steps e Hooks)
)
public class RunCucumberTest {
    // Esta classe fica vazia. Ela serve apenas como um ponto de entrada
    // para o JUnit 5 executar o Cucumber.
}