package io.github.humbertoluiz.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import io.github.humbertoluiz.domain.entity.Beer;
import io.github.humbertoluiz.dto.BeerDTO;

@Mapper
public interface BeerMapper {

    BeerMapper INSTANCE = Mappers.getMapper(BeerMapper.class);

    Beer toModel(BeerDTO beerDTO);

    BeerDTO toDTO(Beer beer);
}