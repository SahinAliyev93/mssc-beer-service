package guru.springframework.msscbeerservice.web.mappers;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

 BeerDto beertoBeerDto(Beer beer);

 @Mapping(target = "minOnHand", ignore = true)
 Beer beerDtoToBeer(BeerDto beerDto);
}
