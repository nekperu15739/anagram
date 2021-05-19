/*
 * Copyright (c) 2020 Ryanair Ltd. All rights reserved.
 */

package com.nekperu15739.anagram.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(KeyPairProperties.class)
public class KeyConfig {

    @Bean
    public KeyFactory keyFactory() throws NoSuchAlgorithmException {
        return KeyFactory.getInstance("RSA");
    }

    @Bean
    public RSAPrivateKey privateKey(final KeyPairProperties keyPairProperties) throws InvalidKeySpecException, NoSuchAlgorithmException {
        var keyFactory = keyFactory();
        var keySpecPKCS8 = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(keyPairProperties.getRsaPrivateKey()));

        return (RSAPrivateKey) keyFactory.generatePrivate(keySpecPKCS8);
    }

    @Bean
    public RSAPublicKey publicKey(final KeyPairProperties keyPairProperties) throws InvalidKeySpecException, NoSuchAlgorithmException {
        var keyFactory = keyFactory();
        var keySpecX509 = new X509EncodedKeySpec(Base64.getDecoder().decode(keyPairProperties.getRsaPublicKey()));

        return (RSAPublicKey) keyFactory.generatePublic(keySpecX509);
    }
}
