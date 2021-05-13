package com.nekperu15739.anagram;

import com.nekperu15739.anagram.config.KeyPairProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(KeyPairProperties.class)
public class AnagramApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnagramApplication.class, args);
	}

}
