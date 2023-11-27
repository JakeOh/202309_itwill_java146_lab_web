package com.itwill.spring1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
    private static final Logger log = LoggerFactory.getLogger(LogTest.class);
    
    @Test
    public void test() {
        Assertions.assertNotNull(log);
        log.info("test()");
    }

}
