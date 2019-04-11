package com.j4mt.api.test;

import com.intuit.karate.junit4.Karate;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Karate.class)
@CucumberOptions(
        plugin = {"pretty" ,"html:reports" ,
        "json:reports/cucumber.json" ,
        "junit:reports/cucumber.xml"},
        features = "src/test/resources",
        tags = {"~@ignore"})
public class GameCatalogAPIE2ERunnerTest {
}
