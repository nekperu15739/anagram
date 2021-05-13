/*
 * Copyright (c) 2020 Ryanair Ltd. All rights reserved.
 */

package com.nekperu15739.anagram.service;

import com.nekperu15739.anagram.mapper.AnagramMapper;
import com.nekperu15739.anagram.model.AnagramModel;
import com.nekperu15739.anagram.persistence.repository.AnagramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CollectionsGenerateAnagram implements GenerateAnagram {

    protected static final List<Integer> BASE_POSITIONS = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

    private final AnagramRepository repository;
    private final AnagramMapper mapper;

    @Override
    public Mono<AnagramModel> generate() {
        return ReactiveSecurityContextHolder
                .getContext()
                .map(SecurityContext::getAuthentication)
                .cast(AbstractAuthenticationToken.class)
                .map(AbstractAuthenticationToken::getName)
                .map(userId -> mapper.toModel(userId, this.generateRandomList()))
                .map(mapper::toEntity)
                .map(repository::save)
                .map(mapper::toModel);
    }

    protected List<Integer> generateRandomList() {
        final List<Integer> l = new ArrayList<>(BASE_POSITIONS);
        Collections.shuffle(l);
        return l;
    }

}
