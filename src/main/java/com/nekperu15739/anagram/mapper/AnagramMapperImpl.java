package com.nekperu15739.anagram.mapper;

import com.nekperu15739.anagram.model.AnagramModel;
import com.nekperu15739.anagram.persistence.document.AnagramDocument;
import com.nekperu15739.anagram.resource.AnagramResource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AnagramMapperImpl implements AnagramMapper {

    @Override
    public AnagramResource toResource(AnagramModel model) {
        if ( model == null ) {
            return null;
        }

        final var anagramResource = AnagramResource.builder();

        List<Integer> list = model.getPositions();
        if ( list != null ) {
            anagramResource.positions( new ArrayList<Integer>( list ) );
        }

        return anagramResource.build();
    }

    @Override
    public AnagramModel toModel(String userId, List<Integer> positions) {
        if ( userId == null && positions == null ) {
            return null;
        }

        final var anagramModel = AnagramModel.builder();

        if ( userId != null ) {
            anagramModel.userId( userId );
        }
        if ( positions != null ) {
            List<Integer> list = positions;
            if ( list != null ) {
                anagramModel.positions( new ArrayList<Integer>( list ) );
            }
        }

        return anagramModel.build();
    }

    @Override
    public AnagramDocument toEntity(AnagramModel model) {
        if ( model == null ) {
            return null;
        }

        final var anagramEntity = AnagramDocument.builder();

        List<Integer> list = model.getPositions();
        if ( list != null ) {
            anagramEntity.positions( new ArrayList<Integer>( list ) );
        }
        anagramEntity.userId( model.getUserId() );

        return anagramEntity.build();
    }

    @Override
    public AnagramModel toModel(AnagramDocument entity) {
        if ( entity == null ) {
            return null;
        }

        var anagramModel = AnagramModel.builder();

        List<Integer> list = entity.getPositions();
        if ( list != null ) {
            anagramModel.positions( new ArrayList<Integer>( list ) );
        }
        anagramModel.userId( entity.getUserId() );

        return anagramModel.build();
    }
}
