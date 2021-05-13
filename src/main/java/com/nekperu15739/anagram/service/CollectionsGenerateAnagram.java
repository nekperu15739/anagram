/*
 * Copyright (c) 2020 Ryanair Ltd. All rights reserved.
 */

package com.nekperu15739.anagram.service;

import com.nekperu15739.anagram.mapper.AnagramMapper;
import com.nekperu15739.anagram.model.AnagramModel;
import com.nekperu15739.anagram.persistence.repository.AnagramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static reactor.core.publisher.Mono.just;

@Component
@RequiredArgsConstructor
public class CollectionsGenerateAnagram implements GenerateAnagram {

    protected static final List<Integer> BASE_POSITIONS = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

    private final AnagramRepository repository;
    private final AnagramMapper mapper;

    /**
     * Retrieves the userId to store the positions it in the persistence layer
     * We're using defer() to reevaluate the saving. Might need some rework
     * @return generated positions
     */
    @Override
    public Mono<AnagramModel> generate() {
        return just(mapper.toModel("userId", this.generateRandomList()))
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
