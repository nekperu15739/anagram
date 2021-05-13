/*
 * Copyright (c) 2020 Ryanair Ltd. All rights reserved.
 */

package com.nekperu15739.anagram.mapper;

import com.nekperu15739.anagram.model.AnagramModel;
import com.nekperu15739.anagram.persistence.document.AnagramDocument;
import com.nekperu15739.anagram.resource.AnagramResource;

import java.util.List;

public interface AnagramMapper {

    AnagramResource toResource(AnagramModel model);

    AnagramModel toModel(String userId, List<Integer> positions);

    AnagramDocument toEntity(AnagramModel model);

    AnagramModel toModel(AnagramDocument entity);
}
