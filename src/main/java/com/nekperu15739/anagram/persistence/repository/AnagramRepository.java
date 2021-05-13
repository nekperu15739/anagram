/*
 * Copyright (c) 2021 Ryanair Ltd. All rights reserved.
 */

package com.nekperu15739.anagram.persistence.repository;

import com.nekperu15739.anagram.persistence.document.AnagramDocument;
import org.springframework.data.repository.CrudRepository;

public interface AnagramRepository extends CrudRepository<AnagramDocument, String> {
}
