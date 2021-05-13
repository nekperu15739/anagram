/*
 * Copyright (c) 2020 Ryanair Ltd. All rights reserved.
 */

package com.nekperu15739.anagram.handler;


import com.nekperu15739.anagram.mapper.AnagramMapper;
import com.nekperu15739.anagram.resource.AnagramResource;
import com.nekperu15739.anagram.service.GenerateAnagram;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Slf4j
@Component
@RequiredArgsConstructor
public class AnagramHandler {

    private final GenerateAnagram anagramService;
    private final AnagramMapper anagramMapper;

    @PreAuthorize("hasAuthority('anagram:write')")
    public Mono<ServerResponse> createAnagram(final ServerRequest request) {
        return ok()
                .body(anagramService.generate()
                        .doOnNext(model -> log.info(model.toString()))
                        .map(anagramMapper::toResource), AnagramResource.class);
    }
}
