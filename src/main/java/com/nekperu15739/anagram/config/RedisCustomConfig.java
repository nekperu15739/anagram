package com.nekperu15739.anagram.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nekperu15739.anagram.converter.AnagramDocumentToBytesConverter;
import com.nekperu15739.anagram.converter.BytesToAnagramDocumentConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.convert.RedisCustomConversions;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

import java.util.List;

@Configuration
public class RedisCustomConfig {

    @Bean
    GenericJackson2JsonRedisSerializer getSerializer(final ObjectMapper objectMapper) {
        return new GenericJackson2JsonRedisSerializer(objectMapper);
    }

    @Bean
    public RedisCustomConversions redisCustomConversions(final BytesToAnagramDocumentConverter bytesToAnagramDocumentConverter, final AnagramDocumentToBytesConverter anagramDocumentToBytesConverter) {
        return new RedisCustomConversions(List.of(bytesToAnagramDocumentConverter, anagramDocumentToBytesConverter));
    }

}
