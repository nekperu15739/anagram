package com.nekperu15739.anagram.converter;

import com.nekperu15739.anagram.persistence.document.AnagramDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

@Component
@ReadingConverter
@RequiredArgsConstructor
public class BytesToAnagramDocumentConverter implements Converter<byte[], AnagramDocument> {

    private final GenericJackson2JsonRedisSerializer serializer;

    @Override
    public AnagramDocument convert(final byte[] value) {
        return serializer.deserialize(value, AnagramDocument.class);
    }
}
