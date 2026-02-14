package com.uam.automation.ui.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/purchase_product.feature",
        glue = "com.uam.automation.ui.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class PurchaseRunner {
}