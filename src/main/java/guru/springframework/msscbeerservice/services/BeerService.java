package guru.springframework.msscbeerservice.services;

import guru.springframework.msscbeerservice.web.model.BeerDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface BeerService {
    BeerDto getById(UUID beerId);

    BeerDto createBeer(BeerDto beerDto);

    BeerDto updateBeerById(UUID beerId,BeerDto beerDto);
}
