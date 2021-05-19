package com.nekperu15739.anagram.converter;

import com.nekperu15739.anagram.persistence.document.AnagramDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

@Component
@WritingConverter
@RequiredArgsConstructor
public class AnagramDocumentToBytesConverter implements Converter<AnagramDocument, byte[]> {

    private final GenericJackson2JsonRedisSerializer serializer;

    @Override
    public byte[] convert(final AnagramDocument value) {
        return serializer.serialize(value);
    }
}
