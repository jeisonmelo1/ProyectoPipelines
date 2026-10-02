package com.advantageonlineshopping.runnner;

import com.advantageonlineshopping.utils.BeforeSuite;
import com.advantageonlineshopping.utils.DataToFeature;
import io.cucumber.junit.CucumberOptions;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import java.io.IOException;

@CucumberOptions (features = "src/test/resources/features/registro.feature",
        tags= "@Login",
        glue = "com.advantageonlineshopping.stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE)

@RunWith(RunnerPersonalizado.class)
public class RegistroRunner {
    @BeforeSuite
    public static void test() throws InvalidFormatException, IOException {
        DataToFeature.overrideFeatureFiles("./src/test/resources/features/registro.feature");
    }

}
