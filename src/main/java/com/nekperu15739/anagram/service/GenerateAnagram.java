/*
 * Copyright (c) 2020 Ryanair Ltd. All rights reserved.
 */

package com.nekperu15739.anagram.service;

import com.nekperu15739.anagram.model.AnagramModel;
import reactor.core.publisher.Mono;

public interface GenerateAnagram {

    Mono<AnagramModel> generate();
}
