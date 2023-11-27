package com.itwill.spring1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogTest {
//    private static final Logger log = LoggerFactory.getLogger(LogTest.class);
    
    @Test
    public void test() {
        Assertions.assertNotNull(log);
        log.info("test() - Lombok");
    }

}
