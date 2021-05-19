/*
 * Copyright (c) 2020 Ryanair Ltd. All rights reserved.
 */

package com.nekperu15739.anagram.router;

import com.nekperu15739.anagram.handler.AnagramHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class AnagramRouterConfig {

    public static final String ANAGRAMS = "anagrams";

    @Bean
    public RouterFunction<ServerResponse> createAnagram(final AnagramHandler handler) {
        return route().POST(ANAGRAMS, handler::createAnagram).build();
    }
}
