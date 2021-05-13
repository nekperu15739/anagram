/*
 * Copyright (c) 2020 Ryanair Ltd. All rights reserved.
 */
package com.nekperu15739.anagram.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@Setter
@ToString
@ConstructorBinding
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "key-pair")
public class KeyPairProperties {

    private final String rsaPublicKey;
    private final String rsaPrivateKey;
}
