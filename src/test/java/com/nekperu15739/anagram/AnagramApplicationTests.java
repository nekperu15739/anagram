package com.nekperu15739.anagram;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
    (properties = {
        "spring.cloud.kubernetes.enabled=false",
        "spring.cloud.kubernetes.discovery.enabled=false",
        "spring.cloud.kubernetes.config.enable-api=false",
        "kubernetes.informer.enabled=false"
    })
class AnagramApplicationTests {

    @Test
    void contextLoads() {
    }

}
