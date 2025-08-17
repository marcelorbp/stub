package ie.pensionsauthority.unittets;

import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SampleTest {
	
    private static final Logger logger = LoggerFactory.getLogger(SampleTest.class);
    		
    @Test
    void unitTestCaseSample() {
    	logger.info("core - " + Thread.currentThread().getStackTrace()[1].getMethodName());
    	assertTrue(true);
    }    

}
