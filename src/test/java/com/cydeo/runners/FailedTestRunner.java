package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/cydeo/step_definitions",
        features = "@target/rerun.txt"

)
//bu rapor sadece hangı dosya da hangi satırda hata olduğunu gösteriyor
//böylelikle zamandan tasarruf ediyorsun


public class FailedTestRunner {

}
