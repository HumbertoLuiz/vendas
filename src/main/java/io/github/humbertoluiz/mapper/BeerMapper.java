<<<<<<< HEAD
//package io.github.humbertoluiz.mapper;
//
//import org.mapstruct.Mapper;
//import org.mapstruct.factory.Mappers;
//import io.github.humbertoluiz.domain.entity.Beer;
//import io.github.humbertoluiz.dto.BeerDTO;
//
//@Mapper
//public interface BeerMapper {
//
//    BeerMapper INSTANCE = Mappers.getMapper(BeerMapper.class);
//
//    Beer toModel(BeerDTO beerDTO);
//
//    BeerDTO toDTO(Beer beer);
//}
=======
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
>>>>>>> 5ae35af1d740607db2bc7c21cc0d6a506a6f2920
