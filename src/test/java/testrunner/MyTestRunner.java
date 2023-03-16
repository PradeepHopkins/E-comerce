package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resource/AppFeatures/BuyOrder.feature" },
                 glue = {"com/stepdefiniton","AppHooks"},
               plugin = { "pretty" ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
            		      "timeline:test-output-thread/"}, dryRun =false
            		   
       	
       		)
               
               
public class MyTestRunner {


  
}
