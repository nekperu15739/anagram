package com.nekperu15739.anagram;

import com.nekperu15739.anagram.resource.AnagramResource;
import org.springframework.aop.SpringProxy;
import org.springframework.aop.framework.Advised;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.DecoratingProxy;
import org.springframework.nativex.hint.ProxyHint;
import org.springframework.nativex.hint.TypeHint;

@SpringBootApplication
@TypeHint(types = {AnagramResource.class})
@ProxyHint(types = {SpringProxy.class, Advised.class, DecoratingProxy.class})
public class AnagramApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnagramApplication.class, args);
    }
}
